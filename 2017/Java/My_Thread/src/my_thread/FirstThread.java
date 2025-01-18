/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */

package my_thread;

/**
 *
 * @author Nathan Pelletier
 */
public class FirstThread extends Thread {
    public static int idNum;
    private int personalId;
    
    FirstThread(){
        personalId = idNum;
        idNum++;
    }
    public void run(){
        System.out.println("Hi" + personalId);
    }//run

}//firstthread
