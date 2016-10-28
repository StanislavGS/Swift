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
public class Task4d_SumOfNumbersInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        //String st = "Helen has 3 dogs and 11 cats";
        

        int sum=0,number=0;
        //boolean isDigit=false;
        
        int n = st.length();
        for (int i = 0; i < n; i++) {
            char c = st.charAt(i);
            if(c>='0' && c<='9'){
                number=number*10+c-'0';                
            }else{
                sum+=number;
                number=0;
            }
        }
        System.out.println(sum);
       
    }

}
