/**
 * AUCSC 112 Test Suite
 * for Lab #4
 * @author R. Heise
 */

package bankaccounts;


public class TestSuite{
    public static void runTests(){
        testCheque();
        testSpecialCheque();
        testSavings();       
    }
    
    public static void testCheque(){
        System.out.println("=============== START OF CHEQUINGACCOUNT TESTS "
                + "=========================");
        
        ChequingAccount ch1 = new ChequingAccount("03", "Donald", "Duck", 
                1000);
        ChequingAccount ch2 = new ChequingAccount("06", "Mickey", "Mouse", 
                250);
        ChequingAccount ch3 = new ChequingAccount("09", "Tweety", "Bird", 
                4000);
        ChequingAccount ch4 = new ChequingAccount();
        ChequingAccount ch5 = new ChequingAccount("100");
        
        System.out.println("=======   ch1  " + ch1);
        ch1.deposit(12.50);
        System.out.println("deposit(12.50)=======   ch1  " + ch1);
        ch1.deposit(-12.50);
        System.out.println("deposit(-12.50)=======   ch1  " + ch1);
        ch1.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch1  " + ch1);
        ch1.withdrawal(-100);
        System.out.println("withdrawal(-100)=======   ch1  " + ch1);
        ch1.withdrawal(5000);
        System.out.println("withdrawal(5000)=======   ch1  " + ch1);
        ch1.billPayment(25.75, ch4);
        System.out.println("billPayment(25.75, ch4)=sent==   ch1  " + ch1);
        System.out.println();
        System.out.println("billPayment(25.75, ch4)=recv==   ch4  " + ch4);
        ch1.billPayment(-25.75, ch4);
        System.out.println("billPayment(-25.75, ch4)=======   ch1  " + ch1);
        System.out.println("billPayment-(25.75, ch4)=recv==   ch4  " + ch4);
        ch1.billPayment(5000, ch4);
        System.out.println("billPayment(5000, ch4)=======   ch1  " + ch1);
        System.out.println("billPayment(5000, ch4)=recv==   ch4  " + ch4);
        ch1.chequeCashed(35, 70);
        System.out.println("chequeCashed(35, 70)=======   ch1  " + ch1);
        ch1.chequeCashed(38, -71);
        System.out.println("chequeCashed(38, -71)=======   ch1  " + ch1);
        ch1.chequeCashed(36, 100.50);
        System.out.println("chequeCashed(36, 100.50)=======   ch1  " + ch1);
        ch1.chequeCashed(32, 5000);
        System.out.println("chequeCashed(32, 5000)=======   ch1  " + ch1);
        ch1.endOfMonth();
        
        ch1.deposit(2500);
        ch1.chequeCashed(40, 250);
        ch1.endOfMonth();
        
        ch1.withdrawal(400);
        ch1.billPayment(35.90, ch4);
        ch1.endOfMonth();
        
        System.out.println("=======   ch2  " + ch2);
        ch2.deposit(85);
        ch2.deposit(100);
        ch2.deposit(300);
        ch2.withdrawal(40);
        ch2.withdrawal(30);
        ch2.withdrawal(10);
        ch2.billPayment(5.5, ch4);
        ch2.chequeCashed(8, 30);
        ch2.endOfMonth();
        
        System.out.println("=======   ch3  " + ch3);
        ch3.deposit(20);
        ch3.withdrawal(100);
        ch3.billPayment(40, ch4);
        ch3.chequeCashed(125, 70);
        ch3.chequeCashed(130, 200);
        ch3.endOfMonth();
        
        System.out.println("=======   ch4  " + ch4);
        System.out.println("=======   ch5  " + ch5);
        System.out.println("=============== END OF CHEQUINGACCOUNT TESTS "
                + "=========================");
    }//testCheque
    
