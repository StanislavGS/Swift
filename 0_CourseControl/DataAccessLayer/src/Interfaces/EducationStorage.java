/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Exceptions.DALException;
import education.Education;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stanislav
 */
public interface EducationStorage {
    public Object getEducationById(int id);
    public ArrayList<Education> getEducationsByCitizenId(int id) throws DALException;
    public void putEducationInDB(Education education,int idCitizen) throws DALException;
    public void updateEducation(Object education,int id);  
    public void clearAllEducations();
    public void putEducationsInDB(List<Education> educations,List<Integer> educationCitizeIdx) throws DALException;
}
