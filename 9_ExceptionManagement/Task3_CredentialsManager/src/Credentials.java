/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Credentials implements Comparable<Credentials>  {
    private String username;
    private String password;
    private String[] oldPasswords;
    private int numberOldPasswords;
    
    String getUsername(){
        return username;
    }
    void setPassword(String oldPassword,String newPassword) throws OldPasswordConflictException{
        checkPassword(oldPassword);
        boolean existInOldPasswords=false;
        int i=0;
        while(i<numberOldPasswords && !existInOldPasswords){
            existInOldPasswords=newPassword.equals(oldPasswords[i]);
            i++;
        }
        if(existInOldPasswords){
            throw new OldPasswordConflictException(numberOldPasswords-i);
        }else{
            oldPasswords[numberOldPasswords++]=newPassword;
            password=newPassword;            
        }
    }
    Credentials(String username, String password){
        this.username=username;
        this.password=password;
        oldPasswords=new String[100];
        oldPasswords[0]=password;
        numberOldPasswords=1;
    }
    void checkPassword(String password){
        if (!password.equals(this.password)){
            throw new SecurityException("Illegal password");
        }        
    }
    
    @Override
    public int compareTo(Credentials compareCredentials){
        return this.username.compareTo(compareCredentials.username);
    }
    
    @Override
    public boolean equals(Object compareCredentials){
        if (!(compareCredentials instanceof Credentials))
            return false;
        return this.username.equals(((Credentials) compareCredentials).username);
    }
}
