import java.util.*;
/**
 * A String container class which implements MyLinkedList data structure.
 *
 * @author Sena Yevenyo
 * @version September 28, 2019
 */
public class MyListStringContainer
{
    // instance variables - replace the example below with your own
    private MyLinkedList<String> container = new MyLinkedList<String>();
    
    /**
     * Adds String to the front of the container
     *
     * @param  val parameter to be added to front
     */
    public void addToFront(String val)
    {
        container.addFirst(val);
    }
    
    /**
     * Adds String to the back of the container
     *
     * @param  val parameter to be added to back
     */
    public void addToBack(String val)
    {
        container.addEnd(val);
    }
    
    /**
     * Searches for a String or a String containing a substring of the parameter without using iterator
     *
     * @param  val parameter to be searched
     */
    public int linearSearch(String val){
        boolean contains = false;
        for(int i =0;i<container.size();i++){
            contains = container.get(i).contains(val);
            if (contains) return i;
        }
        return -1;
    }
    
    
     /**
     * Searches for a String or a String containing a substring of the parameter using iterator
     *
     * @param  val parameter to be searched
     */
    public int linearSearchIterator(String val){
        boolean contains = false;
        Iterator iterator = container.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            String curString = (String) iterator.next();
            contains = curString.contains(val);
            if (contains) return counter;
            counter++;
        }
        return -1;
    }
    
    public String toString(){
        return container.toString();
    }
    
    public int size(){
        return container.size();
    }
    
    /**
     * Obtains a String at a given index
     *
     * @param key index to be obtained
     */
    public String get(int key){
        return container.get(key);
    }
}
