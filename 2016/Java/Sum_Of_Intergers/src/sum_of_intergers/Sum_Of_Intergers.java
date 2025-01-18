/*
 * Program to get interger from user
 * By Nathan Pelletier
 * January 15, 2016
*/
package sum_of_intergers;

import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class Sum_Of_Intergers {

    /**
     * @param args the command line arguments (none)
     */
    public static void main(String[] args) {
        int num;
        int sum = 0;
        Scanner keyboardIn = new Scanner(System.in);
        System.out.print("Enter an interger ('q' to quit): ");
        while(keyboardIn.hasNextInt()){ // quits on non interger
            num = keyboardIn.nextInt();
            sum = sum + num;
            System.out.print("Enter an interger ('q' to quit): ");
        }//while
        System.out.println("You entered " + sum);
    }//main
    
}//class
