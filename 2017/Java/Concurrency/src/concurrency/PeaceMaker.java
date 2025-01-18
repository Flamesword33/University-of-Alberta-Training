/**
 * PeaceMaker.java
 * by Nathan Pelletier
 * Feb 1 2017
 * 
 * A final arguer which interjects a message of peace,
 * it becomes angry every fourth time it speaks.
 */

package concurrency;

/**
 *
 * @author Nathan Pelletier
 */
public class PeaceMaker extends Arguer{

    private final String name = "PEACEMAKER";
    
    private final String argument1 = "* peace, peace, peace" ;
    
    private final String argument2 = "* PEACE, PEACE, PEACE" ;

    /**
     * PeaceMaker(string,String)
     * notably, I did not want this method, the Java IDE did... 
     * @param name
     * @param argument 
     */
    public PeaceMaker(String name, String argument) {
        super(name, argument);
    }
    
    /**
     * run()
     * 
     */
    @Override
    public void run(){
        int y = 0; //tracking variable
        System.out.println("===" + name + " is starting");
        
        while(2 < Arguer.activeCount()){ //tracks how many threads are open
            //notably only a approximate therefore I am using 2 as a way to 
            //hopefully end it early in the case that it detects only one thread
            //even though there are none
            
            y++;
            if(y >= 4){
                System.out.println("   " + argument2);
                y = 0;
            }//if
            else{
                System.out.println("   " + argument1);
            }//else
            
            Arguer.yield(); //tells peacemaker to chill out
        }//while
        
        System.out.println("=== " + name + " is done.");
        
    }//run

}//class PeaceMaker
