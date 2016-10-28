/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author Stanislav Stanslavov
 */
public class Task1f_ToBinaryAndHexa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        //long n=sc.nextLong();
        //long n=15;
        //long n=231281;
        long n=222222222;
        //long n=31;
        
        String stBinary="", stHex="";
        byte forHex=0, hex=0,pow=1;
        while (n>0){
            stBinary=n % 2 + stBinary;
            hex+=(n % 2)*pow;            
            n/=2;
            pow<<=1;
            if (forHex<3 && n>0){
                forHex++;
            }else{
                forHex=0;
                if (hex<10){
                    stHex=hex+stHex;
                }else{
                    stHex=(char) (hex-10 + (int)'A' )+stHex;
                }
                hex=0;pow=1;
            }
        }
        
        System.out.println(stBinary);
        System.out.println(stHex);
    }
    
}
