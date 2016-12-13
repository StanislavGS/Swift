package task3_personcharacteristics;


import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import education.Education;
import education.GradedEducation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
    public enum Gender {
        Male,
        Female;
    }
    
    
    
    String firstName;
    String middleName;
    String lastName;
    Gender gender;
    LocalDate dateOfBirth;
    float heigh;
    List<Object> education;
    Address currentAddress;
    List<Address> pastAddresses;

    public Person(String firstName, String middleName, String lastName, Gender gender, LocalDate dateOfBirth, float heigh,
            Object education, Address address) {
        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty <first,last,...> name.");
        }
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        /*if (gender != 'M' && gender != 'F') {
            throw new IllegalArgumentException("Expected M or F for gender.");
        }*/
        this.gender = gender;
        if (dateOfBirth.compareTo(LocalDate.of(1900, 1, 1)) < 0
                || dateOfBirth.compareTo(LocalDate.now()) > 0) {
            throw new IllegalArgumentException("Date of birth is expected to be after 01.01.1900 and before now.");
        }
        this.dateOfBirth = dateOfBirth;
        if (heigh < 40 || heigh > 300) {
            throw new IllegalArgumentException("Expected height is between 40 and 300 cm.");
        }
        this.heigh = heigh;
        this.education = new ArrayList<>();
        this.education.add(education);
        this.pastAddresses = new ArrayList<>();
        this.currentAddress = address;
    }

    Gender getGender() {
        return gender;
    }

    public void addEducation(Education education) {
        this.education.add(education);
    }

    public void removeEducation(String institutionName, LocalDate enrollmentDate, LocalDate graduationDate) {
        PrimaryEducation trash = new PrimaryEducation(institutionName, enrollmentDate, graduationDate);
        this.education.remove(trash);

    }
    
    public  void removeEducation(Object o){
        this.education.remove(o);
    }

    public void changeAddress(Address address) {
        this.pastAddresses.add(currentAddress);
        Address trash = new Address("", "", "", 0, "", "");
        trash = this.currentAddress;
        this.pastAddresses.add(trash);
        this.currentAddress = address;
    }

    @Override
    public String toString() {

        int yearOfBirth = dateOfBirth.getYear();
        String heOrShe, hisOrHer;
        if (getGender() == Gender.Male) {
            heOrShe = "He";
            hisOrHer = "His";
        } else {
            heOrShe = "She";
            hisOrHer = "Her";
        }

        String underAged;
        if (LocalDate.now().minusYears(18).compareTo(dateOfBirth) >= 0) {
            underAged = "";
        } else {
            underAged = String.format("%s %s is under-aged.%n", firstName, lastName);
        }
        String educations="";
        /*
        ListIterator<Object> it=this.education.listIterator();
        while(it.hasNext()){
            educations+=it.next().toString();
        }*/
        
        for(Object edu:this.education){
            if (edu instanceof HigherEducation){
                HigherEducation trash=((HigherEducation) edu);
                educations+=trash.toString(heOrShe,hisOrHer)+"\n";
            } else if (edu instanceof SecondaryEducation){
                SecondaryEducation trash=((SecondaryEducation) edu);
                educations+=trash.toString(heOrShe,hisOrHer)+"\n";
            } else if (edu instanceof PrimaryEducation){
                PrimaryEducation trash=((PrimaryEducation) edu);
                educations+=trash.toString(heOrShe,hisOrHer)+"\n";
            }
            
        }
        
        return String.format("%s %s %s is %d years old. %s was born in %d.%n"
                + "%s%s lives at:%n%s%s",
                firstName, middleName, lastName, LocalDate.now().getYear() - yearOfBirth,
                heOrShe, yearOfBirth, underAged, heOrShe, this.currentAddress.toString(),
                educations);
    }
}
