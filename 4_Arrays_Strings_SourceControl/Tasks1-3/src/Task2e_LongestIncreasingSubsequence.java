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
public class Task2e_LongestIncreasingSubsequence {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        
        int n = sc.nextInt();
        int[] task2e=new int[n];
        for(int i=0;i<n;i++){
           task2e[i] = sc.nextInt();
        }        
        //int[] task2e={9,8,1,2,6,11,4,8,9,3};
        //int n=task2e.length;
        
        boolean isInSuseqence=false;
        int maxLengthSubseqence=0,currentLengthSubseqence=0,startIndex=0,indexMaxLengthSubseqence=0;
        for (int i=1;i<n;i++){            
            if (task2e[i]>task2e[i-1]){
                currentLengthSubseqence++;
                if (maxLengthSubseqence<currentLengthSubseqence){
                      maxLengthSubseqence=currentLengthSubseqence;
                      indexMaxLengthSubseqence=startIndex;
                }
            }else{
                currentLengthSubseqence=0;startIndex=i;
            }
        }
        for (int i=indexMaxLengthSubseqence;i<=indexMaxLengthSubseqence+maxLengthSubseqence;i++){
            System.out.print(task2e[i]+" ");
        }
        System.out.println();
        
        
    }
    
}
