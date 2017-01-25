/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
import Interfaces.SocialInsuranceStorage;
import com.mysql.jdbc.Util;
import insurance.SocialInsuranceRecord;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author stanislav
 */
public class MySQLSocialInsuranceStorage implements SocialInsuranceStorage {

    @Override
    public Object getInsuranceById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SocialInsuranceRecord> getInsurancesByCitizenId(int id) throws DALException{
               String sqlQuery="SELECT * FROM `citizen_insurance`.`social_insurances_has_citizen` AS t1"
                + " JOIN `citizen_insurance`.`social_insurances` AS t2 ON t1.`social_insurances_id`="
                + "t2.`id` WHERE t1.`citizen_id`='"+id+"';";
        MySQLRequest request=new MySQLRequest(sqlQuery, TypeStatement.executeQuery, 
                TypeResult.InsuranceList);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while getting educationss by citizen from DB", ex);
        }        
        return (ArrayList<SocialInsuranceRecord>) request.getResult();
        
    }
    
    @Override
    public void putInsuranceInDB(SocialInsuranceRecord isuranceRecord,int idCitizen) throws DALException{
        String sqlQuery=isuranceRecord.getYear()+"@@@"+isuranceRecord.getMonth()+"@@@"+isuranceRecord.getAmount();
        MySQLRequest request= new MySQLRequest(sqlQuery, TypeStatement.callable, TypeResult.Insurance);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting insurance record in DB", ex);
        }
        
        sqlQuery="INSERT INTO `citizen_insurance`.`social_insurances_has_citizen` "
                + "VALUES ('"+((int) request.getResult())+"','"+idCitizen+"');";
        request.setSQLtext(sqlQuery);
        request.typeStatement=TypeStatement.execute;
        request.typeRsult=TypeResult.Void;
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting insuranceCitizen record in DB", ex);
        }
    }

    @Override
    public void updateInsurance(SocialInsuranceRecord isuranceRecord, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearAllInsurances() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putInsurancesInDB(ArrayList<SocialInsuranceRecord> insuranceRecords, int[][] personInsurance) throws DALException {
        ArrayList<CharSequence> sts=new ArrayList<>();
        sts.add( "INSERT INTO `citizen_insurance`.`social_insurances` VALUES \n");
        for (int i = 0; i < insuranceRecords.size(); i++) {
            SocialInsuranceRecord current = insuranceRecords.get(i);
            if (i > 0) {
                sts.add(",\n");
            }
            sts.add( String.format("('%d','%d','%d','%.2f')",
                    i+1, current.getYear(), current.getMonth(), current.getAmount()));
        }
        insuranceRecords=null;
        sts.add(";");
        MySQLRequest request = new MySQLRequest(String.join("", sts), TypeStatement.execute, TypeResult.Void);
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting addresses in DB", ex);
        }

        sts.clear();
        sts.add("INSERT INTO `citizen_insurance`.`social_insurances_has_citizen` VALUES \n");
        for (int i = 0; i < personInsurance.length; i++) {
            for (int j = personInsurance[i][0]; j <= personInsurance[i][1]; j++) {
                if (j > personInsurance[0][0]) {
                    sts.add( ",\n");
                }
                sts.add( String.format("('%d','%d')", j+1, i+1));
            }

        }
        personInsurance=null;
        sts.add(";");
        request.setSQLtext(String.join("", sts)); 
        try {
            request.execute();
        } catch (SQLException ex) {
            throw new DALException("Problem while putting addresses in DB", ex);
        }

    }

}
