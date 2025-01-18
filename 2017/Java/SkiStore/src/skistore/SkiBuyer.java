/*
 * SkiBuyer  (part of SkiStore package)
 * R. Heise
 * 9 March 2017
 *
 * CONSUMER
 */

package skistore;

import java.util.Random;


/**
 * SkiBuyer
 * This class ...
 *
 * @author Rosanna
 */
public class SkiBuyer extends PeopleInStore{
    private String name;
    private boolean done = false; //won't synch on this, as it does not
                                  //need to be exact
                                  //main tells when to close store and
                                  //then done is set to true
    public static Object boughtLock = new Object();
    public static int skiisBought = 0;
    
    SkiBuyer(String name){
        this.name = name;
        done = false;
    }
    
    public void run(){
        int numSkiis = 0;//need to get 2
        int numWaitTime = 0;//for deciding when to give back a ski
        synchronized(PRINTLOCK){
            System.out.println(name + " is in the store, wants 2 skiis");
        }
        
        while (!done && numSkiis < 2){//counter < 100
            
            synchronized(SKILOCK){               
                if (skiisAvailable > 0){
                    synchronized(PRINTLOCK){
                        System.out.println("-----Skiis Available: " + 
                            skiisAvailable + " " + name + " taking 1");
                    }
                
                    skiisAvailable--;//Take a ski
                    numSkiis += 1;  //Have a ski
                }//if
                else{
                    try{
                        SKILOCK.wait(1);
                        //when wait is done, don't assume skiis available
                        //hence why there is a while loop
                        numWaitTime++;
                    } catch (Exception e) {
                        System.out.println("Exception waiting SkiBuyer");
                    }
                }//else
                
                if(numWaitTime > 3 && numSkiis == 1){
                    System.out.println(name + "gave 1");
                    skiisAvailable++;
                    numWaitTime = 0;
                    numSkiis = 0;
                    SKILOCK.notifyAll();
                    try{
                        SKILOCK.wait(1);
                    }catch (Exception e) {
                        System.out.println("Exception waiting SkiBuyer");
                    }    
                }
                  
                
            }//synch
            if (numSkiis == 2){
                done = true; 
                synchronized(boughtLock){
                    skiisBought += 2;
                }
            }
            
        }//while
        synchronized(PRINTLOCK){
            System.out.print("=====" + name + " is ");
            System.out.print((numSkiis == 2) ? "happy" : "sad");
            System.out.println(" with " + numSkiis + " skiis\n");
        }
        if (numSkiis == 1){//put it back
            synchronized(SKILOCK){
                skiisAvailable++;
            }
        }//if
    }//run
    
    public void closeStore(){
        done = true;
    }
}//class SkiBuyer
