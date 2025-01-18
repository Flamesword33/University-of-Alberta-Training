/**
 * An even determination program, program will ask for numbers until 
 * user gives a string breaking out of the program.
 * Example numbers are posted.
 * by Nathan Pelletier
 * January 18, 2016
 */
package lab1part3;

import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class Lab1Part3 {
    public static void even(int number){
        
        int compairison; //compaired to number after bit shifting
        
        compairison = number >> 1; //ex. 111 >> 011 
        compairison = compairison << 1; //ex. 011 << 110
        
        if(compairison == number) 
            System.out.println(number + " is even.");
        else
            System.out.println(number + " is odd.");                
    }//even
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num;
        
        even(5);
        even(6);
        //copy and pasted from Sum_of_intergers class
        Scanner keyboardIn = new Scanner(System.in);
        System.out.print("Enter an interger ('e' to quit): ");
        
        while(keyboardIn.hasNextInt()){ // quits on non interger
            num = keyboardIn.nextInt();
            even(num);
            System.out.print("Enter an interger ('e' to quit): ");
        }//while
    }//main
    
}//class
