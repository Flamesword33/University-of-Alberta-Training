/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package lab1.concurrency;
import java.util.Random;

/**
 *
 * @author Rosanna
 */
public class Lab1Concurrency {

    /**
     * main
     *
     * @param args - the command line arguments
     */
    public static void main(String[] args) {
        final int SIZE = 10000000;
        final int UNIT_PER = SIZE / 10;
        final int NINES = UNIT_PER - 1;
        final int NUM_THREADS = 10;
        double[] numList = new double[SIZE];
        double sumSerial;
        Random randGen = new Random();
        SumArrayPartial aSummer;
        int loBound;
long startTimeS;
long endTimeS;
long startTimeP;
long endTimeP;

        
        
        //create random array
        for (int i = 0; i < SIZE; i++)
            numList[i] = 1;//randGen.nextDouble(); //random in [0, 1)
        
        //find serial sum
startTimeS = System.nanoTime();        
        sumSerial = 0;
        for (int i = 0; i < SIZE; i++)
            sumSerial = sumSerial + numList[i];
endTimeS = System.nanoTime();         
        //find sum in parallel

        SumArrayPartial[] sumThreads = new SumArrayPartial[10];
        //make Threads
        loBound = 0;
        for (int i = 0; i < NUM_THREADS; i++){                   
            sumThreads[i] = new SumArrayPartial(numList, loBound, 
                                                loBound + NINES);
            loBound = loBound + UNIT_PER;
        }//for

startTimeP = System.nanoTime();         
        //start Threads
        for (int i = 0; i < NUM_THREADS; i++){
            sumThreads[i].start();
        }
        
        //make sure threads finished
        try{
            for (int i = 0; i < NUM_THREADS; i++){
                sumThreads[i].join();
            }
        }
        catch (Exception e){}
endTimeP = System.nanoTime(); 

        //Print answers
        System.out.print("Serial sum is:   " + sumSerial);
        System.out.println("            TIME: " + (endTimeS - startTimeS) / 1000000000.0);
        System.out.print("Parallel sum is: " + SumArrayPartial.getSum());
        System.out.println("            TIME: " + (endTimeP - startTimeP) / 1000000000.0);
    }//main

}//class