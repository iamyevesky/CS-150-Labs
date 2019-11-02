
/**
 * Provides interaction methods for Binary Tree implementations.
 *
 * @author Sena Yevenyo
 * @version October 21, 2019
 */
public interface Tree<E extends Comparable<E>>
{
    /**
     * Inserts an object into the class implementing Tree
     *
     * @param object inserted into class implementing Tree
     */
    boolean insert(E e);
    
    /**
     * Returns true if an object is present in class implenting Tree
     *
     * @param object to be searched  
     * @return boolean value determining if an object is present or not
     */
    boolean contains (E e);
    
    /**
     * Returns the number of objects at a certain depth
     *
     * @param depth number
     * @return number of objects at the input depth
     */
    int numOfElementsDepth(int i);
    
    /**
     * Returns the largest object in the class implementing Tree
     *
     * @return the largest object in the class implementing Tree
     */
    E findMax();
    
    /**
     * Returns the largest object in the class implementing Tree
     *
     * @return the largest object in the class implementing Tree
     */
    E findMin();
    
    /**
     * Returns a String representation using the pre-order transversal
     *
     * @return the String representation of the pre-order transversal the class object implementing Tree
     */
    String preOrderString();
    
    /**
     * Returns a String representation using the post-order transversal
     *
     * @return the String representation of the post-order transversal the class object implementing Tree
     */
    String postOrderString();
    
    /**
     * Returns a String representation using the in-order transversal
     *
     * @return the String representation of the in-order transversal the class object implementing Tree
     */
    String inOrderString();
    
     /**
     * Removes all the objects in a tree
     *
     *
     */
    void empty();
    
    /**
     * Returns true if there are no objects in the object class implementing Tree
     *
     * @return boolean value determining if a tree implementing class object is empty or not
     */
    boolean isEmpty();
    
}
