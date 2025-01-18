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
public class SpecialChequingAccount extends ChequingAccount {
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
    public SpecialChequingAccount(String num, String fName, String lName, 
                          double amount){
        super(num, fName, lName, amount);
        if (amount >= 1000){
            depFee = 0;
            withdrawFee = 0;
            bill_fee = 0;
        }//no service fees  
        
    }//Constructor, all arguments
        public SpecialChequingAccount
        (String num, String fName, String lName) {
        
        super(num, fName, lName, 0); 
    }
   
    public SpecialChequingAccount(String num){
        super(num, "Unknown", "Unknown", 0);
    }//Constructor, missing amount and names
    
    public SpecialChequingAccount(){
        super("0", "Unknown", "Unknown", 0);               
    }//default constructor, no arguments given
    
    /**************************************
     * withdrawal
     *    Subtract amount (and service fee) from balance, assuming amount 
     *    is positive and service fee (depFee) is available in account
     * 
     * @param amount = positive double number
     * @return: true if transaction successful; false otherwise
     */
    
    @Override
    public boolean withdrawal(double amount){
        if (amount > 0){
            double totalW = amount + withdrawFee;
            if (balance > totalW){
                balance = balance - totalW;
                if(balance < 1000 && withdrawFee == 0){ //ensures is only done
                                                        //once a month
                    withdrawFee = 3.5;
                    bill_fee = 5.5;
                }//service fees return to normal
                
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
    @Override
    public void endOfMonth(){
        balance = balance + minMonthBalance * interestRate;
        minMonthBalance = balance;
        System.out.println("===========================");
        System.out.println(this + cheque_numbers);
        cheque_numbers = "";         
        if(minMonthBalance >= 1000){
            withdrawFee = 0;
            bill_fee = 0;
        }//no service fees
        
    }//endOfMonth
    
}//special class
