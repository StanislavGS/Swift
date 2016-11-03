/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Comparator;
/**
 *
 * @author Stanislav Stanislavov
 */
public class Credentials  {
    private String username;
    private String password;
    private String[] oldPasswords;
    private int numberOldPasswords;
    
    String getUsername(){
        return username;
    }
    String setPassword(String oldPassword,String newPassword){
        if(!this.password.equals(oldPassword)){
            return "fail";
        }
        boolean existInOldPasswords=false;
        int i=0;
        while(i<numberOldPasswords && !existInOldPasswords){
            existInOldPasswords=newPassword.equals(oldPasswords[i]);
            i++;
        }
        if(existInOldPasswords){
            return "fail";
        }else{
            oldPasswords[numberOldPasswords++]=newPassword;
            password=newPassword;
            return "success";
        }
    }
    Credentials(String username, String password){
        this.username=username;
        this.password=password;
        oldPasswords=new String[100];
        oldPasswords[0]=password;
        numberOldPasswords=1;
    }
    Boolean checkPassword(String password){
        return password.equals(this.password);        
    }
    
      
}
