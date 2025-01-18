/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */
package correctnesspart1testing;

/**
 *
 * @author Nathan
 */
public class CorrectnessPart1Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(sumOddV1(7));
//        System.out.println(sumOddV1(8));
//        System.out.println(sumOddV1(-5));
        System.out.println(sumOddV1(15));
        
    }//main
//    public static int sumOddV1(int n){
//        int answer = 0;
//        int place = 1;
//        
//        while (place <= n){
//            if (place % 2 == 1) //odd
//                answer = answer + place;
//            place++;
//        }
//        return answer;
//    }//sumOddV1
    
//    public static int sumOddV1(int n){
//        int answer = 0;
//        int place = 1;
//        
//        while (place <= n){
//            answer = answer + place;
//            place = place + 2;
//        }
//        return answer;
//    }//sumOddV2

    public static int sumOddV1(int n){
        int answer = 0;
        
        if (n > 0){        //checks if positive
            if ((n & 1) == 1){//odd  bitwise way to tell if odd
                                    // comares last 1 in bionary
                n = n + 1;
            }
            
            n = n >> 1;  //n / 2
            answer = n * n;
        }//outer if

        return answer;
    }//sumOddV3

    
}
