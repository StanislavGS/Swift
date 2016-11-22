
import java.util.HashMap;
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
public class Task6_WordReplacement {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        
        
        Map<String, String> couples = new HashMap<>();
        
        String st=sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String[] s=sc.nextLine().split(" ");
            couples.put(s[0].toLowerCase(), s[1]);
        }
        
        String[] s=st.split(" ");
        String newString="";
        for(String s2:s){
            if(couples.containsKey(s2.toLowerCase())){
                newString+=" "+couples.get(s2.toLowerCase());
            }else{
                newString+=" "+s2;
            }
        }
        
        System.out.println(newString.substring(1));
        
    }
    
}
