
/**
 * Abstract class that implements the Tree interface
 *
 * @author Sena Yevenyo
 * @version October 21, 2019
 */
public abstract class BinaryTree<E extends Comparable<E>> implements Tree<E>
{
    // instance variables - replace the example below with your own
    protected BinaryNode treeRoot = null;
    protected int treeHeight;
    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree()
    {
        // initialise instance variables
    }

    /**
     * Removes all the objects in a tree
     *
     *
     */
    public void empty(){
        treeRoot = null;
    }
    
    /**
     * Returns true if there are no objects in the object class implementing Tree
     *
     * @return boolean value determining if a tree implementing class object is empty or not
     */
    public boolean isEmpty(){
        return treeRoot == null;
    }
    
     /**
     * Returns height of the tree
     *
     * @return height of the tree;
     */
    public int getHeight(){
        if(treeRoot==null) return 0;
        return treeRoot.getHeight();
    }
    
    /**
     * Returns the number of objects at a certain depth
     *
     * @param depth number
     * @return number of objects at the input depth
     */
    public int numOfElementsDepth(int i){
        if(treeRoot==null) return 0;
        return numOfElementsDepthRecursive(treeRoot,i,treeRoot.getHeight()); 
    }
    
    /**
     * Returns the number of objects at a certain depth
     *
     * @param depth number
     * @return number of objects at the input depth
     */
    private int numOfElementsDepthRecursive(BinaryNode node, int i, int treeHeight){
        int output = 0;
        if(node==null) return 0;
        
        if(node.getDepth()<i){
            output+=numOfElementsDepthRecursive(node.L,i, treeHeight);
            output+=numOfElementsDepthRecursive(node.R,i, treeHeight);
        }
        else if(node.getDepth()==i) output++;
        return output;
    }
    
    /**
     * Returns the largest object in the class implementing Tree
     *
     * @return the largest object in the class implementing Tree
     */
    public E findMax(){
        BinaryNode rightNode = treeRoot;
        while(rightNode.R!=null) rightNode = rightNode.R;
        return (E) rightNode.getValue();
    }
    
    /**
     * Returns the largest object in the class implementing Tree
     *
     * @return the largest object in the class implementing Tree
     */
    public E findMin(){
        BinaryNode leftNode = treeRoot;
        while(leftNode.L!=null) leftNode = leftNode.L;
        return (E) leftNode.getValue();
    }
    
    /**
     * Returns a String representation using the in-order transversal
     *
     * @return the String representation of the in-order transversal the class object implementing Tree
     */
    public String inOrderString(){
        if(inOrderStringRecursive(treeRoot)==null) return "[]";
        return "["+inOrderStringRecursive(treeRoot)+"]";
    }
    
    /**
     * Returns a String representation using the in-order transversal in recursive form
     *
     * @return the String representation of the in-order transversal the class object implementing Tree
     */
    private String inOrderStringRecursive(BinaryNode node){
        if(node == null) return null;
        String output = inOrderStringRecursive(node.L);
        if(output==null){
            output = node.toString();
        }else output = output + ", " + node.toString();
        if(inOrderStringRecursive(node.R) == null){
            if(node.getValue()==this.findMax()) return output;
        }else output = output +", "+inOrderStringRecursive(node.R);
        return output;
    } 
    
    /**
     * Returns a String representation using the post-order transversal
     *
     * @return the String representation of the post-order transversal the class object implementing Tree
     */
    public String postOrderString(){
        if(postOrderStringRecursive(treeRoot)==null) return "[]";
        return "["+postOrderStringRecursive(treeRoot)+"]";
    }
    
    /**
     * Returns a String representation using the post-order transversal in recursive form
     *
     * @return the String representation of the post-order transversal the class object implementing Tree
     */
    private String postOrderStringRecursive(BinaryNode node){
        if(node == null) return null;
        String output = postOrderStringRecursive(node.L);
        if(output==null){
            output = postOrderStringRecursive(node.R);
        }else if(postOrderStringRecursive(node.R)!=null) output = output+", "+postOrderStringRecursive(node.R);
        if(output==null) return node.toString();
        return output+", "+node.toString();
    } 
    
    /**
     * Returns a String representation using the pre-order transversal
     *
     * @return the String representation of the pre-order transversal the class object implementing Tree
     */
    public String preOrderString(){
        return "["+preOrderStringRecursive(treeRoot)+"]";
    }
    
    private String preOrderStringRecursive(BinaryNode node){
        if(node == null) return "";
        String output = node.toString();
        if(preOrderStringRecursive(node.L).length()>0)output=output+", "+preOrderStringRecursive(node.L);
        if(preOrderStringRecursive(node.R).length()>0)output=output+", "+preOrderStringRecursive(node.R);
        return output;
    }
}
