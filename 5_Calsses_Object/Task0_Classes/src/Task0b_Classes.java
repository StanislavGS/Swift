
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
public class Task0b_Classes {
    public static void main(String[] args) {
        //Scanner sc= new Scanner(System.in);
        
        //String n=sc.nextLine();
        
        //Car[] cars=new Car[4];
        //cars[0]=new Car("Mercedes-Benz", "S220", (short) 2009 ,160);
        
        Car[] cars={new Car("Mercedes-Benz", "S220", (short) 2009 ,160),
                    new Car("Opel", "Astra", (short) 1996 ,85),
                    new Car("Bugatti", "Veyron", (short) 2015 ,612),
                    new Car("Lada", "5", (short) 1989 ,75)};
        
        for(int i=0;i<cars.length;i++){
            System.out.println(cars[i].tax());
        }
        
        
        
               
    }
    
}
