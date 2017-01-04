/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_school;

import Objects.*;
import dataBaseTransfer.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author stanislav
 */
public class Task1_School {

    public static void main(String[] args) {

        try {
            int id1=TaskFunctions.insertTeacher(new Teacher("Peatar Toshev", "petar.toshev@gmail.com", 1450,
                    new Address("Bulgaria", "Sofia", "rd. Gotse Deltchev", "125-B", 3, 19)));

            Teacher teacher = TaskFunctions.getTeacher(2);
            
            ArrayList<Teacher> teachers = TaskFunctions.teachersWithSpSalary(1000, 2000);

            int id2=TaskFunctions.insertStudent("Ivancho Mladenov", LocalDate.of(2016, 9, 15),
                    new Address("Bulgaria", "Sofia", "Pirotska", "175", 2, 3));
            
            Student student=TaskFunctions.getStudent(3);
            
            ArrayList<Student> students=TaskFunctions.getStudents(LocalDate.of(2010 ,1,1));
            
            ArrayList<String> disciplines=TaskFunctions.getDisciplinesByTeacherId(1);
            
            ArrayList<Teacher> teachers1=TaskFunctions.getTeachersByDisciplineName("Mathematics");

        } catch (SQLException ex) {
            while (ex != null) {
                System.out.println(ex.getSQLState());
                System.out.println(ex.getMessage());
                System.out.println(ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }
}
