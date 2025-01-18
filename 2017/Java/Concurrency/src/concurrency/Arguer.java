/**
 * Arguer.java
 * by Nathan Pelletier
 * Feb 1 2017
 * 
 * Each arguer takes a name and states its argument until it maxes out.
 * When the arguer is finished it will state so and place itself 
 * on the winners chart.
 *
 */

package concurrency;

/**
 * Arguer
 * @author Nathan Pelletier
 */
public class Arguer extends Thread{
    
    private static final Object lock = new Object();
    
    private static final int MAX = 20; 
//used to end threads at 20
    private static String WINNER = ""; 
//saves the winner results 
    private String name;
    
    private String argument;
    
    
    /**
     * Arguer(string, string)
     * sets up parameters for run, allowing threads
     * to hold required information
     * @param name
     * @param argument 
     */
    Arguer(String name, String argument){
        this.name = name;
        this.argument = argument;
    }//Arguer
    
    /**
     * run()
     * takes a name and argument from Arguer 
     * and causes the thread to state its argument 
     * MAX times before entering the thread into the winners chart
     * 
     */
    public void run(){
        int x = 0; //ensure loop starts at 0
        System.out.println("===" + name + " is starting.");
        
        while(x < MAX){
            
           System.out.println("   " + name + ": " + argument);
           x++; //end loop at MAX
       }//while
        
        System.out.println("=== " + name + " reached MAX ARGUMENTS");
        System.out.println("===" + name + " grabbed lock");
        synchronized(lock){
        winner_chart(name);  //all done, so saved in WINNER
        }//synchronized bit to ensure that each thread
        //enters the winner chart on time
        System.out.println("===" + name + " released lock");
    }//argue
    
    /**
     * winner_chart(String)
     * saves a name into string WINNER
     * @param name2 
     */
    public void winner_chart(String name2){
        WINNER = WINNER + "   " + name2 + " \n";
    }//winner chart
    
    /**
     * print_winners()
     * prints a previously set up winner chart
     */
    public static void print_winners(){
        State endPeace = PeaceMaker.State.TERMINATED;//didn't know what this did at the time
        System.out.println("And the winners are: ");
        System.out.println(WINNER);
    }//print_winners

}//arguer
