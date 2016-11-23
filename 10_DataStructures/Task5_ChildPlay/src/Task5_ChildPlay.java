
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

        boolean fl = true;
        while (fl) {
            fl = false;
            //ListIterator<Integer> li=heights.listIterator();
            ListIterator<Integer> it=heights.listIterator();
            boolean isFirst=true;
            int oldHeight;
            while(it.hasNext()){
                if(!isFirst){
                    if(it.next()>it.previous()){
                        it.next();
                        it.remove();
                        fl=true;
                    }else{
                        it.next();
                    }
                    
                }else{
                    isFirst=false;
                }       
            }
        }
    }
}
