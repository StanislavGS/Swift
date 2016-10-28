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
public class Task2f_LargestSumOfKSubsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        if (k>n) {
            System.out.println("Некоректно въведени данни.");
            System.exit(0);
        }
        int[] task2f=new int[n];
        for(int i=0;i<n;i++){
           task2f[i] = sc.nextInt();
        }        
        //int[] task2f={9,8,1,2,6,11,4,8,9,3};
        //int n=task2f.length,k=5;
        
        int i,index=k-1,maxSum=0;
        for(i=0;i<k;i++){
            maxSum+=task2f[i];
        }
        int curSum=maxSum;
        for (i=k;i<n;i++){            
            curSum-=task2f[i-k];
            curSum+=task2f[i];
            if (maxSum<curSum){
                maxSum=curSum;
                index=i;                
            }
        }
        for (i=index-k+1;i<=index;i++){
            System.out.print(task2f[i]+" ");
        }
        System.out.println();
        
        
    }
    
}
