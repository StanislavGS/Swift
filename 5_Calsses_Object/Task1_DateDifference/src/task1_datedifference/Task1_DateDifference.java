/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1_datedifference;
import java.util.Scanner;
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task1_DateDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc= new Scanner(System.in);
        
        String[] stringDates={sc.nextLine(),sc.nextLine()};
        
        String[] trash1=stringDates[0].split(" ");
        SwiftDate date1=new SwiftDate(Short.parseShort(trash1[0]),Byte.parseByte(trash1[1]),Byte.parseByte(trash1[2]));
        
        trash1=stringDates[1].split(" ");
        SwiftDate date2=new SwiftDate(Short.parseShort(trash1[0]),Byte.parseByte(trash1[1]),Byte.parseByte(trash1[2]));
        
        System.out.println(date1.getDaysDifference(date2));
        date1.printInfo();
        date2.printInfo();
    }
    
}
