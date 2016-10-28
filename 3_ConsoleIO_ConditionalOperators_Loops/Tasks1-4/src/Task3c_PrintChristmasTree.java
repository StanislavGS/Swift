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
public class Task3c_PrintChristmasTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int withDivide2=n*n/2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <withDivide2*2; j++) {
                if (j>=withDivide2-i && j<=withDivide2+i && i<n-2 ||
                    j==withDivide2 && i==n-2 ||
                    j>=withDivide2-1 && j<=withDivide2+1 && i==n-1 ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

}
