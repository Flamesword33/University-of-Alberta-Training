/*
 * SkiMaker.java (Part of SkiStore package)
 * R. Heise
 * 9 March 2017
 *
 * PRODUCER
 */

package skistore;

/**
 * SkiMaker
 * This class ...
 *
 * @author Rosanna
 */
public class SkiMaker extends PeopleInStore{
    private static final int TIME = 100; //create a doing time
    private static boolean done = false;
    private String name;
    public static int skiisMade = 0; //synch on skiLock
    
    SkiMaker(String name){
        this.name = name;
    }
    
    public void run(){
        int garbage = 0;
        
        while (!done){ //counter < 100
            makeSki();
            for(int i=0; i < TIME; i++){
                garbage = garbage + 1; //waste some time but keep CPU
            }//for

            try {
                sleep(0, 1);
            } catch (Exception e) {
                System.out.println("Exception in SkiMaker");
            }
        }//while
    }//run
    
    public void makeSki(){
        synchronized(SKILOCK){
            skiisAvailable++; //Add ski to rack
            skiisMade++;
            synchronized(PRINTLOCK){
                System.out.println("++++++" + skiisMade + " " + name + 
                    " made a ski; Total skiis available " + skiisAvailable);
            }
            SKILOCK.notifyAll();
        }//synch
    }//makeSki
    
    public void closeStore(){
        done = true;
    }

}//class SkiMaker