    public static void testSpecialCheque(){
        System.out.println("=============== START OF SPECIALCHEQUINGACCOUNT "
                + "TESTS "
                + "=========================");

        SpecialChequingAccount ch5 = new SpecialChequingAccount("150", 
                "Santa", "Claus", 1000);
        SpecialChequingAccount ch6 = new SpecialChequingAccount();
        SpecialChequingAccount ch7 = new SpecialChequingAccount("54");
        
        System.out.println("=======   ch5  " + ch5);
        ch5.deposit(12.50);
        System.out.println("deposit(12.50)=======   ch5  " + ch5);
        ch5.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch5  " + ch5);
        ch5.withdrawal(200);
        System.out.println("withdrawal(200)=======   ch5  " + ch5);
        ch5.billPayment(25.75, ch6);
        System.out.println("billPayment(25.75, ch6)=======   ch5  " + ch5);
        System.out.println("billPayment(25.75, ch6)=======   ch6  " + ch6);
        ch5.billPayment(-25.75, ch6);
        System.out.println("billPayment(-25.75, ch6)=======   ch5  " + ch5);
        System.out.println("billPayment(-25.75, ch6)=======   ch6  " + ch6);
        ch5.chequeCashed(35, 70);
        System.out.println("chequeCashed(35, 70)=======   ch5  " + ch5);
        ch5.chequeCashed(36, 100.50);
        System.out.println("chequeCashed(36, 100.50)=======   ch5  " + ch5);
        ch5.chequeCashed(99, 5000);
        System.out.println("chequeCashed(36, 5000)=======   ch5  " + ch5);
        ch5.endOfMonth();
        
        ch5.deposit(2500);
        ch5.chequeCashed(40, 250);
        ch5.chequeCashed(41, 9000);
        ch5.endOfMonth();
        
        ch5.withdrawal(400);
        ch5.billPayment(35.90, ch6);
        ch5.endOfMonth();
        
        System.out.println("=======   ch6  " + ch6);
        System.out.println("=============== END OF SPECIALCHEQUINGACCOUNT "
                + "TESTS "
                + "=========================");
    }//testSpecialCheque
    
    public static void testSavings(){
        System.out.println("=============== START OF SAVINGSACCOUNT TESTS "
                + "=========================");
        SavingsAccount ch7 = new SavingsAccount("21", "Road", "Runner", 
                10000);
        SavingsAccount ch8 = new SavingsAccount("24", "Porky", "Pig", 50);
        SavingsAccount ch9 = new SavingsAccount("27", "Bunny", "Bugs", 
                4000);
        SavingsAccount ch10 = new SavingsAccount();
        
        System.out.println("=======   ch7  " + ch7);
        ch7.deposit(12.50);
        System.out.println("deposit(12.50)=======   ch7  " + ch7);
        ch7.deposit(-12.50);
        System.out.println("deposit(-12.50)=======   ch7  " + ch7);
        ch7.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch7  " + ch7);
        ch7.withdrawal(-100);
        System.out.println("withdrawal(-100)=======   ch7  " + ch7);
        ch7.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch7  " + ch7);
        ch7.billPayment(25.75, ch9);
        System.out.println("billPayment(25.75, ch9)=======   ch7  " + ch7);
        ch7.chequeCashed(35, 70);
        System.out.println("chequeCashed(35, 70)=======   ch7  " + ch7);
        ch7.endOfMonth();
        
        ch7.deposit(2500);
        System.out.println("deposit(2500)=======   ch7  " + ch7);
        ch7.withdrawal(100000);
        System.out.println("withdrawal(100000)=======   ch7  " + ch7);
        ch7.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch7  " + ch7);
        ch7.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch7  " + ch7);
        ch7.withdrawal(100);
        System.out.println("withdrawal(100)=======   ch7  " + ch7);
        ch7.endOfMonth();
        
        ch7.withdrawal(400);
        ch7.endOfMonth();
        
        System.out.println("=======   ch8  " + ch8);
        ch8.withdrawal(10);
        ch8.withdrawal(10);
        ch8.withdrawal(10);
        ch8.withdrawal(10);
        ch8.withdrawal(10);
        ch8.deposit(85);
        ch8.withdrawal(10);
        ch8.endOfMonth();
        
        System.out.println("=======   ch9  " + ch9);
        ch9.deposit(20);
        ch9.withdrawal(100);
        ch9.endOfMonth();
        
        System.out.println("=======   ch10  " + ch10);
        System.out.println("=============== END OF SAVINGSACCOUNT TESTS "
                + "=========================");
    }//testSavings
    
    
}//Test Suite
