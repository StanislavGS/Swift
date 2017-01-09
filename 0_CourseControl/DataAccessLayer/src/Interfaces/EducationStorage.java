/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import education.Education;
import java.util.List;

/**
 *
 * @author stanislav
 */
public interface EducationStorage {
    public Object getEducationById(int id);
    public int putEducationInDB(Education education);
    public void updateEducation(Object education,int id);  
    public void clearAllEducations();
    public int putEducationsInDB(List<Education> educations);
}
