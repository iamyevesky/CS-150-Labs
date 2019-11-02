
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
     * Returns height of a node in a tree
     *
     * @return height of node in the tree;
     */
    public int getHeight(){
        int lHeight = 0;
        int rHeight = 0;
        if(L==null) lHeight = -1;
        else lHeight= L.getHeight();
        if(R==null) rHeight = -1;
        else rHeight=R.getHeight();
        height = Math.max(lHeight,rHeight)+1;
        return height;
    }
    
    /**
     * String representation of node
     * 
     * @ String representation of node
     */
    public String toString(){
        return element.toString();
    }
    
     /**
     * Returns depth of a node in a tree
     *
     * @return depth of node in the tree;
     */
    public int getDepth(){
        int depth = 0;
        BinaryNode root = parent;
        while(root!=null){
            root = root.parent;
            depth++;
        }
        return depth;
    }
}
