
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Bank {

    private Account[] accounts = new Account[5];
    private int numAccounts;
    private double assets;
    boolean result;

    void Bank() {
        numAccounts = 0;
        assets = 0;
        result = true;
    }

    void openAccount(String name, String govId, String username, String password) {
        if (numAccounts == 5) {
            result = false;
        } else {
            accounts[numAccounts++] = new Account(name, govId, username, password);
            if (numAccounts  > 1){
                Arrays.sort(accounts, 0, numAccounts);
            }            
            result = true;            
        }
    }

    void closeAccount(String username, String password) {
        if (numAccounts == 0) {
            result = false;
        } else {
            Account trash = new Account("", "", username, "");
            int idx = Arrays.binarySearch(accounts, 0, numAccounts, trash);
            if (idx < 0) {
                result = false;
            } else {
                if (accounts[idx].hasAccess(password)) {
                    result = true;
                    if (idx < numAccounts - 1) {
                        accounts[idx] = accounts[numAccounts - 1];
                        if (numAccounts - 1 > 1) {
                            Arrays.sort(accounts, 0, numAccounts - 1);
                        }
                    }
                    numAccounts--;
                    accounts[numAccounts] = null;
                } else {
                    result = false;
                }
            }
        }
    }

    void deposit(String username, double amount) {
        if (numAccounts == 0 || amount<0) {
            result = false;
        } else {
            Account trash = new Account("", "", username, "");
            int idx = Arrays.binarySearch(accounts, 0, numAccounts, trash);
            if (idx < 0) {
                result = false;
            } else {
                result = true;
                accounts[idx].deposit(amount);
                assets+=amount;
            }
        }

    }

    void withdraw(String username, String password, double amount) {
        if (numAccounts == 0  || amount<0) {
            result = false;
        } else {
            Account trash = new Account("", "", username, "");
            int idx = Arrays.binarySearch(accounts, 0, numAccounts, trash);
            if (idx < 0) {
                result = false;
            } else {
                if (amount <= accounts[idx].balance) {
                    if (accounts[idx].hasAccess(password)) {
                        accounts[idx].withdraw(amount);
                        assets-=amount;
                        result = true;
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
        }
    }
    
    void transfer(String username,String password, double amount,String recipient){
        if (numAccounts < 2 || username.equals(recipient) ||  amount<0) {
            result = false;
        } else{
            Account trash = new Account("", "", username, "");
            int idx = Arrays.binarySearch(accounts, 0, numAccounts, trash);
            trash = new Account("", "", recipient, "");
            int idx1 = Arrays.binarySearch(accounts, 0, numAccounts, trash);
            if (idx<0 || idx1<0){
                result = false;
            }else{
                withdraw(username,password,amount);
                if (result){
                    deposit(recipient,amount);
                }
            }
        }
    }
    
    double getAssets(){
        return assets;
    }
    
    String getList(){
        System.out.printf("%.2f%n", getAssets());
        String st="";
        for (int i=0;i<numAccounts;i++){
            st+=String.format("%s,%s,%.2f%n", accounts[i].name,accounts[i].govId,accounts[i].balance);            
        }
        return st;
    }
}
