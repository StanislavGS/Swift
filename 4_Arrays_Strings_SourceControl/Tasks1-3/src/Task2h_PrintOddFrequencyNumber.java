/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2h_PrintOddFrequencyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] task2h=new int[n];
        for(int i=0;i<n;i++){
           task2h[i] = sc.nextInt();
        }        
        //int[] task2h = {4, 6, 4, -3, 5, 2, 5, 4, 5, 6, -3, 2, 5, 4, 6};
        //int n = task2h.length;

        Arrays.sort(task2h);
        boolean isOdd = true;
        int currentNumber = task2h[0];
        for (int i = 1; i < n; i++) {
            if (task2h[i] != task2h[i - 1]) {
                if (isOdd) {
                    System.out.println(task2h[i - 1]);
                } else {
                    isOdd = true;
                }
            } else {
                isOdd = !isOdd;
            }
        }
        if (isOdd) {
            System.out.println(task2h[n - 1]);
        }

    }

}
