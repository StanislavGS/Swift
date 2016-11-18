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
public abstract class GradedEducation extends Education{
    float finalGrade;   
    @Override
    public void gotGraduated(float finalGrade){
        this.graduated=true;
        this.finalGrade=finalGrade;
    }
    public float getFinalGrade(){
        return finalGrade;
    }

    public GradedEducation(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate,float finalGrade) {
        super(institutionName, enrollmentDate, graduationDate);
        this.finalGrade=finalGrade;
        this.graduated=graduationDate.compareTo(LocalDate.now())<=0;
    }
    
    
    
}
