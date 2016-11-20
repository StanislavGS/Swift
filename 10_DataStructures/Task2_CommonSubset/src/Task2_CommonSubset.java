
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_CommonSubset {

    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        String st = sc.nextLine();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();            
            numbers.add(number);
        }
        
        st = "";
        for (int i = 0; i < m; i++) {
            int number = sc.nextInt();
            if (numbers.contains(number)) {
                st += " " + number;
            }
        }

        if (st.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(st.substring(1));
        }
    }
}
