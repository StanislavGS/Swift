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
public class Task2d_PrintSplitIndex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        
        
        int n = sc.nextInt();
        int[]task2d=new int[n];
        for(int i=0;i<n;i++){
          task2d[i] = sc.nextInt();
        }        
        //int[]task2d={1,2,3,4,9,1};
        //int n=task2d.length;
        
        
        //Първи начин
        int sumRight=0,sumLeft=0;
        int i=0,j=n-1,idx=i;
        while (j>=i){
            if (sumRight>sumLeft){
                sumLeft+=task2d[i];i++;idx=j;
            }else{
                sumRight+=task2d[j];j--;idx=i-1; 
            }
        }
        if (sumRight==sumLeft){
            System.out.println(idx);
        }else{
            System.out.println("NO");
        }
        
        
        
        //Втори начин - по дървен
        /*
        int sumRight=0,sumLeft=0;
        for (int i=0;i<n;i++){
            sumRight+=task2d[i];
        }
        for (int i=0;i<n;i++){
            sumLeft+=task2d[i];sumRight-=task2d[i];
            if (sumLeft==sumRight){
                System.out.println(i);break;
            }
            if (sumLeft>sumRight){
                System.out.println("NO");break;
            }
        }      
        */
        
    }
    
}
