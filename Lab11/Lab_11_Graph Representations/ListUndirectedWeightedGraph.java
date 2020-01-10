import java.util.*;
/**
 * Write a description of class ListUndirectedWeightedGraph here.
 *
 * @author Sena Yevenyo
 * @version November 18, 2019
 */
public class ListUndirectedWeightedGraph extends UndirectedWeightedGraph
{
    private ArrayList<String> stringNodes;
    private ArrayList<NamedEdge> namedEdgeList;
    private ArrayList<NumberedEdge> numEdgeList;
    private ArrayList<ArrayList<NumberedEdge>> adjacencyList;
    /**
     * Constructor for objects of class ListUndirectedWeightedGraph
     */
    public ListUndirectedWeightedGraph()
    {
        stringNodes = new ArrayList<String>();
        namedEdgeList = new ArrayList<NamedEdge>();
        numEdgeList = new ArrayList<NumberedEdge>();
        adjacencyList  = new ArrayList<ArrayList<NumberedEdge>>();
    }

    /**
     * Adds a new node to a graph
     * @param name - new name to be added to graph
     * @return number of nodes in the graph
     */
    public int addNode(String name){
        if(!stringNodes.contains(name)){
            stringNodes.add(name);
            adjacencyList.add(new ArrayList<NumberedEdge>());
            return stringNodes.size();
        }
        return -1;
    }
    
    /**
     * Adds an edge between two vertices in a graph
     * @param name1 - one Vertex of new edge
     * @param name2 - another Vertex of new edge
     * @param weight - weight of new edge
     * @return true if both vertices exist and no such edge exist
     */
    public boolean addEdge(String name1, String name2, float weight){
        if(!stringNodes.contains(name1) || !stringNodes.contains(name2)){
            return false;
        }
        int nodeName1 = stringNodes.indexOf(name1);
        int nodeName2 = stringNodes.indexOf(name2);
        return addEdge(nodeName1, nodeName2, weight);
    }
    
    /**
     * Adds an edge between two nodes in a graph
     * @param node1 - one Node of new edge
     * @param node2 - another Node of new edge
     * @param weight - weight of new edge
     * @return true if both nodes exist and no such edge exist
     * 
     */
    public boolean addEdge(int node1, int node2, float weight){
        int nodeFirst = node1;
        int nodeLast = node2;
        if(node1 == node2) return false;
        else if(node1>node2){
            nodeFirst = node2;
            nodeLast = node1;
        }
        
        for(int i=0;i<numEdgeList.size();i++){
            NumberedEdge edge = numEdgeList.get(i);
            if(edge.getNode1()== nodeFirst){
                if(edge.getNode2() == nodeLast){
                    return false;
                }
            }
        }
        
        NumberedEdge newEdge = new NumberedEdge(nodeFirst, nodeLast, weight);
        NamedEdge newNamedEdge = new NamedEdge(stringNodes.get(nodeFirst), stringNodes.get(nodeLast), weight);
        numEdgeList.add(newEdge);
        namedEdgeList.add(newNamedEdge);
        adjacencyList.get(nodeFirst).add(newEdge);
        adjacencyList.get(nodeLast).add(newEdge);
        return true;
    }
    
