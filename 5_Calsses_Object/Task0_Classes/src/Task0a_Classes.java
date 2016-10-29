/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author t
 */
public class Task0a_Classes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Person[] persons={new Person(),
                    new Person("Peter"),
                    new Person("Asen", 32)};
        
        for(int i=0;i<persons.length;i++){
            System.out.println(persons[i].sayHello());
        }
    }
    
}
