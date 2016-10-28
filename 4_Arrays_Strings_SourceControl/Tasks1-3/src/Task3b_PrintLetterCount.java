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
public class Task3b_PrintLetterCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        //String st="Programming";
        
        int n=st.length();
        st=st.toLowerCase();
        int[] count=new int[(int)'z'-'a'+1];       
        
        for(int i=0;i<n;i++){
            count[(int) st.charAt(i)-'a']++;
        }
        for(int i=0;i<='z'-'a';i++){
            if(count[i]>0){
                System.out.printf("%s(%d)%n",(char) ((int)'a'+i),count[i]);
            }
        }
        
                
    }

}
