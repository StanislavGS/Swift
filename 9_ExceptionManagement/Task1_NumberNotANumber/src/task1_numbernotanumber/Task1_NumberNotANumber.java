/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_numbernotanumber;

import java.util.Scanner;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task1_NumberNotANumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String st;
        do{
            st=sc.nextLine();
            try{
                int i=Integer.parseInt(st);
                System.out.println("Number");
            }catch(NumberFormatException ex){
                System.out.println("Not a number");
            }
            
        }while(!st.trim().equalsIgnoreCase("end"));
    }    
}
