/**
 * GeneralAccount.java
 * by R. Heise
 * 7 February 2016
 * 
 * Public Methods:
 *    Constructors to make a GeneralAccount
 *    deposit(double) --> boolean
 *        Adds to balance if amount positive (takes out deposit fee)
 *    withdrawal(double) --> boolean
 *        Subtracts from balance if amount positive (takes out withdrawal
 *        fee)
 *    
 *      endOfMonth()
 *        Performs month end stuff (interest calc, reset variables,
 *        print report)
 *    billPayment(double amount, GeneralAccount g) --> false
 *       Not activated.
 *    chequeCashed(int num, double amount) --> false
 *       Not activated.
 *    toString() --> String
 *       String report
 */
package bankaccounts;

public class GeneralAccount {

    
    //===========================================
    //DATA
   
    protected String accountNum;
    protected String firstName;
    protected String lastName;
    protected double balance;
    protected double depFee;
    protected double withdrawFee;
    protected double minMonthBalance;
    protected double interestRate;
    
    //===========================================   
    //METHODS
    
    /**************************************
     * Constructors
     *    Creates account, sets all fee amounts to 0.
     * 
     * @param num = the account number, given as a String.
     * @param fName = the first name of account holder, given as a String.
     * @param lName = the last name of account holder, given as a String.
     * @param amount = the initial deposit amount (must be +ve or set to 0)
     */
    public GeneralAccount(String num, String fName, String lName, 
                          double amount){
        accountNum = num;
        firstName = fName;
        lastName = lName;
        if (amount < 0)  //only allow +ve amounts, else set to 0
            amount = 0;
        balance = amount;
        minMonthBalance = amount; //also change the min balance on creation
        depFee = 0;
        withdrawFee = 0;
        interestRate = 0;
    }//Constructor, all arguments
    
    public GeneralAccount(String num, String fName, String lName){
        this(num, fName, lName, 0);
    }//Constructor, missing amount
    
    public GeneralAccount(String num){
        this(num, "Unknown", "Unknown", 0);
    }//Constructor, missing amount and names
    
    public GeneralAccount(){
        this("0", "Unknown", "Unknown", 0);               
    }//default constructor, no arguments given
    
    /**************************************
     * deposit
     *    Add amount to balance, assuming amount is positive
     *    and service fee (depFee) is available in account.  Service
     *    fee is taken off balance.
     * 
     * @param amount = positive double number
     * @return: true if transaction successful; false otherwise
     */
    public boolean deposit(double amount){
        if (amount > 0){
            double newBal = balance + amount - depFee;
            if (newBal > 0){
                balance = newBal;
                return true;
            }
            else{
                System.out.println("deposit error: balance not sufficient to"
                        + " cover service fee");
            }
        }//outer if
        else{
            System.out.printf("deposit error:  amount (%.2f) should be "
                    + "positive \n", amount);
        }
        return false;
            
    }//deposit
    
    /**************************************
     * withdrawal
     *    Subtract amount (and service fee) from balance, assuming amount 
     *    is positive and service fee (depFee) is available in account
     * 
     * @param amount = positive double number
     * @return: true if transaction successful; false otherwise
     */
    public boolean withdrawal(double amount){
        if (amount > 0){
            double totalW = amount + withdrawFee;
            if (balance > totalW){
                balance = balance - totalW;
                
                //might change minBalance
                if (balance < minMonthBalance)
                    minMonthBalance = balance; 
                return true;
            }
            else{
                System.out.printf("withdrawal error:  amount and service fee"
                        + " (%.2f) is greater than balance\n", totalW);
                return false;
            }
        }
        else{
            System.out.printf("withdrawal error:  amount (%.2f) should be "
                    + "positive\n", amount);
            return false;
        }        
    }//withdrawal
    
    /**************************************
     * endOfMonth
     *    Adds interest to balance and prints report
     */
    public void endOfMonth(){
        balance = balance + minMonthBalance * interestRate;
        minMonthBalance = balance;
        System.out.println("===========================");
        System.out.println(this);

    }//endOfMonth
    
    /**************************************
     * billPayment
     *    Prints error message, as bills cannot be paid on
     *    general accounts.
     * 
     * @param amount = amount of the bill (positive double)
     * @param g = account to pay
     * @return false since action is not successful
     */
    public boolean billPayment(double amount, GeneralAccount g){
        System.out.println("ERROR -- no bill payments allowed");
        return false;
    }//billPayment
    
    /**************************************
     * chequeCashed
     *    Prints error message, as cheques cannot be cashed on
     *    general accounts.
     * 
     * @param num = the cheque number (an int)
     * @param amount = amount of the cheque (positive double)
     * @return false since action is not successful
     */
    public boolean chequeCashed(int num, double amount){
        System.out.println("ERROR -- no cheques allowed");
        return false;
    }//chequeCashed
    
    /**************************************
     * toString
     *    Gives String representation of an account
     * 
     * @return the String representation
     */
    @Override
    public String toString(){
        return "\n" +accountNum + "\n" + lastName.toUpperCase() + ", " + 
                firstName + "\n" +  
                "Balance: " + String.format("%.2f", balance) ;
    }//toString
 
}//GeneralAccount
