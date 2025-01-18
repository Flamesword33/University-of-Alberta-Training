/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwisestuff;

/**
 *
 * @author Nathan
 */
public class BitWiseStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        x = x >> 1;
        x = x << 1;
        y = y & x;
        System.out.println(x + " " + Integer.toString(x, 2));
        System.out.println(y + " " + Integer.toString(y, 2));
    }
    
}
