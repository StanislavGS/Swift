/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public abstract class Account implements Comparable<Object>{
    private int iban;
    private double balance;
    private double montlyInterestRate;
    Object customer;
    public int getIBAN(){
        return iban;
    }
    public double getBalance(){
        return this.balance;
    }
    protected void setBalance(double amount){
        this.balance=amount;
    }
    public double getMontlyInterestRate() {
        return this.montlyInterestRate;
    }    
    Account(int iban,Object customer,double balance,double interestRate){
        this.iban=iban;
        this.setBalance(balance);
        this.montlyInterestRate=interestRate;
        this.customer=customer;        
        ((Customer) customer).account=this;
                
    }
    public void putInBalance(double deposit){
        this.balance+=deposit;
    }
    public abstract double calculateInterest(double mounts) ;    
    @Override
    public int compareTo(Object comparableObject){
        return Integer.compare(this.iban,((Account) comparableObject).getIBAN());
    }
}
