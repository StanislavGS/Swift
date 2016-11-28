
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
public class Task7_StackMax {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        
        Scanner sc = new Scanner(System.in);
        String st;
        String s1[];
        long milis;
        do {
            st = sc.nextLine();
            s1 = st.split(" ");
            if (!s1[0].equals("END") && (s1[0].equals("PUSH") || s1[0].equals("POP") || s1[0].equals("MAX"))) {
                switch(s1[0]){
                    case "PUSH":
                        //milis=System.nanoTime();
                        myStack.push(Integer.parseInt(s1[1]));
                        //System.out.println(" Time:" + (System.nanoTime()-milis));
                        break;
                    case "POP":
                        //milis=System.nanoTime();
                        System.out.println(myStack.pop());
                        //System.out.println(" Time:" + (System.nanoTime()-milis));
                        break;
                    case "MAX":
                        //milis=System.nanoTime();
                        System.out.println(myStack.max());
                       //System.out.println(" Time:" + (System.nanoTime()-milis));
                }
            }
        } while (!s1[0].equals("END"));   
        
        while(!myStack.isEmpty()){
            System.out.print(myStack.pop()+" ");
        }
        System.out.println();
    }
}
