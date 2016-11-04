
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
public class Task4_PersonCharacteristics {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
                
        int n = sc.nextInt();
        Person[] persons=new Person[n];
        for(int i=0;i<n;i++){
            String st;
            /*st=sc.nextLine();*/
            
            switch (i){
                case 0:
                    st="Peter,Petrov,M,1985,89.9,184,miner,4.5,4,3.75,4.25";
                    break;
                case 1:
                    st="Ivan,Ivanov,M,2000,71.2,177,student,5,4,6,5";
                    break;
                default:
                    st="Mariya,Atanasova,F,1992,51.6,160,secretary,6,6,5.75,5.5";                    
            }
            
            persons[i]=new Person(st);            
        }
        
        for(int i=0;i<n;i++){
            persons[i].printf();
        }
    }
}
