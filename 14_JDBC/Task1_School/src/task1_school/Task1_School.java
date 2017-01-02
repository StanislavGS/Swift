/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_school;
import Objects.*;
import dataBaseTransfer.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author stanislav
 */
public class Task1_School {
public static void main(String[] args) {
        TaskFunctions.insertTeacher(new Teacher("Peatar Toshev","petar.toshev@gmail.com",1450,
                new Address("Bulgaria","Sofia","rd. Gotse Deltchev","125-B",3,15)));
        
        Teacher teacher= TaskFunctions.getTeacher(2);
        ArrayList<Teacher> teachers=TaskFunctions.teachersWithSpSalary(1000,2000);
        TaskFunctions.insertStudent("Ivancho Mladenov",new  LocalDate(1.1.2017), 
                new Address("Bulgaria","Sofia","Pirotska","175",2,3));
        
    }
    
}
