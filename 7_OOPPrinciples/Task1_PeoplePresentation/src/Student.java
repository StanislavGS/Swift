/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Student extends Person {

    private String _facultyNumber;
    private int _lectureCount;
    private int _exerciseCount;

    String getFacultyNumber() {
        return this._facultyNumber;
    }

    void setFacultyNumber(String _facultyNumber) {
        this._facultyNumber = _facultyNumber;
    }

    int getLectureCount() {
        return this._lectureCount;
    }

    void setLectureCount(int _lectureCount) {
        this._lectureCount = _lectureCount;
    }

    int getExerciseCount() {
        return this._exerciseCount;
    }

    void setExerciseCount(int _exerciseCount) {
        this._exerciseCount = _exerciseCount;
    }

    Student(String firstName,String lastName,String _facultyNumber, int _lectureCount, int _exerciseCount) {
        super(firstName,lastName);
        this._facultyNumber = _facultyNumber;
        this._lectureCount = _lectureCount;
        this._exerciseCount = _exerciseCount;
    }
    @Override
    public String toString(){
        return String.format("First name: %s%nLast name: %s%nOccupation: Student%n" +
                            "Faculty number: %s%nHours per day: %.2f%n",
                getFirstName(),getLastName(),getFacultyNumber(),
                (getLectureCount()*2+getExerciseCount()*1.5)/5);
    }

}
