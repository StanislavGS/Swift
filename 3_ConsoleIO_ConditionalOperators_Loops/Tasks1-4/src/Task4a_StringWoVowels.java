/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task4a_StringWoVowels {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
       
        //String st = "Peter loves dogs";
        
        
        String stWithoutVolews="";
        int n = st.length();
        for (int i = 0; i < n; i++) {
            char c=st.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' &&
                    c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U') {
                stWithoutVolews+=c;                
            }
        }
        System.out.println(stWithoutVolews);
    }

}
