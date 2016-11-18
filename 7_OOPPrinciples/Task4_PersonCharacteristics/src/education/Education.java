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
public abstract class Education {

    boolean graduated;
    LocalDate enrollmentDate;
    LocalDate graduationDate;
    String institutionName;

    public abstract String getDegree();
    public abstract void gotGraduated(float finalGrade);
    
    public boolean isGraduated(){
        return this.graduated;
    }
    public LocalDate  getEnrollmentDate(){
        return this.enrollmentDate;
    }
    
    public LocalDate getGraduationDate(){
        return this.graduationDate;
    }
    public String   getInstitutionName(){
        return this.institutionName;
    }
    public void setGraduationDate(LocalDate graduationDate){
        this.graduationDate=graduationDate;
    }
    
    Education(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate){
        this.institutionName=institutionName;
        this.enrollmentDate=enrollmentDate;
        this.graduationDate=graduationDate;
                
    }
}
