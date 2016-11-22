
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
public class Task4_CountryTour {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=Integer.parseInt(sc.nextLine());
        int[] distanceToNextCity=new int[n];
        int[] neededFood=new int[n]; 
        int min=Integer.MAX_VALUE,idxMin=-1;
        int sum=0;
        for (int i = 0; i < n; i++) {
            String[] st=sc.nextLine().split(" ");
            distanceToNextCity[i]=Integer.parseInt(st[0]);
            neededFood[i]=Integer.parseInt(st[1]);
            sum+=distanceToNextCity[i]-neededFood[i];
            if (min>sum){
                min=sum;
                idxMin=i;
            }            
        }
        
        sum=0;
        int idx=idxMin+1;
        if (idx==n){
            idx=0;
        }
        boolean result=true;
        for (int i = 0; i < n; i++) {
            sum+=distanceToNextCity[idx]-neededFood[idx];
            if (sum<0) {
                result=false;
                break;
            }
        }
        
        System.out.println(result?idxMin:"NO");
    }
}
