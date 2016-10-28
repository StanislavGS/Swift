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
public class Task1d_PrintAllDivisors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        //long n=sc.nextLong();
        long n=48;
        //long n=13;
        
        System.out.print("1 ");
        for (long i=2;i<=n/2;i++){
            if(n % i ==0){
                System.out.print(i + " ");
            }
        }
        System.out.print(n + " ");
        System.out.println();
    }
    
}
