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
public class Task5_PersonCharacteristics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
                
        int n = sc.nextInt();
        
        short currentYear=(short) (System.currentTimeMillis() / (1000 * 60 * 60 * 24 * 365.25) + 1970) ;
        Person[] persons=new Person[n];
        for(int i=0;i<n;i++){
            boolean isCorrect;
            
            //Въвежда първо име
            String firstName=sc.nextLine();
            do{
                firstName=sc.nextLine() ;
                isCorrect=(!firstName.isEmpty()) && (!firstName.contains(" "));
                if(!isCorrect){
                    System.out.println("Некоректно въведено име. Моля, въведете отново!");
                }
            }while(!isCorrect);
            
            //Въвежда фамилия
            String lastName="";
            do{
                lastName=sc.nextLine();
                isCorrect=(!lastName.isEmpty()) && (!lastName.contains(" "));
                if(!isCorrect){
                    System.out.println("Некоректно въведено име. Моля, въведете отново!");
                }
            }while(!isCorrect);
            
             //Въвежда година на раждане
           int yearOfBirth=0;
            do{
                yearOfBirth=sc.nextInt();
                isCorrect=yearOfBirth>currentYear-200 && yearOfBirth<=currentYear;
                if(!isCorrect){
                    System.out.println("Некоректно въведена година на раждане. Моля, въведете отново!");
                }
            }while(!isCorrect);
            
            //Въвежда тегло
            double weight=0;
            do{
                //String tmp=sc.nextLine() ;                
                weight= sc.nextDouble();//tmp;
                isCorrect=weight>0.3 && weight<560;
                if(!isCorrect){
                    System.out.println("Некоректно въведено тегло. Моля, въведете отново!");
                }
            }while(!isCorrect);
            
            //Въвежда височина в сантиметри
            double height=0;
            do{
                height=sc.nextDouble();                
                isCorrect=height>30 && height<= 271.7;
                if(!isCorrect){
                    System.out.println("Некоректно въведена височина. Моля, въведете отново!");
                }
            }while(!isCorrect);
            
            String proffesion=sc.nextLine();
            proffesion=sc.nextLine();
            persons[i]= new Person(firstName,lastName,yearOfBirth,weight,height,proffesion);            
        }  
        for(int i=0;i<n;i++){
            System.out.println( persons[i].Output());
        }
    }
    
}
