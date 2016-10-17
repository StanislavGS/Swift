/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task3_CalculateExpression {
    public static void main(String[] args){
         //Exercize  -  Task3_CalculateExpression - a SGS
        double a=(3291+88581);
        a/=14;
        a+=(1116 % 171)*5;
        a-=312.0/(4+18);        
        System.out.println("Стойността на израза ( 3291 + 88581 ) / 14 + ( 1116 % 171 ) * 5 – 312 / ( 4 + 18 ) е = на " + a);
        System.out.println("Стойността на израза ( 3291 + 88581 ) / 14 + ( 1116 % 171 ) * 5 – 312 / ( 4 + 18 ) е = на " + 
                (( 3291.0 + 88581 )/14.0 + ((1116 % 171)*5) - 312.0/(4 + 18)));
        //sign '-'ASCII-45 is diferent from text '–' ASCII-150
        
    }
    
}
