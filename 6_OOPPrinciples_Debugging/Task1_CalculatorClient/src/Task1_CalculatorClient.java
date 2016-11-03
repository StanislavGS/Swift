
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
public class Task1_CalculatorClient {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        String command="",st;
        String s1[];
        do{
            st=sc.nextLine();
            s1=st.split(" ");
            if (!s1[0].equals("END")){
                switch (s1[0]){
                    case "SUM":
                        System.out.printf("%.3f%n",
                                Calculator.sum(
                                        Double.parseDouble(s1[1]), 
                                        Double.parseDouble(s1[2])
                                )
                        );
                        break;
                    case "SUB":
                        System.out.printf("%.3f%n",
                                Calculator.substract(
                                        Double.parseDouble(s1[1]), 
                                        Double.parseDouble(s1[2])
                                )
                        );
                        break;
                    case "MUL":
                        System.out.printf("%.3f%n",
                                Calculator.multiply(
                                        Double.parseDouble(s1[1]), 
                                        Double.parseDouble(s1[2])
                                )
                        );
                        break;
                    case "DIV":
                        System.out.printf("%.3f%n",
                                Calculator.divide(
                                        Double.parseDouble(s1[1]), 
                                        Double.parseDouble(s1[2])
                                )
                        );
                        break;
                    case "PER":
                        System.out.printf("%.3f%n",
                                Calculator.percentage(
                                        Double.parseDouble(s1[1]), 
                                        Double.parseDouble(s1[2])
                                )
                        );
                        break;
                        
                }
            }
        }while(!s1[0].equals("END"));// s1[0]!="END" not working. I dont know why.
    }    
}
