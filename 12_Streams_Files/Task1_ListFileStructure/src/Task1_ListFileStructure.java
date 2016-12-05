
import java.io.File;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task1_ListFileStructure {

    public static void main(String[] args) {
        //String st = "c:\\users\\t\\desktop\\javakurs\\lectures\\";
        String st=args[0];

        Stack<String> totList = new Stack<>();

        totList.push(st);

        while (!totList.isEmpty()) {
            String s1 = totList.pop();
            File file = new File(s1);
            for (String s2 : file.list()) {
                File file2 = new File(s1 + s2);
                if (file2.isFile()) {
                    System.out.println(s1+s2);
                } else {
                    totList.push(s1+s2+"\\");
                }
            }
        }
    }
}
