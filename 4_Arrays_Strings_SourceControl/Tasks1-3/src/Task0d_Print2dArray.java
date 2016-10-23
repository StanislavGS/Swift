/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author t
 */
public class Task0d_Print2dArray {

    public static void main(String[] args) {
        int[][] task0d = new int[4][4];
        int br = 0;

        for (int i = 0; i < task0d.length; i++) {
            for (int j = 0; j < task0d[i].length; j++) {
                task0d[i][j] = ++br;
                System.out.printf("%3d ", task0d[i][j]);
            }
            System.out.println();
        }
    }
}
