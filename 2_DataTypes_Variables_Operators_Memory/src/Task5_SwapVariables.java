/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task5_SwapVariables {
    public static void main(String[] args){
        //Exercize  - Task5_SwapVariables - a SGS
        int variablesForSwap[]={5,9,11,7};
        for(int i=0;i<variablesForSwap.length;i+=2){
            int a=variablesForSwap[i];
            int b=variablesForSwap[i+1];
            System.out.print("Вариант1 - Преди размяната " + a + " " +b);
            int m=a;
            a=b;
            b=m;
            System.out.println("    След размяната "+ a + " " + b);        
            a=variablesForSwap[i];
            b=variablesForSwap[i+1];
            System.out.print("Вариант2 - Преди размяната "+ a + " " +b);
            a=a+b;
            b=a-b;
            a=a-b;
            System.out.println("    След размяната "+ a + " " +b);
        }
    }
    
}
