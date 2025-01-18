/**
 * To create a simple binary search tree
 * by Nathan Pelletier
 * March 22, 2016
 */
package tree;

/**
 *
 * @author Nathan
 */
public class Tree {
    
    //+++++++++++++++++++++++++++++++++++++++++++
    protected class Node{
        //Data
        //================================
        protected int num;
        protected String name;
        protected Node left_child;
        protected Node right_child;
        
        //CONSTRUCTORS
        //==================================
        /** 
         * Sets up a node with a number and a name
         * @param num
         * @param name 
         */
        Node(int num, String name){
            this.num = num;
            this.name = name;
            left_child = null;
            right_child = null;
        }//Node constructor
        
        //ACCESSOR METHODS
        public int get_num(){
            return num;
        }//get num
        
        public String get_name(){
            return name;
        }//get name
        
        public Node get_left_child(){
            return left_child;
        }//get left
        
        public Node get_right_child(){
            return right_child;
        }//get right
        
        
        //SETTER METHODS
        //============================
        public void set_num(int num){
            this.num = num;
        }//set num
        
        public void set_name(String name){
            this.name = name;
        }//set name
        
        public void set_left_child(Node n){
            left_child = n;
        }//set left
        
        public void set_right_child(Node n){
            right_child = n;
        }//set right
        
        //OTHER METHODS
        //===================================
        public String toString(){
            return "(" + num + ", " + name + ")";
        }//toString
        
    }//embeded Node class
    //+++++++++++++++++++++++++++++++++++++++++++++++
    
    //DATA
    /////////////////////////////////////////////
    protected Node root;
    
    //CONSTRUCTOR
    //////////////////////////////////////////////
    Tree(){
        root = null;
    }//base tree
    
    //METHODS
    /////////////////////////////////////////////
    /**
     * Puts an new node with number and name into tree
     * Maintain a binary search order
     * @param num
     * @param name 
     */
    public void insert(int num, String name){
        if(root == null){//tree is empty
            Node new_node = new Node(num,name);
            root = new_node;
        }//tree is empty
        
        else {//something is in the tree already
            //find the spot to put the new node
            insert(num, name, root);
            
            
        }//something is in the tree already
    }//insert
    
    private void insert(int num, String name, Node location){
        
        if(location.get_num() <  num){
            
            if(location.get_right_child() == null){
                Node new_node = new Node(num,name);
                location.set_right_child(new_node);
            }//if next is there
            
            else
                insert(num, name, location.get_right_child());
        }//num is greater
        
        else{
            
            if(location.get_left_child() == null){
                Node new_node = new Node(num,name);
                location.set_left_child(new_node);
            }//if next is there
            
            else//keep looking for location
                insert(num, name, location.get_left_child());
        }// num is less
        
    }//recursive insert
    
    public String toString(){
        if(root == null)
            return "ERROR 404 NOT FOUND";
        return rec_depth_string(root);
    }//toString
    
    private String rec_depth_string(Node location){
        if(location == null)
            return "";
        
        else{

            return rec_depth_string(location.get_left_child()) + 
                    rec_depth_string(location.get_right_child())
                    + location.toString();
        }//both have more
        
    }//rec depth string
    
     public String preToString(){
        if (root == null)
            return "ERROR 404 NOT FOUND";
     
        return pre_rec_depth_string(root);
    }//toString
    
    private String pre_rec_depth_string(Node location){
        if(location == null)
            return "";
        
        else{
            return location.toString() +
                   pre_rec_depth_string(location.get_left_child()) + 
                   pre_rec_depth_string(location.get_right_child());
        }//else
    }//pre_rec_depth_string
    
//        if( root == null){
//            return "Empty";
//        }
//        
//        else if (location.get_left_child() == null &&
//                location.get_left_child() == null){
//            return location.toString();
//        }//done
//        
//        else if (location.get_left_child() == null){
//            return rec_depth_string(location.get_right_child())
//                    + location.toString();
//            
//        }//more at right
//        //done on left
//        
//        else if (location.get_right_child() == null){
//            return rec_depth_string(location.get_left_child())
//                    + location.toString();
//        }//more at left
//        //done on right
//        
//        else{
    
    /**
     * Finds the name corisponding to the number
     * @param num
     * @return 
     */
    public String find(int num){
        return findAux(num, root);
        
    }//find and return name 
    
    /**
     * 
     * @param num
     * @param location
     * @return 
     */
    private String findAux(int num, Node location){
        if(location == null)
            return " ERROR 404 NOT FOUND";
        if(location.get_num() == num){
            return location.get_name();
        }//if root is the one you want
        else if(location.get_num() < num){
            return findAux(num, location.get_right_child());
        }//right
        else{
            return findAux(num, location.get_left_child());
        }//left
        
    }//findAux
    
    //=========================================================================
    /**
     * finds the greatest number and returns the assosiated name
     * uses same principle as find but uses only greater than until it finds 
     * a null
     * @return String
     */
    public String maxName(){
        return max_name(root);        
    }//maxName
    
