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
public class HigherEducation extends GradedEducation {

    private String degree;

    @Override
    public String getDegree() {
        return this.degree;
    }

    
    
    public HigherEducation(String institutionName,LocalDate enrollmentDate, LocalDate graduationDate,float finalGrade,String degree){
        super(institutionName, enrollmentDate, graduationDate, finalGrade);
        this.degree=degree;
    }
    
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
        return String.format("%s started %s degree in %s on %s and %s on %s.%s",
                heOrShe,this.degree,this.getInstitutionName(),this.getEnrollmentDate().toString(),
                finishedOrSupposed,this.getGraduationDate().toString(),gradefinished);
    }
}
