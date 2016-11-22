
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] distAndFood = new int[2];
        List<DistAndFood> distancesAndFood = new ArrayList<>();
        int min = Integer.MAX_VALUE, idxMin = -1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            String[] st = sc.nextLine().split(" ");
            //in original condition is reversed
            //distancesAndFood.add(i, new DistAndFood(Integer.parseInt(st[1]), Integer.parseInt(st[0])));
            distancesAndFood.add(i, new DistAndFood(Integer.parseInt(st[1]), Integer.parseInt(st[0])));
            sum += distancesAndFood.get(i).getDiastance() - distancesAndFood.get(i).getFood();
            if (min >= sum) {//min>sum - is bettter(but the answer for first example is 4 --not like in example)
                min = sum;
                idxMin = i;
            }
        }

        sum = 0;
        idxMin++;
        if (idxMin == n) {
            idxMin = 0;
        }
        boolean result = true;
        for (int i = idxMin; i < idxMin + n; i++) {
            sum += distancesAndFood.get(i % n).getDiastance() - distancesAndFood.get(i % n).getFood();
            if (sum < 0) {
                result = false;
                break;
            }

        }

        System.out.println(result ? idxMin + 1 : "NO");//Show the number of city. Numbers started from 1.
    }
}

class DistAndFood {

    private int distance;
    private int food;

    public int getDiastance() {
        return this.distance;
    }

    public int getFood() {
        return this.food;
    }

    DistAndFood(int distance, int food) {
        this.distance = distance;
        this.food = food;
    }
}
