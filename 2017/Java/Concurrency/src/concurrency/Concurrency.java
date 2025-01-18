/**
 * Concurrency.java
 * by Nathan Pelletier
 * started: Feb 1 2017
 * 
 * Checks how many processors are in the given machine,
 * then starts four threads that argue until they hit max arguments.
 * It also starts a peacemaker that argues indefinitely until all winners
 * are declared.
 * 
 */
package concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;//added by Netbeans 

/**
 *
 * @author Nathan
 */
public class Concurrency {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== main is starting . . .");
        processor_check();
        System.out.println();
        Arguer floating = new Arguer("FLOATING", "The "
                + "world is floating in a sea of coal.");
        Arguer angel = new Arguer("ANGEL", "Every star is "
                + "an angel watching us and our destinies.");
        Arguer magical = new Arguer("MAGICAL", "The old woman"
                + " in the bush with the cats says so.");
        Arguer round = new Arguer("ROUND", "As gravity exists,"
                + " the earth seems to bend when on a mountain"
                + " and no man has yet to fall off the earth,"
                + " the earth is therfore round");
        PeaceMaker peace = new PeaceMaker("",""); //could put anything 
        //as I know peace only has one name and two lines 
        
        floating.start();
        angel.start();
        magical.start();
        round.start();
        peace.start();
        
        try{
            floating.join();
            angel.join();
            magical.join();
            round.join();
            peace.join();
        }//try
        
        catch (InterruptedException ex) {  //added by Netbeans
            Logger.getLogger(Concurrency.class.
                    getName()).log(Level.SEVERE, null, ex);
        }//catch
        
        Arguer.print_winners();
    }//main
    
    /**
     * processor_check()
     * gets the approximate number of processors in a given computer
     */
    public static void processor_check(){
        int processor = Runtime.getRuntime().availableProcessors();
        System.out.println(processor);
    }//proccesor_check
    
}//concurrency
