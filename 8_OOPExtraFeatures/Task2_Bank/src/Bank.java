
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
class Bank {
    private String _name;
    private int _firstFreeIban;
    private Object[] accounts;
    private int numAccounts;
    private Object[] customers;
    private int numCustomers;
    
    public String getName(){
        return _name;        
    }
    Bank(String name){
        this.numAccounts=0;
        this.numCustomers = 0;
        this.accounts = new  Object[200];
        this.customers=new Object[200];
        _name=name;
        _firstFreeIban=1;
    }

    String openAccount(String[] s)  {
        Object customer;
        if (s[1].equals("1")){            
                customer=new IndividualCustomer(s[0]);
        }else if(s[1].equals("2")){
            customer=new CompanyCustomer(s[0]);
        }else{
            throw new BadInputData("Unknown type Customer");
        }
        
        addCustomer(customer);
        Object account;
        if (s[2].equals("1")){
            accounts[numAccounts++]=new DepositAccount(_firstFreeIban++,customer,
                    Double.parseDouble(s[3]),Double.parseDouble(s[4]));
        } else if (s[2].equals("2")){
            accounts[numAccounts++]=new LoanAccount(_firstFreeIban++,customer,
                    Double.parseDouble(s[3]),Double.parseDouble(s[4]));
        } else if (s[2].equals("3")){
            accounts[numAccounts++]=new MortgageAccount(_firstFreeIban++,customer,
                    Double.parseDouble(s[3]),Double.parseDouble(s[4]));
        }else{
            throw new BadInputData("Unknown type account");
        }
        Arrays.sort(accounts, 0, numAccounts);
        return String.format("%08d", _firstFreeIban-1);
    }

    boolean putInAccount(String st1, String st2) {
        Object account=findAccount(st1);
        if (account==null){
            return false;
        }else{
            ((Account) account).putInBalance(Double.parseDouble(st2));
            return true;
        }
        /*
        if(isIban(st1)){
            int i=Arrays.binarySearch(accounts,0,numAccounts,
                    new DepositAccount(Integer.parseInt(st1), null, 0, 0));
            if (i>=0){
                
            }
        }else{
            
        }*/
    }

    boolean getFromAccount(String st1, String st2) {
        Object account=findAccount(st1);
        if (account==null){
            return false;
        }else{
            ((DepositAccount) account).getAmount(Double.parseDouble(st2));
            return true;
        }
    }

    String infoForAccount(String st1, String st2) {
        Object account=findAccount(st1);
        if (account==null){
            return "Cant't find account.";
        }else{
            return String.format("%.2f",((Account) account).calculateInterest(Double.parseDouble(st2)));
        }
    }

    private void addCustomer(Object customer)  {
        int i=Arrays.binarySearch(customers, 0, numCustomers, customer);
        if (i>=0){
            throw new BadInputData("Customer already exist.");
        } 
        customers[numCustomers++]=customer;
        Arrays.sort(customers, 0, numCustomers);
    }

    private Object findAccount(String st1) {
        //first check if is iban
        boolean isIban=false;
        int n=st1.length();
        if (n==8){
            for (int i = 0; i < n; i++) {
                if(st1.charAt(i)<'0' || st1.charAt(i)>'9'){
                    break;
                }
                if(i==7){
                    isIban=true;
                }
            }
        }
        if (isIban){
            IndividualCustomer trashCustomer=new IndividualCustomer("nobody");
            DepositAccount trash=new DepositAccount(Integer.parseInt(st1), trashCustomer, 0, 0);
            return accounts[Arrays.binarySearch(accounts, 0, numAccounts, trash)];
        }else{
            IndividualCustomer trash=new IndividualCustomer(st1);
            return ((Customer) customers[Arrays.binarySearch(customers, 0, numCustomers,trash)]).account;
        }
    }
    
    
}
