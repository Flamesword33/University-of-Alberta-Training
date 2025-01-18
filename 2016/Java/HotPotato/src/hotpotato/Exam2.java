/*
 * File Purpose
 * by Nathan Pelletier
 * Date
 */

package hotpotato;

/**
 *
 * @author Nathan Pelletier
 */
public class Exam2 {
    
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

      //=========================================================================
  
  /**
   * finds the two elements next to node and returns them if found
   * returning the element before the tail first and the element after the 
   * tail next
   * @param element
   * @return 
   */
  public String neighbors(E element){
    if(size == 0) //ensures linked list is filled
        return "ERROR EMPTY LIST";
    
    if (tail.getElement() != element) //sets tail equal to element
        for(int j = 0; j < size ; j++){
            tail = tail.getNext();
            if (tail.getElement() == element)
                break;
            else if(j == size - 1)
                return "ERROR ELEMENT DOSEN'T EXIST";
        }
    
    Node<E> first_part = tail.getNext(); //saves the element after tail
    Node<E> last_part = first_part;      // for finding the element before tail
    
    if(first_part == tail) //no neighbors
        return "Neighbors of "+ tail.getElement()+ ": No neighbors";
    
    else if(first_part.getNext() == tail) //one neighbor
        return "Neighbors of " + tail.getElement() + ": "
                + first_part.getElement() + " " + first_part.getElement();
    else  //two neighbors, finds other neighbor
        for(int i = 0; i < size - 2; i ++){
            last_part = last_part.getNext();
        }
    return "Neighbors of " + tail.getElement() + ": " 
            + last_part.getElement() + " " + first_part.getElement();
            
  }//neighbors
  ///////////////////
  //DONE AND TESTED//
  ///////////////////
  //==========================================================================
    

}
