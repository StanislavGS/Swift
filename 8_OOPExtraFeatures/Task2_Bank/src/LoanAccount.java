/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stanislav Stanislavov
 */
public class LoanAccount extends Account {

    public LoanAccount(int iban, Object customer, double balance, double montlyInterestRate) {
        super(iban, customer, balance, montlyInterestRate);
    }

    @Override
    public double calculateInterest(double months) {

        if (this.customer instanceof IndividualCustomer) {
            double montsInInterest = (months > 3) ? months-3 : 0;
            return (Math.pow((1 + this.getMontlyInterestRate()), montsInInterest) * this.getBalance());
        }
        
        double montsInInterest = (months > 2) ? months-2 : 0;
        return (Math.pow((1 + this.getMontlyInterestRate()), montsInInterest) * this.getBalance());
    }

}
