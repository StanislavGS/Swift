/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task4_InchToCm {
    //Exercize  - Task4_InchToCm - a SGS
    public static void main(String[] args){
        double measurements[]={12,23.23};
        final double CM_PER_INCH=2.54;
        for(int i=0;i<measurements.length;i++){
            System.out.println(measurements[i] + "  инча са = на " + measurements[i]*CM_PER_INCH + " сантиметра.");
        }
    }
    
}
