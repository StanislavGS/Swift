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

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPhone() {
        return this.phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }
    Person(String name,String phone){
        this.name=name;
        this.phone=phone;
    }

}
