/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_datedifference;

import java.time.LocalDateTime;

/**
 *
 * @author t
 */
public class SwiftDate {

    short year;
    byte month;
    byte day;

    void setMonth(byte month) {
        if (month < 1) {
            System.out.println("Entered value is " + month
                    + ". The month must be more or equal to 1. Accepted value is 1.");
            this.month = 1;
        } else if (month > 12) {
            System.out.println("Entered value is " + month
                    + ". The month must be less or equal to 12. Accepted value is 12.");
            this.month = 12;
        } else {
            this.month = month;
        }
    }
    
    
    void setDay(byte day){
        byte maxDayOfMonth=31;
        if (month==4 || month==6 || month==9 || month==11){
            maxDayOfMonth=30;
        }
        if (month==2){
            maxDayOfMonth=  isLeapYear()?(byte) 29:(byte) 28;
        }
        if (day < 1) {
            System.out.println("Entered value is " + day
                    + ". The day must be more or equal to 1. Accepted value is 1.");
            this.day = 1;
        } else if (day > maxDayOfMonth) {
            System.out.println("Entered value is " + day
                    + ". The days in month" + month + " are " + maxDayOfMonth+ 
                    ". Accepted value is "+maxDayOfMonth);
            this.day = maxDayOfMonth;
        } else {
            this.day =day;
        }
    }
    
    SwiftDate() {
        year = (short) LocalDateTime.now().getYear();
        month = (byte) LocalDateTime.now().getMonthValue();
        day = (byte) LocalDateTime.now().getDayOfMonth();
    }

    SwiftDate(short year) {
        this.year = year;
        month = 1;
        day = 1;
    }
    
    SwiftDate(short year, byte month) {
        this.year = year;
        setMonth(month);
        day = 1;
    }
    
    SwiftDate(short year, byte month,byte day) {
        this.year = year;
        setMonth(month);
        setDay(day);
    }
    
    boolean isLeapYear(){
        return (year % 4 ==0 && year % 400 !=100 && year % 400 !=200 && year % 400 !=300);
    }
    
    int getCentury(){
        return (year /100 +1);
    }
    
    int daysFromChristBirth(){
        int days=(year-1)*365;
        days+=(year-1)/4+1; //Added a day per all years that is divide to 4 include 0
        days-=((year-1) /100);//Substract a day per hundred years
        days+=((year-1) /400);
        int[] daysInMonthsBefore={0,31,59,90,120,151,181,212,243,273,304,334};
        days+=daysInMonthsBefore[month-1];
        if (isLeapYear() && month>2){
            days++;
        }
        days+=day;
        return days;
    }
    
    int getDaysDifference(SwiftDate other){
        return daysFromChristBirth()-other.daysFromChristBirth();
    }
    
    void printInfo(){
        System.out.printf("%4d %2d %2d - <%d> century%s%n", 
                            year,month, day,getCentury(),
                            isLeapYear() ? ".[ It is LEAP year.]":".");
    }
}
