
/**
 * Write a description of class IntegerTernarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerTernarySearchTree<E extends Comparable<E>> extends TernarySearchTree<E> 
{   
    public TernaryTree<E> leftSubTree(){
        IntegerTernarySearchTree<E> subLeft = new IntegerTernarySearchTree<E>();
        subLeft.setRoot(treeRoot.L);
        return subLeft;
    }
    
    public TernaryTree<E> rightSubTree(){
        IntegerTernarySearchTree<E> subRight = new IntegerTernarySearchTree<E>();
        subRight.setRoot(treeRoot.R);
        return subRight;
    }
    
    public TernaryTree<E> midSubTree(){
        IntegerTernarySearchTree<E> subMid = new IntegerTernarySearchTree<E>();
        subMid.setRoot(treeRoot.M);
        return subMid;
    }
    
    public void insertMany(E val, int n){
        for(int i=0;i<n;i++){
            this.insert(val);
        }
    }
    
    public void removeDuplicates(E val){
        BinaryNode node = this.contains(val);
        if(node!=null){
            node.M = null;
        }
    }
    
    public BinaryNode contains(E value){
        return containsRecursive(value, treeRoot);
    }
    
    private BinaryNode containsRecursive(E value, BinaryNode node){
        if(node==null) return node;
        else if(value.compareTo((E)node.getValue())==0) return node;
        else if(value.compareTo((E)node.getValue())<0)return containsRecursive(value, node.L);
        else if(value.compareTo((E)node.getValue())>0)return containsRecursive(value, node.R);
        return null;
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
    
    public int total(){
        int total = 0;
        total = this.inOrderTraversal();
        if(total>=0){
            return total;
        }
        return 0;
    }
    
    public int inOrderTraversal(){
        return inOrderTraversalRecursive(treeRoot);
    }
    
    private int inOrderTraversalRecursive(BinaryNode node){
        if(node == null) return -1;
        int output = 0;
        if(inOrderTraversalRecursive(node.L)!=-1){
            output = output + (Integer) inOrderTraversalRecursive(node.L);
        }
        
        if(inOrderTraversalRecursive(node.M)!=-1){
            output = output + (Integer) inOrderTraversalRecursive(node.M);
        }
        
        if(inOrderTraversalRecursive(node.R)!=-1){
            output = output + (Integer) inOrderTraversalRecursive(node.R);
        }
        
        output = output + (Integer) node.getValue();
        
        return output;
    } 
}
