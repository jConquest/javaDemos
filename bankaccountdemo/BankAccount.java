package bankaccountdemo;
/**
 * @author Joseph Conquest
 * Design an abstract class named BankAccount to hold the following data for a 
 * bank account:
 Balance
 Number of deposits this month
 Number of withdrawals 
 Annual interest rate
 Monthly service charges
* Functionality includes setters for fields, constructor, deposit, withdraw,
* calcInterest, monthlyProcess
 */
public abstract class BankAccount {
    protected double balance;//balance amount
    protected int depositNum;//deposit counter
    protected int withdrawNum;//withdrawal counter
    private double interest;//interest rate
    protected double fee;//service charges
   //default constructor 
   public BankAccount(){
       setBalance(0);
       interest = 0;
       depositNum = 0;
       withdrawNum = 0;
       fee = 0;
   } 
   /**
    * Constructor sets balance and interest to parameters and all other fields
    * to 0
    * @param balance double first entered
    * @param interest double second entered
    */
    public BankAccount(double balance, double interest){
      setBalance(balance);
      this.interest = interest;
       depositNum = 0;
       withdrawNum = 0;
       fee = 0;
    }
    /**
     * Setter for balance
     * @param num double 
     */
    public void setBalance(double num){
        balance = num;
    }
    /**
     * Setter for fee
     * @param num double
     */
    public void setFee(double num){
        fee = num;
    }
    /**
     * Mutator adds parameter to fee amount
     * @param num double
     */
    public void addFee(double num){
        fee += num;
    }
    /**
     * Setter for Interest
     * @param num double
     */
    public void setInterest(double num){
        interest = num;
    }
    /**
     * Getter for balance
     * @return balance as double
     */
    public double getBalance(){
        return balance;
    }
    /**
     * Deposit Method increments depositNum
     * adds the parameter to balance
     * @param amount double amount to be added
     */
    public void deposit(double amount){
        depositNum ++;
        balance += amount;
    }
    /**
     * withdraw Method increments withdrawlNum
     * subtracts parameter from balance
     * @param amount double to be subtracted
     */
    public void withdraw(double amount){
        withdrawNum++;
        balance -= amount;
    }
    /**
     * Method calculates interest and adjusts balance accordingly
     */
    public void calcInterest(){
        double monthInterestRate = interest/12;
        double monthInterest = balance * monthInterestRate;
        setBalance(balance+monthInterest);
    }
    /**
     * Method prepares account at the end of the month by 
     * subtracting monthly fee
     * calc interest
     * set deposit, withdraw, and fee to 0
     */
    public void monthlyProcess(){
        balance -= fee;
        calcInterest();
        depositNum = 0;
        withdrawNum = 0;
        fee = 0;
    }
    
}
