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
        if(this.getGraduationDate().compareTo(LocalDate.now())>0){
            throw new IllegalArgumentException("Graduation date is expected to be a date in the past.");        
        }
        this.graduated=true;
        if(finalGrade<2 || finalGrade>6){
            throw new IllegalArgumentException("Graduation grade is expected to be between 2 and 6.");
        }
        this.finalGrade=finalGrade;
    }
    public float getFinalGrade(){
        if(this.graduationDate.compareTo(LocalDate.now())>=0){
            throw new IllegalArgumentException("No final grade can be provided before graduation.");
        }
        return finalGrade;
    }

    public GradedEducation(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate,float finalGrade,
            EducationDegree degree) {
        super(institutionName, enrollmentDate, graduationDate,degree);
        if((finalGrade<2 || finalGrade>6)&&graduationDate.compareTo(LocalDate.now())<0){
            throw new IllegalArgumentException("Graduation grade is expected to be between 2 and 6.");
        }
        this.finalGrade=finalGrade;
        this.graduated=graduationDate.compareTo(LocalDate.now())<=0;
    }
    
    
    
}
