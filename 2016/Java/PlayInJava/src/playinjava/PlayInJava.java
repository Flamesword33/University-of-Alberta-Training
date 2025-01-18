/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playinjava;

import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class PlayInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println("Your number was " + input_number() + ".");
        int[] list = {1,3,5,14,12,10,0,1,2,3,4,5,57,15,14,12,11,10,1,2,3,5};
        System.out.println(list.length);
    }//main
    
    public static int input_number(){
        int num;
        Scanner keyboardInput = new Scanner(System.in);
        System.out.print("Please enter your favorite number: ");
        num = keyboardInput.nextInt();
        return num;
    }//input_number
    

    
}//class
