/**
 * AUCSC 112
 * Examples of Recursion
 * by Nathan Pelletier
 * 
 * 1) Sum an array both interivly and recursivly
 * 2) Reverse an array
 */
package recursion.examples;

/**
 *
 * @author Nathan
 */
public class RecursionExamples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a1 = {2};
        int[] a2 = {};
        int[] a3 = {1,2,3,6,7,10};
        
        System.out.println("Sum of a1: " + sum_array_1(a1));
        System.out.println("Sum of a2: " + sum_array_1(a2));
        System.out.println("Sum of a3: " + sum_array_1(a3));
        System.out.println();
        System.out.println("Sum of a1: " + sum_array_2(a1));
        System.out.println("Sum of a2: " + sum_array_2(a2));
        System.out.println("Sum of a3: " + sum_array_2(a3));
        System.out.println();
        
        print_array(a3);
        reverse_arrayI(a3);
        print_array(a3);
        
        print_array(a3);
        reverse_arrayR(a3);
        print_array(a3);
        
        print_array(a1);
        reverse_arrayI(a1);
        print_array(a1);
    }//main
    
    
    /**
     * Sums using loops
     * @param the_array
     * @return 
     */
    public static int sum_array_1(int[] the_array){
        int total_sum = 0;
        for(int location = 0; location < the_array.length; location++){
            total_sum = total_sum + the_array[location];
            
        }//for
        return total_sum;    
    }//sum_array_1
    
    /**
     * Sums an integer array recursively
     * @param the_array
     * @return 
     */
    public static int sum_array_2(int[] the_array){
        return sum_array_2(the_array, the_array.length - 1);
        
    }//recursive sum
    public static int sum_array_2(int[] the_array, int size){
        if(size < 0)
            return 0;
        return the_array[size] + sum_array_2(the_array, size - 1);
    }//recursive sum
    
    /**
     * Reverses array in place without extra memory
     * @param the_array 
     */
    public static void reverse_arrayI(int[] the_array){
        int temp;
        int upper_index = the_array.length - 1;
        for(int lower_index = 0; lower_index < (the_array.length/2); lower_index++){
            temp = the_array[upper_index];
            the_array[upper_index] = the_array[lower_index];
            the_array[lower_index] = temp;
            upper_index--;
            
        }//outer for
    }//reverseI
    
    public static void print_array(int[] an_array){
        for(int i = 0; i < an_array.length; i++)
            System.out.print(an_array[i] + " ");
        System.out.println();
    }//print_array
    
    public static void reverse_arrayR(int[] the_array){
        reverse_arrayR(the_array, 0, the_array.length - 1);
    }//reverse_arrayR
    
    public static void reverse_arrayR(int[] the_array, int start, int end){
        int temp; // used to swap
        
        //base case
        if(start >= end)
            return;
        
        //work: swap the two and elements
        temp = the_array[start];
        the_array[start] = the_array[end];
        the_array[end] = temp;
        
        reverse_arrayR(the_array, start + 1, end - 1);
    }//reverse_arrayR
    
}//RecursionExamples
