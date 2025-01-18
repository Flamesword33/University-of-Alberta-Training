/**
 * Serial.java
 * Multiplies two matrixes using the old fashioned method without threads
 * and returns how long it took to calculate
 * by Nathan Pelletier
 */

package matrix.multiplication;
/** 
 * METHODS
 * multiply(double[],double[])
 * 
 * @author Nathan Pelletier
 */
public class Serial {
    
    
    ///////////
    //METHODS//
    ///////////
    
    /**
     * multiply(matrix,matrix)
     *  Takes two matrixes and calculates their cross product
     *  while a timer runs in the background 
     * @param matrix_a
     * @param matrix_b
     * @return matrix_c
     */
    public static double[][] multiply(double[][] matrix_a, double[][] matrix_b){
        double[][] matrix_c; 
        matrix_c = new double[matrix_a.length][matrix_b[0].length];
        double running_total = 0;
        
        
        for(int i = 0; i < matrix_a.length; i++) {//rows
            
            for(int j = 0; j < matrix_b[0].length; j++){//colums
            
                for(int k = 0; k < matrix_b.length; k++){
                    running_total = matrix_a[i][k] * 
                            matrix_b[k][j] + running_total;
                }//final loop to do multiplication
                
                matrix_c[i][j] = running_total; //saves running_total to matrix
                running_total = 0; //reset for next use
            }//second for to acess colums
        
        } //first for to acess rows
            
        return matrix_c;
    }//multiply

}//Serial
