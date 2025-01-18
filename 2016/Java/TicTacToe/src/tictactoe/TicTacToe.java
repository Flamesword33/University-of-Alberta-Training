/**
 * AUCSC 112 LAB EXAM #1
 * 23 Feb 2016
 * @author R. Heise
 * Tic Tac Toe Game
 * Plays the simple game of X's and O's
 *
 *******NOTE:  do not change this file (except maybe the package name
 */

package tictactoe;

public class TicTacToe {
    

    /**
     * main
     *    Runs the game
     * @param args the command line arguments (none)
     */
    public static void main(String[] args) {   
        TicTacToeGame theGame = new TicTacToeGame();
        boolean gameOver = false;
        
        theGame.print();  //print a blank board
        
        while(!gameOver){
            //X goes first
            gameOver = theGame.oneTurn('X');
            
            //Did X win?  Is there still room on the board?
            if (gameOver){
                break;
            }
            
            //Then O goes
            gameOver = theGame.oneTurn('O');
        }//while
    }//main

}//class TicTacToe
