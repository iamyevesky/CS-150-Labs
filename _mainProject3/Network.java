import java.util.*;
/**
 * This class represents the road network in a town or city.
 * All node locations in this network are connected and have
 * an average branching of 5.
 * Nodes are not connected to each other in any specific order.
 * <p>
 * All edges in this graph are undirected.
 * The weight of edges between nodes represent the time in minutes taken to traverse
 * between the nodes. These times change randomly to represent changing
 * traffic conditions in real life with values distributed from 2 to 15.
 * <p>
 * The distance between nodes has a constant value of 1 unit(mile/km)
 * @author Sena Yevenyo
 * @version November 27, 2019
 */
public class Network
{
    private int [][] distanceMatrix;
    private ArrayList<Node> nodeList;
    private int numOfEdges;
    private int min;
    private int max;
    private int totalNumOfBranches;
    private Random random = new Random();
    /**
     * Constructor for objects of class Network
     * Creates a connected network with a specific connectivity factor
     * @param int size - number of node locations in the road network
     * @param int branching factor - average brancing of neach node of the graph. 
     * Lowest factor possible is 2.0. Highest is N(N-1) where N is number of nodes
     */
    public Network(int size, float factor, int min, int max)
    {
        nodeList = new ArrayList<Node>(size);
        for(int i=0;i<size;i++){
            nodeList.add(new Node(i));
        }
        distanceMatrix = new int[size][size];
        this.max = max;
        this.min = min;
        totalNumOfBranches = 0;
        this.createNetwork(size, min, max);
        this.createFactor(factor, min, max);
    }
    
    /**
     * Constructor for objects of class Network
     * Creates an unconnected network with a specific size
     * @param int size - number of node locations in the road network
     */
    public Network(int size){
        nodeList = new ArrayList<Node>();
        for(int i=0;i<size;i++){
            nodeList.add(new Node(i));
        }
        distanceMatrix = new int[size][size];
        totalNumOfBranches = 0;
    }
    
    private void createNetwork(int size, int min, int max){
        LinkedList toBeAdded = new LinkedList<Node>();
        ArrayList<Node> added = new ArrayList<Node>();
        for(int i=1;i<size;i++){
            toBeAdded.add(nodeList.get(i));
        }
        
        Node startV = nodeList.get(0);
        added.add(startV);
        while(toBeAdded.peek()!=null){
            Node node = (Node) toBeAdded.poll();
            int adjNodeIndex = random.nextInt(added.size());
            Node adjNode = added.get(adjNodeIndex);
            createEdge(node, adjNode, random.nextInt(max-min)+min);
            added.add(node);
        }
    }
    
    private boolean createEdge(Node first, Node second, int weight){
        if(first.getID() == second.getID()) return false;
        else if(distanceMatrix[first.getID()][second.getID()]>0) return false;
        distanceMatrix[first.getID()][second.getID()] = weight;
        distanceMatrix[second.getID()][first.getID()] = weight;
        ++numOfEdges;
        first.increaseBranching();
        first.addNeighbour(second);
        second.increaseBranching();
        second.addNeighbour(first);
        totalNumOfBranches = totalNumOfBranches+2;
        return true;
    }
    
    private boolean updateEdge(Node first, Node second, int weight){
        if(first.getID() == second.getID()) return false;
        else if(distanceMatrix[first.getID()][second.getID()]==0) return false;
        distanceMatrix[first.getID()][second.getID()] = weight;
        distanceMatrix[second.getID()][first.getID()] = weight;
        return true;
    }
    
    private boolean checkPossibility(float factor){
        int possibleTotalBranching = totalNumOfBranches+2;
        if(possibleTotalBranching>nodeList.size()*factor) return false;
        return true;
    }
    
    private void createFactor(float factor, int min, int max){
        while(checkPossibility(factor)){
            Node node1 = nodeList.get(random.nextInt(nodeList.size()));
            Node node2 = nodeList.get(random.nextInt(nodeList.size()));
            this.createEdge(node1, node2, random.nextInt(max-min)+min);
        }
    }
    
