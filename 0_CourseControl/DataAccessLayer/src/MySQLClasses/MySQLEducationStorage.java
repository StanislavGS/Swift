/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQLClasses;

import Exceptions.DALException;
import Interfaces.EducationStorage;
import education.Education;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stanislav
 */
public class MySQLEducationStorage implements EducationStorage {

    @Override
    public Object getEducationById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int putEducationInDB(Education education) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEducation(Object education, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearAllEducations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putEducationsInDB(List<Education> educations, List<Integer> educationCitizeIdx) throws DALException {
        if (educations.size() != educationCitizeIdx.size()) {
            throw new DALException("Citizen array and index array of addresses are different length",
                    new IllegalArgumentException());
        }
        ArrayList<CharSequence> sts=new ArrayList<>();
        //String sqlQuery = "INSERT INTO `citizen_insurance`.`educations` VALUES \n";
        sts.add("INSERT INTO `citizen_insurance`.`educations` VALUES \n");
        for (int i = 0; i < educations.size(); i++) {
            Education current = educations.get(i);
            if (i > 0) {
                //sqlQuery += ",\n";
                sts.add(",\n");
            }
            int type;
            float finalGrade=0;
            if (current instanceof PrimaryEducation) {
                type = 1;
                
            } else if (current instanceof SecondaryEducation) {
                type = 2;
                if (current.isGraduated()){
                    finalGrade=((SecondaryEducation) current).getFinalGrade();
                }                
            } else{
                type = ((HigherEducation) current).getDegree().getValue();
                if(current.isGraduated()){
                    finalGrade=((HigherEducation) current).getFinalGrade();
                }                
            }
            //sqlQuery +=
            sts.add( String.format("('%d','%d','%s','%s','%s',%d,'%.3f','%d')",
                    i+1, type, current.getInstitutionName(), current.getEnrollmentDate().toString(),
                    current.getGraduationDate().toString(), current.isGraduated()?1:0,
                    finalGrade,educationCitizeIdx.get(i)+1));
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

}
