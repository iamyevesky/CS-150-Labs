//Code copied from Lab07
/**
 * A class that creates the node for a binary tree.
 *
 * @author Sena Yevenyo
 * @version October 21, 2019
 */
public class BinaryNode<E extends Comparable<E>>
{
    // instance variables - replace the example below with your own
    private int height = 0;
    //public int id;
     /**
     * Left child of node
     */
    public BinaryNode L = null;
    /**
     * Right child of node
     */
    public BinaryNode R = null;
    /**
     * Middle child of node
     */
    public BinaryNode M = null;
    /**
     * Parent of node
     */
    public BinaryNode parent = null;
    private E element;
    
    /**
     * Constructor for objects of class BinaryNode
     */
    public BinaryNode()
    {
        element = null;
    }
    
    /**
     * Constructor for objects of class BinaryNode
     */
    public BinaryNode(E data)
    {
        element = data;
    }
    
    /**
     * Returns value stored in node
     *
     * @return the value stored in node object
     */
    public E getValue()
    {
        return element;   
    }
    
    
    /**
     * String representation of node
     * 
     * @ String representation of node
     */
    public String toString(){
        return element.toString();
    }
    
}