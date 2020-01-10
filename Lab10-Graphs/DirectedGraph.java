import java.util.*;
/**
 * Creates Graph objects.
 *
 * @author Sena Yevenyo
 * @version November 16, 2019
 */
public class DirectedGraph<K extends Comparable<K>>
{
    // instance variables - replace the example below with your own
    private ArrayList<DirectedGraph.DirectedGraphNode> nodes;
   
    /**
     * Constructor for objects of class DirectedGraph
     */
    public DirectedGraph()
    {
        nodes = new ArrayList<DirectedGraph.DirectedGraphNode>();
    }

    /**
     * Adds a value to the graph and prevents duplicates of the same value
     *
     * @param generic class K object k, object to be added
     * @return True if key was added
     */
    public boolean addNode(K k)
    {
        // put your code here
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getValue()==k){
                return false;
            }
        }
        nodes.add(new DirectedGraph.DirectedGraphNode(k));
        return true;
    }
    
    /**
     * Obtains the node of a key in the grap
     *
     * @param generic class K object k, object's node to be obtained
     * @return null if key not present
     */
    public DirectedGraph.DirectedGraphNode getNode(K key){
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getValue()==key){
                return nodes.get(i);
            }
        }
        return null;
    }
    
    /**
     * Adds an edge from one object in the graph to the other
     *
     * @param K k1,k2 objects to be connected 
     * @returns True if edge was added and both objects k1 and k2 are present in the graph
     */
    public boolean addEdge(K k1, K k2, int w)
    {
        DirectedGraph.DirectedGraphNode firstNode = null;
        DirectedGraph.DirectedGraphNode lastNode = null;
        if(!addNode(k1)&&!addNode(k2)){
            firstNode = getNode(k1);
            lastNode = getNode(k2);
            firstNode.addEdge(lastNode, w);
            return true;
        }
        return false;
    }
    
    /**
     * Returns the neighbours of input object K in the graph
     *
     * @param K k, object whose neighbours are to be found in the graph 
     * @returns objects in the graph which can be reached in one jump from object K
     */
    public ArrayList<K> getNeighbours(K k){
        ArrayList<K> output = null;
        DirectedGraph.DirectedGraphNode node = getNode(k);
        if(node!=null){
            output = new ArrayList<K>();
            for(int i=0;i<node.getEdges().size();i++){
                output.add((K)((DirectedGraph.DirectedGraphEdge) node.getEdges().get(i)).toVertex().getValue());
            }
        }
        return output;
    }
    
    /**
     * Prints ot all nodes reachable from k1 along with their distances
     * using Djikstra's algorithm
     *
     * @param K k, object whose neighbours are to be found in the graph 
     * @returns objects in the graph which can be reached in one jump from object K
     */
    public void dijkstra(K k1){
        DirectedGraph.DirectedGraphNode startV = getNode(k1);
        Queue<DirectedGraph.DirectedGraphNode> unvisitedVertex = new PriorityQueue<DirectedGraph.DirectedGraphNode>();
        if(startV == null) return;
        
        startV.setDistance(0);
        for(int i=0;i<nodes.size();i++){
            unvisitedVertex.add(nodes.get(i));
        }
        
        while(unvisitedVertex.peek()!=null){
            DirectedGraph.DirectedGraphNode currentV = unvisitedVertex.poll();
            ArrayList<DirectedGraph.DirectedGraphEdge> currentVEdges = currentV.getEdges();
            for(int i=0;i<currentVEdges.size();i++){
                DirectedGraph.DirectedGraphEdge currentVEdge = currentVEdges.get(i);
                DirectedGraph.DirectedGraphNode currentVNode = currentVEdge.toVertex();
                int alternativePathLength = currentV.getDistance()+currentVEdge.getWeight();
                if(alternativePathLength<currentVNode.getDistance()){
                    currentVNode.setDistance(alternativePathLength);
                }
            }
        }
    }
    
    public String toString(){
        Queue<DirectedGraph.DirectedGraphNode> unvisitedVertex = new PriorityQueue<DirectedGraph.DirectedGraphNode>();
        for(DirectedGraph.DirectedGraphNode node:nodes){
            unvisitedVertex.add(node);
        }
        String output = "";
        
        while(unvisitedVertex.peek()!=null){
            DirectedGraph.DirectedGraphNode currentNode = unvisitedVertex.poll();
            output = output+currentNode.getValue().toString()+" "+currentNode.getDistance()+" "; 
        }
        return output;
    }
    
    /**
     * Creates node objects for the DirectedGraph objects
     * 
     */
    public class DirectedGraphNode<K> implements Comparable<DirectedGraph.DirectedGraphNode>{
        /**
         * Constructor for the DirectedGraphNode class 
         */
        private K value;
        private ArrayList<DirectedGraph.DirectedGraphEdge> edges;
        private int distance;
        private DirectedGraph.DirectedGraphNode prevNode;
        public DirectedGraphNode(K value){
            this.value = value;
            edges = new ArrayList<DirectedGraph.DirectedGraphEdge>();
            distance = Integer.MAX_VALUE;
            prevNode = null;
        }
        
        public ArrayList<DirectedGraph.DirectedGraphEdge> getEdges(){
            return edges;
        }
        
        public DirectedGraph.DirectedGraphNode closest(){
            int lowestDistance = Integer.MAX_VALUE;
            DirectedGraph.DirectedGraphEdge output = null;
            for(int i =0; i<edges.size();i++){
                if(edges.get(i).getWeight()<lowestDistance){
                    output = edges.get(i);
                    lowestDistance = edges.get(i).getWeight();
                }
            }
            
            if(output==null) return null;
            return output.toVertex();
        }
        
        public void addEdge(DirectedGraph.DirectedGraphNode node, int weight){
            DirectedGraph.DirectedGraphEdge edge = getEdge(node);
            if(edge != null){
                edge.setWeight(weight);
            }
            else{
                edges.add(new DirectedGraph.DirectedGraphEdge(this, node, weight));
            }
        }
        
        public DirectedGraph.DirectedGraphEdge getEdge(DirectedGraph.DirectedGraphNode node){
            for(int i=0;i<edges.size();i++){
                if(edges.get(i).toVertex() == node){
                    return edges.get(i);
                }
            }
            return null;
        }
        
        public K getValue(){
            return value;
        }
        
        public int getDistance(){
            return distance;
        }
        
        public void setDistance(int value){
            distance = value;
        }
        
        public void setPrevNode(DirectedGraph.DirectedGraphNode node){
            prevNode = node;
        }
        
        public DirectedGraph.DirectedGraphNode getPrevNode(){
            return prevNode;
        }
        
        public int compareTo(DirectedGraph.DirectedGraphNode node){
            return this.getDistance() - node.getDistance();
        }
    }
    
    
    /**
     * Creates edge objects for the DirectedGraphNode objects
     * 
     */
    public class DirectedGraphEdge<K>{
        private int weight;
        private DirectedGraph.DirectedGraphNode startNode;
        private DirectedGraph.DirectedGraphNode endNode;
        
        public DirectedGraphEdge(DirectedGraph.DirectedGraphNode start, DirectedGraph.DirectedGraphNode end, int weight){
            startNode = start;
            endNode = end;
            this.weight = weight;
        }
        
        public int getWeight(){
            return weight;
        }
        
        public void setWeight(int value){
            weight = value;
        }
        
        public DirectedGraph.DirectedGraphNode toVertex(){
            return endNode;
        }
    }
}
