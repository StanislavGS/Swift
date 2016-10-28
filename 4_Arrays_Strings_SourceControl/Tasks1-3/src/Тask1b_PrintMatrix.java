
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
public class Тask1b_PrintMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] task1b = new int[n][n];
        
        //int n=4;
        //int[][] task1b=new int[n][n];
        
        for (int i = 0; i < task1b.length; i++) {
            for (int j = 0; j < task1b[i].length; j++) {
                if (j % 2 == 0) {
                    task1b[i][j] = j * n + i + 1;
                } else {
                    task1b[i][j] = j * n +n - i ;
                }

                System.out.printf("%3d ", task1b[i][j]);
            }
            System.out.println();
        }
    }
}
