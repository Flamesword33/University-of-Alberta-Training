/**
 * SumArrayPartial.java
 * by R. Heise
 * 26 January 2017
 * 
 * Sums up a contiuous portion of an array, and adds this sum
 * to a class total.
 */

package lab1.concurrency;

/**
 *
 * @author Nathan Pelletier
 */
public class SumArrayPartial extends Thread{
    private static double sumOfAll = 0;
    private static final Object lock = new Object();
    private int loBound;
    private int hiBound;
    public double[] array;

    /**
     * Constructor
     * Now ready to sum the array from locations loBound to
     * hiBound (inclusive)
     *
     * @param array
     * @param loBound
     * @param hiBound
     */

    SumArrayPartial(double[] array, int loBound, int hiBound){
        this.array = array;
        this.loBound = loBound;
        this.hiBound = hiBound;
    }//constructor

    /**
     * getSum() --> double
     * @return value of sum of array
     * Note that it may not be the full sum of the array--depends how many
     * portions have been finished summing based on how the threads
     * are run.
     */
    public static double getSum(){
        return sumOfAll;
    }//getSum

    /**
     * run() --> void
     * Runs the thread to find the partial sum and add to the
     * class total.
     */
    public void run(){
        double partSum = 0;
        for (int i = loBound; i <= hiBound; i++)
            partSum = partSum + array[i];

        //have this thread's sum, now add to total (sumOfAll)
        //needs to be locked and syncronize
        synchronized(lock){

            sumOfAll = sumOfAll + partSum;
        }//synchronized
    }//run

}//class