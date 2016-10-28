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
public class Task2c_PrintOnlyEvenNumbers {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        
        int n=sc.nextInt();
        String list="";
        
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            if (num %2==0){
                list+=((list=="")?"":" ") +num;
                //list+=" " +num;
            }
        }
        System.out.println(list);
    }
    
}
