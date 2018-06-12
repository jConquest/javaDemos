/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountdemo;

/**
 *
 * @author Joseph Conquest
 * Class extends BankAccount adding field active
 * additional functionalities allow withdrawal and deposit only if active account
 * IF deposit is big enough to get balance <=25 then account is reactivated
 * override montlyProcess
 */
public class SavingsAccount extends BankAccount {
    private boolean active; //true if balance is greater than 25, active account
    /**
     * no argument constructor sets activity to false
     */
    public SavingsAccount(){
        active = false;
    }
    /**
     * constructor first double is balance second double is interest
     * @param balance double
     * @param interest double should be less than 1.0
     */
    public SavingsAccount(double balance, double interest){
        setBalance(balance);
        setInterest(interest);
        if(balance > 25)
            active = true;
        else{
            active = false;
            System.out.println("Balance below 25.00.....Inactive");
        }
    }
    /**
     * method if active withdraws parametere amount from balance
     * calls withdraw() from BankAccount
     * @param num double
     */
    public void Withdraw(double num){
        if(active)
            withdraw(num);
        else
            System.out.println("Insufficent Funds for a Withdrawal");
    }
    /**
     * method if deposit is being made on inactive account, deposite must be
     * sufficient to get funds at or above $25.00
     * Otherwise method deposits parameter passed
     * @param num double
     */
    public void Deposit(double num){
        if(!active && balance + num >= 25){
            active = true;
            deposit(num);
        }
        else
            System.out.printf("Your current balance is %f\nYou must deposit "
                    + "sufficent funds to raise your balance above $25.00\n",
                    balance);
    }
    /**
     * monthlyProcess override calculates fee, calls calcInterest. Resets 
     * depositNum, withdrawNum, and fee to 0
     */
    @Override
    public void monthlyProcess(){
        if(withdrawNum > 4){
            addFee(withdrawNum - 4);
            balance -= fee;
            calcInterest();
            depositNum = 0;
            withdrawNum = 0;
            fee = 0;
        }
        
        if(balance - fee < 25){
            active = false;
            System.out.println("Balance below 25.00.....Inactive");
        }
    }
}
