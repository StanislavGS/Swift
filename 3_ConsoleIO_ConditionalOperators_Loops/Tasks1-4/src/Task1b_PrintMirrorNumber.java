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
public class Task1b_PrintMirrorNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        long n=sc.nextLong();
        //long n=5612;
        //long n=12321;
        
        long nTurned=0;
        while (n>0){
            nTurned=10*nTurned+n % 10;
            n/=10;
        }
        
        System.out.println(nTurned);
    }
    
}
