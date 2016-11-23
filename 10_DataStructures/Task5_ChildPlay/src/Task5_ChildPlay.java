
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
public class Task5_ChildPlay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> heights = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            heights.add(i, sc.nextInt());
        }

        boolean haveRemoving = true;
        int steps = -1, a, b;
        while (haveRemoving) {
            haveRemoving = false;
            ListIterator<Integer> it = heights.listIterator(heights.size());
            while (it.hasPrevious()) {
                a = it.previous();
                if (it.hasPrevious()) {
                    b = it.previous();
                    b=it.next();
                    if (a > b) {
                        it.next();
                        it.remove();
                        haveRemoving = true;
                    }                  
                }              
            }
            steps++;

        }
        System.out.println(steps);
    }
}
