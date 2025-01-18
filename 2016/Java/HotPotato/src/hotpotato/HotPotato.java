/**
 * HotPotato.java
 * by Nathan Pelletier
 * March 8, 2016
 * 
 * Asks user for the people playing and creates a linked list
 * then randomly switches two people, 
 * the program then starts the game,
 * eliminating a player based on a seconds count.
 * 
 * The game ends when only one person is left.
 * 
 * Persistant Problems:
 *      random second try dosen't work for more than three people and is 
 *      disorganized for three
 * 
 * Data:
 *     + my_list
 * 
 * Methods:
 *     + main --> void
 *     + game --> void
 *     + input_group --> void
 *     + timer --> void
 *     + winner --> boole
 *     + switch_places --> void
 */

package hotpotato;

import java.util.Random;
import java.util.Scanner;
/**
 * @author Nathan Pelletier
 */
public class HotPotato {
    
    public static CircularlyLinkedList<String> my_list = 
            new CircularlyLinkedList();
    public static int person_1;
    public static int person_2;

    /**
     * main
     *      Runs the game
     * @param args the command line arguments (none
     */
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
        
        //game();
    }//main
    
    /**
     * game
     *      connects and ensures all other functions 
     * 
     */
    public static void game (){//part 5 putting it together
        int s;
        String j;
        String k;
//        String responce;
        Random randInt_1 = new Random();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the number of players: ");
        s = input.nextInt();
        
        if(s > 0)
            input_group(s);
        else if (s == 0){
            System.out.println("Why dosen't anyone want to play?");
            game();//recursion to force user to type more than 0
        }
        else{
            System.out.println("???What??? Try a positive number next time.");
            game();
                    
        }//else    
        
        
//        person_1 = randInt_1.nextInt(my_list.size());
//        person_2 = randInt_1.nextInt(my_list.size());
//        
//        if(person_1 != person_2){
//            for(int a = 0; a < person_1; a++) //rotates until at random switch
//                my_list.rotate();
//
//            j = my_list.first();
//
//            for(int b = person_1; b < my_list.size(); b++) //returns to start
//                my_list.rotate();
//
//            for(int c = 0; c < person_2; c++) // again until random switcher
//                my_list.rotate();
//
//            k = my_list.first();
//            System.out.println("Random Switch " + j + " and " + k);
//            
//            for(int d = person_2; d < my_list.size(); d++) //again returns
//                my_list.rotate();
//
//            my_list.switch_places(j, k);
//        }//if
        
        timer();
         
    }//game
    
    /**
     * input_group
     *      creates the game design within a linked list
     * @param size 
     */
    public static void input_group (int size){//part 1
        int group = 0;
        String name;
        Scanner input1 = new Scanner(System.in);
        
        for(int i = 0 ; i < size; i++){
            group++;
            System.out.println("Please enter the " + (i + 1) +
                    " member of your group: ");
            name = input1.next();
            my_list.addLast(group + "." + name); 
            
        }//group input for loop
        System.out.println(my_list);
        
    }//input group
    ///////////////////////
    //Complete and Tested//
    ///////////////////////
    
    /**
     * timer
     *      creates a random number and runs through the list 
     *      eliminating the element of the list that timer stops on
     */
    public static void timer (){//part 2
        int timer;
        Random randInt = new Random();
        //Timer won't go higher than 30 seconds as kids will get bored
        while(!(winner())){
            timer = randInt.nextInt(19);
            System.out.println(timer + 1);
            System.out.println(my_list.first());
            for(int j = 1; j < timer + 1; j++){
                my_list.rotate();
                System.out.println(my_list.first());
            }//for loop determining rotation through group
            my_list.removeFirst();
            System.out.println(my_list);
        }//while    
    }//timer
    ////////
    //DONE//
    ////////   
    
    /**
     * winner--> boole
     *      determines if the size of the list is one 
     *      returns true if it is one
     * @return 
     */
    public static boolean winner(){//part 3
        int win;
        win = my_list.size();
        if(win > 1)
            return false;
        else{
            System.out.println("The winner is " + my_list);
            return true;
        }    
    }//winner
    ////////
    //DONE//
    ////////
    
    //////////////////
    //AGAIN OLD CODE//
    //////////////////
    
    /**
     * switch_places
     *      uses two names to run through entire list comparing to find 
     *      replaces element of list when found
     *      (NEEDS TO BE A CHANGE OF LIST PLACEMENT NOT ELEMENT)
     * @param place_1
     * @param place_2 
     */
//  public static void switch_places(String place_1, String place_2){//part 4
////      for loop and two if statments should do here, followed by a call to 
////      switch them(this will be the hard part)
////      finally a check in case there not in the list
//        for(int l = 0 ; l < my_list.size(); l++){
//            if(my_list.first() == place_1){
//                my_list.removeFirst();
//                my_list.addFirst(place_2);
//            }//if    
//            else if(my_list.first() == place_2){
//                my_list.removeFirst();
//                my_list.addFirst(place_1);
//            }//else if
//                    
//            my_list.rotate();
//        }//for loop        
//    }//switch places
//    
    ///////////////////////////////
    //NEEDS TO BE FIXED LOGICALLY//
    ///////////////////////////////
}//HotPotato
