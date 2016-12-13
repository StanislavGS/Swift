package task3_personcharacteristics;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task3_PersonCharacteristics {

    static ArrayList<Person> persons = new ArrayList<Person>();

    public static void main(String[] args)  {
        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        }

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line = br.readLine();
                while (line != null) {
                    String[] s1 = line.split(";");
                    ManipulatePesonsList.addPerson(s1, persons);
                    line = br.readLine();
                }
            }
        } catch (IOException ex1) {
            readFromScanner();
        }

        for (Person person : persons) {

            System.out.println(person.toString());
        }
    }

    public static void readFromScanner() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String st;
        for (int i = 0; i < n; i++) {

            st = sc.nextLine();
            String[] s1 = st.split(";");
            ManipulatePesonsList.addPerson(s1, persons);
        }

    }

}
