/**
 * This file contains the randomized game board 
 * uses random to place boat and orient 
 * Ocean.java
 * by Nathan Pelletier
 * January 19, 2016
 * 
 * Data items:
 *  size is the board size asked for + 1
 *  grid is the saved game board
 * 
 * Methods:
 *  Ocean (someSize)
 *      creates a grid for game using Coord.java
 *  placeBoat()
 *      creates a random boat
 *  print()
 *      prints grid and boat
 *  shoot()
 *      supposed to;
 *           ask user for input
 *           count shots taken, missed and hit
 *           update grid and restart until user wins or runs out of lives
 */

package sinkingship;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Nathan Pelletier
 */
public class Ocean {
    //data
    private final int size;//The grid is square: size X size
    private final char[][] grid;
    
    //methods
    //creates grid                                        
    Ocean(int someSize){
        size = someSize + 1;//offset to allow 1-based addressing
                            //into the grid
        grid = new char[size][size];
        
        
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++)
                grid[i][j] = 'O'; // puts 'O' in the blank places

        placeBoat();
        
    }//Ocean
    
    // places boat randomly
    private void placeBoat(){
        Random randInt = new Random();
        
        int alignment;  
        int size2 = size - 1;

        Coord place = new Coord (randInt.nextInt(size2) + 1,
                randInt.nextInt(size2) + 1);
        
        System.out.println(place.getX()+ " " + place.getY());
        alignment = randInt.nextInt(4);
        System.out.println("Orientation " + alignment);
        
            //placement first stratagy        
        if (place.getX() > 1 && place.getX() < size2 
                && place.getY() > 1 && place.getY() < size2){
        
            grid[place.getX()][place.getY()] = 'S'; 
            
            switch(alignment){// orientation second
                case 0: //verticle
                    grid[place.getX() + 1][place.getY()] = 'S';
                    grid[place.getX() - 1][place.getY()] = 'S';
                    break;
              
                case 1: //horizontal
                    grid[place.getX()][place.getY() + 1] = 'S';
                    grid[place.getX()][place.getY() - 1] = 'S';
                    break;
                
                case 2: // diagonal left down to right up
                    grid[place.getX() - 1][place.getY() - 1] = 'S';
                    grid[place.getX() + 1][place.getY() + 1] = 'S';
                    break;
                
                case 3: // diagonal right down to left up
                    grid[place.getX() + 1][place.getY() - 1] = 'S';
                    grid[place.getX() - 1][place.getY() + 1] = 'S';
                    break;
            //no other cases should ever occur            
            }//switch            
        }//if center
            
            //restarts if center is in a corner
        else if (place.getX() == 1 && place.getY() == 1 
                || place.getX() == size2 && place.getY() == 1
                || place.getX() == 1 && place.getY() == size2
                || place.getX() == size2 && place.getY() == size2){
            placeBoat();
        }//else if corners
           
        else if (place.getY() == 1 || place.getY() == size2){
            grid[place.getRow()][place.getCol()] = 'S';
            grid[place.getY()][place.getX() + 1] = 'S';
            grid[place.getY()][place.getX() - 1] = 'S';
        }//else if edges verticle
        
        else {
            grid[place.getRow()]  [place.getCol()] = 'S';
            grid[place.getY() + 1][place.getX()] = 'S';
            grid[place.getY() - 1][place.getX()] = 'S';          
        }//else edges horizontal
     
    /////////////////////////////////////////////
//DON'T WRITE ADDITIONAL CODE AFTER IF ELSE STRUCTURE//
    /////////////////////////////////////////////                   
                                    
    }//placeBoat
    //prints out grid
    
        //needs to use list to print coordanites as asked for 
    public void print(){//tried using int r, int c to place coords, 
                        // printed whole grid instead  
        //print colum numbers
        System.out.print("   ");
        
        for(int i = 1; i < size; i++)
            System.out.print(i + " ");//horizontal row
        
        System.out.println();
        
        for(int row = 1; row < size; row++){
            System.out.print(row + "  "); //verticle row number
            for(int col = 1; col < size; col++)
                System.out.print(grid[row][col] + " "); //hoped to use list here
            System.out.println();
        }//outer for
    }//print
        
        //NOT FINSHED WITH, WATCH OUT FOR WHILE LOOP
        //combined shot_counter into shoot to simplify code
    public void shoot(){
       
        
        int hits = 3;     // set to 0 when shoot is fixed
        int misses = 0;
        int total_shots = 10; //counts down as a life counter
        Scanner user_input = new Scanner(System.in);
        Coord user_coord = new Coord();
        
        //how do i connect varible from SinkingShip to shoot in Ocean
        //can't connect list to user_input to use for print
        
        do{
            System.out.print("You have " + total_shots + " left. "
                    + "Enter a Coordinate: ");
            user_coord.setX (user_input.nextInt());
            user_coord.setY (user_input.nextInt());
            
            //need to make a way to print out in list format displaying
            //
            if (grid(user_coord) == 'S'){ //supposed to use grid to detect if
                                          // user_coord is aligned with ship
                print();  //updates grid
                hits++;
                total_shots--;
            }//if
            
            else if (user_coord.getX() < size && user_coord.getY() < size){
                                            //detectes if grid was hit
                print();  //updates grid
                misses++;
                total_shots--;
            }//else if
            
            //error condition, needed for 
            //symbols and letters to break loop early,
            //problems testing due to if statement
            
            else{       //for numbers out of range only
                System.out.println("You missed the grid try again.");
            }//else
            
//need listlike variable which will save previous attempts            
        }while(total_shots > 1 && hits < 2);
        
        if (hits > 2){
            System.out.println("YOU WIN");
            System.out.println("Game over, your score was "
                    + (500 * hits - 100 * misses));
        }//if
        else
            System.out.println("Game over");
    }//shoot
    
}//class