    private void clearTimeDiff(){
        for(int i=0;i<nodeList.size();i++){
            nodeList.get(i).setTimeDiff(Integer.MAX_VALUE);
            nodeList.get(i).setPrevNode(null);
        }
    }
    
    /**
     * Creates an edge between two nodes in the graph
     * 
     * @param int firstNodeIndex - index of one node of the edge
     * @param int secondNodeIndex - index of the other node of the edge
     * @param int weight - weight of edge created
     */
    public boolean createEdge(int firstNodeIndex, int secondNodeIndex, int weight){
        return createEdge(nodeList.get(firstNodeIndex), nodeList.get(secondNodeIndex), weight);
    }
    
    /**
     * Returns the size of the graph
     * 
     * @return the size of the road network locations 
     */
    public int getSize(){
        return nodeList.size();
    }
    
    public Node getNode(int index){
        return nodeList.get(index);
    }
    
    /**
     * Returns the number of edges in a graph
     * 
     * @return the number of edges in a graph 
     */
    public int getEdgeNum(){
        return numOfEdges;
    }
    
    /**
     * Returns the sum of the branching of all nodes in the graph
     * 
     * @return the sum of the branching of all nodes in the graph
     */
    public int getTotalBranching(){
        return totalNumOfBranches;
    }
    
    /**
     * Updates the edge weight between two nodes in the graph
     * 
     * @param int firstNodeIndex - index of one node of the edge
     * @param int secondNodeIndex - index of the other node of the edge
     * @param int weight - new weight of edge 
     */
    public boolean updateEdge(int firstNodeIndex, int secondNodeIndex, int weight){
        return updateEdge(nodeList.get(firstNodeIndex), nodeList.get(secondNodeIndex), weight);
    }
    
    /**
     * Calculates the connectivity factor of the graph
     * 
     * @returns the connectivity factor of a graph
     */
    public float calculateConnectivity(){
        float output = (float) -1.0;
        output = (float) totalNumOfBranches/(float)(nodeList.size()*(nodeList.size()-1));
        return output;
    }
    
    /**
     * Returns the neighbours of each node in the road network
     * 
     * @param int id - Unique index of a node in the graph
     * @returns an Node array containing the neighbours of a specific node in a network
     */
    public Node[] getNeighbours(int id){
        Node [] output = new Node[nodeList.get(id).getBranching()];
        Node node = nodeList.get(id);
        Integer [] neighbours = node.getNeighbours();
        int index = 0;
        for(int i=0;i<neighbours.length;i++){
            if(distanceMatrix[id][neighbours[i]]>0){
                output[index] = nodeList.get(neighbours[i]);
                index++;
            }
        }
        return output;
    }
    
    /**
     * Returns mean time taken to travel between non adjacent cells of a specific node in the graph
     * 
     * @param int id - Unique index of a node in the graph
     * @returns mean time taken to travel between non adjacent cells of a specific node in the graph
     */
    public float getMeanTimeTraversal(int id){
        float output = (float) -1.0;
        ArrayList<Integer> timeList = new ArrayList<Integer>();
        Node [] neighbours = getNeighbours(id);
        ArrayList<Node> doNotVisit = new ArrayList<Node>();
        
        doNotVisit.add(nodeList.get(id));
        for(int i=0;i<neighbours.length;i++){
            doNotVisit.add(neighbours[i]);
        }
        
        for(int i = 0; i<neighbours.length; i++){
            Node [] nonAdjneighbours = getNeighbours(neighbours[i].getID());
            for(int j=0;j<nonAdjneighbours.length;j++){
                int time = getTimeTraversal(id, neighbours[i].getID()) + getTimeTraversal(neighbours[i].getID(), nonAdjneighbours[j].getID());
                if(!doNotVisit.contains(nonAdjneighbours[j])){
                    timeList.add(time);
                }
            }
        }
        
        int sum = 0;
        for(int i=0;i<timeList.size();i++){
            sum += timeList.get(i);
        }
        output = (float) sum/ (float) timeList.size();
        return output;
    }
    
