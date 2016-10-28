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
public class Task3c_CaesarCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        String encodeSt = sc.nextLine();
        //String st = "I love programming.";
        //String encodeSt = "encode";
        //String st = "J ibuf tusjoht opx.";
        //String encodeSt = "decode";

        if (encodeSt != "encode" && encodeSt != "decode") {
            System.out.println("Bad Input");
            System.exit(0);
        }

        int n = st.length();
        String codedSt = "";

        for (int i = 0; i < n; i++) {
            char c=st.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if(encodeSt.equals("encode")){
                    if (c!='z' && c!='Z'){
                        c=(char) ((int) c+1);
                    }else if(c=='z'){
                        c='a';
                    }else{
                        c='A';
                    }
                }else{
                    if (c!='a' && c!='A'){
                        c=(char) ((int) c-1);
                    }else if(c=='a'){
                        c='z';
                    }else{
                        c='Z';
                    }
                }
                
            }

            codedSt += c;
        }

        System.out.println(codedSt);

    }

}
