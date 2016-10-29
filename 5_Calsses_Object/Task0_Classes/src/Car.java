/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDateTime;

/**
 *
 * @author t
 */
public class Car {
       String brand;
       String model;
       int powerOfEngine;
       short yearOfMade;
       
       Car(String brand,String model,short yearOfMade,int powerOfengine){
           this.brand=brand;
           this.model=model;
           this.yearOfMade=yearOfMade;
           this.powerOfEngine=powerOfengine;
       }
       byte insuranceCategory(){
           int yearsOld=LocalDateTime.now().getYear()-yearOfMade;
           if(yearsOld<=8){
               return 1;
           }else if(yearsOld<=15){
               return 2;
           }else if(yearsOld<=25){
               return 3;
           }else {
               return 4;
           }
       }
       
       float tax(){
           float taxIndipendetFromPower;
           switch(insuranceCategory()){
               case 1: 
                   taxIndipendetFromPower= 150f;
                   break;
               case 2: 
                   taxIndipendetFromPower= 200f;
                   break;
               case 3: 
                   taxIndipendetFromPower= 300f;
                   break;
               case 4: 
                   taxIndipendetFromPower= 500f;
                   break;
               default:
                   taxIndipendetFromPower=0f;
           }
           if (powerOfEngine<80){
               return taxIndipendetFromPower*1.2f;
           } else if(powerOfEngine>140){
               return (taxIndipendetFromPower*1.45f);
           } else{
               return (taxIndipendetFromPower);
           }
       }
    
}
