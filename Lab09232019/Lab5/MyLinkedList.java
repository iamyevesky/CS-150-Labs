import java.util.*;
/**
 * Creates a singly linked list object when instantiated 
 *
 * @author Sena Yevenyo
 * @version September 23, 2019
 */
public class MyLinkedList<V> implements Iterable
{
    // instance variables
    private Node head;
    private Node tail;
    private int length;
    /**
     * Constructor for objects of class MyLinkedList
     */
    public MyLinkedList()
    {
        // initialise instance variables
        head = null;
        tail = null;
        length = 0;
    }
    
    private void setHead(Node node){
        if(head==null){
            head = node;
            tail = node;
        }else{
            node.setNext(head);
            head = node;
        }
    }
    
    private void setTail(Node node){
        if(head==null){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
    }
    
    private void append(Node node){
        setTail(node);
        resetKeys(tail, length);
        length++;
    }
    
    private void prefix(Node node){
        setHead(node);
        resetKeys(head,0);
        length++;
    }
    
    public int size(){
        return length;
    }
    
    public String toString(){
        if(head==null) return"[]";
        return "["+printList(head)+"]";
    }
    
    private String printList(Node node){
        if(node.getNext()==null) return ""+node.getValue();
        return ""+node.getValue()+", "+ printList(node.getNext());
    }
    
    public MyLinkedListIterator<V> iterator(){
        return new MyLinkedListIterator<V>(this,head);
    }
    
    /**
     * Adds a value to the front of the list
     *
     * @param value parameter to be added to front
     */
    public void addFirst(V value){
        prefix(new Node(value));
    }
    
    /**
     * Obtains a value at a given index
     *
     * @param key index to be obtained
     */
    public V get(int key){
        return getValue(head,key);
    }
    
    private V getValue(Node node, int key){
        if(node==null) return null;
        else if(node.getKey() == key) return  (V) node.getValue();
        else if(node.getNext()==null) return null;
        return getValue(node.getNext(), key);
    }
    
    /**
     * Adds a value to the end of the list
     *
     * @param value parameter to be added to front
     */
    public void addEnd(V value){
        append(new Node(value));
    }
    
    /**
     * Removes a value at a given index
     *
     * @param key index to be removed
     */
    public V remove(int key){
        return removeKey(head, key);
    }
    
    private V removeKey(Node node, int key){
        if(node.getKey()==key){
            head = head.getNext();
            V value = (V) node.getValue();
            node.setNext(null);
            node = null;
            if(head!=null)resetKeys(head,0);
            length--;
            return value;
        }
        else if(node.getNext().getKey()== key){
            Node temp = node.getNext();
            V value = (V) temp.getValue();
            node.setNext(temp.getNext());
            length--;
            if(temp==tail) {
                tail = node;
                resetKeys(node,length-1);
            }
            else{
                resetKeys(node,node.getKey());
            }
            temp.setNext(null);
            temp = null;
            return value;
        }
        else if(node.getNext()==null) return null;
        return removeKey(node.getNext(), key);
    }
    
    private void resetKeys(Node node, int key){
        node.setKey(key);
        if(node.getNext()!=null){
            resetKeys(node.getNext(), key+1);
        }
    }
    
}