    /**
     * Returns the average mean time taken to travel between non adjacent cells in the graph
     * 
     * @returns the average mean time taken to travel between non adjacent cells in the graph
     */
    public float getAvgMeanTimeTraversal(){
        float sum = 0;
        for(int i=0;i<nodeList.size();i++){
            sum+=getMeanTimeTraversal(nodeList.get(i).getID());
        }
        return sum/(float)nodeList.size();
    }
    
    /**
     * Returns the time taken to travel between adjacent cells in the graph.
     * Returns Integer.MAX_VALUE if nodes are not adjacent.
     * 
     * @param int first - index of one node
     * @param int second - index the other node
     * @returns time taken to traverse between these two adjacent graphs.
     */
    public int getTimeTraversal(int first, int second){
        int output = Integer.MAX_VALUE;
        if(distanceMatrix[first][second]>0){
            output = distanceMatrix[first][second];
        }
        return output;
    }
    
    /**
     * Returns the distribution of time taken to travel between adjacent cells in the graph.
     * 
     * @returns Integer [] array containg time taken to traverse between these two adjacent graphs.
     */
    public Integer [] rangeDistr(){
        ArrayList<Integer> weightArray = new ArrayList<Integer>();
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=i+1;j<nodeList.size();j++){
                if((distanceMatrix[i][j])>0){
                    weightArray.add(distanceMatrix[i][j]);
                }
            }
        }
        weightArray.sort(null);
        Integer [] output = new Integer[weightArray.size()]; 
        output = weightArray.toArray(output);
        return output;
    }
    
    /**
     * Returns the distribution of time taken to travel between adjacent cells in the graph.
     * 
     * @returns Integer [] array containg time taken to traverse between these two adjacent graphs.
     */
    public float getAvgEdge(){
        float sum = 0;
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=i+1;j<nodeList.size();j++){
                if((distanceMatrix[i][j])>0){
                    sum+=distanceMatrix[i][j];
                }
            }
        }
        return sum/(float)numOfEdges;
    }
    
    public float getAvgRange(){
        float sum = 0;
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=i+1;j<nodeList.size();j++){
                if((distanceMatrix[i][j])>0){
                    sum+=distanceMatrix[i][j];
                }
            }
        }
        return sum/(float)numOfEdges;
    }
    
    /**
     * Updates the weights of edges in the road network.
     * 
     */
    public void updateNetwork(){
        for(int i=0;i<nodeList.size()-1;i++){
            for(int j=i+1;j<nodeList.size();j++){
                if((distanceMatrix[i][j])>0){
                    distanceMatrix[i][j] = random.nextInt(max-min)+min;
                    distanceMatrix[j][i] = distanceMatrix[i][j];
                }
            }
        }
    }
    
    /**
     * Solves the shortest time to traverse to all nodes reachable from a specific node
     * using Djikstra's algorithm and then returning the shortest path from source node
     * to another node in the graph
     *
     * @param int id - Source node index for the Dijkstra's algorithm
     * @param int destination - Destination node index
     * @returns a LinkedList object that presents the path to take from source node to destination node
     */
    public Deque<Node> dijkstra(int id, int destination){
        clearTimeDiff();
        Node startV = nodeList.get(id);
        Queue<Node> unvisitedVertex = new PriorityQueue<Node>();
        if(startV == null) return null;
        
        startV.setTimeDiff(0);
        
        for(int i=0;i<nodeList.size();i++){
            unvisitedVertex.add(nodeList.get(i));
        }
        
        while(unvisitedVertex.peek()!=null){
            Node currentV = unvisitedVertex.poll();
            Node [] neighbours = getNeighbours(currentV.getID());
            for(int i=0;i<neighbours.length;i++){
                Node currentVNode = neighbours[i];
                int weight = getTimeTraversal(currentVNode.getID(), currentV.getID());
                int alternativePathLength = currentV.getTimeDiff()+weight;
                if(alternativePathLength<currentVNode.getTimeDiff()){
                    unvisitedVertex.remove(currentVNode);
                    currentVNode.setTimeDiff(alternativePathLength);
                    currentVNode.setPrevNode(currentV);
                    unvisitedVertex.add(currentVNode);
                }
            }
        }
        
        Deque<Node> output = new LinkedList<Node>();
        Node destinationNode = nodeList.get(destination);
        output.addFirst(destinationNode);
        Node toBeAdded = destinationNode.getPrevNode();
        while(toBeAdded!=null){
            output.addFirst(toBeAdded);
            toBeAdded = toBeAdded.getPrevNode();
        }
        output.remove(startV);
        return output;
    }
    
    /**
     * Returns the estimated time arrival from a source node to a destination node
     * given the path from the source node to the destination node
     * @param int id - Source node index for the Dijkstra's algorithm
     * @param Deque<Node> path - Path to traverse from source node to destination node
     * @returns the estimated time arrival from a source node to a destination node
     */
    public int getETA(int id, Deque<Node> path){
        int eta = 0;
        int prevNode = id;
        while(path.peek()!=null){
            int currentNode = path.poll().getID();
            eta+=getTimeTraversal(prevNode, currentNode);
            prevNode = currentNode;
        }
        return eta;
    }
    
    /**
     * Returns the ID of a node which at a specifiied number of hops from a source node
     * @param int id - Source node ID
     * @param depth - the number of steps from the source node
     * @returns a node with is at a specified number of hops from the source node
     */
    public Node getNodeAtBreadth(int id, int depth){
        this.clearTimeDiff();
        Node startNode = nodeList.get(id);
        startNode.setTimeDiff(0);
        LinkedList<Node> frontierQueue = new LinkedList();
        ArrayList<Node> possibleNodes = new ArrayList<Node>();
        frontierQueue.add(startNode);
        int breadth = 0;
        while(frontierQueue.peek()!=null){
            Node currentV = frontierQueue.poll();
            if(currentV.getTimeDiff()>=breadth){
                breadth = breadth+1;
            }
            Node [] neighbours = this.getNeighbours(currentV.getID());
            for(int i=0;i<neighbours.length;i++){
                //TimeDiff is used to check if node has been visited instead of using a visitedQueue list to save time
                if(neighbours[i].getTimeDiff()>breadth){
                    neighbours[i].setTimeDiff(breadth);
                    frontierQueue.add(neighbours[i]);
                }
            }
        }
        
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getTimeDiff()==depth){
                possibleNodes.add(nodeList.get(i));
            }
        }
        
        
        return possibleNodes.get(random.nextInt(possibleNodes.size()));
    }
    
    /**
     * Returns true if a graph is connected using a depth first search
     * @return Returns true if a graph is connected using a depth first search
     */
    public boolean isConnected(){
        Node startNode = nodeList.get(0);
        Stack<Node> stack = new Stack<Node>();
        stack.push(startNode);
        HashSet<Node> visitedSet = new HashSet<Node>();
        while(!stack.empty()){
            Node currentV = stack.pop();
            if(!visitedSet.contains(currentV)){
                visitedSet.add(currentV);
                Node [] neighbours = this.getNeighbours(currentV.getID());
                for(int i=0;i<neighbours.length;i++){
                    Node toBeAdded = neighbours[i];
                    stack.push(toBeAdded);
                }
            }
        }
        return visitedSet.size() == nodeList.size();
    }
    
    /**
     * Returns average branching of the nodes in a graph
     * 
     * @return the size of the road network locations 
     */
    public float getAvgBranching(){
        return (float) totalNumOfBranches/(float)nodeList.size();
    }
}
