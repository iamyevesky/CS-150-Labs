
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DirectedGraphTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DirectedGraphTest
{
    DirectedGraph<String> graph0 = new DirectedGraph<String>();
    DirectedGraph<Integer> graph1 = new DirectedGraph<Integer>();
    DirectedGraph<String>.DirectedGraphNode<String> node0 = graph0.new DirectedGraphNode<String>("a");
    DirectedGraph<Integer>.DirectedGraphNode<Integer> node1 = graph1.new DirectedGraphNode<Integer>(5);
    DirectedGraph<String>.DirectedGraphNode<String> node2 = graph0.new DirectedGraphNode<String>("b");
    DirectedGraph<Integer>.DirectedGraphNode<Integer> node3 = graph1.new DirectedGraphNode<Integer>(7);
    
    DirectedGraph<String>.DirectedGraphEdge<String> edge0 = graph0.new DirectedGraphEdge<String>(node0, node2, 5);
    DirectedGraph<String>.DirectedGraphEdge<String> edge1 = graph0.new DirectedGraphEdge<String>(node1, node3, 15);
    /**
     * Default constructor for test class DirectedGraphTest
     */
    public DirectedGraphTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        DirectedGraph<String> graph0 = new DirectedGraph<String>();
        DirectedGraph<Integer> graph1 = new DirectedGraph<Integer>();
        DirectedGraph<String>.DirectedGraphNode<String> node0 = graph0.new DirectedGraphNode<String>("a");
        DirectedGraph<Integer>.DirectedGraphNode<Integer> node1 = graph1.new DirectedGraphNode<Integer>(5);
        DirectedGraph<String>.DirectedGraphNode<String> node2 = graph0.new DirectedGraphNode<String>("b");
        DirectedGraph<Integer>.DirectedGraphNode<Integer> node3 = graph1.new DirectedGraphNode<Integer>(7);
        DirectedGraph<String>.DirectedGraphEdge<String> edge0 = graph0.new DirectedGraphEdge<String>(node0, node2, 5);
        DirectedGraph<String>.DirectedGraphEdge<String> edge1 = graph0.new DirectedGraphEdge<String>(node1, node3, 15);
    }
    
    @Test
    public void testGetValue0(){
        assertEquals("a",node0.getValue());
    }
    
    @Test
    public void testGetValue1(){
        assertEquals(new Integer(5), node1.getValue());
    }
    
    @Test
    public void testGetDistance0(){
        assertEquals(Integer.MAX_VALUE, node0.getDistance());
    }
    
    @Test
    public void testGetDistance1(){
        assertEquals(Integer.MAX_VALUE, node1.getDistance());
    }
    
    @Test
    public void testSetDistance(){
        node0.setDistance(2);
        assertEquals(2, node0.getDistance());
    }
    
    @Test
    public void testGetPrevNode(){
        assertEquals(null, node0.getPrevNode());
    }
    
    @Test
    public void testSetPrevNode(){
        node0.setPrevNode(node1);
        assertEquals(node1, node0.getPrevNode());
    }
    
    @Test
    public void testCompareTo(){
        node0.setDistance(2);
        node2.setDistance(7);
        assertEquals(true,node0.compareTo(node2)<0);
    }
    
    @Test
    public void testGetWeight(){
        assertEquals(5,edge0.getWeight());
    }
    
    @Test
    public void testSetWeight(){
        edge0.setWeight(17);
        assertEquals(17,edge0.getWeight());
    }
    
    @Test
    public void testToVertex(){
        assertEquals(node2,edge0.toVertex());
    }
    
    @Test
    public void testGetEdges(){
        node0.addEdge(node2, 6);
        assertEquals(node2, node0.getEdges().get(0).toVertex());
    }
    
    @Test
    public void testClosest(){
       node0.addEdge(node2, 6);
       node0.addEdge(node1, 18);
       assertEquals(node2, node0.closest()); 
    }
    
    @Test
    public void testAddNode0(){
        assertEquals(true, graph0.addNode("cb"));
    }
    
    @Test
    public void testAddNode1(){
        graph0.addNode("cb");
        assertEquals(false, graph0.addNode("cb"));
    }
    
    @Test
    public void testGetNode0(){
        graph0.addNode("cb");
        assertEquals(null, graph0.getNode("ab"));
    }
    
    @Test
    public void testGetNode1(){
        graph0.addNode("cb");
        assertEquals("cb", graph0.getNode("cb").getValue());
    }
    
    @Test
    public void testAddEdgeGraphLevel0(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(19);
        assertEquals(false, graph1.addEdge(2,7,3));
    }
    
    @Test
    public void testAddEdgeGraphLevel1(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(19);
        assertEquals(true, graph1.addEdge(3,5,3));
    }
    
    @Test
    public void testAddEdgeGraphLevel2(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(19);
        graph1.addEdge(3,5,3);
        graph1.addEdge(3,5,5);
        assertEquals(5, graph1.getNode(3).getEdge(graph1.getNode(5)).getWeight());
    }
    
    @Test
    public void testgetNeighbours(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(19);
        graph1.addEdge(3,5,3);
        graph1.addEdge(3,4,5);
        graph1.addEdge(3,6,3);
        assertEquals(true, graph1.getNeighbours(3).contains(5) && graph1.getNeighbours(3).contains(4) && graph1.getNeighbours(3).contains(6) && !graph1.getNeighbours(3).contains(19));
    }
    
    @Test
    public void testDijstra0(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(7);
        graph1.addNode(8);
        graph1.addEdge(3,5,4);
        graph1.addEdge(5,6,7);
        graph1.addEdge(6,7,2);
        graph1.addEdge(6,8,1);
        graph1.addEdge(7,3,2);
        graph1.dijkstra(3);
        assertEquals(12,graph1.getNode(8).getDistance());
    }
    
    @Test
    public void testDijkstra1(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(7);
        graph1.addNode(8);
        graph1.addEdge(3,4,1);
        graph1.addEdge(3,5,5);
        graph1.addEdge(3,7,1);
        graph1.addEdge(4,5,2);
        graph1.addEdge(4,6,3);
        graph1.addEdge(4,8,5);
        graph1.addEdge(5,6,6);
        graph1.addEdge(6,5,15);
        graph1.addEdge(7,8,1);
        graph1.addEdge(7,4,2);
        graph1.dijkstra(3);
        assertEquals(2,graph1.getNode(8).getDistance());
    }
    
    @Test
    public void testDijkstra2(){
        graph0.addNode("a");
        graph0.addNode("b");
        graph0.addNode("c");
        graph0.addNode("d");
        graph0.addNode("e");
        graph0.addNode("f");
        graph0.addEdge("a","b",1);
        graph0.addEdge("a","c",5);
        graph0.addEdge("a","e",1);
        graph0.addEdge("b","c",2);
        graph0.addEdge("b","d",3);
        graph0.addEdge("b","f",5);
        graph0.addEdge("c","d",6);
        graph0.addEdge("d","c",15);
        graph0.addEdge("e","f",1);
        graph0.addEdge("e","b",2);
        graph0.dijkstra("a");
        assertEquals(2,graph0.getNode("f").getDistance());
    }
    
    @Test
    public void testToString0(){
        graph1.addNode(3);
        graph1.addNode(4);
        graph1.addNode(5);
        graph1.addNode(6);
        graph1.addNode(7);
        graph1.addNode(8);
        graph1.addEdge(3,4,1);
        graph1.addEdge(3,5,5);
        graph1.addEdge(3,7,1);
        graph1.addEdge(4,5,2);
        graph1.addEdge(4,6,3);
        graph1.addEdge(4,8,5);
        graph1.addEdge(5,6,6);
        graph1.addEdge(6,5,13);
        graph1.addEdge(7,8,1);
        graph1.addEdge(7,4,2);
        graph1.dijkstra(3);
        assertEquals("3 0 4 1 7 1 8 2 5 3 6 4 ",graph1.toString());
    }
    
    @Test
    public void testToString1(){
        graph0.addNode("a");
        graph0.addNode("b");
        graph0.addNode("c");
        graph0.addNode("d");
        graph0.addNode("e");
        graph0.addNode("f");
        graph0.addEdge("a","b",1);
        graph0.addEdge("a","c",5);
        graph0.addEdge("a","e",1);
        graph0.addEdge("b","c",2);
        graph0.addEdge("e","f",1);
        graph0.addEdge("e","b",2);
        graph0.addEdge("b","d",3);
        graph0.addEdge("b","f",5);
        graph0.addEdge("c","d",6);
        graph0.addEdge("d","c",15);
        graph0.dijkstra("a");
        assertEquals("a 0 b 1 e 1 f 2 c 3 d 4 ",graph0.toString());
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
