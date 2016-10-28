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
public class Task2a_PrintLargestNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        
        int n = sc.nextInt();
        int[] task2a=new int[n];
        for(int i=0;i<n;i++){
           task2a[i] = sc.nextInt();
        }        
        //int[] task2a={21,8,11,-1,-3,55,4,19,5,-6,0};
        //int n=task2a.length;
        
        int max=task2a[0];
        for (int i=1;i<n;i++){
            if (max<task2a[i]){
                max=task2a[i];
            }
        }
        System.out.println(max);
        
        
    }
    
}
