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
public class Task3e_ConvertibleStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String surroundString = sc.nextLine();
        String nestedString = sc.nextLine();
        
       // String surroundString = "I love orange t-shirts";
        //String nestedString = "I love oranges";
        
        //String surroundString = "abbajkfhkhbfv";
        //String nestedString = "abab";
        
        
        
        int nSurr=surroundString.length();
        int nNest=nestedString.length();
        boolean isNested=false;
        int i=0,j=0;
        while(i<nSurr-nNest+j+1 ){
            if (surroundString.charAt(i)==nestedString.charAt(j)){
                i++;j++;
                if (j==nNest){
                    isNested=true;
                    break;
                }
            }else{
                i++;
            }
        }
        
        
        
        System.out.println(isNested);

    }

}
