
/**
 * Represents a node in a LinkedList
 *
 * @author Sena Yevenyo
 * @version September 23, 2019
 */
public class Node<V>{
    private int nodeKey;
    private V nodeValue;
    private Node next;
    
    public Node(int k, V v){
        nodeKey = k;
        nodeValue = v;
        next = null;
    }
    
    public Node(V v){
        nodeKey = -1;
        nodeValue = v;
        next = null;
    }
    
    public int getKey(){
        return nodeKey;
    }
    
    public void setKey(int k){
        nodeKey = k;
    }
    
    public V getValue(){
        return nodeValue;
    }
    
    public void setValue(V value){
        nodeValue = value;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setNext(Node node){
        next = node;
    }
    
    public String toString(){
        return "("+nodeKey+", "+nodeValue+")";
    }
}