
/**
 * Abstract class UndirectedWeightedGraph - write a description of the class here
 *
 * @author Sena Yevenyo
 * @version November 18, 2019
 */
public abstract class UndirectedWeightedGraph
{
    /**
     * Adds a new node to a graph
     * @param name - new name to be added to graph
     * @return number of nodes in the graph
     */
    abstract int addNode(String name);
    
    /**
     * Adds an edge between two vertices in a graph
     * @param name1 - from Vertex of new edge
     * @param name2 - to Vertex of new edge
     * @param weight - weight of new edge
     * @return true if both vertices exist and no such edge exist
     */
    abstract boolean addEdge(String name1, String name2, float weight);
    
    /**
     * Adds an edge between two nodes in a graph
     * @param node1 - from Node of new edge
     * @param node2 - to Node of new edge
     * @param weight - weight of new edge
     * @return true if both nodes exist and no such edge exist
     * 
     */
    abstract boolean addEdge(int node1, int node2, float weight);
    
    /**
     * Updates the edge weight between two nodes in a graph
     * @param node1 - from Node of new edge
     * @param node2 - to Node of new edge
     * @param weight - weight of new edge
     * @return true if both vertices exist and such edge exist 
     */
    abstract boolean updateWeight(int node1, int node2, float weight);
    
    /**
     * Updates the edge weight between two vertices in a graph
     * @param name1 - from Vertex of new edge
     * @param name2 - to Vertex of new edge
     * @param weight - weight of new edge
     * @return true if both nodes exist and such edge exist 
     */
    abstract boolean updateWeight(String name1, String name2, float weight);
    
    /**
     * Returns the list of String vertices in a graph
     * @return String [] list containing all vertices in graph in ascending order of how they were added
     */
    abstract String [] getNodeNames();
    
    /**
     * Returns the list of String vertices one jump from a specific vertex
     * @param name - String vertex whose neighbors are to be found
     * @return String [] list containing all nodes in graph of one jump from a specific vertex
     */
    abstract String [] getNeighbourNames(String name);
    
    /**
     * Returns the list of Integer nodes one jump from a specific node
     * @param node - Integer node whose neighbors are to be found
     * @return String [] list containing all nodes in graph of one jump from a specific node
     */
    abstract int [] getNeighbourNums(int node);
    
    /**
     * Returns the list of all edges in a graph in a 'to Vertex from Vertex' form
     * @return NamedEdge [] list containing all edges in a graph
     */
    abstract NamedEdge[] getEdgeNames();
    
    /**
     * Returns the list of all edges in a graph in a adjacent matrix form
     * @return NamedEdge [] list containing all edges in a graph
     */
    abstract NumberedEdge[] getEdgeNumbers();
    
    /**
     * Removes all edges and nodes from a graph
     */
    abstract void empty();
    
    /**
     * Returns true if a graph is connected using a depth first search
     * @return Returns true if a graph is connected using a depth first search
     */
    abstract boolean isConnected();
    
    // /**
     // * Returns true if the parameter sent into the function is a connected tree
     // * Strips down the nodes and edges of the input tree and the minimum spanning
     // * tree of the input graph is stored in the input.
     // * @return Returns true if a graph is connected
     // */
    // boolean kruskal(ListUndirectedWeightedGraph minTree){
        // return false;
    // }
    
    // /**
     // * Returns true if the parameter sent into the function is a connected tree
     // * Strips down the nodes and edges of the input tree and the minimum spanning
     // * tree of the input graph is stored in the input.
     // * @return Returns true if a graph is connected
     // */
    // boolean kruskal(MatrixUndirectedWeightedGraph minTree){
        // return false;
    // }
}
