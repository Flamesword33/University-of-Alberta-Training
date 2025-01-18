/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package my_thread;

/**
 *
 * @author Nathan
 */
public class My_Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        FirstThread x = new FirstThread();
//        
//        x.start();
        
        //now we'll make 100
        FirstThread[] threadArray = new FirstThread[100];
        
        for(int i = 0; i < 100; i++)
            threadArray[i] = new FirstThread();
        
        for(int i = 0; i < 100; i++)
            threadArray[i].start();
        
        System.out.println("...");
        // TODO code application logic here
    }
    
}
