
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task1_UniqueNumbers {
    public static void main(String[] args) {
        //List<Integer> numbers=new LinkedList();
        Set<Integer> numbers=new TreeSet<>();
        
        Scanner sc= new Scanner(System.in);
        
        int n =Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            int number=sc.nextInt();
            //int index=numbers.indexOf(number);
            // if(index<0){
            if (numbers.add(number)){
                System.out.print(number+" ");
                //numbers.add(-index-1, number);
                
            } 
        }
    }
    
    
}
