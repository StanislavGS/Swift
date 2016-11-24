
import java.util.ArrayList;
import java.util.Arrays;
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

    List <Credentials> usersClasses=new ArrayList<>();
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
            if (!s1[0].equals("END") && (s1[0].equals("ENROLL") || s1[0].equals("CHPASS") || s1[0].equals("AUTH")  )) {
                //Credentials trash = new Credentials(s1[1], "");
                i=findByName(s1[1]);
                System.out.print(s1[0]);
                switch (s1[0]) {
                    case "ENROLL":
                        //System.out.print(s1[0]);
                        if (numUsers == 0 || Arrays.binarySearch(usersClasses, 0, numUsers, trash) < 0 && numUsers < 200) {
                            usersClasses[numUsers++] = new Credentials(s1[1], s1[2]);
                            Arrays.sort(usersClasses, 0, numUsers);
                            System.out.println("success");
                        } else {
                            System.out.println("fail");
                        }
                        break;
                    case "CHPASS":
                        //System.out.print(s1[0]);
                        if (numUsers == 0) {
                            System.out.println("fail");
                        } else {
                            int idx = Arrays.binarySearch(usersClasses, 0, numUsers, trash);
                            if (idx < 0) {
                                System.out.println("fail");
                            } else {
                                System.out.println(usersClasses[idx].setPassword(s1[2], s1[3]));
                            }
                        }
                        break;
                    case "AUTH":
                        //System.out.print(s1[0]);
                        if (numUsers == 0) {
                            System.out.println("fail");
                        } else {
                            int idx = Arrays.binarySearch(usersClasses, 0, numUsers, trash);
                            if (idx < 0) {
                                System.out.println("fail");
                            } else {
                                System.out.println(usersClasses[idx].checkPassword(s1[2]) ? "success" : "fail");
                            }
                        }
                        break;
                }
            }
        } while (!s1[0].equals("END"));

    }

    private static int findByName(String name) {
        Credentials trash = new Credentials(name, "");
        int idx =ArrayList<Credentials
                this.usersClasses. //Arrays.binarySearch(usersClasses, 0, numUsers, trash);
        if (idx < 0) {
            throw new ArrayIndexOutOfBoundsException("Unexist Credential");
        } else {
            return idx;
        }
    }

}
