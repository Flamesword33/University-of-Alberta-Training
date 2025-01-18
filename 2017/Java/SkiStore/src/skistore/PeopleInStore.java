/*
 * PeopleInStore.java (Part of SkiStore package)
 * R. Heise
 * 9 March 2017
 *
 * COMMUNICATION between PRODUCER and CONSUMER
 */

package skistore;

/**
 * PeopleInStore
 * This class sets up the ski rack for the store.  Each person would
 * access the same ski rack (whether a ski maker or a ski buyer).
 * 
 * Locks are also set up here, to make printing nicer and for the ski rack
 *
 * @author Rosanna
 */
public class PeopleInStore extends Thread{
    public static int skiisAvailable = 0;//number of skiis on the rack
    public static final Object SKILOCK = new Object();
    public static final Object PRINTLOCK = new Object();
    
    //Putting a ski onto the rack
    public void add(){
        synchronized(SKILOCK){
            skiisAvailable++;
        }
    }
    
    //Taking a ski off the rack
    public void take(){
        synchronized(SKILOCK){
            skiisAvailable--;
        }
    }
    

}//$(name)
