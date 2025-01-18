/**
 * Parallel.java
 * Multiplies two matrixes using threads for each cell
 * and sends back how long it took to complete
 * by Nathan Pelletier
 */

package matrix.multiplication;

/**
 * GLOBAL VARIABLES
 * double[][] matrix_c
 * int row
 * int column
 * 
 * METHODS
 * Parallel(int,int)
 * run()
 * 
 * @author Nathan Pelletier
 */
public class Parallel extends Thread{
    
    ////////////////////
    //GLOBAL VARIABLES//
    ////////////////////
    //I decided I needed to create matrix_c as a global variable in 
    //this instance in order to keep track of all threads at once by keeping 
    //one resorce for them to save into instead of multiple locals 
    
    protected static double[][] matrix_c = new double
            [MatrixMultiplication.matrix1.length]
            [MatrixMultiplication.matrix2[0].length];
    protected int row;
    protected int column;
    
    ///////////
    //Methods//
    ///////////
    
    /**
     * Parallel(row,column)
 sets up thread call for run
     * @param row
     * @param colum 
     */
    Parallel(int row,int colum){
        this.row = row;
        this.column = colum;
    }//Parallel
    
    
    /**
     * run()
     * takes two integers and multiplies two matrixes at
     * one particular grid position
     */
    public void run(){
        double running_total = 0;
        
        
        for(int k = 0; k < MatrixMultiplication.matrix2.length; k++){
            running_total = MatrixMultiplication.matrix1[row][k] * 
                            MatrixMultiplication.matrix2[k][column] 
                    + running_total;
        }//single for loop for cell
        
        
        
        matrix_c[row][column] = running_total;       
        
    }//multiply
    
}//Parallel
