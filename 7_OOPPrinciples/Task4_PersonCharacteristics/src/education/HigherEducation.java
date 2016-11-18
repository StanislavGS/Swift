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
}
