/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package myprog;

/**
 *
 * @author Nathan
 */
import java.util.Scanner;

public class MyProg {
    
    public static int absVal(int x){
        if (x < 0)
        x = -x;
        return x;
    }//abs Val
    
    public static void main(String[] args) {
        Scanner userNumbers = new Scanner(System.in);
        int totNum;
        int inNum;
        int sum = 0;
        int i;
        System.out.println("How many numbers will you enter? ");
        totNum = userNumbers.nextInt();
    
        for(i = 1; i <= totNum; i++){
            System.out.print("Please enter number " + i + ": ");
            inNum = userNumbers.nextInt();
            sum = sum + absVal(inNum);
        }//for loop
    
        System.out.println("The sum of magnitudes is: " + sum);
    }//main
}//MyProg