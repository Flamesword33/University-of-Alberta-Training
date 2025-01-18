/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package play_with_arrays;

/**
 *
 * @author Nathan
 */
public class Play_With_Arrays {
    //prints one char per line
    public static void print_forwards(char[] some_chars){
        for(char letter : some_chars)
            System.out.println(letter);
    }//print_forwards
    
    public static void print_backwards(char[] some_chars){
        for(int i = some_chars.length - 1 ; i > - 1 ; i-- ){
            System.out.println();// find a variable that manipulates i and uses indexing into student
        }//for each loop
            
    }//print_backwards

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] student1 = {'M','i','c','k','e','y'};
        char[] student2 = {'M','i','n','n','e','y'};
        
        print_forwards(student1);
        System.out.println();
        print_forwards(student2);
        System.out.println();
        print_backwards(student1);
        System.out.println();
        print_backwards(student2);
        
    }//main
    
}//Play_With_Arrays
