/**
 * This file contains the data type of an 
 * (x, y) coordinate.
 * Coord.java
 * by Nathan Pelletier
 * January 19, 2016
 * 
 * Data items:
 *  x is the x coordinate
 *  y is the y coordinate
 *  row matches with y for placement in 2-D structure
 *  col matches with x for placement in 2-D structure
 * 
 * Methods:
 *   Only construtors:
 *      Coord(int,int)
 *      Coord(int)
 *          sets default y to 0
 *      Coord()
 *          sets default to 0
 */

package sinkingship;

/**
 *
 * @author Nathan Pelletier
 */

public class Coord {
    private int x;  
    private int y;
    private int row;
    private int col;
    
    /*****************************
     * 
     * @param xCoord
     * @param yCoord 
     */
    
    Coord(int xCoord, int yCoord){
        x = xCoord;
        y = yCoord;
        row = yCoord;
        col = xCoord;
    }//both Coord
    
    Coord(int xCoord){
        this(xCoord, 0);
    }//x only Coord
    
    Coord(){
        this(0,0);
    }//default Coord
    
    //methods to set data
    //========================
    public void setX(int x){
        this.x = x;
        col = x;
    }//to get x
    public void setY(int y){
        this.y = y;
        row = y;
    }//to get y
    
    //======================
    //Methods to get data
    public int getX(){
        return x;
    }//
    public int getY(){
        return y;
    }//
    public int getRow(){
        return row;
    }//
    public int getCol(){
        return col;
    }//

}//class
