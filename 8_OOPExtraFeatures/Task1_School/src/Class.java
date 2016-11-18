
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Class extends SchoolObject {

    Student[] students ;
    int numStudents ;

    Class(String name) {
        this.name = name;
        this.disciplines = new Discipline[50];
        this.numDisciplines = 0;
        this.teachers = new Teacher[50];
        this.numTeachers = 0;
        this.students = new Student[50];
        this.numStudents = 0;
    }

    void addStudent(Student student) {
        this.students[numStudents++] = student;
        Arrays.sort(students, 0, numStudents);
        for (int i = 0; i < numStudents; i++) {
            students[i].setNumberInClass(i);
        }
    }

    void removeStudent(int numberStudent) {
        if (numberStudent < numStudents) {
            students[numberStudent] = students[numStudents-- - 1];
            if (numStudents > 1) {
                Arrays.sort(students, 0, numStudents);
                for (int i = 0; i < numStudents; i++) {
                    students[i].setNumberInClass(i);
                }
            }
        }
    }
}
