/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class MortgageAccount extends Account{

    public MortgageAccount(int iban, Object customer, double balance, double montlyInterestRate) {
        super(iban, customer, balance, montlyInterestRate);
    }

    @Override
    public double calculateInterest(double months) {

        if (this.customer instanceof IndividualCustomer) {
            double montsInInterest = (months > 6) ? months-6 : 0;
            
             //-----probably this must be method of calculation
            //return (Math.pow((1 + this.getMontlyInterestRate()), montsInInterest) * this.getBalance());
            return (this.getMontlyInterestRate()* montsInInterest*0.01) * this.getBalance();
            
        }
        //В дадения пример Svoge е CompanyCustomer а лихвата му е смятана като за Individual Customer.
        if (months>12){
            //return Math.pow((1 + this.getMontlyInterestRate()), (months-12)) *   Math.pow(1.5, 12)*this.getBalance();
            return (this.getMontlyInterestRate()*(months-12)+0.5*12)*0.01*this.getBalance();
        }else{
            //return Math.pow((1 + 0.5), months) * this.getBalance();
            return 0.5*months*0.01*this.getBalance();
        }
        
    }
    
}
