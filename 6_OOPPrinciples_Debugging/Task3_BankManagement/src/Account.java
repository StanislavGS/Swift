/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class Account implements Comparable<Account>{
    String name;
    String govId;
    double balance;
    Credentials credentials;
    
    double getBalance(){
        return balance;
    }
    
    String getUsername(){
        return credentials.getUsername();
    }
    
    String getGovId(){
        return govId;
    }
    
    String getName(){
        return name;
    }
    
    Account(String name,String  govId,String  username,String  password){
        this.name=name;
        this.govId=govId;
        credentials= new Credentials(username,password);
        balance=0;
    }
    
    boolean hasAccess(String password){
        return credentials.checkPassword(password);
    }
    
    void deposit(double amount){
        balance+=amount;
    }
    
    void withdraw(double amount){        
           balance-=amount;        
    }
    
    public int compareTo(Account compareAccount){
        //String s1=this.credentials.getUsername();
       // String s2=compareAccount.credentials.getUsername();
        return this.credentials.getUsername().compareTo(compareAccount.credentials.getUsername());
    }  
}
