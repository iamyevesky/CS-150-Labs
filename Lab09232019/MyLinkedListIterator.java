import java.util.*;
/**
 * Implements the Iterator interface.
 *
 * @author Sena Yevenyo
 * @version September 23, 2019
 */
public class MyLinkedListIterator<V> implements Iterator{
    /**
     * Constructor for objects of class MyLinkedListIterator
     */
    Node index = null;
    Node prevIndex = null;
    MyLinkedList obj = null;
    public MyLinkedListIterator(MyLinkedList obj,Node node){
        index = node;
        this.obj = obj;
    }
    
    public V next(){
        if(index==null) return null;
        V data = (V) index.getValue();
        Node next = index.getNext();
        prevIndex = index;
        index = next;
        return data;
    }
    
    public boolean hasNext(){
       return index != null;
    }
    
    public void remove(){
       obj.remove(prevIndex.getKey());
    }
}
