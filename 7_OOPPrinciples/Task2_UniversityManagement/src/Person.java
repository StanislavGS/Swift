/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class Person {

    String name;
    String phone;

    String getFirstName() {
        return this.name;
    }

    void setFirstName(String name) {
        this.name = name;
    }

    String getLastName() {
        return this.phone;
    }

    void setLastName(String phone) {
        this.phone = phone;
    }
    Person(String name,String phone){
        this.name=name;
        this.phone=phone;
    }

}
