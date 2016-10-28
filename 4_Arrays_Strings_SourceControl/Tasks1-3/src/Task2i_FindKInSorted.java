/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2i_FindKInSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), toFind = sc.nextInt();
        int[] task2i=new int[n];
        for(int i=0;i<n;i++){
           task2i[i] = sc.nextInt();
        }        
        //int[] task2i = {-11, -8, -4, -3, 0, 2, 4, 5, 5, 6, 7, 9, 4};
        //int toFind = 4;
        //int[] task2i = {1,2,3,4,5,6,7,8,9};
        //int toFind=11;
        //int n = task2i.length;

        //Направил съм бинарно търсене максимално бързо по скорост
        int beg = 0, end = n - 1, m=0;
        if (toFind < task2i[beg] || toFind > task2i[end]) {
            System.out.println("NO");
            System.exit(0);
        }

        if (toFind == task2i[beg]) {
            System.out.println(beg);
            System.exit(0);
        }

        if (toFind == task2i[beg]) {
            System.out.println(beg);
            System.exit(0);
        }

        while (beg < end - 1) {
            m = (beg + end) / 2;
            if (toFind == task2i[m]) {
                System.out.println(m);
                break;
            }
            if (toFind < task2i[m]) {
                end = m;
            } else {
                beg = m;
            }
        }
        if (toFind != task2i[m]) {
            System.out.println("NO");           
        }
    }

}
