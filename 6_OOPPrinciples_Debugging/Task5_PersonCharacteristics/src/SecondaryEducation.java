
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
public class SecondaryEducation {
    double finalGrade;
    boolean graduated;
    private LocalDate enrollmentDate;
    LocalDate graduationDate;
    private String institutionName;
    
    void setFinalGradeAndGraduated(double finalGrade,boolean graduated){
        this.finalGrade=finalGrade;
        this.graduated=graduated;
    }
    void setGraduationDate(LocalDate graduationDate){
        this.graduationDate=graduationDate;
    }
    
    double getFinalGrade(){
        return finalGrade;
    }
    boolean getGraduated(){
        return graduated;
    }
    LocalDate getEnrollmentDate(){
        return enrollmentDate;
    }
    LocalDate getGraduationDate(){
        return graduationDate;
    }
    String getInstitutionName(){
        return institutionName;
    }
    SecondaryEducation(String institutionName,LocalDate enrollmentDate,
                            LocalDate graduationDate,double finalGrade){
        this.institutionName=institutionName;
        this.enrollmentDate=enrollmentDate;
        setGraduationDate(graduationDate);
        setFinalGradeAndGraduated(finalGrade,finalGrade>=0.00);
    }
    
    
}
