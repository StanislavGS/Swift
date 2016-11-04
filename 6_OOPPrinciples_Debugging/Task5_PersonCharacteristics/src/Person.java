
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t
 */
public class Person {
    String firstName;
    String lastName;
    char gender;
    LocalDate dateOfBirth;
    float heigh;
    SecondaryEducation secondaryEducation;
    
    
    public Person(String st){
        String[] s1=st.split(";");
        firstName=s1[0];
        lastName=s1[1];
        gender=s1[2].trim().charAt(0);
        heigh=Float.parseFloat(s1[3]);
        dateOfBirth=LocalDate.parse(s1[4].trim(), DateTimeFormatter.ofPattern("d.M.y"));
        double finalgrade;
        if(s1.length>8){
            finalgrade=Double.parseDouble(s1[8]);
        }else{
            finalgrade=-1;
        }
        secondaryEducation=new SecondaryEducation(s1[5], 
                        LocalDate.parse(s1[6].trim(), DateTimeFormatter.ofPattern("d.M.y")),
                        LocalDate.parse(s1[7].trim(), DateTimeFormatter.ofPattern("d.M.y")), 
                        finalgrade);
       
    }
    char getGender(){
        return gender;
    }
    public void printf(){
        int yearOfBirth=dateOfBirth.getYear();
        String heOrShe,hisOrHer;
        if(getGender()=='M' || getGender()=='m'){
            heOrShe="He";
            hisOrHer="His";
        }else{
            heOrShe="She";
            hisOrHer="Her";            
        }
        String finishedOrSupposed;
        if(secondaryEducation.getGraduationDate().compareTo(LocalDate.now())>0){
            finishedOrSupposed="is supposed to graduate";
        }else{
            finishedOrSupposed="finished";
        }
        String gradeOrUnderAged;
        if (secondaryEducation.getGraduated()){
            gradeOrUnderAged=String.format("with a grade of %.3f.", secondaryEducation.getFinalGrade());
        }else{
            if(LocalDate.now().getYear()-yearOfBirth<18){
                gradeOrUnderAged=String.format(". %s %s is under-aged.", firstName,lastName);
            }else{
                gradeOrUnderAged=".";
            }
        }
        
        System.out.printf("%s %s is %d years old. %s was born in %d." +
                " %s started %s on %s and %s on %s %s%n",
                firstName,lastName,LocalDate.now().getYear()-yearOfBirth,
                heOrShe, yearOfBirth,
                heOrShe,secondaryEducation.getInstitutionName(),
                secondaryEducation.getEnrollmentDate().toString(),
                finishedOrSupposed,secondaryEducation.getGraduationDate().toString(),
                gradeOrUnderAged);
    }
}
