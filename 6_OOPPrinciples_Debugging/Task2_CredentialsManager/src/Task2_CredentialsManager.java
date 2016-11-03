/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task2_CredentialsManager {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        
        
        Credentials[] usersClasses=new Credentials[200];
        int numUsers=0;
        String command="",st;
        String s1[];
        do{
            st=sc.nextLine();
            s1=st.split(" ");
            if (!s1[0].equals("END")){
                Credentials trash=new Credentials(s1[1],"");
                switch (s1[0]){                    
                    case "ENROLL":      
                        System.out.print(s1[0]);
                        if(numUsers==0 || Arrays.binarySearch(usersClasses, 0, numUsers, trash)<0 && numUsers<200 ){
                           usersClasses[numUsers++]=new Credentials(s1[1],s1[2]);
                           Arrays.sort(usersClasses,0, numUsers );
                           System.out.println("success"); 
                        }else{
                           System.out.println("fail");
                        }
                        break;
                    case "CHPASS":
                        System.out.print(s1[0]);
                        if (numUsers==0 ){
                             System.out.println("fail");
                        }else{
                            int idx=Arrays.binarySearch(usersClasses, 0, numUsers, trash);
                            if (idx<0){
                                 System.out.println("fail");
                            } else{
                                System.out.println(usersClasses[idx].setPassword(s1[2], s1[3]));
                            }
                        }
                        break;
                    case "AUTH":
                        System.out.print(s1[0]);
                        if (numUsers==0 ){
                             System.out.println("fail");
                        }else{
                            int idx=Arrays.binarySearch(usersClasses, 0, numUsers, trash);
                            if (idx<0){
                                 System.out.println("fail");
                            } else{
                                System.out.println(usersClasses[idx].checkPassword(s1[2]));
                            }
                        }
                        break;                        
                }
            }
        }while(!s1[0].equals("END"));// s1[0]!="END" not working. I dont know why.
    }
}
