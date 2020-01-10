import java.util.*;
/**
 * Represents a node or location within the road network of a city or town.
 * 
 * @author Sena Yevenyo
 * @version November 27,2019
 */
public class Node implements Comparable<Node>
{
    // instance variables - replace the example below with your own
    private Set<Passenger> passengerList;
    private Set<Driver> driverList;
    private ArrayList<Integer> neighbours;
    private int id;
    private int branches;
    private int timeDiff;
    private Node prevNode;
    /**
     * Constructor for objects of class Node
     * @param int id - Unique ID for the node
     */
    public Node(int id)
    {
        neighbours = new ArrayList<Integer>();
        this.id = id;
        timeDiff = Integer.MAX_VALUE;
        prevNode = null;
    }

    /**
     * Returns unique ID of the node
     *
     * @return the ID of the node
     */
    public int getID()
    {
        // put your code here
        return id;
    }
    
    /**
     * Adds an adjacent node to a node
     *
     * @param Node adjNode - adjacent node to be added
     */
    public void addNeighbour(Node adjNode){
        neighbours.add(adjNode.getID());
    }
    
    /**
     * Removes an adjacent node to a node
     *
     * @param Node adjNode - adjacent node to be removed
     */
    public void removeNeighbour(Node adjNode){
        neighbours.remove(adjNode.getID());
    }
    
    /**
     * Returns an Integer array of IDs of adjacent nodes of a Node object
     *
     * @return an Integer array of IDs of adjacent nodes of a Node object
     */
    public Integer [] getNeighbours(){
        Integer [] array = new Integer[neighbours.size()];
        return neighbours.toArray(new Integer[0]);
    }
    
    /**
     * Returns the branching factor of a node
     *
     * @return the branching factor of a node
     */
    public int getBranching(){
        return branches;
    }
    
    /**
     * Increases the branching factor of a node
     *
     */
    public void increaseBranching(){
        branches++;
    }
    
    /**
     * Decreases the branching factor of a node
     *
     */
    public void decreaseBranching(){
        branches--;
    }
    
    /**
     * Returns the time difference between node object and source node
     * 
     * @return time difference to traverse between source node and this node
     */
    public int getTimeDiff(){
        return timeDiff;
    }
    
    /**
     * Sets the time difference between node object and source node
     * 
     * @param new time difference to traverse between source node and this node
     */
    public void setTimeDiff(int timeDiff){
        this.timeDiff = timeDiff; 
    }
    
    /**
     * Sets the previous node of a node object
     * 
     * @param  Node node - new previous node of node object
     */
    public void setPrevNode(Node node){
        prevNode = node;
    }
    
    /**
     * Returns the previous node of a node object
     * 
     * @return the previous node of a node object
     */
    public Node getPrevNode(){
        return prevNode;
    }
    
    public int compareTo(Node that){
        if(this.getTimeDiff()>that.getTimeDiff()) return 1;
        else if(this.getTimeDiff()<that.getTimeDiff()) return -1;
        return 0;
    }
}
