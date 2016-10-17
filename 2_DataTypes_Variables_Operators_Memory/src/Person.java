/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */


//Exercize - Task7_PersonCharacteristics - a SGS
public class Person {
       
    String firstName;
    String lastName;
    int yearOfBirth;
    float weight;
    float height;
    String profession;
    
    Person(String frstNm,String lstNm,int yeaO, float wei,float hei,String prof){
        this.firstName=frstNm;
        this.lastName=lstNm;
        this.yearOfBirth=yeaO;
        this.weight=wei;
        this.height=hei;
        this.profession=prof;
    }
    
    public String Output(){
        return firstName + " " + lastName + " is " + 
                (long)(System.currentTimeMillis()/(1000*60*60*24*365.25)+1970-yearOfBirth)+ 
                " years old. His weight is " +
                weight + " and he is " + height + " cm tall. He is a " + profession +".";
    }
    
    
    
}
