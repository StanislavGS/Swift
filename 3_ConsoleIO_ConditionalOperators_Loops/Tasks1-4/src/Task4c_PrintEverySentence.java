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
public class Task4c_PrintEverySentence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //String st = sc.nextLine();
        String st = "Peter loves dogs. He doesn’t like cats. Maria likes cats";
        

        String oneLine = "";
        int n = st.length();
        for (int i = 0; i < n; i++) {
            char c = st.charAt(i);
            oneLine += c;
            if(oneLine.equals(" ")){
                oneLine="";
            }
            if (c == '.' || c == '!' || c == '?') {
                if (!oneLine.equals("")) {
                    System.out.println(oneLine);
                    oneLine="";
                }
            } 
        }
        if (!oneLine.equals("")) {
            System.out.println(oneLine);
        }

    }

}
