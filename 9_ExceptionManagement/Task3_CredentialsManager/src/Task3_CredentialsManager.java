
import java.util.ArrayList;
import java.util.List;
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
public class Task3_CredentialsManager {

    static List<Credentials> usersClasses = new ArrayList<>();
    //Credentials[] usersClasses = new Credentials[200];
    //int numUsers = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command = "", st;
        String s1[];
        int i;

        do {
            st = sc.nextLine();
            s1 = st.split(" ");
            if (!s1[0].equals("END") && (s1[0].equals("ENROLL") || s1[0].equals("CHPASS") || s1[0].equals("AUTH"))) {
                //Credentials trash = new Credentials(s1[1], "");
                i = findByName(s1[1]);
                System.out.print(s1[0]+" ");
                switch (s1[0]) {
                    case "ENROLL":
                        if (i < 0) {
                            usersClasses.add(new Credentials(s1[1], s1[2]));
                            System.out.println("success");
                        } else {
                            System.out.println("fail");
                        }
                        break;
                    case "CHPASS":
                        if (i < 0) {
                            System.out.println("failed");
                        } else {
                            try {
                                usersClasses.get(i).setPassword(s1[2], s1[3]);
                                System.out.println("success");
                            } catch (OldPasswordConflictException ex) {
                                System.out.printf("failed [Password matches a recently used one: %d]%n",
                                        ex.getPasswordConflictIndex());
                            } catch (SecurityException ex) {
                                System.out.println("failed");
                            }
                        }
                        break;
                    case "AUTH":
                        if (i < 0) {
                            System.out.println("fail");
                        } else {
                            try {
                                usersClasses.get(i).checkPassword(s1[2]);
                                System.out.println("success");
                            } catch (SecurityException ex) {
                                System.out.println("fail");
                            }
                        }
                        break;
                }
            }
        } while (!s1[0].equals("END"));
    }

    private static int findByName(String name) {
        Credentials trash = new Credentials(name, "");
        return usersClasses.indexOf(trash);
        
    }
}
