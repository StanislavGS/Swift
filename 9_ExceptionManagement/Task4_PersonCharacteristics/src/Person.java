
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import education.Education;
import education.GradedEducation;
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
    String middleName;
    String lastName;
    char gender;
    LocalDate dateOfBirth;
    float heigh;
    Object education;
    Address address;

    
    public Person(String firstName,String middleName, String lastName,char gender,LocalDate dateOfBirth,float heigh,
            Object education,Address address){
        if(firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty()){
            throw new IllegalArgumentException("Expected non-empty <first,last,...> name.");
        }
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        if(gender!='M'&& gender!='F'){
            throw new IllegalArgumentException("Expected M or F for gender.");
        }
        this.gender=gender;
        if(dateOfBirth.compareTo(LocalDate.of(1900,1,1))<0 ||
                    dateOfBirth.compareTo(LocalDate.now())>0){
            throw new IllegalArgumentException("Date of birth is expected to be after 01.01.1900 and before now.");
        }
        this.dateOfBirth=dateOfBirth;
        if (heigh<40 || heigh>300){
            throw new IllegalArgumentException("Expected height is between 40 and 300 cm.");
        }
        this.heigh=heigh;
        this.education=education;
        this.address=address;
    }
    /*
    public Person(String st) {
        String[] s1 = st.split(";");
        firstName = s1[0];
        lastName = s1[1];
        gender = s1[2].trim().charAt(0);
        heigh = Float.parseFloat(s1[3]);
        dateOfBirth = LocalDate.parse(s1[4].trim(), DateTimeFormatter.ofPattern("d.M.y"));

        float grade = -1;
        LocalDate graduationDate = LocalDate.parse(s1[8].trim(), DateTimeFormatter.ofPattern("d.M.y"));
        if (!s1[5].trim().equals("P") && graduationDate.compareTo(LocalDate.now()) < 0) {
            grade = Float.parseFloat(s1[9]);
        }
        switch (s1[5].trim()) {
            case "P":
                education = new PrimaryEducation(s1[6], LocalDate.parse(s1[7].trim(), DateTimeFormatter.ofPattern("d.M.y")),
                        graduationDate);
                break;
            case "S":
                education = new SecondaryEducation(s1[6], LocalDate.parse(s1[7].trim(), DateTimeFormatter.ofPattern("d.M.y")),
                        graduationDate, grade);
                break;
            case "B":
                education = new HigherEducation(s1[6], LocalDate.parse(s1[7].trim(), DateTimeFormatter.ofPattern("d.M.y")),
                        graduationDate, grade, "bachelor");
                break;
            case "M":
                education = new HigherEducation(s1[6], LocalDate.parse(s1[7].trim(), DateTimeFormatter.ofPattern("d.M.y")),
                        graduationDate, grade, "master");
                break;
            case "D":
                education = new HigherEducation(s1[6], LocalDate.parse(s1[7].trim(), DateTimeFormatter.ofPattern("d.M.y")),
                        graduationDate, grade, "doctorate");                

        }
    }
    */
    char getGender() {
        return gender;
    }

    @Override
    public String toString() {

        int yearOfBirth = dateOfBirth.getYear();
        String heOrShe, hisOrHer;
        if (getGender() == 'M' || getGender() == 'm') {
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
        return String.format("%s %s %s is %d years old. %s was born in %d.%n"
                + "%s%s lives at:%n%s%s",
                firstName,middleName, lastName, LocalDate.now().getYear() - yearOfBirth,
                heOrShe, yearOfBirth, underAged, heOrShe,this.address.toString(),
                ((Education) this.education).toString(heOrShe,hisOrHer));
    }
}
