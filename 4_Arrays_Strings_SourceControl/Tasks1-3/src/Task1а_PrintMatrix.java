
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
public class Task1а_PrintMatrix {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        
        int n=sc.nextInt();
        
        int[][] task1a = new int[n][n];
        
        for (int i = 0; i < task1a.length; i++) {
            for (int j = 0; j < task1a[i].length; j++) {
                task1a[i][j] = j*n+i+1;
                System.out.printf("%3d ", task1a[i][j]);
            }
            System.out.println();
        }
    }
}
