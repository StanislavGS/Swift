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
public class Task3f_LongestCommonSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //String st1 = sc.nextLine();
        //String st2 = sc.nextLine();
        String st1 = "ahasjaaakxmza";
        String st2 = "ahaooxmaaakxs";

        int n1 = st1.length(), n2 = st2.length();
        if (n1 > n2) {
            int t = n1;
            n1 = n2;
            n2 = t;
            String ts = st1;
            st1 = st2;
            st2 = ts;
        }

        String findedString = "";
        boolean isFindedString = false;
        for (int i = n1; i > 0; i--) {
            for (int j = 0; j <= n1 - i; j++) {
                findedString = st1.substring(j, j + i);
                int idxFind = st2.indexOf(findedString, 0);
                if (idxFind >= 0) {
                    isFindedString = true;
                    break;
                }
            }
            if (isFindedString) {
                break;
            }
        }

        if (isFindedString) {
            System.out.println(findedString);
        } else {
            System.out.println("No matches!!!");
        }

        

    }

}
