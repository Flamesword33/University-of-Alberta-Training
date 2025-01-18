/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package lab.pkg7.ts;

/**
 *
 * @author Nathan
 */
public class Lab7TS implements RecLabInterface{
    
    public static int stars = 1;
    public static int check;
    
    //=======================================================
    //First Section:  printTriangle method(s)
    //must be done recursively (no loops allowed)
    
    
    @Override
    public void printTriangle(int size){
        if (size > 0){
            //made stars global to fix resetting variable
            size --;
            printDots(size);
            printStars(stars);
            stars ++;
            System.out.println();
            printTriangle(size);
            
        }//size is greater than 0
        stars = 1;
    }//printTriangle
    
    public void printStars(int stars){
        if(stars > 0){
            System.out.print("*");
            System.out.print(" ");
            printStars(stars - 1);
        }//if stars is greater than 0
    }//printStars
    
    public void printDots(int dots){
        if (dots > 0){
            System.out.print(" ");
            printDots(dots - 1);
        }//if dots is positive
    }//printDots
    
    //=======================================================
    //Second Section:  oddBeforeEven method(s)
    //method(s) for getting odd elements before even
    //elements in an Array (do this in place)
    //Must be done recursively (no loops allowed)
    
    @Override
    public void oddBeforeEven(int [] anArray){
        int end_pointer = anArray.length - 1;
        int first_pointer = 0;
        if(end_pointer > 0)
            oddBeforeEven(anArray, end_pointer, first_pointer);
        
    }//oddBeforeEven wrapper, sets up pointer
    
    public void oddBeforeEven
        (int [] anArray, int end_pointer, int first_pointer){
        check = anArray[end_pointer];
        check = check >> 1;
        check = check << 1;
        
        
        if(end_pointer > first_pointer){
            
            if(anArray[end_pointer] == 0){
                check = anArray[end_pointer];
                anArray[end_pointer] = anArray[first_pointer];
                anArray[first_pointer] = check;
                first_pointer ++;
                oddBeforeEven(anArray, end_pointer, first_pointer);    
            }//zero case
            
            else if (check == anArray[end_pointer]){//positive
               end_pointer --;
               oddBeforeEven(anArray, end_pointer, first_pointer);
            }//inner if
            
            
            else{//negitive
                check = anArray[end_pointer];
                anArray[end_pointer] = anArray[first_pointer];
                anArray[first_pointer] = check;
                first_pointer ++;
                oddBeforeEven(anArray, end_pointer, first_pointer);
            } //inner else
            
        }//outer if 
        
    }//oddBeforeEven
        
        ////////////////////////////////////////////////////////////
        //Second attempt, though completly inefficent in every way// 
        //it gets the job done forsefully, would like help fixing // 
        //                  my efficent code                      //
        ////////////////////////////////////////////////////////////
    
//    public void oddBeforeEven(int [] anArray, 
//            int end_pointer, int first_pointer){
//        //check is a global variable to reduce on memory
//        
//        check = anArray[end_pointer];
//        check = check >> 1;
//        check = check << 1;
//        
//        if(anArray[end_pointer] == check){
//            end_pointer --;
//            oddBeforeEven(anArray, end_pointer, first_pointer);
//        }//checks if even
//        
//        if(anArray[end_pointer] > anArray[first_pointer]){
//            oddBeforeEven(anArray, end_pointer, first_pointer, 0);
//            oddBeforeEven(anArray, end_pointer, first_pointer);
//        }//contiues and loops
//         
//    }//first pointer loop
//    
//    public void oddBeforeEven(int [] anArray, 
//            int end_pointer, int first_pointer, int d){
//        //check is a global variable to reduce on memory
//        
//        check = anArray[first_pointer];
//        check = check >> 1;
//        check = check << 1;
//        
//        if(anArray[first_pointer] != check){
//            first_pointer ++;
//            if(first_pointer < end_pointer)
//                oddBeforeEven(anArray, end_pointer, first_pointer, d);
//        }//moves pointer if on odd numbers
//        
//        else if(anArray[first_pointer] == check){
//            anArray[first_pointer] = anArray[end_pointer];
//            anArray[end_pointer] = check;
//            
//        }//switches if an even is found
//        
//        
//    }//other pointer loop
    
        
        /////////////////////////////////////////////////////////
        //this is a more effiecient idea but can't get to work //
        //currently dose its job but runs into an infinite loop//
        //upon trying to exit the method and also dosen't make //
        //                  proper use of recursion            //
        /////////////////////////////////////////////////////////
        
   //=======================================================
   //Third Section:  Methods to test your other ones
   //You don't have to write anything here

    public static void printArray(int[] x){
        for (int i = 0; i < x.length; i++){
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    //test odd before even
    public static void testOE(int[] x){
        Lab7TS myGuy = new Lab7TS(); //just need an object
                                 //to make non static stuff run
        System.out.println("Before: ");
        printArray(x);
        myGuy.oddBeforeEven(x);
        System.out.println("After");
        printArray(x);
    }//testOE

    //test printing of triangle
    public static void testPT(int x){
        Lab7TS myGuy = new Lab7TS(); //just need an object
                                 //to make non static stuff run
        System.out.println();
        System.out.println("Size " + x + ":");
        myGuy.printTriangle(x);
    }//testPT

    /**
     * Run tests
     * @param args the command line arguments (none)
     */
    
    public static void main(String[] args) {
        
        //=====================================================
        //Tests for printing a variety of triangles
        testPT(5);
        testPT(4);
        testPT(-1);
        testPT(0);
        testPT(1);
        testPT(2);
        testPT(10);
        testPT(25);

        //=====================================================
        //Tests for getting the array into odd and even sections
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 17, 19};
        int[] a2 = {2};
        int[] a3 = {1, 3, 5};
        int[] a4 = {};
        int[] a5 = {3};
        int[] a6 = {-15, -17, 2};
        int[] a7 = {2, 3};
        int[] a8 = {0, 2, 3, 4};
        testOE(a1);
        testOE(a2);
        testOE(a3);
        testOE(a4);
        testOE(a5);
        testOE(a6);
        testOE(a7);
        testOE(a8);
    }
    
}
