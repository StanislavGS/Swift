
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
public class Task3_BankManagement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        
        Bank bank=new Bank();
        String command="",st;
        String s1[];
        do{
            st=sc.nextLine();
            s1=st.split(" ");
            if (!s1[0].equals("END")){
                switch (s1[0]){                    
                    case "OPEN":      
                        bank.openAccount(s1[3], s1[4], s1[1], s1[2]);
                        System.out.println(s1[0] +" " + (bank.result?"success":"fail"));
                        break;
                    case "CLOSE":      
                        bank.closeAccount(s1[1], s1[2]);
                        System.out.println(s1[0]+" " +(bank.result?"success":"fail"));
                        break;
                    case "DEPOSIT":      
                        bank.deposit(s1[1],Double.parseDouble(s1[2]));
                        System.out.println(s1[0]+" " +(bank.result?"success":"fail"));
                        break;
                    case "WITHDRAW":      
                        bank.withdraw(s1[1], s1[2], Double.parseDouble(s1[3]));
                        System.out.println(s1[0]+" " +(bank.result?"success":"fail"));
                        break;
                    case "TRANSFER":      
                        bank.transfer(s1[1], s1[2], Double.parseDouble(s1[3]), s1[4]);
                        System.out.println(s1[0]+" " +(bank.result?"success":"fail"));                        
                }
            }
        }while(!s1[0].equals("END"));
        System.out.print(bank.getList());
    }
    
}
