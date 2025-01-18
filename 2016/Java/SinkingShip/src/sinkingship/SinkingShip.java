/**
 * 
 * by Nathan Pelletier
 * January 19, 2016
 * goals: 
 * 1. constuct grid :)
 * 2. design boat placement :)
 * 3. design shot placement :\ 
 * 4. fix what person playing sees :| see Ocean.print() line 122
 * 5. final test and fix of bugs XD
 *      :)= good to go
 *      :\= stuck
 *      :|= working on
 *      XD= haven't tried yet
 * 
 * SinkingShip.java creates a grid filled with 'O's
 * it then changes 'O's to create a boat using 'S'
 * program then prompts user to input coordinates
 * 
 * PROJECT IS INCOMPLETE NEEDS:
 *      to use coordinates to print places
 *      to tell the difference between a hit and miss
 *      to be tested around letters and symbols
 *          making an error exception
 * 
 */



package sinkingship;


//import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class SinkingShip {
//    public static int input_x;
//    public static int input_y;

    /**
     * @param args the command line arguments (none)
     */
    public static void main(String[] args) {
//        Scanner userInput = new Scanner(System.in);
//        Coord userCoord = new Coord();
//
//        System.out.println(userCoord.getX() + " " + userCoord.getY());
//        System.out.print("Enter a coordinate    x y   : ");
//        userCoord.setX (userInput.nextInt());
//        userCoord.setY (userInput.nextInt());
//        System.out.println(userCoord.getX() + " " + userCoord.getY());
//        System.out.println(userCoord.getRow() + " " + userCoord.getCol());

        Ocean myOcean;
        
        myOcean = new Ocean(10);
        myOcean.shoot();
        myOcean.print();
    }//main
    
}//class
