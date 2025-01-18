/**
 * File Purpose
 * by Nathan Pelletier
 * March 15 2016
 * 
 * Project Goals;
 *      READ FILE!
 *      Store paraenthasis!
 *          types !
 *          opening / closing!
 *      tranverse through a line?
 *          stack structure!
 *          compare?
 * 
 * DATA
 *      my_stack
 *      open_paren
 *      closed_paren
 * Methods 
 *      main
 *      read_file
 *      make_paren_Array
 *      interpret_array
 *      compair --> boole
 */
package parenmatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author Nathan
 */
public class ParenMatch {

    //DATA
    ///////////////////////////////////////////////////////
    public static Stack<Character> my_stack = new Stack();
    //Not sure what you mean by not creating a global object
    //90% of what i do calls to the same prebuilt object
    public static Character [] openParen;  
    public static Character [] closedParen; 
    
    //Methods
    //////////////////////////////////////////////////

    /**
     * main 
     * 
     * calls all other methods
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner file;
       
       file = read_file();
       make_paren_Arrays(file);//put in main
    }//main
    
    /**
     * read_file
     * 
     * starts file and allows access to file
     * @return 
     */
    public static Scanner read_file(){
        File input_file;
        Scanner file_scanner;
        //Character[] openParen = null;
        //Character[] closedParen = null;
      
        input_file = new File("C:/Users/Nathan/Desktop/School Files"
                + "/computing science/112/labs/Data for lab 5");
        try {
            file_scanner = new Scanner(input_file);
        }//try
        catch (FileNotFoundException ex) {
            System.out.println("File NOT found");
            return null;
        }//catch
        return file_scanner;
      
    }//read_file
    
    /**
     * make_paren_Arrays
     * 
     * finds open brackets and closed brackets for program
     * @param in 
     */
    public static void make_paren_Arrays(Scanner in){
            
        
        String line; // reads back file
        int num = in.nextInt(); //tells us where we are    
         //read each line of file and print to standard out
         //because first thing is 
         
        in.nextLine(); //flush CR with the num
                  
        openParen = new Character[num];
        closedParen = new Character[num];
        
        for(int i = 0; i < num ; i++){
            line = in.nextLine();
            //System.out.println(line);
            openParen[i] = line.charAt(0);  //opening paren
            closedParen[i] = line.charAt(1); //closing paren
        
        }//while 
        
        interpret_file(in);
        
    }//make_paren_Arrays
        
    /**
     * interpret_file
     * 
     * runs through file one line at a time checking if brackets are opened 
     * closed and prints a statement with line number found on
     * @param in 
     */    
    public static void interpret_file(Scanner in){
        
        //char open_c;
        //char closed_c;
        String line;
        //String place;
        int line_num = 0;
        //boolean done = false;
        
        while(in.hasNextLine()){
            
            line = in.nextLine();
            line_num ++; //counts which line it happened on
            my_stack.clear();
            
            for(int j = 0; j < line.length(); j++){
                //System.out.print(line.charAt(j));
            
                for(int k = 0; k < 7; k++){
                    
                    if(line.charAt(j) == openParen[k]){
                        //System.out.print("5");
                        my_stack.add(openParen[k]);
                    }//if open
                
                    else if(line.charAt(j) == closedParen[k]){
                        //System.out.print("6");
                        
                        if(!(compair(k))){
                            
                            System.out.println(" Error: forgot to close a" 
                                    + " braket on line " + line_num + ".");
                            
                            line_num ++;                            
                            
                            //need help with, causes error and fails to find
                            // second to final line of code
                            line = in.nextLine();   //full 
                            j = 0;                  //manual
                            k = 0;                  //reset
                            my_stack.clear();
                           
                        }//inner if
                   
                    }//else if
                
                }//inner for
                
                if(j == (line.length() - 1) && !(my_stack.isEmpty())){
                    System.out.println("Error: forgot to open a" + 
                            " bracket on line " 
                            + line_num +".");
                    
                }//final if
           
            }//outer for
       
        }//while
        
    }//interpret_file
    
    /**
     * compair --> boole
     * 
     * compairs if the open bracket is closed
     * @param finder
     * @return 
     */
    public static boolean compair (int finder){
        
        char open;    
        
        if(my_stack.isEmpty()){
            return false;
        }//if
        //pop after cheching if empty    
        
        open = my_stack.pop();
        
        if (open != openParen[finder])
                return false;
        
        else 
            return true;
        
    }//compair    
 
}//ParenMatch
