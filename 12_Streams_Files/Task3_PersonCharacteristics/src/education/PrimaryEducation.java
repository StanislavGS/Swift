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
    //@Override
    //public String getDegree(){
    //    return "primary";
    //}

    @Override
     public void gotGraduated(float finalGrade){
        if(this.getGraduationDate().compareTo(LocalDate.now())>0){
            throw new IllegalArgumentException("Graduation date is expected to be a date in the past.");        
        }
        this.graduated=true;
    }
    
    
    public PrimaryEducation(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate){
        super(institutionName, enrollmentDate, graduationDate,EducationDegree.Primary);
        this.graduated=graduationDate.compareTo(LocalDate.now())<=0;        
    }
    
    public String toString(String heOrShe,String hisOrHer){
        String finishedOrSupposed;
        
        if (!this.graduated) {
            finishedOrSupposed = "is supposed to graduate";            
        } else {
            finishedOrSupposed = "finished";            
        }
        return String.format("%s started primary degree in %s on %s and %s on %s.", heOrShe,this.getInstitutionName(),
                this.getEnrollmentDate().toString(),finishedOrSupposed,this.getGraduationDate().toString());
    }
    
}
