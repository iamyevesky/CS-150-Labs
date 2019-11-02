
/**
 * A binary search tree implementation
 *
 * @author Sena Yevenyo
 * @version October 27,2019
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements Tree<E>
{
    /**
     * Constructor for objects of class BinarySearchTree
     */
    public BinarySearchTree()
    {
        // initialise instance variables
        treeHeight = 0;
    }
    
    public BinarySearchTree(E value){
        treeRoot = new BinaryNode(value);
        treeRoot.parent = null;
        treeHeight = treeRoot.getHeight();
    }
    
    /**
     * Inserts an object into the class implementing Tree
     *
     * @param object inserted into class implementing Tree
     * @return Returns true if the object is inserted
     */
    public boolean insert(E value){
        if(treeRoot==null) {
            treeRoot = new BinaryNode(value);
            treeRoot.parent = null;
            treeHeight = treeRoot.getHeight();
            return treeRoot.getValue() == value;
        }
        else return insertRecursive(value, treeRoot);
    }
    
    private boolean insertRecursive(E value, BinaryNode node){
        if(value.compareTo((E)node.getValue())<0){
            if(node.L==null) {
                node.L = new BinaryNode(value);
                node.L.parent = node;
                treeHeight = treeRoot.getHeight();
                return node.L.getValue()==value && node.L.parent==node;
            }
            else return insertRecursive(value, node.L);
        }
        else if(value.compareTo((E)node.getValue())>0){
            if(node.R==null) {
                node.R = new BinaryNode(value);
                node.R.parent = node;
                treeHeight = treeRoot.getHeight();
                return node.R.getValue()==value && node.R.parent==node;
            }
            else return insertRecursive(value,node.R);
        }
        else return false;
    }
    
    /**
     * Returns true if an object is present in class implenting Tree
     *
     * @param object to be searched  
     * @return boolean value determining if an object is present or not
     */
    public boolean contains(E value){
        return containsRecursive(value, treeRoot);
    }
    
    private boolean containsRecursive(E value, BinaryNode node){
        if(node==null) return false;
        else if(value.compareTo((E)node.getValue())==0) return true;
        else if(value.compareTo((E)node.getValue())<0)return containsRecursive(value, node.L);
        else if(value.compareTo((E)node.getValue())>0)return containsRecursive(value, node.R);
        return false;
    }
}
