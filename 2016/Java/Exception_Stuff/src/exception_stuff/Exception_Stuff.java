/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package exception_stuff;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class Exception_Stuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int y = 0;
        boolean valid = false;
        do{
            System.out.println ("Enter an integer: ");
            try{
                y = input.nextInt ();
                valid = true;
            }//try
            catch(InputMismatchException e){
                input.next ();
            }//catch
        }while (valid != true);//do and while 
    }//main
    
}//class
