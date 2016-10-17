/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task6_SecondsInBiggerIntervals {
    public static void main(String[] args){
         //Exercize  - Task6_SecondsInBiggerIntervals - a SGS
        long totalSeconds[]={1234567,3600,129600};
        for(int i=0;i<totalSeconds.length;i++){
            System.out.println(totalSeconds[i] + "sec are " + Task6_SecondsInBiggerIntervals(totalSeconds[i]));        
        }
    }
    
    private static String Task6_SecondsInBiggerIntervals(long tot){
        String st=tot % 60 + " seconds";
        tot/=60;
        st= tot % 60 + " minutes, " + st;
        tot/=60;
        st= tot % 24 + " hours, " + st;
        tot/=24;
        st= tot  + " days, " + st;
        return st;
    }
    
}
