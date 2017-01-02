/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.time.LocalDate;

/**
 *
 * @author stanislav
 */
public class Student {
    String name;
    LocalDate enrollmentDate;
    Address address;

    public Student(String name, LocalDate enrollmentDate, Address address) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
        this.address = address;
    }
    
}
