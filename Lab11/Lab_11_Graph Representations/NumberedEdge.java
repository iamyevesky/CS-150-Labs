import java.util.*;
/**
 * Number representation of edges in a graph (Adjacent matrix implementation).
 *
 * @author Sena Yevenyo
 * @version November 18, 2019
 */
public class NumberedEdge implements Comparable<NumberedEdge>
{
    // instance variables - replace the example below with your own
    private int node1;
    private int node2;
    private float weight;
    /**
     * Constructor for objects of class NumberedEdge
     * @param node1 - Field name for node1
     * @param node2 - Field name for node2
     * @param weight - Field name for weight
     */
    public NumberedEdge(int node1, int node2, float weight)
    {
        // initialise instance variables
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
    
    /**
     * Sets the value of node1 of an edge
     * @param node - the new value for node1
     */
    public void setNode1(int node){
        node1 = node;
    }
    
    /**
     * Gets the value of node1 of an edge
     * @return the value for node1
     */
    public int getNode1(){
        return node1;
    }
    
    /**
     * Sets the value of node2 of an edge
     * @param node - the new value for node2
     */
    public void setNode2(int node){
        node2 = node;
    }
    
    /**
     * Gets the value of node2 of an edge
     * @return the value for node1
     */
    public int getNode2(){
        return node2;
    }
    
    /**
     * Sets the weight of an edge
     * @param value - the new weight for an edge
     */
    public void setWeight(float value){
        weight = value;
    }
    
    /**
     * Gets the weight of an edge
     * @return the weight for an edge
     */
    public float getWeight(){
        return weight;
    }
    
    public int compareTo(NumberedEdge that){
        if(this.getWeight()>that.getWeight()) return 1;
        else if(this.getWeight()<that.getWeight()) return -1;
        else return 0;
    }
}
