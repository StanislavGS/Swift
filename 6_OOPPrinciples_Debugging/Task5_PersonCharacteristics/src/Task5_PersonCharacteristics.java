
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Stanislav Stanislavov
 */
public class Task5_PersonCharacteristics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                
        int n = sc.nextInt();
        Person[] persons=new Person[n];
        for(int i=0;i<n;i++){
            String st;
            st=sc.nextLine();
            
            /*switch (i){
                case 0:
                    st="Peter;Petrov;M;184;9.9.1985;SOU Pushkin;15.9.2000;20.5.2005;5.11";
                    break;
                case 1:
                    st="Ivan;Ivanov;M;177;29.2.2000;SOU Chintulov;16.9.2015;22.5.2020";
                    break;
                default:
                    st="Mariya;Atanasova;F;160;15.10.1992;SOU Geo Milev;20.9.2007;20.5.2012;4.14";                    
            }*/
            
            persons[i]=new Person(st);            
        }
        
        for(int i=0;i<n;i++){
            persons[i].printf();
        }
    }
    
    
}
