/*
 * Program to print a count down, with "BLAST OFF" to finish
 * by AUCSC 112
 * 12 January 2016
 */
package secondprogram;

/**
 *
 * @author Nathan
 */
public class SecondProgram {
            /**
         * This method prints a triangular count down
         * starting from x to 1. It then prints "BLAST OFF"
         * @param x - starting number (int)
         */
    public static void blastOff(int x){
        while (x != 0){
            int counter = x;
            while (counter > 0){
                System.out.print(x + " ");
                counter = counter - 1;//can use (counter -- > 0) instead
            }//inner while
            x = x - 1;
            System.out.println("");
        }
        System.out.println("BLAST OFF");    
    }//blastOff
    
    public static void blastOff(double x){
        while (x > 0){
            int counter = (int) x;
            while (counter > 0){
                System.out.print(x + " ");
                counter = counter - 1;
            }//inner while
            x = x - 1;
            System.out.println("");
        }
        System.out.println("BLAST OFF");    
    }//blastOff

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        blastOff(3.5);
        // TODO code application logic here
    }
    
}
