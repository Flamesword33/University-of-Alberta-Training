/**
 * File Purpose
 * by Nathan Pelletier
 * Started March 11 2017
 * Finished March 19 2017
 * 
 * Asks user for how many profs and their names. Then asks user for how many
 * resources are available to start. Program will then start prof threads 
 * and profs will begin to eat 85 or more noodles, write 200 or more lines 
 * of code and will sleep all at random times. Program does not allow profs 
 * to go over 24 hours. All profs need a fork and bib to dine therefore there
 * can be deadlock over materials to which profs will show courtesy.
 * Finally profs will declare when they have finished and will then leave.
 * 
 * TO DO LIST:
 *  BASKET CLASS (DONE)
 *      BIBS IMPLIMENTED (DONE)
 *      FORKS IMPLIMENTED (DONE)
 *      GET ITEM (NOT UPDATING)
 *      GIVE ITEM (NOT UPDATING)
 *      ALLERTS AND ERRORS ()
 *  PROF CLASS (DONE)
 *      RUN (DONE)
 *      SLEEP (DONE)
 *      PROGRAM (DONE)
 *      HUNGRY (DONE)
 *      EAT (DONE)
 *          GIVE 
 *          GET 
 *          LOCKS
 *          ALLERTS
 *      DONE (DONE)
 *      ERRORS (DONE)
 *  DINING PROGRAMMERS
 *      UI (DONE)
 *      THREADS (DONE)
 *      ERRORS ()
 * 
 *  FINAL NOTE: I COULDN'T GET PROFS TO RANDOMLY PICK UP FORKS AND BIBS
 *              AND RANDOMLY PUT THEM BACK WITHOUT BREAKING MY CODE...
 * 
 */
//package diningprogrammers;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NOTE: 
 * + PUBLIC
 * - PRIVATE
 * = PROTECTED
 * 
 * ///////////
 * //METHODS//
 * + main
 * @author Nathan
 */
public class DiningProgrammers {

    /**
     * Creates user interface and profs threads to run 
     * ensures all profs are done before ending
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int profs;
        int x = 0;
        String[] names;
        Prof[] names1;
        Scanner input = new Scanner(System.in);
        int forks;
        int bibs;
        
        
        //UI
        System.out.print("How many Profs do you have: ");
        profs = input.nextInt();
        
        names = new String[profs]; //allocs array for prof names to be put
        names1 = new Prof[profs];
        System.out.println("What are their first names? ");
        
        while(profs > x){
            System.out.print(x + 1 + ": ");
            names[x] = input.next();
            names1[x] = new Prof(names[x]); //initallizes threads 
                                            //(man thats a lot of new)
            x++;
        }//while to get prof names
        
        x = 0;//reset x in case I want to use it again
        
        System.out.println("How many forks are in the basket to eat with?");
        System.out.print(": ");
        forks = input.nextInt();
        
        System.out.println("How many bibs are near the basket to eat with?");
        System.out.print(": ");
        bibs = input.nextInt();
        
        BasketCase.user_input(bibs, forks);
        
        
        //start the threads
        
        while(profs > x){
            names1[x].start();
            x++;
        }//while to start threads
        
        while(profs > x){
            try {
                names1[x].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(DiningProgrammers.class.
                        getName()).log(Level.SEVERE, null, ex);
            }//try catch added by java to use .join
            x++;
        }//final while to stall program until all threads end
        
        
    }//main
    
}//Dining Progammers
