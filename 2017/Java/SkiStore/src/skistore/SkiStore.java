/*
 * SkiStore.java (Part of SkiStore package)
 * R. Heise
 * 9 March 2017
 */

package skistore;

/**
 *
 * @author Rosanna
 */
public class SkiStore {

    /**
     * main
     *
     * @param args - the command line arguments (none)
     */
    public static void main(String[] args) {
        final int TIME = 15; //how long the store is open for
        
        SkiMaker john = new SkiMaker("John");
        SkiMaker marg = new SkiMaker("Marg");
        SkiBuyer santa = new SkiBuyer("Santa");
        SkiBuyer mrsClaus = new SkiBuyer("Mrs. Claus");
        SkiBuyer elf = new SkiBuyer("Elf");
        SkiBuyer dasher = new SkiBuyer("Dasher");
        SkiBuyer dancer = new SkiBuyer("Dancer");
        SkiBuyer olive = new SkiBuyer("Olive");
        SkiBuyer vixen = new SkiBuyer("Vixen");
        SkiBuyer rudolf = new SkiBuyer("Rudolf");
        SkiBuyer[] customers = {santa, mrsClaus, elf, dasher, 
                                dancer, olive, vixen, rudolf};
        SkiMaker[] employees = {john, marg};
        
        john.start();
        santa.start();
        mrsClaus.start();
        elf.start();
        dasher.start();
        dancer.start();
        olive.start();
        vixen.start();
        rudolf.start();
        //marg.start();
        
        try {
            Thread.sleep(TIME);  //how long the store is open
        } catch (Exception e) {
            System.out.println("Exception in main");
        }
        
        
        //now close the store
        //get rid of employees first
        for (SkiMaker person : employees){
            person.closeStore();
        }
        for (SkiMaker person : employees){
            try{
                person.join();
            } catch (Exception e) {
                System.out.println("Exception in main");
            }
        }//for

        System.out.println("All employees home");

        //then get rid of customers
        for (SkiBuyer person : customers){
            person.closeStore();
        }
        for (SkiBuyer person : customers){
            try{
                person.join();
            } catch (Exception e) {
                System.out.println("Exception in main");
            }
        }//for
        
        System.out.println("All customers out of store");
        
        //Check if final numbers are right (should print 0)
        System.out.println(SkiMaker.skiisMade - 
                (SkiBuyer.skiisBought + PeopleInStore.skiisAvailable));

    }//main

}//class SkiStore
