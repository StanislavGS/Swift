
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1_FilterFiles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String stAccum="\n\n";
        for (int i = 0; i < n; i++) {
            String st = sc.nextLine();
            //Pattern.
                    
            if (Pattern.matches(".*\\.(jpg|gif|png)\\s*$",st.toLowerCase().subSequence(0,st.length()))) {
                stAccum+=st+"\n";
            }
        }
        System.out.println(stAccum);
    }
}
