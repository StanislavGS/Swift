/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author t
 */
public class Person {
    String name;
    int years;
    
    public Person(){
        name="No name";
        years=-1;
    }
    
    public Person(String nameValue){
        name=nameValue;
        years=-1;
    }
    
    public Person(String nameValue,int yearValue){
        setName(nameValue);
        setYears(yearValue);
    }
    String getName(){
        return name;
    }
    void setName(String name){
        this.name=name;
    }
    int getYears(){
        return years;
    }
    void setYears(int years){
        this.years=years;
    }
    String sayHello(){
        if (name=="No name"){
            return "I am John Doe";
        }
        String st="Hello, I am "+name;
        if (years<0){
            return st;
        }else{
            return st+String.format(". I am %d years old.", years);
        }
        /*return String.format("%s I am %s.%s", 
                name=="No name"?"":"Hello, ",
                name=="No name"?"John doe":name,
                years<0?"":String.format(" I am %d years old.", years));
        */
    }
    
}
