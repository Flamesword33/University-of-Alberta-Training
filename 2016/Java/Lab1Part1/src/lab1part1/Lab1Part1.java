/**
 * The purpose of this file is to illustrate a simple Java function that will
 * print out an integer with its digits in reverse order, i.e.
 * 13456 gets printed as 65431
 * 
 *
 * by R. Heise
 * AUCSC 112
 * 15 January 2015

 */
package lab1part1;

/**
 * Methods contained in class Lab1Part1:
 * reverseInt(int)
 *      Prints the integer in reverse order.
 * main(String[])
 *      Tests reverseInt with input numbers from user.
 * 
 * @author R. Heise
 * @date 15 January 2015
 */
public class Lab1Part1 {

    /**
     * Tests reverseInt with input numbers from user.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("The reverse of 12345 is ");
        reverseInt(12345);
        
        System.out.print("The reverse of 100 is ");
        reverseInt(100);
        
        System.out.print("The reverse of 2 is ");
        reverseInt(2);
        
        System.out.print("The reverse of 567891023 is ");
        reverseInt(567891023);
 
        System.out.print("The reverse of 0 is");
        reverseInt(0);
        
        System.out.print("The reverse of -13 is ");
        reverseInt(-13);
        
        System.out.print("The reverse of -43567 is");
        reverseInt(-43567);
        
    }
    
     /**
     * Prints num in reverse order.
     * @param num an integer (size between -2^15 and 2^15 - 1)
     *        i.e. between -32,768  and +32,767 inclusive
     */   
   
    public static void reverseInt(int num){ //**line 60
        final int TEN = 10;                 //**line 61
        int digit;                          //**line 62
        int negitive;
        
        //print from back towards front
        digit = num % TEN; //get the last digit  
           
        if (num == 0)
            System.out.print(0);
        else if (num < 0){
            num = num * -1;
            negitive = num % TEN;
            while (num > 0){
                System.out.print(negitive);
                num = num / 10;
                digit = num % TEN;
            }//while
            System.out.print("-");
        }//else if
        else 
        {while (num > 0){                    //**line 66
            System.out.print(digit);        //**line 67
            num = num / 10; //remove last digit from num, i.e. shift it right
            digit = num % TEN;              //**line 69
        }//while
        }//else if
        
            
        System.out.println();               //**line 71
        
    }//reverseInt
}//main