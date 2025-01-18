/**
 * PartParallel.java
 * Multiplies two matrixes by using a thread per row
 * and sends back how long it took to preform
 * by Nathan Pelletier
 */

package matrix.multiplication;

/**
 * GLOBAL VARIABLES
 * double[][]matrix_c
 * int row
 * 
 * METHODS
 * PartParallel(int)
 * run()
 * 
 * @author Nathan Pelletier
 */
public class PartParallel extends Thread{

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
    
    ///////////
    //Methods//
    ///////////
    
    /**
     * PartParallel(row)
     * sets up thread call for run
     * @param row 
     */
    PartParallel(int row){
        this.row = row;
    }//Parallel
    
    
    /**
     * run()
     * takes two integers and multiplies two matrixes at
     * one particular grid position
     */
    public void run(){
        double running_total = 0;
        
        for(int j = 0; j < MatrixMultiplication.matrix2[0].length; j++){
            for(int k = 0; k < MatrixMultiplication.matrix2.length; k++){
                running_total = MatrixMultiplication.matrix1[row][k] * 
                                MatrixMultiplication.matrix2[k][j] 
                        + running_total;
            }//single for loop for cell
        
        matrix_c[row][j] = running_total;
        running_total = 0; //reset variable to get correct result
        }//colum loop
    }//multiply
}//PartParallel
