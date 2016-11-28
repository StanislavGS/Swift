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
    public abstract String toString(String s1,String s2);
    
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
    final public void setGraduationDate(LocalDate graduationDate){
        if(this.enrollmentDate.compareTo(graduationDate)>=0){
            throw new IllegalArgumentException("Graduation date is expected to be after enrollment date.");
        }
        this.graduationDate=graduationDate;
    }
    
    Education(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate){
        this.institutionName=institutionName;
        this.enrollmentDate=enrollmentDate;
        this.setGraduationDate(graduationDate);                
    }
    
    @Override
    public boolean equals(Object other){
        if (!(other instanceof Education)){
            return false;
        }
        return this.institutionName.equals(((Education) other).institutionName) &&
                this.enrollmentDate.equals(((Education) other).enrollmentDate) &&
                this.graduationDate.equals(((Education) other).graduationDate);
    }
}
