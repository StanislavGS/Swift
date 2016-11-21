/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_FileStructure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st;
        FolderObject root=new FolderObject("root", null);
        LinkedList<String> list = new LinkedList<>();
        do {
            st = sc.nextLine();
            if (!st.trim().equalsIgnoreCase("end")) {
                list.add(st);
            }
        } while (!st.trim().equalsIgnoreCase("end"));
        int j = 0;
        for (String s : list) {
            j++;
            String[] command = s.split(" ");
            try {
                switch(command[0]){
                    case "mkdir":
                        root.addFileOrFolder((byte) 0,command[1].split("/")); 
                        break;
                    case "touch":
                        root.addFileOrFolder((byte) 1,command[1].split("/")); 
                }    
            } catch (IllegalArgumentException ex) {
                System.out.println(j+" - "+ex.getMessage());
            }  
            System.out.println(s);         
        }
       
    }

}
