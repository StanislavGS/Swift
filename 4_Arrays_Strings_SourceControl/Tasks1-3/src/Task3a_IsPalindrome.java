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
public class Task3a_IsPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        //String st="alabala";
        //String st="abbaabba";
        
        int n=st.length();
        boolean isPalindrome=true;
        int i=0;
        for (i=0;i<n/2;i++){
            if (st.charAt(i)!= st.charAt(n-i-1)){
                isPalindrome=false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }

}
