
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t
 */
public class Task0c_PrintString {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        
        String st=sc.nextLine();                
        for(int i=0;i<st.length();i++){             
            System.out.println(st.charAt(i));
        }
    }
}
