
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Task0a_FindIntegers {
    public static void main(String[] args) {
       String[] inputs = {
            "+359 -15 34.56 32",
           "kjдфснasg!@#^#U#$%^& 8b.aknd97",
           "INSERT INTO address ('city',municipality,'country',number) VALUES ('Sofia',Sofia_grad,Bulgaria,'5a')"
        };

       //String name="";
       
        String[] patterns = {
            "-?\\d+",
            "[^a-zA-Z0-9~!@#$%\\^&*()_+\\-=/\\\\]",
            "INSERT\\s+INTO\\s+((`[a-zA-Z_0-9]+`)|([a-zA-Z_0-9]+))\\s+\\(((('[a-zA-Z_0-9]+')|([a-zA-Z_0-9]+)),)*"+
                "(('[a-zA-Z_0-9]+')|([a-zA-Z_0-9]+))\\)\\s+VALUES\\s+\\(((('[a-zA-Z_0-9]+')|([a-zA-Z_0-9]+)),)*"+
                "(('[a-zA-Z_0-9]+')|([a-zA-Z_0-9]+))\\)"
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.printf("Looking for \"%s\" in \"%s\"%n", patterns[i], inputs[i]);
            printAllRegexMatches(inputs[i], patterns[i]);
            System.out.println();
        } 
    }
    
    private static void printAllRegexMatches(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(input);

        while (matcher.find()) {
            System.out.printf("Found match [%s] at index [%d]%n", matcher.group(), matcher.start());
        }
    }
}
