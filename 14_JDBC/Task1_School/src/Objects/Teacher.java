/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author stanislav
 */
public class Teacher {
    String name;
    String email;
    double salary;
    Address address;

    public Teacher(String name, String email, double salary, Address address) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
    
    
}
