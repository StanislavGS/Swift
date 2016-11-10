/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class Employee extends Person{
    double hourSalary;

    public Employee(String name,String phone,double hourSalary) {
        super(name, phone);
        this.hourSalary=hourSalary;
    }
    
}
