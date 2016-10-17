/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_LeapYear {
    public static void main(String[] args){
        //Exercize  -  Task2_LeapYear  - a SGS
        int years[]={2016,1992,2001,1900,2400};
        for(int i=0;i<years.length;i++){
            System.out.println("Година" + years[i]+" е "+Task2_LeapYear(years[i]));
        }
    }
    //Exercize  -  Task2_LeapYear - method
    private static String Task2_LeapYear(int year){
        int yearMod400=year % 400;
        return ((year % 4 == 0)&&(yearMod400 != 100)&&(yearMod400 != 200)&&(yearMod400 != 300)?"Високосна":"Невисокосна");
    }
    
}
