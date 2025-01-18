/**
 * AUCSC 112 Lab EXAM #1
 * 23 Feb 2016
 * @author Nathan Pelletier
 * ensures tic tac toe game is seeable and runs correctly
 */
package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
    //////////////////////////////////////
    //DATA
    
    private static final Scanner input = new Scanner(System.in);
    public int size;
    public char [][] grid;
    
    //////////////////////////////////////////
    //METHODS
    
    /**
     * TicTacToeGame()
     *      constructs the game board with blank spaces
     *      0   1   2  
     *    |---|---|---|
     *  0 |   |   |   |
     *    |---|---|---|
     *  1 |   |   |   |
     *    |---|---|---|
     *  2 |   |   |   |
     *    |---|---|---|
     */
    public TicTacToeGame (){
        grid = new char[3][3];
        
        for(int f = 0; f < 3; f++)
            for(int g = 0; g < 3; g++)
                grid[f][g] = ' '; // creates blank spaces
    }//TicTacToeGame
    //////////////////////////
    //NO NEED TO TOUCH AGAIN//
    //////////////////////////
    
    /**
     * print()
     *      prints the game board and inputs given
     * 
     */
    public void print(){
        System.out.print("    ");
        
        for(int h = 0; h < 3; h++) //creates horizontal numbers
            System.out.print(h + "   ");
        
        System.out.println("");          
        System.out.println("  |---|---|---|");
        
        for(int i = 0; i < 3; i++){
            System.out.print(i + " | ");  //verticle numbers 
            for(int j = 0; j < 3; j++){
                System.out.print(grid[i][j] + " | ");   //fills graph
            }//inner for
            System.out.println("");               //aligns graph
            System.out.println("  |---|---|---|");
        }//outer for
            
    }//print
    
    
    //////////////////////////
    //NO NEED TO TOUCH AGAIN//
    //////////////////////////
    
    
    /**
     * placeItem(char, int, int) --> boolean
     *      asks user input to change squares to 'X' or 'O'
     *      checks for blank space 
     *      checks for numbers within grid size
     *      returns true if all conditions met and places 'X' or 'O'
     *      otherwise program will return false
     * @param item
     * @param rowLoc
     * @param colLoc
     * @return 
     */
    
    public boolean placeItem(char item, int rowLoc, int colLoc){
        
    if(rowLoc > -1 && rowLoc < 3 && 
            colLoc > -1 && colLoc < 3){
        if(grid[rowLoc][colLoc] == ' '){
                grid[rowLoc][colLoc] = item;
                return true;
            }//second if //checks for blank space
            
            else
                return false;
        }//first if //makes sure point is on grid
        
        else
            return false;
    
    }//placeItem
    
    
    //////////////
    //GOOD TO GO//
    //////////////
    
    
    /**
     * isWinner(char)--> boolean
     *      checks if game is won by making 8 checks based on all possible
     *      winning senarios
     *      returns true if winning senario is found
     *      returns false otherwise
     *  
     * @param item
     * @return 
     */
    public boolean isWinner(char item){  
        if(grid[1][1] == item && grid[0][0] == item && grid[2][2] == item)
            return true;//diagonal #1
        else if(grid[1][1] == item && grid[2][0] == item && grid[0][2] == item)
            return true; // diagonal #2
        else if(grid[1][0] == item && grid[0][0] == item && grid[2][0] == item)
            return true;//horizontal #1
        else if(grid[1][1] == item && grid[0][1] == item && grid[2][1] == item)
            return true;//horizontal #2
        else if(grid[1][2] == item && grid[0][2] == item && grid[2][2] == item)
            return true;//horizontal #3
        else if(grid[0][1] == item && grid[0][0] == item && grid[0][2] == item)
            return true;//verticle #1
        else if(grid[1][1] == item && grid[1][0] == item && grid[1][2] == item)
            return true;//verticle #2
        else if(grid[2][1] == item && grid[2][0] == item && grid[2][2] == item)
            return true;//verticle #3
        else
            return false;
    }
    
    
    //////////////////////
    //TEST IF EXTRA TIME//
    //////////////////////
    
    
    /**
     * spaceLeft()--> boolean
     *      checks entire grid for remaining blank spaces
     *      returns true if one is found 
     *      returns false if loop is not broken
     * 
     * @return 
     */
    public boolean spaceLeft (){
        for(int k = 0; k < 3; k++)
            for(int l = 0; l < 3; l++){
                if(grid[k][l] == ' ')
                    return true;
            }//inner for
        return false;        
    }//spaceLeft
    
    /////////////////////////
    //DON'T TOUCH, ALL DONE//
    /////////////////////////
    
    /**
     * oneTurn(char) --> boolean
     *    Performs exactly one turn of Tic Tac Toe, either for 'X' if
     *    the char is 'X' or for 'O' if the char is 'O'
     * @param item - 'X' or 'O' (the character to place)
     * @return - true if the game is now over (line of the item or board
     *                is full)
     *           false otherwise (if there is still room and neither side
     *                has won)
     */
    public boolean oneTurn(char item) {
     
        boolean validInputType = false;
        boolean validLoc = false;
        int row = 0; //will obtain from the user
        int col = 0; //will obtain from the user
        
        System.out.println("===========================");
        System.out.println(item + "'s Turn");
        do{
            do{
                System.out.print("Enter location to place your mark as "
                        + "\"x y\":  ");
                try{
                    col = input.nextInt();
                    row = input.nextInt();
                    validInputType = true;  //no exceptions, must be good
                }
                catch(InputMismatchException e){
                    System.out.println("Please use only numbers 0, 1, and 2");
                    input.next();
                }
            }while (!validInputType);
            
            //Now check if item can be placed in board
            if (placeItem(item, row, col)){ //yes, placed it
                validLoc = true;
                print();
                if (isWinner(item)){  //check for winner and be done if so
                    System.out.println("GAME OVER!  Winner is " + item);
                    return true;
                }
                else if (!spaceLeft()){  //check if room left on board
                                         //game is tied if no room left
                    System.out.println("CAT'S GAME");
                    return true;
                }
            }//outer if
            else{ //item could not be placed in board
                System.out.println("Out of bounds or space occupied, "
                        + "Try again");
            }                           
        }while (validLoc != true);
        
        return false; //Game is not over
    }//oneTurn
    
}
