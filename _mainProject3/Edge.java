
/**
 * A class that represents an edge connection in a graph.
 * 
 * NOTICE: Edge class is not intended to be part of program. This was started so I could explore if Kruskal would be a better implementation
 * in case my computer could not run the initial program. THat is why no tests are node on this class. 
 *
 * @author Sena Yevenyo
 * @version November 28, 2019
 */
public class Edge
{
    // instance variables - replace the example below with your own
    private int weight;
    private Node nodeA;
    private Node nodeB;
    /**
     * Constructor for objects of class Edge
     * @param Node first - one node of the edge connection
     * @param Node second - the other node of the edge connection
     * @param int weight - the weight of the edge connection
     */
    public Edge(Node first, Node second, int weight)
    {
        nodeA = null;
        nodeB = null;
        this.weight = Integer.MIN_VALUE;
        if(first.getID()>second.getID()){
            nodeA = first;
            nodeB = second;
            this.weight = weight;
        }
        else if(first.getID()<second.getID()){
            nodeB = first;
            nodeA = second;
            this.weight = weight;
        }
    }

    /**
     * Returns the 'first' node of the edge connection: Node with the lowest index of the edge connection
     * Edges are undirected, thus there is no 'from' or 'to' connection.
     * @return node object with the lowest index of the edge connection
     */
    public Node getFirstNode()
    {
        return nodeA;
    }
    
    /**
     * Returns the 'second' node of the edge connection: Node with the highest index value of the edge connection
     * Edges are undirected, thus there is no 'from' or 'to' connection.
     * @return node object with the highest index value of the edge connection
     */
    public Node getSecondNode()
    {
        return nodeB;
    }
    
    /**
     * Returns the weight of the edge connection
     * @return the weight of the edge connection
     */
    public int getWeight()
    {
        return weight;
    }
    
}
