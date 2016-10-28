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
public class Task2c_PrintClusterCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        
        int n = sc.nextInt();
        int[] task2c=new int[n];
        for(int i=0;i<n;i++){
           task2c[i] = sc.nextInt();
        }        
        //int[] task2c={1,1,2,3,3,5,6,6,7,9,9,9,9,10,10};
        //int n=task2c.length;
        
        boolean isInCluster=false;
        int numClusters=0;
        for (int i=1;i<n;i++){
            if (!isInCluster){
                if (task2c[i]==task2c[i-1]){numClusters++;}
            }
            isInCluster=task2c[i]==task2c[i-1];
        }
        System.out.println(numClusters);
        
        
    }
    
}
