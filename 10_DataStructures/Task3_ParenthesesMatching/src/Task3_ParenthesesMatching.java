
import java.util.Scanner;
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
public class Task3_ParenthesesMatching {
    public static void main(String[] args) {
        //Set<Integer> numbers = new TreeSet<>();
        Stack<Character> parentheses=new Stack<>();
        
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        boolean isCorrect=true;
        for (int i = 0; i < st.length(); i++) {
            char ch=st.charAt(i);
            if (ch=='(' || ch=='{' || ch=='['){
                parentheses.push(ch);
            }else if(ch==')'){
                if(parentheses.isEmpty() || parentheses.pop()!='('){
                    isCorrect=false;
                    break;
                }
            }else if(ch==']'){
                if(parentheses.isEmpty() || parentheses.pop()!='['){
                    isCorrect=false;
                    break;
                }
            }else if(ch=='}'){
                if(parentheses.isEmpty() || parentheses.pop()!='{'){
                    isCorrect=false;
                    break;
                }
            }            
        }
        
        System.out.println(isCorrect);
    }
}
