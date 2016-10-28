/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2b_PrintSortedNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        
        int n = sc.nextInt();
        int[] task2b=new int[n];
        for(int i=0;i<n;i++){
           task2b[i] = sc.nextInt();
        }        
        //int[] task2a={21,8,11,-1,-3,7,4,19,5,-6,0};
        //int n=task2a.length;
        
        Arrays.sort(task2b);
        for (int i=0;i<n;i++){
            System.out.print(task2b[i]+" ");
        }
        System.out.println();
        
        
    }
    
}
