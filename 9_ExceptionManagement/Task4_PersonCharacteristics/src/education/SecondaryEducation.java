package education;


import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class SecondaryEducation extends GradedEducation{
    
    
    public SecondaryEducation(String institutionName,LocalDate enrollmentDate,
                            LocalDate graduationDate,float finalGrade){
        super(institutionName,enrollmentDate,graduationDate,finalGrade);        
    }

    @Override
    public String getDegree() {
        return "secondary";
    }

        
    @Override
    public String toString(String heOrShe,String hisOrHer){
        String finishedOrSupposed;
        String gradefinished;
        if (!this.graduated) {
            finishedOrSupposed = "is supposed to graduate";
            gradefinished = "";
        } else {
            finishedOrSupposed = "finished";
            gradefinished = String.format(" His grade was %.3f.", this.getFinalGrade());
        }
        return String.format("%s started secondary degree in %s on %s and %s on %s.%s",
                heOrShe,this.getInstitutionName(),this.getEnrollmentDate().toString(),
                finishedOrSupposed,this.getGraduationDate().toString(),gradefinished);
    }
    
}
