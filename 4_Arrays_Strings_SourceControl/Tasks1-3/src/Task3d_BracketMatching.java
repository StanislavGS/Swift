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
public class Task3d_BracketMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
        //String st = "(([[{({})]}]))";
        //String st = "([]({}){[]})";
        
        int n=st.length();
        byte[] stack= new byte[n];
        int pointer=-1;
        boolean isCorrect=true;
        
        for (int i = 0; i < n; i++) {
            switch (st.charAt(i)){
                case '(': 
                    stack[++pointer]=1;
                    break;
                case '{': 
                    stack[++pointer]=2;
                    break;
                case '[': 
                    stack[++pointer]=3;
                    break;
                case ')': 
                    if (pointer<0 || stack[pointer]!=1){
                        isCorrect=false;                        
                    }else{
                        pointer--;
                    }
                    break;
                case '}':
                     if (pointer<0 || stack[pointer]!=2){
                        isCorrect=false;                        
                    }else{
                        pointer--;
                    }
                    break;
                case ']': 
                     if (pointer<0 || stack[pointer]!=3){
                        isCorrect=false;                        
                    }else{
                        pointer--;
                    }
                    break;
                default:
                    System.out.println("Некоректен знак.");System.exit(0);
            }
            if (!isCorrect){
                break;
            }
        }
        System.out.println(isCorrect && pointer<0);

    }

}
