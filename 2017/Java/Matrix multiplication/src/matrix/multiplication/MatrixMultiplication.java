/**
 * MatrixMultiplication.java
 * Program uses serial, partly parallel and fully parallel methods 
 * to multiply matrixes of x size
 * by Nathan Pelletier
 * Started on Feb 28 2017
 * Finished on Mar 5 2017
 * 
 *  TO DO LIST:
 *      PRINT MATRIX FUNCTION(FINISHED)
 *      INPUT MATRIX FUNCTION(FINISHED)
 *      SERIAL MATRIX MULTIPLICATION CLASS(FINISHED)
 *      PARRALLEL MANY MULTIPLICATION CLASS(FINISHED)
 *      PARRALLEL FEW MULTIPLICATION CLASS(FINISHED)
 *      USER INTERFACE(FINISHED)
 *      FINAL BUGS(FINISHED(i hope...))
 *      
 *      DOESN'T PRINT RESULTS YET
 * 
 */
package matrix.multiplication;

import java.util.Random;
import java.util.Scanner;

/**
 *Asks user to input matrix and prints out matrix 
 * then multiplies matrix using all three class extensions and 
 * sends back how long each matrix took to do. It then asks if the 
 * user would like a print out of the results.
 * 
 * GLOBAL VARIABLES
 * Scanner input
 * double[][] matrix1
 * double[][] matrix2
 * double[][] matrix3
 * long timer_a
 * long timer_b
 * long timer_c
 * 
 * METHODS
 * main
 * running()
 * print_matrix(double[][])
 * initialize_matrix(double[][])
 * 
 * @author Nathan
 */
public class MatrixMultiplication {

    ////////////////////
    //GLOBAL VARIABLES//
    public static Scanner input = new Scanner(System.in);
    static double[][] matrix1; 
    static double[][] matrix2; 
    static double[][] matrix3; //result matrix
    static long timer_a; //initally created in class but biased info 
    static long timer_b;//threads are tricky to note when done so
    static long timer_c;//i created these here instead
    
    ///////////
    //METHODS//
    ///////////
    
    public static void main(String[] args) {
        running();
    }//main
    
    
    /**
     * running()
     * creates and starts several processes,
     * holds program together and is UI
     */
    public static void running() {
        
        //////////////////////////////////
        //create first and second matrix//
        matrix1 = initialize_matrix(matrix1);
        print_matrix(matrix1);
        matrix2 = initialize_matrix(matrix2);
        print_matrix(matrix2);
        
        if(matrix1[0].length == matrix2.length){//checks if
                                //multiplication is possible
                                
            /////////////////////////
            //serial multiplication// 
            timer_a = System.nanoTime(); //start timer
            matrix3 = Serial.multiply(matrix1,matrix2);
            timer_a = System.nanoTime() - timer_a; //end timer
            System.out.println("RESULT: "); //for clairity sake
            print_matrix(matrix3);
            System.out.println("Serial took " + timer_a + 
                    " nano seconds to complete.");
            
            ///////////////////////////
            //parallel multiplication//
            timer_b = System.nanoTime(); //time started
            for(int i = 0; i < matrix1.length; i++) {//rows
            
                for(int j = 0; j < matrix2[0].length; j++){//colums
                    
                    Parallel z = new Parallel(i,j);//called object 
                                    //z for quick editing purposes
                    z.start();
                }//for inner
            }//for outer 
            
            
            while(Parallel.activeCount() > 1){
//empty to wait for threads
                //before contiuing
            }//while to check that done
            timer_b = System.nanoTime() - timer_b; //time stopped
            
            //TO BE COMMENTED OUT AFTER TESTING
            //print_matrix(Parallel.matrix_c);
            System.out.println("Parallel took " + timer_b 
                    + " nano seconds to complete");
            
            //////////////////////////////////
            //partly parallel multiplication//
            timer_c = System.nanoTime();
            for(int i = 0; i < matrix1.length; i++) {//rows
                PartParallel x = new PartParallel(i);
                x.start();
            }//for to set up row structure
            
            while(PartParallel.activeCount() > 1){
                
            }//while to ensure threads are done
            timer_c = System.nanoTime() - timer_c;
            
            //TO BE COMMENTED OUT AFTER TESTING
            //print_matrix(PartParallel.matrix_c);
            
            System.out.println("Parallel took " + timer_c
                    + " nano seconds to complete");
            
            System.out.println(Runtime.getRuntime().availableProcessors());
        }//if to check if multiplication is possible
        
        else{
            System.out.println("Error: SIZE INCOMPATIBLE");
        }//multiplication isn't possible
    }//running (used to be main)
    
    
    
    /**
     * print_matrix(matrix)
     * 
     * takes the size of a matrix and the matrix and prints said matrix
     * @param matrix 
     */
    public static void print_matrix(double[][] matrix){
        String confirm;
        
        System.out.println("Would you like to print? Yes or No: ");
        confirm = input.next();
        confirm = confirm.toLowerCase(); //reduces cases to check for
        if("y".equals(confirm)){
            //double loop to acess grid structure
            for(int i = 0; i < matrix.length; i++){
                System.out.print(" ");//aligns and starts matrix
                for(int j = 0; j < matrix[0].length; j++){
                    System.out.print(matrix[i][j] + " ");
                }//column for loop
                System.out.println();
            }//row for loop
        } //if
           
    }//print_matrix
    
    
    
    /**
     * initialize_matrix(matrix)
     * 
     * asks user to input the number of rows and columns in said matrix
     * and whether they would like to enter said values or not
     * @param matrix
     * @return 
     */
    public static double[][] initialize_matrix(double[][] matrix){
        
        String confirm2;
        
        Random randInt = new Random();
        int column;
        int row;
        
        System.out.println("Please enter how many columns and rows in your "
                + "matrix: ");
        
        column = input.nextInt();
        row = input.nextInt();
        matrix = new double[column][row];//gives the matrix the size
        
        System.out.println("You inputted a " + column + "X" + row +
                " matrix. Would you like to enter the values? Yes or No: ");
        
        confirm2 = input.next();
        confirm2 = confirm2.toLowerCase(); //reduces caseses to check for
        
        if("yes".equals(confirm2) || "y".equals(confirm2)){
            
            for(int a = 0; a < column ; a++){
                for(int b = 0; b < row; b++){
                    System.out.println("enter " + a + "X" + b +": ");
                    matrix[a][b] = input.nextDouble();
                    
                    
                }//second for to create matrix rows
            }//first for to create matrix colums
        }//if check for yes
        
        else{
            for(int a = 0; a < column ; a++){
                for(int b = 0; b < row; b++){
                    matrix[a][b] = randInt.nextInt(10); //0 to 10 for now
                    
                }//second for to create matrix rows
            }//first for to create matrix colums
        }//else
        
 //       System.out.println(matrix.length);
 //       System.out.println(matrix[0].length);
        //testing which is which
 
        return matrix;
    }//initialize_matrix
    
    
}//matrixmultiplication
