/**
 * Part 2 of Lab Exam 2
 * March 2016
 * 
 * by R. Heise
 */
package hotpotato;


public class MainToTestPart2 {

    public static void main(String[] args) {
        CircularlyLinkedList<Character> alpha = new CircularlyLinkedList();
        
        //1. Test empty list
        System.out.println("Neighbors of E: " + alpha.neighbors('E'));
        System.out.println();
        
        //2. Test list of size one
        alpha.addLast('Z');
        System.out.println("Neighbors of E: " + alpha.neighbors('E'));
        System.out.println("Neighbors of Z: " + alpha.neighbors('Z'));
        System.out.println();
        
        //3. Test list of size two
        alpha.addLast('H');
        System.out.println("Neighbors of E: " + alpha.neighbors('E'));
        System.out.println("Neighbors of Z: " + alpha.neighbors('Z'));
        System.out.println("Neighbors of H: " + alpha.neighbors('H'));
        System.out.println();
        
        //3. Test list of size three
        alpha.addLast('W');
        System.out.println("Neighbors of E: " + alpha.neighbors('E'));
        System.out.println("Neighbors of Z: " + alpha.neighbors('Z'));
        System.out.println("Neighbors of H: " + alpha.neighbors('H'));
        System.out.println("Neighbors of W: " + alpha.neighbors('W'));
        System.out.println();
        
         //4. Test list of size four
        alpha.addLast('B');
        System.out.println("Neighbors of E: " + alpha.neighbors('E'));
        System.out.println("Neighbors of Z: " + alpha.neighbors('Z'));
        System.out.println("Neighbors of H: " + alpha.neighbors('H'));
        System.out.println("Neighbors of W: " + alpha.neighbors('W'));
        System.out.println("Neighbors of B: " + alpha.neighbors('B'));
        System.out.println();
        
        //5. Test bigger list
        alpha.addLast('K');
        alpha.addLast('P');
        alpha.addLast('U');
        alpha.addLast('Y');
        System.out.println("Neighbors of E: " + alpha.neighbors('E'));
        System.out.println("Neighbors of Z: " + alpha.neighbors('Z'));
        System.out.println("Neighbors of H: " + alpha.neighbors('H'));
        System.out.println("Neighbors of W: " + alpha.neighbors('W'));
        System.out.println("Neighbors of B: " + alpha.neighbors('B'));
        System.out.println("Neighbors of K: " + alpha.neighbors('K'));
        System.out.println("Neighbors of P: " + alpha.neighbors('P'));
        System.out.println("Neighbors of U: " + alpha.neighbors('U'));
        System.out.println("Neighbors of Y: " + alpha.neighbors('Y'));
        System.out.println();
        
    }//main  
}//class MainToTestPart2

//Expected Output
//run:
//Neighbors of E: Element not found
//
//Neighbors of E: Element not found
//Neighbors of Z: No neighbors
//
//Neighbors of E: Element not found
//Neighbors of Z: H H
//Neighbors of H: Z Z
//
//Neighbors of E: Element not found
//Neighbors of Z: W H
//Neighbors of H: Z W
//Neighbors of W: H Z
//
//Neighbors of E: Element not found
//Neighbors of Z: B H
//Neighbors of H: Z W
//Neighbors of W: H B
//Neighbors of B: W Z
//
//Neighbors of E: Element not found
//Neighbors of Z: Y H
//Neighbors of H: Z W
//Neighbors of W: H B
//Neighbors of B: W K
//Neighbors of K: B P
//Neighbors of P: K U
//Neighbors of U: P Y
//Neighbors of Y: U Z
//
//BUILD SUCCESSFUL (total time: 0 seconds)