    /**
     * recursivly calls from maxName
     * @param location
     * @return 
     */
    private String max_name(Node location){
        if(location == null) //cuts off program if it encounters null
            return "ERROR 404 NOT FOUND";
        if(location.get_right_child() == null)//right child no longer exists
            return location.get_name();
        else//more numbers
            return max_name(location.get_right_child());
    }//max name recursive
    ///////////////////
    //DONE AND TESTED//
    ///////////////////
    
    //========================================================================
    
    /**
     * Looks through tree and stops one node before the requested number
     * program then returns the node.
     * If the program can't find the node it will return null
     * @param num
     * @return Node
     */
    public Node parent(int num){
        return parentR(num, root);
    }//parent
    
    /**
     * recursive calls to exicute search through tree
     * @param num
     * @param location
     * @return 
     */
    private Node parentR(int num, Node location){
        if(location == null || location.get_num() == num) //checks for node
            return null;              //and a match to num terminates program
                                      //if found
                                      
        if(location.get_num() < num){   //look right
            if(location.get_right_child() == null) //checks if node exists
                return null;
            else if(location.get_right_child().get_num() == num) 
                return location;                    //checks for desired num
            
            else                                    //contiues to right
                return parentR(num, location.get_right_child());
        }//right
        else{       //looks left
            if(location.get_left_child() == null) //checks if node exists
                return null;
            else if(location.get_left_child().get_num() == num)
                return location;            //checks for desired num
            
            else                            //continues to left
                return parentR(num, location.get_left_child());
        }//left
        
    }//parent recursion calls
    
    ///////////////////
    //DONE AND TESTED//
    ///////////////////
    
    //=========================================================================

    /**
     * @param args the command line arguments(don't use)
     */
    public static void main(String[] args) {
        
//        Tree employees = new Tree();
//        employees.insert(50, "Bugs");
//        employees.insert(30, "Mickey");
//        employees.insert(80, "Minney");
//        employees.insert(25, "Donald");
//        employees.insert(65, "Pluto");
//        employees.insert(40, "Santa");
//        employees.insert(100, "Elsa");
//        employees.insert(70, "Anna");
//        employees.insert(58, "Olaf");
//        System.out.println("My employees are: " + employees.preToString());
//        
//        System.out.println("25" + employees.find(25));
//        System.out.println("100" + employees.find(100));
//        System.out.println("65" + employees.find(65));
//        System.out.println("69" + employees.find(69));
//        System.out.println("25" + employees.find(50));
        
        Tree employees = new Tree();
        
        //1.  Test empty tree
        System.out.println("My employees: " + employees);
        System.out.println("Max so far: " + employees.maxName());
        System.out.println("Parent of 80: " + employees.parent(80));
        System.out.println();
        
        //2. Test tree with only root
        employees.insert(50, "Bugs Bunny");
        System.out.println("My employees: " + employees);
        System.out.println("Max so far: " + employees.maxName());
        System.out.println("Parent of 50: " + employees.parent(50));
        System.out.println("Parent of 80: " + employees.parent(80));
        System.out.println("Parent of 20: " + employees.parent(20));
        System.out.println();
        
        //3. Test tree with 2 nodes
        employees.insert(30, "Mickey");
        System.out.println("My employees: " + employees);
        System.out.println("Max so far: " + employees.maxName());
        System.out.println("Parent of 50: " + employees.parent(50));
        System.out.println("Parent of 30: " + employees.parent(30));
        System.out.println("Parent of 80: " + employees.parent(80));
        System.out.println("Parent of 20: " + employees.parent(20));
        System.out.println();
        
        //4. Test tree where the max changes
        employees.insert(25, "Donald");
        employees.insert(80, "Minnie");
        System.out.println("My employees: " + employees);
        System.out.println("Max so far: " + employees.maxName());
        System.out.println("Parent of 50: " + employees.parent(50));
        System.out.println("Parent of 30: " + employees.parent(30));
        System.out.println("Parent of 80: " + employees.parent(80));
        System.out.println("Parent of 20: " + employees.parent(20));
        System.out.println("Parent of 70: " + employees.parent(70));
        System.out.println("Parent of 37: " + employees.parent(37));
        System.out.println("Parent of 100: " + employees.parent(100));
        System.out.println("Parent of 25: " + employees.parent(25));
        System.out.println();
        
        //5. Test our tree as shown on handout
        employees.insert(65, "Pluto");
        employees.insert(40, "Santa");
        employees.insert(100, "Elsa");
        employees.insert(70, "Anna");
        employees.insert(58, "Olaf");        
        System.out.println("My employees: " + employees);
        System.out.println("Max so far: " + employees.maxName());
        System.out.println("Parent of 50: " + employees.parent(50));
        System.out.println("Parent of 30: " + employees.parent(30));
        System.out.println("Parent of 80: " + employees.parent(80));
        System.out.println("Parent of 20: " + employees.parent(20));
        System.out.println("Parent of 70: " + employees.parent(70));
        System.out.println("Parent of 37: " + employees.parent(37));
        System.out.println("Parent of 100: " + employees.parent(100));
        System.out.println("Parent of 25: " + employees.parent(25));
              
    
    }//main
    
}//Tree