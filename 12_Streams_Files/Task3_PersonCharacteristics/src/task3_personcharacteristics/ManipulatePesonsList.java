package task3_personcharacteristics;

import education.Education;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class ManipulatePesonsList {

    public static void addPerson (String[] s1,ArrayList<Person> persons ){
        
            Address address;
            if (!s1[12].trim().equals("") && !s1[13].trim().equals("")) {
                address = new Address(s1[6], s1[7], s1[8], Integer.parseInt(s1[9]), s1[10], s1[11],
                        Integer.parseInt(s1[12]), Integer.parseInt(s1[13]));
            } else if (s1[12].trim().equals("") && s1[13].trim().equals("")) {
                address = new Address(s1[6], s1[7], s1[8], Integer.parseInt(s1[9]), s1[10], s1[11]);
            } else {
                address = new Address(s1[6], s1[7], s1[8], Integer.parseInt(s1[9]), s1[10], s1[11], Integer.parseInt(s1[12]));
            }
            try {
                Object education = null;
                LocalDate graduationDate = LocalDate.parse(s1[17], DateTimeFormatter.ofPattern("d.M.y"));
                float grade = 0f;
                if (s1[14].trim().toUpperCase() != "P" && graduationDate.compareTo(LocalDate.now()) <= 0) {
                    grade = Float.parseFloat(s1[18]);
                }
                switch (s1[14].trim().toUpperCase()) {
                    case "P":
                        education = new PrimaryEducation(s1[15],
                                LocalDate.parse(s1[16], DateTimeFormatter.ofPattern("d.M.y")),
                                graduationDate);
                        break;
                    case "S":
                        education = new SecondaryEducation(s1[15],
                                LocalDate.parse(s1[16], DateTimeFormatter.ofPattern("d.M.y")),
                                graduationDate, grade);
                        break;
                    case "B":
                        education = new HigherEducation(s1[15],
                                LocalDate.parse(s1[16], DateTimeFormatter.ofPattern("d.M.y")),
                                graduationDate, grade, Education.EducationDegree.Bachelor);
                        break;
                    case "M":
                        education = new HigherEducation(s1[15],
                                LocalDate.parse(s1[16], DateTimeFormatter.ofPattern("d.M.y")),
                                graduationDate, grade, Education.EducationDegree.Master);
                        break;
                    case "D":
                        education = new HigherEducation(s1[15],
                                LocalDate.parse(s1[16], DateTimeFormatter.ofPattern("d.M.y")),
                                graduationDate, grade, Education.EducationDegree.Doctorate);
                        break;
                    default:
                        throw new IllegalArgumentException("Unrecognized education code.");
                }
                Person.Gender readGender;
                if (s1[3].trim().toLowerCase().charAt(0)=='m'){
                    readGender=Person.Gender.Male;
                }else if(s1[3].trim().toLowerCase().charAt(0)=='f'){
                    readGender=Person.Gender.Female;
                }else{
                    throw new IllegalArgumentException("Bad genger.");
                }
                persons.add(  new Person(s1[0], s1[1], s1[2], readGender,
                        LocalDate.parse(s1[4], DateTimeFormatter.ofPattern("d.M.y")),
                        Float.parseFloat(s1[5]), education, address));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());

            }
        

        

    }
}
