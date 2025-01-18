/**
 * Adds the odd numbers up to and including the final odd number given.
 * by Nathan Pelletier
 * Date
 */
package labpart2;

/**
 *
 * @author Nathan
 */
public class LabPart2 {
    public static void odd_count(int n){
        int counter = 1;
        int final_count = 0;
        if (n < 0)
            System.out.println(0);
        else {
            while (counter < n){
                final_count = counter + final_count;
                counter = counter + 2;
            }//while, counting odd
            if (n % 2 != 0){
                final_count = final_count + n;                
            }// determine if odd
                
            
            System.out.println(final_count);
        }//else
    }//odd_count 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        odd_count(15);
        odd_count(14);
        odd_count(-15);
        odd_count(0);
        odd_count(1);
        odd_count(2);
    }//main
    
}//class
