/**
 * Deals solely with prof behavior and whether a prof is sleeping,
 * hungry, eating, coding or done
 * Profs will cycle between each until both 85 noodles have been eaten and
 * 200 lines of code have been created(or more in both cases)
 * Profs end early if 24 hours have passed 
 * by Nathan Pelletier
 * 
 * HAVING PROBLEM WITH thread.notifyAll() command that ends program early
 */

//package diningprogrammers;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ////////////////////
 * //GLOBAL VARIABLES//
 *  + BIBLOCK
 *  + FORKLOCK
 *  - name 
 *  + time left
 *  - lines coded
 *  - noodles
 *  + rng 
 * 
 * ///////////
 * //METHODS//
 *     + Prof
 *     + run
 *     - sleep
 *     - program
 *     - eat
 * @author Nathan Pelletier
 */
public class Prof extends BasketCase{
    
    ////////////////////
    //GLOBAL VARIABLES//
    public static final Object FORKLOCK = new Object();
    public static final Object BIBLOCK = new Object();
    private final String name;
    //probably could be set to 3000 for more effect
    public long time_left = 28800; //seconds in 8 hours 
    //desided to make next two global due to running tally nature
    private long lines_coded;
    private long noodles;
    //all my random number generated needs
    public static Random rng = new Random();
    
    
    ///////////
    //METHODS//
    Prof(String name){
        this.name = name;
    }
    
    
    /**
     * run()
     * activates sleep, program and eat respectively
     * when either 200 lines of code and 80 noodles are eaten or
     * when 24 hours has passed the thread ends.
     */
    public void run(){
        int hunger = 0;
        boolean done = false;
        boolean f = false; //f for fork 
        boolean b = false; //b for bib
        int waiting = 0; //waiting for food
        
        while(!done){
            program();
            while(hunger > 2){
//number here controls how often a programmer eats
                synchronized(BIBLOCK){ //not sure if i need this
                    if(!b)
                        b = get_bib();
                }//synch
                
                synchronized(FORKLOCK){
                    if(!f)
                        f = get_fork();
                }//synch
                
                waiting++;
                
                if(b && f){
                    eat();
                    hunger = 0;//reset to exit loop
                    b = false;//reset all variables for next time
                    f = false;
                    time_left = time_left - waiting;
                    waiting = 0;
                }//if
                
                if(waiting >= 3 && f){
                    System.out.println(name 
                            + " had a fit waiting for food... and is "
                                    + "throwing a... EVERYONE DOWN! FORK "
                                    + "INCOMMING!");
                    System.out.println(Prof.activeCount() + " profs dodged.");
                    //extra line that finds out how many profs dodged
                    synchronized(FORKLOCK){
                        f = give_fork();
                        FORKLOCK.notifyAll();
                    }//synch
                    time_left = time_left - waiting;
                    waiting = 0;
                }//impatiant fit while holding fork
                
                
                if(waiting >= 3 && b){
                    System.out.println(name 
                            + " had a fit waiting for food... and threw a "
                                    + "bib... wonderful.");
                    synchronized(BIBLOCK){
                        b = give_bib();
                        BIBLOCK.notifyAll();
                    }//synch
                    time_left = time_left - waiting;
                    waiting = 0;
                }//impatiant fit while holding bib
                
                
                if(waiting >= 3){
                    System.out.println(name 
                            + " had a fit waiting for food...");
                    time_left = time_left - waiting;
                    waiting = 0;
                }//just had a fit 
                
                
            }//hungry while
            
            hunger++;
            sleep();
            
            if(time_left <= 0 || lines_coded >= 200 && noodles >= 85){
                System.out.println(time_left 
                        + " " + bibs + " " + forks); //JUST FOR TESTING
                done = true; //checks if done before looping again
            }    
        }//while
        

        //case 1: time ran out
        
        if(time_left <= 0){
            System.out.println(name + " has ran out of time.");
            System.out.println("Lines coded: " + lines_coded);
            System.out.println("Noodles eaten: " + noodles);
        }//if
        
        //case 2: sucsess
        else
            System.out.println("===" + 
                    name + " has finished succesfully");
    }//run
      
    /**
     * sleep()
     * puts prof to sleep for random time
     */
    private void sleep(){
        long time_slept;
        time_slept = rng.nextInt(100);
        System.out.println(name + " is going to sleep for " + time_slept + 
                " milliseconds.");
        
        try {
            Prof.sleep(time_slept);
        } catch (InterruptedException ex) {
            Logger.getLogger(Prof.class.getName()).
                    log(Level.SEVERE, null, ex);
        }//try catch added by netbeans (I never really understood these) 
        
        time_left = time_left - time_slept;
    
    }//sleep
    
    /**
     * program()
     * prof programs random number of lines at one
     * millisecond per line of code
     * 
     */
    private void program(){
        long programming;
        programming = rng.nextInt(20);
        lines_coded = lines_coded + programming;
    
        System.out.println("***" + name + " programmed " + programming
                + " lines of code. In total: " + lines_coded);
        
        //forcing thread to take time by using .sleep command until a better 
        //way is found
        try {
            Prof.sleep(programming);
        } catch (InterruptedException ex) {
            Logger.getLogger(Prof.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        time_left = time_left - programming;
        
    }//program
    
    /**
     * eat()
     * prof eats random amount until full
     * Hunger managed in run()
     */
    private void eat(){
        long temp;
        
        //eating with supplies
        temp = rng.nextInt(8);//0-8 offset by two to 2-10
        temp = temp + 2;
        noodles = temp + noodles;
        
        try {
            Prof.sleep(temp);
        } catch (InterruptedException ex) {
            Logger.getLogger(Prof.class.getName()).
                    log(Level.SEVERE, null, ex);
        }//try catch for sleep thread
        
        System.out.println("+++" + name + " ate " 
                + temp + " noodles. In total :" + noodles);
        
        
        //give back supplies  
        synchronized(BIBLOCK){
            give_bib(); // = so I can update variables
            BIBLOCK.notifyAll();
        }//synch
        
        synchronized(FORKLOCK){
            give_fork();
        
            FORKLOCK.notifyAll();
        }//synch
        time_left = time_left - temp;
    }//eat

}//Prof
