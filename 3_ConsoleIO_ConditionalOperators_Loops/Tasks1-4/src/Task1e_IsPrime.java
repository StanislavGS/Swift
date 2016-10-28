/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Stanislav Stanslavov
 */
public class Task1e_IsPrime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        long n=sc.nextLong();
        //long n=3;
        //long n=5;
        //long n=12;
        
        boolean isPrime=true;
        long maxDivizor=(long) sqrt(n);
        for (long i=2;i<=maxDivizor;i++){
            if(n % i ==0){
                isPrime=false;
                break;
            }
        }
        
        System.out.println(isPrime);
    }
    
}
