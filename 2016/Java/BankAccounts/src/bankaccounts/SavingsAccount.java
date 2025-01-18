/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */

package bankaccounts;

/**
 *
 * @author Nathan Pelletier
 */
public class SavingsAccount extends GeneralAccount {
    //===========================================
    //DATA
    private int first_time;

    //===========================================   
    //METHODS
    
    /**************************************
     * Constructors
     *    Creates account, sets withdraw fees to $5.5, 
     *    all other fee amounts to 0.
     *    Sets intrest to 0.2%
     * 
     * @param num = the account number, given as a String.
     * @param fName = the first name of account holder, given as a String.
     * @param lName = the last name of account holder, given as a String.
     * @param amount = the initial deposit amount (must be +ve or set to 0)
     */
    public SavingsAccount(String num, String fName, String lName, 
                          double amount){
        super(num, fName, lName, amount);
        first_time = 0;
        withdrawFee = 5;
        interestRate = 0.002;
    }//Constructor, all arguments
    
    public SavingsAccount(String num, String fName, String lName){
        super(num, fName, lName, 0);
    }//Constructor, missing amount
    
    public SavingsAccount(String num){
        super(num, "Unknown", "Unknown", 0);
    }//Constructor, missing amount and names
    
    public SavingsAccount(){
        super("0", "Unknown", "Unknown", 0);               
    }//default constructor, no arguments given
    
    /**************************************
     * withdrawal
     *    Subtract amount (and service fee, if applicable) from balance, 
     *    assuming amount is positive and service fee (depFee) 
     *    is available in account
     * 
     * @param amount = positive double number
     * @return: true if transaction successful; false otherwise
     */
    @Override
    public boolean withdrawal(double amount){
        double totalW;
        if (amount > 0){
            if (first_time == 0){
                totalW = amount;
                first_time = first_time + 1;
            }//checkes if first time this month and removes fee if it is
            else
                totalW = amount + withdrawFee;  
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
     *    Resets first payment of the month check
     */
    @Override
    public void endOfMonth(){
        first_time = 0;
        balance = balance + minMonthBalance * interestRate;
        minMonthBalance = balance;
        System.out.println("===========================");
        System.out.println(this);

    }//endOfMonth
    



}//svings class
