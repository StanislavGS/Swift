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

    String firstName;
    String lastName;

    String getFirstName() {
        return this.firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }
    Person(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

}
