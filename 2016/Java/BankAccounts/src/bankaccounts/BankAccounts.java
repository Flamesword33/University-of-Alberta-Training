/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package bankaccounts;

import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class BankAccounts {
    //////////////////////////////////
    //Methods
    
    /**
     * main
     *  calls all other functions and starts program
     * 
     * @param args 
     */
    
    public static void main(String[] args) {
        bankaccounts.TestSuite.runTests();
        system_interface();
        
    }//main
    
    /**
     * system_interface
     *    Creates an interface for the user to create accounts and manage 
     *    existing accounts.     
     */
    public static void system_interface(){
        
        /////////////////EXAMPLE ACCOUNTS FOR TEMP USE//////////////////////
        SavingsAccount ch15 = new SavingsAccount("03", "Donald", "Duck", 
                1000);
        ChequingAccount ch16 = new ChequingAccount("06", "Mickey", "Mouse", 
                250);
        GeneralAccount ch17 = new GeneralAccount("09", "Tweety", "Bird", 
                4000);
        SpecialChequingAccount ch18 = new SpecialChequingAccount("10", 
                "Samity", "Sam", 8000);
        ////////////////////////////////////////////////////////////////////
        
        Scanner input = new Scanner(System.in);
        
        //allow access to acounts and inner workings
        int selection;
        String responce; //determines if user would like another transasction
        String u_responce;   //second string to upper case 
        int acount_num = 18; //due to examples, normally would start at 0
        String first_name;      
        String last_name;
        double ammount = 0;     //general ammount used, in any double case
        //equals zero ensures ammount is reset each time
        String acount_string;       //converts int to string for use
        int cheque_num;
      
        
        System.out.println("Please select an acount: ");
        System.out.println("0.New Account");
        System.out.println("1.General Account");
        System.out.println("2.Chequing Account");
        System.out.println("3.VIP Chequing Account");
        System.out.println("4.Savings Account");
        System.out.println("5.EXIT");
        System.out.print(": ");
        selection = input.nextInt();
        
        //gets more spcific to account asked for
        //in real world would be mapped to buttons
       
        switch (selection){
            case 0://new account
                
                System.out.println("Please follow the screen prompts: ");
                
                System.out.println("Using the numbers above which "
                        + "acount would you like to open?");
                selection = input.nextInt();
                
                System.out.println("Please enter your first name: ");
                first_name = input.next();
                
                System.out.println("Please enter your last name: ");
                last_name = input.next();
                
                System.out.println("Finally what amount would you like "
                        + "to be initially deposited in your new account: ");
                ammount = input.nextInt();
                if (ammount > 0)
                    System.out.println("An envelop will "
                            + "be dispensed shortly.");
 
                acount_num = acount_num + 1;
                acount_string = "" + acount_num; 
                
                 //might need to check on when testing
              
                switch(selection){
                    // dosen't work for multiple accounts 
                    //due to screwy variable system, consider replacing with
                    // a changing varible or dictionary whenever redecovered
                    //Needs to print out inputed values
                    
                    case 1:
                        GeneralAccount ch11 = new GeneralAccount
        (acount_string, first_name, last_name, ammount);
                        break;
                    
                    case 2:
                        ChequingAccount ch12 = new ChequingAccount
                        (acount_string, first_name, last_name, ammount);
                        break;
                    
                    case 3:
                        SpecialChequingAccount ch13 = new 
                                SpecialChequingAccount
                        (acount_string, first_name, last_name, ammount);
                        break;
                        
                    case 4:
                        SavingsAccount ch14 = new 
        SavingsAccount(acount_string, first_name, last_name, ammount);
                        break;
                }//case 0 switch
                
                break;
            case 1://general account
                System.out.println("What would you like to do?");
                System.out.println("    1.Deposit");
                System.out.println("    2.Withdraw");
                System.out.println("    3.Ballance");
                selection = input.nextInt();
                
                switch(selection){
                    
                //////////////////////////////////////////////////    
                //does nothing as object must be garenteed to be//
                //created in order to work                      //
                //////////////////////////////////////////////////    
                    
                    case 1:
                        System.out.println("Please enter an "
                                + "amount to deposit: ");
                        ammount = input.nextDouble();
                        
                        ch17.deposit(ammount);
                        break;
                    
                    case 2:
                        System.out.println("Please enter an "
                                + "amount to withdraw: ");
                        ammount = input.nextDouble();
                        
                        ch17.withdrawal(ammount);
                        break;
                    
                    case 3:
                        System.out.println(ch17.toString());
                        break;
                }//case 1 switch     
                break;
                
            case 2://Chequing account
                System.out.println("What would you like to do?");
                System.out.println("    1.Deposit");
                System.out.println("    2.Withdraw");
                System.out.println("    3.Ballance");
                System.out.println("    4.Cash a Cheque");
                System.out.println("    5.Pay a Bill");
                selection = input.nextInt();
                
                switch(selection){
                    
                    case 1: //Deposit
                        System.out.println("Please enter an "
                                + "amount to deposit: ");
                        ammount = input.nextDouble();
                        
                        ch16.deposit(ammount);
                        break;
                    
                    case 2: // withdraw
                        System.out.println("Please enter an "
                                + "amount to withdraw: ");
                        ammount = input.nextDouble();
                        
                        ch16.withdrawal(ammount);
                        break;
                    
                    case 3: // Ballance statement
                        System.out.println(ch16.toString());
                        break;
                        
                    case 4: // Cheque
                        System.out.println("Please enter "
                                + "your cheque number: ");
                        cheque_num = input.nextInt();
                        System.out.println("Please enter the amount: ");
                        ammount = input.nextDouble();
                        ch16.chequeCashed(cheque_num, ammount);
                        break;
                    
                    case 5://Pay bill
                        //Additional quetion toward account number of general
                        //account
                        System.out.println("How much is your bill: ");
                        ammount = input.nextDouble();
                        ch16.billPayment(ammount, ch16);//account num 
                                                        //in place of ch16
                        break;
                        
                }//case 2 switch     
                break;
            case 3://VIP Chequing account
                System.out.println("What would you like to do?");
                System.out.println("    1.Deposit");
                System.out.println("    2.Withdraw");
                System.out.println("    3.Ballance");
                System.out.println("    4.Cash a Cheque");
                System.out.println("    5.Pay a Bill");
                selection = input.nextInt();
                
                switch(selection){   
                    
                    case 1: //Deposit
                        System.out.println("Please enter an "
                                + "amount to deposit: ");
                        ammount = input.nextDouble();
                        
                        ch18.deposit(ammount);
                        break;
                    
                    case 2: // withdraw
                        System.out.println("Please enter an "
                                + "amount to withdraw: ");
                        ammount = input.nextDouble();
                        
                        ch18.withdrawal(ammount);
                        break;
                    
                    case 3: // Ballance statement
                        System.out.println(ch18.toString());
                        break;
                        
                    case 4: // Cheque
                        System.out.println("Please enter your "
                                + "cheque number: ");
                        cheque_num = input.nextInt();
                        System.out.println("Please enter the amount: ");
                        ammount = input.nextDouble();
                        ch18.chequeCashed(cheque_num, ammount);
                        break;
                    
                    case 5://Pay bill
                        //Additional quetion toward account number of general
                        //account
                        System.out.println("How much is your bill: ");
                        ammount = input.nextDouble();
                        ch18.billPayment(ammount, ch18);//account num 
                                                        //in place of ch18
                        break;
                        
                }//case 3 switch 
                break;
            case 4://Savings account
                System.out.println("What would you like to do?");
                System.out.println("    1.Deposit");
                System.out.println("    2.Withdraw");
                System.out.println("    3.Ballance");
                selection = input.nextInt();
                
                switch(selection){    
                    
                    case 1:
                        System.out.println("Please enter an "
                                + "amount to deposit: ");
                        ammount = input.nextDouble();
                        
                        ch15.deposit(ammount);
                        break;
                    
                    case 2:
                        System.out.println("Please enter an "
                                + "amount to withdraw: ");
                        ammount = input.nextDouble();
                        
                        ch15.withdrawal(ammount);
                        break;
                    
                    case 3:
                        System.out.println(ch15.toString());
                        break;
                }//case 4 switch     
                break;
                
            case 5:// EXIT
                break;//use a method call instead
                
            default://wrong entry, DELETE WHEN BUTTONS IMPLIMENTED
                System.out.println("Please use the number "
                        + "selection provided.");
                system_interface();
        }//switch
        
        System.out.println("Would you like another transactrion?");
        responce = input.next();
        u_responce = responce.toLowerCase();
        
        if ("y".equals(u_responce) || "yes".equals(u_responce))
            //found through online help with .equals
            system_interface();
        else
            System.out.println("Thank you for your transaction");
        
        /////////////////////////////////////////////
        //NEEDS TO HAVE LINKED LIST TO HOLD OBJECTS//
        //   DELETES OLD TRANSACTIONS ON OBJECTS   //
        //           NOT SURE HOW TO FIX           //
        /////////////////////////////////////////////
    }//system_interface
    
}//BankAccounts