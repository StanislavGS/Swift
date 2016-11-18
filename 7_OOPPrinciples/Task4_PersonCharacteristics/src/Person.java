
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
    String lastName;
    char gender;
    LocalDate dateOfBirth;
    float heigh;
    Object education;

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

        String finishedOrSupposed;
        String gradefinished;
        if (((Education) education).getGraduationDate().compareTo(LocalDate.now()) > 0) {
            finishedOrSupposed = "is supposed to graduate";
            gradefinished = "";
        } else {
            finishedOrSupposed = "finished";
            gradefinished = String.format(" His grade was %.3f.", ((GradedEducation) education).getFinalGrade());
        }

        String underAged;
        if (LocalDate.now().minusYears(18).compareTo(dateOfBirth) >= 0) {
            underAged = "";
        } else {
            underAged = String.format(" %s %s is under-aged.", firstName, lastName);
        }
        return String.format("%s %s is %d years old. %s was born in %d."
                + " %s started %s degree in %s on %s and %s on %s.%s%s",
                firstName, lastName, LocalDate.now().getYear() - yearOfBirth,
                heOrShe, yearOfBirth, heOrShe, ((Education) education).getDegree(),
                ((Education) education).getInstitutionName(),
                ((Education) education).getEnrollmentDate().toString(),
                finishedOrSupposed, ((Education) education).getGraduationDate().toString(),
                gradefinished, underAged);
    }
}
