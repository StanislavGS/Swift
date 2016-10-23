
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t
 */
public class Task0b_ReadArray {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        
        int length0=sc.nextInt();
        int[] task1=new int[length0];
        for(int i=0;i<task1.length;i++){             
            task1[i]=sc.nextInt();
        }
        //System.out.
        //System.out.println(task1.toString());
        for(int i=0;i<task1.length;i++){             
            System.out.println(task1[i]);
        }
     }    
}
