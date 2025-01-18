/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package timing;

/**
 *
 * @author Nathan
 */
public class Timing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int N = 1000000;
        long startTime, endTime;
        long sumN;
        startTime = System.nanoTime();
        sumN = sumToN(N);
        endTime = System.nanoTime();
        System.out.println("Sum to " + N + " is : " + sumN);
        System.out.println("It took " + (endTime - startTime) + " nanoseconds");  
        
        
        startTime = System.nanoTime();
        rep1('x', N);
        endTime = System.nanoTime();
        System.out.println("Sum to " + N + " is : " + sumN);
        System.out.println("It took " + (endTime - startTime) + " nanoseconds");
        
        
        startTime = System.nanoTime();
        rep2('x', N);
        endTime = System.nanoTime();
        System.out.println("Sum to " + N + " is : " + sumN);
        System.out.println("It took " + (endTime - startTime) + " nanoseconds");
    }//main
    
    public static long sumToN(int n) {
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = answer + i;
        }
        return answer;
    }//sumToN
    
    public static String rep1(char c, int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer = answer + c;
        }//for
        return answer;
    }//rep1
    
    public static StringBuilder
            rep2(char c,
                    int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(c);
        }//for
        return answer;
    }//rep2
}
