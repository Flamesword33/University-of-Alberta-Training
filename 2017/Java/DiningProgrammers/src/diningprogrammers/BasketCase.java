/**
 * Uses user implemented number of forks and bibs 
 * Keeps track of the number of forks and bibs in the bowl 
 * Allows profs to take resources(remember to include locks)
 * Allows profs to give back resources(remember to include notifyAll)
 * by Nathan Pelletier
 * 
 * note: currently static, not sure which is better in this context
 */

//package diningprogrammers;

/**
 * ////////////////////
 * //GLOBAL VARIABLES//
 * + bibs
 * + forks
 * 
 * ///////////
 * //METHODS//
 * + User input
 * + Get fork
 * + get bib
 * + Give fork
 * + give bib
 * 
 * @author Nathan Pelletier
 */
public class BasketCase extends Thread{
    
  ////////////////////
  //GLOBAL VARIABLES//
    public static int bibs;
    public static int forks;

 //make two locks, one for bibs and one for forks
  ///////////
  //METHODS//
    /**
     * user_input(bibs, forks)
     * takes user inputed bibs and forks and places values in secure 
     * global variables 
     * @param bibs
     * @param forks 
     */
    public static void user_input(int bibs, int forks){
        BasketCase.bibs = bibs;
        BasketCase.forks = forks;
    }//user_input
    
    
    /**
     * get(item)
     * removes item from basket
     * @return 
     */
    public static boolean get_bib(){
            if(bibs > 0){
                bibs--;
                System.out.println(bibs); //JUST FOR TESTING
                return true;
            }//if   
            System.out.println(bibs);     //JUST FOR TESTING
            return false;
                  //basket is empty
    }//get bib
    
    /**
     * get(item)
     * removes item from basket
     * @return 
     */
    public static boolean get_fork(){
            if(forks > 0){
                forks--;
                System.out.println(forks); //JUST FOR TESTING
                return true;
            }//if   
            System.out.println(forks);     //JUST FOR TESTING
            return false;
                  //basket is empty
    }//get fork

    
    /**
     * give fork
     * adds fork to basket
     * confirms fork given through return false
     * @return 
     */
    public static boolean give_fork(){
            forks++;
            return false;
    }//give forks
    
    
    /**
     * give bib
     * adds bib to basket
     * confirms bib given through return false
     * @return 
     */
    public static boolean give_bib(){
            bibs++;
            return false;
    }//give bibs

}//BasketCase
