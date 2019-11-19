
/**
 * Abstract class TernarySearchTree - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class TernarySearchTree<E extends Comparable<E>> implements TernaryTree<E>
{
    // instance variables - replace the example below with your own
    protected BinaryNode treeRoot = null;  
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
    
    public void insert(E val){
        if(treeRoot==null){
            treeRoot = new BinaryNode(val);
        }
        else insertRecursive(val, treeRoot);
    }
    
    private void insertRecursive(E value, BinaryNode node){
        if(value.compareTo((E)node.getValue())<0){
            if(node.L==null) {
                node.L = new BinaryNode(value);
                node.L.parent = node;
            }
            else insertRecursive(value, node.L);
        }
        else if(value.compareTo((E)node.getValue())>0){
            if(node.R==null) {
                node.R = new BinaryNode(value);
                node.R.parent = node;
            }
            else insertRecursive(value,node.R);
        }
        else {
            if(node.M==null) {
                node.M = new BinaryNode(value);
                node.M.parent = node;
            }
            else insertRecursive(value,node.M);
        }
    }
    
    public BinaryNode getRoot(){
        return treeRoot;
    }
    
    public void setRoot(BinaryNode node){
        treeRoot = node;
    }
}
