
import java.lang.Math;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class DepositAccount extends Account {
    public DepositAccount(int iban, Object customer, double balance, double montlyInterestRate) {
        super(iban,customer,balance,montlyInterestRate);
    }
    @Override
    public double calculateInterest(double monts){
        //-----probably this must be method of calculation
        //return(Math.pow((1+this.getMontlyInterestRate()),monts)*this.getBalance());
        
        return this.getBalance()*(getMontlyInterestRate()*monts*0.01);
    }   
    public void getAmount(double amount){
        if(amount<this.getBalance()){
            this.setBalance(this.getBalance()-amount);
        }else{
            this.setBalance(0);
        }
    }
    
}
