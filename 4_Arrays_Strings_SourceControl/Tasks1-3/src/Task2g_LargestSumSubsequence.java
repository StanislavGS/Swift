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
public class Task2g_LargestSumSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] task2g=new int[n];
        for(int i=0;i<n;i++){
           task2g[i] = sc.nextInt();
        }        
        //int[] task2g = {4, 7, -3, -11, 2, 9, -4, 5, 6, -8, 0, 5};
        //int n = task2g.length;

        
        //Първи начин - по елегантен според мен
        int maxSumTotal = task2g[0], maxSumTotalIndex1 = 0, maxSumTotalIndex2 = 1;
        int minSum=task2g[0],minSumIndex=0;
        int maxSum=task2g[0],maxSumIndex=0;
        int currentSum=task2g[0];
        for(int i=0;i<n;i++){
            currentSum+=task2g[i];
            if (minSum>currentSum){
                minSum=currentSum;
                minSumIndex=i;
            }
            if (maxSum<currentSum){
                maxSum=currentSum;
                maxSumIndex=i;            
                if (maxSumIndex>minSumIndex){
                    if(maxSumTotal<(maxSum-minSum)){
                         maxSumTotalIndex1 = minSumIndex;
                         maxSumTotalIndex2 = maxSumIndex;
                    }
                }
                
            }
        }
        for (int i = maxSumTotalIndex1 + 1; i <= maxSumTotalIndex2; i++) {
            System.out.print(task2g[i] + " ");
        }
        System.out.println();
        
        //Втори начин 
        /*
        int k, maxSum = task2g[0], maxSumIndex = 0, maxSumLength = 1;
        for (k = 1; k <= n; k++) {
            int i, index = k - 1, currentMaxSum = 0;
            for (i = 0; i < k; i++) {
                currentMaxSum += task2g[i];
            }
            int curSum = currentMaxSum;
            for (i = k; i < n; i++) {
                curSum -= task2g[i - k];
                curSum += task2g[i];
                if (currentMaxSum < curSum) {
                    currentMaxSum = curSum;
                    index = i;
                }
            }
            if (maxSum<currentMaxSum){
                maxSum=currentMaxSum;
                maxSumIndex=index;
                maxSumLength=k;
            }
        }
        for (int i = maxSumIndex - maxSumLength + 1; i <= maxSumIndex; i++) {
            System.out.print(task2g[i] + " ");
        }
        System.out.println();
        
        */
        
    }

}
