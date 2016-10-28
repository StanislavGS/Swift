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
public class Task1a_PrintFirstDigit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        long n=sc.nextLong();
        //long n=1381;
        //long n=85851;
        
        
        while (n>9){
            n/=10;
        }
        
        System.out.println(n);
    }
    
}
