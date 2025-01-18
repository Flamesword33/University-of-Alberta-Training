/**
 * File to test Part 1 of Lab Exam #2
 * AUCSC 112 
 * March 2016
 * 
 * by R. Heise
 */


package tree;

public class MainToTestPart1 {

    /**
     * @param args the command line arguments (none)
     */
    public static void main(String[] args) {
//        Tree employees = new Tree();
//        
//        //1.  Test empty tree
//        System.out.println("My employees: " + employees);
//        System.out.println("Max so far: " + employees.maxName());
//        System.out.println("Parent of 80: " + employees.parent(80));
//        System.out.println();
//        
//        //2. Test tree with only root
//        employees.insert(50, "Bugs Bunny");
//        System.out.println("My employees: " + employees);
//        System.out.println("Max so far: " + employees.maxName());
//        System.out.println("Parent of 50: " + employees.parent(50));
//        System.out.println("Parent of 80: " + employees.parent(80));
//        System.out.println("Parent of 20: " + employees.parent(20));
//        System.out.println();
//        
//        //3. Test tree with 2 nodes
//        employees.insert(30, "Mickey");
//        System.out.println("My employees: " + employees);
//        System.out.println("Max so far: " + employees.maxName());
//        System.out.println("Parent of 50: " + employees.parent(50));
//        System.out.println("Parent of 30: " + employees.parent(30));
//        System.out.println("Parent of 80: " + employees.parent(80));
//        System.out.println("Parent of 20: " + employees.parent(20));
//        System.out.println();
//        
//        //4. Test tree where the max changes
//        employees.insert(25, "Donald");
//        employees.insert(80, "Minnie");
//        System.out.println("My employees: " + employees);
//        System.out.println("Max so far: " + employees.maxName());
//        System.out.println("Parent of 50: " + employees.parent(50));
//        System.out.println("Parent of 30: " + employees.parent(30));
//        System.out.println("Parent of 80: " + employees.parent(80));
//        System.out.println("Parent of 20: " + employees.parent(20));
//        System.out.println("Parent of 70: " + employees.parent(70));
//        System.out.println("Parent of 37: " + employees.parent(37));
//        System.out.println("Parent of 100: " + employees.parent(100));
//        System.out.println("Parent of 25: " + employees.parent(25));
//        System.out.println();
//        
//        //5. Test our tree as shown on handout
//        employees.insert(65, "Pluto");
//        employees.insert(40, "Santa");
//        employees.insert(100, "Elsa");
//        employees.insert(70, "Anna");
//        employees.insert(58, "Olaf");        
//        System.out.println("My employees: " + employees);
//        System.out.println("Max so far: " + employees.maxName());
//        System.out.println("Parent of 50: " + employees.parent(50));
//        System.out.println("Parent of 30: " + employees.parent(30));
//        System.out.println("Parent of 80: " + employees.parent(80));
//        System.out.println("Parent of 20: " + employees.parent(20));
//        System.out.println("Parent of 70: " + employees.parent(70));
//        System.out.println("Parent of 37: " + employees.parent(37));
//        System.out.println("Parent of 100: " + employees.parent(100));
//        System.out.println("Parent of 25: " + employees.parent(25));
//              
    }//main
}//class MainToTestPart1

//EXPECTED OUTPUT
//run:
//My employees: null
//Max so far: null
//Parent of 80: Not Available
//
//My employees: (50, Bugs Bunny)
//Max so far: Bugs Bunny
//Parent of 50: Not Available
//Parent of 80: Not Available
//Parent of 20: Not Available
//
//My employees: (30, Mickey)(50, Bugs Bunny)
//Max so far: Bugs Bunny
//Parent of 50: Not Available
//Parent of 30: Bugs Bunny
//Parent of 80: Not Available
//Parent of 20: Not Available
//
//My employees: (25, Donald)(30, Mickey)(80, Minnie)(50, Bugs Bunny)
//Max so far: Minnie
//Parent of 50: Not Available
//Parent of 30: Bugs Bunny
//Parent of 80: Bugs Bunny
//Parent of 20: Not Available
//Parent of 70: Not Available
//Parent of 37: Not Available
//Parent of 100: Not Available
//Parent of 25: Mickey
//
//My employees: (25, Donald)(40, Santa)(30, Mickey)(58, Olaf)(70, Anna)(65, Pluto)(100, Elsa)(80, Minnie)(50, Bugs Bunny)
//Max so far: Elsa
//Parent of 50: Not Available
//Parent of 30: Bugs Bunny
//Parent of 80: Bugs Bunny
//Parent of 20: Not Available
//Parent of 70: Pluto
//Parent of 37: Not Available
//Parent of 100: Minnie
//Parent of 25: Mickey
//BUILD SUCCESSFUL (total time: 3 seconds)