/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stanislav Stanislavov
 */
public class Employee {
    String name;
    Double salary;
    String position;
    String department;
    int age;
    String email;
    
    String getName(){
        return name;
    }
    
    Double getSalary(){
        return salary;
    }
    
    String getPosition(){
        return position;
    }
    
    String getDepartment(){
        return department;
    }
    
    int getAge(){
        return age;
    }
    
    String getEmail(){
        return email;
    }
    
    void setName(String name){
        this.name=name;
    }
    
    void setSalary(Double salary){
        this.salary=salary;
    }
    
    
    void setPosition(String position){
        this.position=position;
    }
    
    void setDepartment(String department){
        this.department=department;
    }
    
    void setAge(int age){
        this.age=age;
    }
    
    void setEmail(String email){
        this.email=email;
    }
    
    Employee(String name,Double salary,String position,String department){
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setAge(0);
        setEmail("");
    }
}
