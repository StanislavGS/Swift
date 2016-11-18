/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package education;

import java.time.LocalDate;

/**
 *
 * @author Stanislav Stanislavov
 */
public class PrimaryEducation extends Education{
    @Override
    public String getDegree(){
        return "primary";
    }

    @Override
     public void gotGraduated(float finalGrade){
        this.graduated=true;
    }
    
    public PrimaryEducation(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate){
        super(institutionName, enrollmentDate, graduationDate);
        this.graduated=graduationDate.compareTo(LocalDate.now())<=0;        
    }    
}
