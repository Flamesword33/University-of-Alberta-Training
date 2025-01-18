/*
 * Creates a Multiplication table 
 * by Nathan Pelletier
 * January 15, 2016
 */
package multiplication_table;

/**
 *
 * @author Nathan
 */
public class Multiplication_Table {
   
    public static void print_table(int num){
        for(int sys_num = 1; sys_num < 13; sys_num++)
            System.out.println(num + " X " + sys_num + " = " + num * sys_num);
    }//print_table

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 1;
        while (i < 12){
            i = i + 1;
            print_table(i);
            System.out.println();
        }//while   
    }//main
}//class
