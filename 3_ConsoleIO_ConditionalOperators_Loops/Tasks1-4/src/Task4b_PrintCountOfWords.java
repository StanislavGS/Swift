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
public class Task4b_PrintCountOfWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();
       
        //String st = "Peter loves dogs. He doesn’t like cats.";
        //String st = "The last word is not a w0rd.";
              
        boolean isInWord=false,isCorrectWord=false;
        int n = st.length();
        char c=st.charAt(n-1);
        if (c!='.' && c!='!' && c!='?'){
            st+='.';
            n++;
        }
        int wordCount=0;
        String word="";
        for (int i = 0; i < n; i++) {
            c=st.charAt(i);
            if (c==' ' || c=='.' || c=='!' || c=='?'){
                if (isInWord){
                    wordCount++;
                    for(int j=0;j<word.length();j++){
                        char c1=word.charAt(j);
                        if (!(c1>='a' && c1<='z' || c1>='A' && c1<='Z' || c1=='’' || c1=='\'')){
                            wordCount--;
                            break;
                        }
                    }
                }
                isInWord=false;
                word="";
            }else{
                isInWord=true;
                word+=c;        
            }
            
            
           
        }
        System.out.println(wordCount);
        
    }

}
