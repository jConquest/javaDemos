package bankaccountdemo;
/**
 * @author Joseph Conquest
 * Below code is small demo for
 * BankAccount and SavingsAccount Classes #9
 * code creates object
 * does 8 withdrawals
 * does one monthly Process causing account to become inactive
 * does one deposit reactivating account
 */
public class BankAccountDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create SavingsAccount object passing balance and interest rate as args
        SavingsAccount test = new SavingsAccount(50,.005);
        
        //Demonstrate 8 withdrawals to encure a 4 dollar fee
        test.Withdraw(5);
        test.Withdraw(5);
        test.Withdraw(5);
        test.Withdraw(5);
        test.Withdraw(1);
        test.Withdraw(1);
        test.Withdraw(1);
        test.Withdraw(1);
        //print result which should be 26.0000
        System.out.printf("Current Balance after withdrawals : %f\n", 
                test.getBalance());
        //Now lets do the monthly process and print the balance
        //A message should occur warning that account is inactive
        test.monthlyProcess();
        System.out.printf("Current Balance after monthly process : %f\n", 
                test.getBalance());
        
        //Lets try to reactivate with insufficent amount THIS WILL PRINT ERROR
        test.Deposit(1);
        
        //Lets reactivate the account by adding sufficent funds
        test.Deposit(1000);
        System.out.printf("Current Balance after deposit : %f\n", 
                test.getBalance());
    }
    
}
