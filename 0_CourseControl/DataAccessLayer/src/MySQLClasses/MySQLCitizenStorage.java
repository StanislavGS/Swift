/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
import Interfaces.CitizenStorage;
import address.Address;
import education.Education;
import insurance.SocialInsuranceRecord;
//import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException;
import java.sql.SQLException;
import java.util.ArrayList;
import personaldetails.*;

/**
 *
 * @author stanislav
 */
public class MySQLCitizenStorage implements CitizenStorage {

    @Override
    public Citizen getCitizenById(int id)  throws DALException{
        String sqlQuery="SELECT * FROM `citizen_insurance`.`citizen` WHERE `id`='"+id+"';";
        MySQLRequest request = new MySQLRequest(sqlQuery, TypeStatement.executeQuery, TypeResult.Citizen);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while getting citizen from DB", ex);
        }
        
        Citizen citizen=(Citizen) ((ArrayList<Object>) request.getResult()).get(0);
        int idAddress=(int) ((ArrayList<Object>) request.getResult()).get(1);
        
        MySqlAddressStorage addressStorage=new MySqlAddressStorage();
        citizen.setAddress(addressStorage.getAddressFromDB(idAddress));
        //citizen.setAddress((Address) request.getResult());
        
        MySQLEducationStorage educationStorage=new MySQLEducationStorage();
        ArrayList<Education> educations=educationStorage.getEducationsByCitizenId(id);        
        for(Education edu:((ArrayList<Education>) educations)){
            citizen.addEducation(edu);
        }       
        
        
        MySQLSocialInsuranceStorage insStorage=new MySQLSocialInsuranceStorage();
        ArrayList<SocialInsuranceRecord> socInsurances=insStorage.getInsurancesByCitizenId(id);
        for(SocialInsuranceRecord sir:socInsurances){
            citizen.addSocialInsuranceRecord(sir);
        }
        
        return citizen;
    }

    @Override
    public int putCitizenInDB(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCitizen(Citizen citizen, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearAllCitizens() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putCitizensInDB(ArrayList<Citizen> citizens, int adressesIdx[]) throws DALException {
        if (citizens.size() != adressesIdx.length) {
            throw new DALException("Citizen array and index array of addresses are different length",
                    new IllegalArgumentException());
        }
        ArrayList<CharSequence> sts=new ArrayList<>();
        //String sqlQuery = "INSERT INTO `citizen_insurance`.`citizen` VALUES \n";
        sts.add("INSERT INTO `citizen_insurance`.`citizen` VALUES \n");
        for (int i = 0; i < citizens.size(); i++) {
            Citizen current = citizens.get(i);
            if (i > 0) {
                //sqlQuery += ",\n";
                sts.add(",\n");
            }
            //sqlQuery +=
            sts.add( String.format("('%d','%s','%s','%s','%.1f','%s','%d','%d')",
                    i+1, current.getFirstName(), current.getMiddleName(), current.getLastName(),
                    (float) current.getHeight(), current.getDateOfBirth().toString(),
                    current.getGender() == Gender.Male ? 1 : 2, adressesIdx[i]+1));
        }
        //sqlQuery += ";";
        sts.add(";");
        MySQLRequest request = new MySQLRequest(String.join("", sts), TypeStatement.execute, TypeResult.Void);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting addresses in DB", ex);
        }
    }

    @Override
    public int getCitizensCount() throws DALException {
        String sqlQuery = "SELECT (`id`) FROM `citizen_insurance`.`citizen`;";

        MySQLRequest request = new MySQLRequest(sqlQuery, TypeStatement.executeQuery, TypeResult.numRows);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting addresses in DB", ex);
        }

        return (int) request.getResult();
    }

    @Override
    public void clearWholeDB() throws DALException {
        String sqlQuery = "SET GLOBAL FOREIGN_KEY_CHECKS = 0;";
        MySQLRequest request = new MySQLRequest(sqlQuery, TypeStatement.execute, TypeResult.Void);
        try {
            request.execute();
            request.setSQLtext("TRUNCATE TABLE citizen_insurance.social_insurances_has_citizen;");
            request.execute();
            request.setSQLtext("TRUNCATE TABLE citizen_insurance.educations;");
            request.execute();
            request.setSQLtext("TRUNCATE TABLE citizen_insurance.social_insurances;");
            request.execute();
            request.setSQLtext("TRUNCATE TABLE citizen_insurance.citizen;");
            request.execute();
            request.setSQLtext("TRUNCATE TABLE citizen_insurance.addresses;");
            request.execute();
            request.setSQLtext("SET GLOBAL FOREIGN_KEY_CHECKS = 1;");
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while erasing DB", ex);
        }
    }

}