    /**
     * Updates the edge weight between two nodes in a graph
     * @param node1 - one Node of new edge
     * @param node2 - another Node of new edge
     * @param weight - weight of new edge
     * @return true if both vertices exist and such edge exist 
     */
    public boolean updateWeight(int node1, int node2, float weight){
        int nodeFirst = node1;
        int nodeLast = node2;
        if(node1 == node2) return false;
        else if(node1>node2){
            nodeFirst = node2;
            nodeLast = node1;
        }
        
        for(int i=0;i<numEdgeList.size();i++){
            NumberedEdge edge = numEdgeList.get(i);
            NamedEdge namedEdge = namedEdgeList.get(i);
            if(edge.getNode1()== nodeFirst){
                if(edge.getNode2() == nodeLast){
                    edge.setWeight(weight);
                    namedEdge.setWeight(weight);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Updates the edge weight between two vertices in a graph
     * @param name1 - one Vertex of new edge
     * @param name2 - another Vertex of new edge
     * @param weight - weight of new edge
     * @return true if both nodes exist and such edge exist 
     */
    public boolean updateWeight(String name1, String name2, float weight){
        if(!stringNodes.contains(name1) || !stringNodes.contains(name2)){
            return false;
        }
        int nodeName1 = stringNodes.indexOf(name1);
        int nodeName2 = stringNodes.indexOf(name2);
        return updateWeight(nodeName1, nodeName2, weight);
    }
    
    /**
     * Returns the list of String vertices in a graph
     * @return String [] list containing all vertices in graph in ascending order of how they were added
     */
    public String [] getNodeNames(){
        return stringNodes.toArray(new String [stringNodes.size()]);
    }
    
    /**
     * Returns the list of String vertices one jump from a specific vertex
     * @param name - String vertex whose neighbors are to be found
     * @return String [] list containing all nodes in graph of one jump from a specific vertex
     */
    public String [] getNeighbourNames(String name){
        int index = stringNodes.indexOf(name);
        int [] initOutput = getNeighbourNums(index);
        String [] output = new String[initOutput.length];
        for(int i=0;i<output.length;i++){
            output[i] = stringNodes.get(initOutput[i]);
        }
        return output;
    }
    
    /**
     * Returns the list of Integer nodes one jump from a specific node
     * @param node - Integer node whose neighbors are to be found
     * @return int [] list containing all nodes in graph of one jump from a specific node
     */
    public int[] getNeighbourNums(int node){
        ArrayList<Integer> intNeighbours = new ArrayList<Integer>();
        ArrayList<NumberedEdge> edges = adjacencyList.get(node);
        int [] output = new int[edges.size()];
        for(int i=0;i<edges.size();i++){
            NumberedEdge currentEdge = edges.get(i);
            if(currentEdge.getNode1()==node){
                intNeighbours.add(currentEdge.getNode2());
            }else if(currentEdge.getNode2()== node){
                intNeighbours.add(currentEdge.getNode1());
            }
        }
        
        for(int i=0;i<output.length;i++){
            output[i] = intNeighbours.get(i);
        }
        return output;
    }
    
    /**
     * Returns the list of all edges in a graph in a 'one Vertex, another Vertex' form
     * @return NamedEdge [] list containing all edges in a graph
     */
    public NamedEdge[] getEdgeNames(){
        return namedEdgeList.toArray(new NamedEdge[namedEdgeList.size()]);
    }
    
    /**
     * Returns the list of all edges in a graph in a adjacent matrix form
     * @return NamedEdge [] list containing all edges in a graph
     */
    public NumberedEdge[] getEdgeNumbers(){
        return  numEdgeList.toArray(new NumberedEdge[numEdgeList.size()]);
    }
    
    /**
     * Removes all edges and nodes from a graph
     */
    public void empty(){
        stringNodes.clear();
        namedEdgeList.clear();
        numEdgeList.clear();
        adjacencyList.clear();
    }
    
    /**
     * Returns true if a graph is connected using a depth first search
     * @return Returns true if a graph is connected using a depth first search
     */
    public boolean isConnected(){
        int startNode = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(startNode);
        ArrayList<Integer> visitedSet = new ArrayList<Integer>();
        while(!stack.empty()){
            int currentV = stack.pop();
            if(!visitedSet.contains(currentV)){
                visitedSet.add(currentV);
                int [] neighbours = this.getNeighbourNums(currentV);
                for(int i=0;i<neighbours.length;i++){
                    int toBeAdded = neighbours[i];
                    stack.push(toBeAdded);
                }
            }
        }
        return visitedSet.size() == stringNodes.size();
    }
    
    /**
     * Returns true if the parameter sent into the function is a connected tree
     * Strips down the nodes and edges of the input tree and the minimum spanning
     * tree of the input graph is stored in the input.
     * DOes not strip down tree if it is not connected
     * @return Returns true if a graph is connected
     */
    public boolean kruskal(ListUndirectedWeightedGraph minTree){
        boolean output = minTree.isConnected();
        if(!output){
            return output;
        }
        
        NumberedEdge[] numEdges = minTree.getEdgeNumbers();
        String [] nodes = minTree.getNodeNames();
        Queue<NumberedEdge> edgeQueue = new PriorityQueue<NumberedEdge>();
        Queue<NumberedEdge> resultEdgeQueue = new PriorityQueue<NumberedEdge>();
        HashMap<Integer,HashSet<Integer>> vertexSet= new HashMap<Integer,HashSet<Integer>>(nodes.length);
        ListUndirectedWeightedGraph answer = new ListUndirectedWeightedGraph();
        minTree.empty();
        for(int i=0;i<numEdges.length;i++){
            edgeQueue.add(numEdges[i]);
        }
        
        for(int i=0;i<nodes.length;i++){
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(i);
            vertexSet.put(i,set);
        }
        
        while(vertexSet.get(0).size()!=nodes.length && edgeQueue.peek()!=null){
            NumberedEdge currentE = edgeQueue.poll();
            int lowVertexIndex = currentE.getNode1();
            int highVertexIndex = currentE.getNode2();
            HashSet<Integer> vertex1Set = vertexSet.get(lowVertexIndex);
            HashSet<Integer> vertex2Set = vertexSet.get(highVertexIndex);
            if(!vertex1Set.equals(vertex2Set)){
                Iterator it = vertex2Set.iterator();
                resultEdgeQueue.add(currentE);
                while(it.hasNext()){
                    vertex1Set.add((Integer) it.next());
                }
                vertexSet.put(highVertexIndex, vertex1Set);
            }
        }
        
        for(int i=0;i<nodes.length;i++){
            minTree.addNode(nodes[i]);
        }
        
        while(resultEdgeQueue.peek()!=null){
            NumberedEdge currentEdge = resultEdgeQueue.poll();
            minTree.addEdge(nodes[currentEdge.getNode1()], nodes[currentEdge.getNode2()], currentEdge.getWeight());
        }
        return output;
    }
}
