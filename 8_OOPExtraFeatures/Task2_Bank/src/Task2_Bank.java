
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_Bank {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st;
        Bank thisbank=new Bank("Task2Bank");
        do{
            st=sc.nextLine();
            String[] s=st.split(" ");
            switch(s[0]){
                case "OPEN":
                    System.out.println(thisbank.openAccount(Arrays.copyOfRange(s, 1, s.length)));
                    break;
                case "PUT":
                    if(!thisbank.putInAccount(s[1],s[2])){
                        System.out.println("Bad operation \"PUT\"");
                    }
                    break;
                case "GET":
                    if(!thisbank.getFromAccount(s[1],s[2])){
                        System.out.println("Bad operation \"GET\"");
                    }
                    break;
                case "INFO":
                    System.out.println(thisbank.infoForAccount(s[1],s[2]));                    
            }
        }while(!st.trim().equalsIgnoreCase("end"));
    }
    
}
