/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
abstract class Customer implements Comparable<Object>{
    private String name;
    Object account;//In condition for this task a customrer can have only one account
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    Customer(String name){
        setName(name);
    }
    @Override
    public int compareTo(Object otherObject){
        return this.getName().compareTo(((Customer) otherObject).getName());
    }
}
