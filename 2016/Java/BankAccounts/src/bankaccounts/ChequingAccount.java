/**
 * Creates a class chequing account which draws on general account
 * allows user to deposit, withdraw, cash cheques and pay bills
 * by Nathan Pelletier
 * February 23 2016
 * 
 * finished: 
 *      bill payment
 *      cheque deposit
 *      end of month 
 *  
 */

package bankaccounts;

public class ChequingAccount extends GeneralAccount {
    //===========================================
    //DATA
    public double bill_fee;
    public String cheque_numbers;
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
    public ChequingAccount(String num, String fName, String lName,
            double amount){
        super(num, fName, lName, amount);
        
        withdrawFee = 3.5;
        bill_fee = 5.5;
        cheque_numbers = "";
    }
    
    public ChequingAccount(String num, String fName, String lName) {
        
        super(num, fName, lName, 0); 
        withdrawFee = 3.5;
        bill_fee = 5.5;
        cheque_numbers = "";
    }
   
    public ChequingAccount(String num){
        super(num, "Unknown", "Unknown", 0);
        withdrawFee = 3.5;
        bill_fee = 5.5;
        cheque_numbers = "";
    }//Constructor, missing amount and names
    
    public ChequingAccount(){
        super("0", "Unknown", "Unknown", 0); 
        withdrawFee = 3.5;
        bill_fee = 5.5;
        cheque_numbers = "";
    }//default constructor, no arguments given
    
    
    
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
   
    @Override
    public boolean billPayment(double amount, GeneralAccount g){
        if(amount > 0)
            if(balance > (amount + bill_fee + withdrawFee)){
                withdrawal(amount + bill_fee);
                g.deposit(amount);
                return true;            
            }//if   
            else{
                System.out.println("Error, not enough funds to continue.");
                return false;
            }//else
        System.out.println("Try a positive ammount.");
        return false;
    }//billPayment
    
    /**************************************
     * chequeCashed
     *    Prints 
     * 
     * @param num = the cheque number (an int)
     * @param amount = amount of the cheque (positive double)
     * @return false since action is not successful
     */
    @Override
    public boolean chequeCashed(int num, double amount){
        if (amount > 0){
            if (balance >(amount + withdrawFee)){
                cheque_numbers = cheque_numbers + num + " ";
            
            return true;
            }//if cheque is deposited
            else{
                System.out.println("Your cheque bounced.");
                return false;
            }//else cheque bounces
        }//if positive
        System.out.println("Please try a positive amount.");
        return false;
    }//chequeCashed
    
    @Override
    public String toString(){
        return "\n" +accountNum + "\n" + lastName.toUpperCase() + ", " + 
                firstName + "\n" +  
                "Balance: " + String.format("%.2f", balance) +
                "\n" + "Cheques cashed this month: " + cheque_numbers;
    }//toString
    
}//cheque class
