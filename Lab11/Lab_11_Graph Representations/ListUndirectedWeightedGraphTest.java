import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListUndirectedWeightedGraphTest.
 *
 * @author  Sena Yevenyo
 * @version November 23, 2019
 */
public class ListUndirectedWeightedGraphTest
{
    ListUndirectedWeightedGraph graph;
    ListUndirectedWeightedGraph answer;
    /**
     * Default constructor for test class ListUndirectedWeightedGraphTest
     */
    public ListUndirectedWeightedGraphTest()
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
        graph = new ListUndirectedWeightedGraph();
        answer = new ListUndirectedWeightedGraph();
    }
    
    @Test
    public void testAddNode0(){
        assertEquals(1,graph.addNode("c"));
    }
    
    @Test
    public void testAddNode1(){
        graph.addNode("c");
        assertEquals(-1,graph.addNode("c"));
    }
    
    @Test
    public void testAddNode2(){
        graph.addNode("a");
        graph.addNode("b");
        assertEquals(3,graph.addNode("c"));
    }
    
    @Test
    public void testAddEdge0(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        assertEquals(true, graph.addEdge("a","b",(float) 3.0));
    }
    
    @Test
    public void testAddEdge1(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        assertEquals(false, graph.addEdge("a","h",(float) 3.0));
    }
    
    @Test
    public void testAddEdge2(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("a","b",(float) 3.0);
        assertEquals(false, graph.addEdge("a","b",(float) 3.0));
    }
    
    @Test
    public void testAddEdge3(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        assertEquals(true, graph.addEdge(0,1,(float) 3.0));
    }
    
    @Test
    public void testAddEdge4(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        assertEquals(false, graph.addEdge(0,0,(float) 3.0));
    }
    
    
    @Test
    public void testUpdateWeight0(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("a","b",(float) 3.0);
        assertEquals(true, graph.updateWeight("a","b",(float) 3.0));
    }
    
    @Test
    public void testUpdateWeight1(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        assertEquals(false, graph.updateWeight("a","b",(float) 3.0));
    }
    
    @Test
    public void testUpdateWeight2(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        assertEquals(false, graph.updateWeight("a","h",(float) 3.0));
    }
    
    @Test
    public void testUpdateWeight3(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge(0,1,(float) 3.0);
        assertEquals(true, graph.updateWeight(0,1,(float) 3.0));
    }
    
    @Test
    public void testUpdateWeight4(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge(1,0,(float) 3.0);
        assertEquals(true, graph.updateWeight(0,1,(float) 15.0));
    }
    
    @Test
    public void testUpdateWeight5(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge(1,0,(float) 3.0);
        assertEquals(false, graph.updateWeight(0,15,(float) 15.0));
    }
    
    @Test
    public void testGetNodeNames(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        String[] answer = {"a","b","c","d","e","f","g"};
        assertEquals(answer, graph.getNodeNames());
    }
    
    @Test
    public void testGetNeighbourNames(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("b","c",5);
        graph.addEdge("b","d",7);
        graph.addEdge("e","b",9);
        String[] answer = {"c","d","e"};
        assertEquals(answer, graph.getNeighbourNames("b"));
    }
    
    @Test
    public void testGetNeighbourNums(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("b","c",5);
        graph.addEdge("b","d",7);
        graph.addEdge("e","b",9);
        int[] answer = {2,3,4};
        assertEquals(true, answer[0] == graph.getNeighbourNums(1)[0] && answer[1] == graph.getNeighbourNums(1)[1] && answer[2] == graph.getNeighbourNums(1)[2]);
    }
    
    @Test
    public void testGetEdgeNames(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("b","c",5);
        graph.addEdge("b","d",7);
        graph.addEdge("e","b",9);
        NamedEdge[] answer = new NamedEdge[3];
        answer[0] = new NamedEdge("b","c",5);
        answer[1] = new NamedEdge("b","d",7);
        answer[2] = new NamedEdge("b","e",9);
        assertEquals(true, answer[0].getName2() == graph.getEdgeNames()[0].getName2() && answer[1].getName2() == graph.getEdgeNames()[1].getName2() && answer[2].getName2() == graph.getEdgeNames()[2].getName2());
    }
    
    @Test
    public void testEmpty(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.empty();
        assertEquals(1, graph.addNode("a"));
    }
    
    @Test
    public void testIsConnected0(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("a","b",5);
        graph.addEdge("a","c",5);
        graph.addEdge("a","d",5);
        graph.addEdge("a","e",5);
        graph.addEdge("a","f",5);
        graph.addEdge("a","g",5);
        assertEquals(true, graph.isConnected());
    }
    
    @Test
    public void testIsConnected1(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addNode("g");
        graph.addEdge("a","b",5);
        graph.addEdge("a","c",5);
        graph.addEdge("a","d",5);
        graph.addEdge("a","e",5);
        graph.addEdge("a","f",5);
        assertEquals(false, graph.isConnected());
    }
    
    @Test
    public void testIsConnected2(){
        graph.addNode("b");
        graph.addNode("a");
        graph.addNode("c");
        graph.addNode("e");
        graph.addNode("d");
        graph.addNode("g");
        graph.addNode("f");
        graph.addEdge("a","b",5);
        graph.addEdge("a","c",5);
        graph.addEdge("a","d",5);
        graph.addEdge("c","e",5);
        graph.addEdge("d","f",2);
        graph.addEdge("b","g",10);
        assertEquals(true, graph.isConnected());
    }
    
    @Test
    public void testIsConnected3(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addEdge("a","d",15);
        graph.addEdge("b","d",4);
        graph.addEdge("b","e",5);
        graph.addEdge("d","f",5);
        graph.addEdge("a","b",1);
        graph.addEdge("a","c",2);
        graph.addEdge("e","f",1);
        graph.addEdge("d","e",1);
        graph.addEdge("c","d",3);
        assertEquals(true, graph.isConnected());
    }
    
    @Test
    public void testKruskal0(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addEdge("a","b",5);
        graph.addEdge("a","c",5);
        graph.addEdge("a","d",5);
        graph.addEdge("a","e",5);
        graph.addEdge("a","f",5);
        answer.kruskal(graph);
        String [] result = {"b","c","d","e","f"};
        assertEquals(result, graph.getNeighbourNames("a"));
    }
    
    @Test
    public void testKruskal1(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addEdge("a","d",15);
        graph.addEdge("b","d",4);
        graph.addEdge("b","e",5);
        graph.addEdge("d","f",5);
        graph.addEdge("a","b",1);
        graph.addEdge("a","c",2);
        graph.addEdge("e","f",1);
        graph.addEdge("d","e",1);
        graph.addEdge("c","d",3);
        answer.addNode("a");
        answer.addNode("b");
        answer.addNode("c");
        answer.addNode("d");
        answer.addNode("e");
        answer.addNode("f");
        answer.addEdge("a","c",2);
        answer.addEdge("a","b",1);
        answer.addEdge("d","e",1);
        answer.addEdge("c","d",3);
        answer.addEdge("d","e",1);
        answer.addEdge("e","f",1);
        answer.kruskal(graph); 
        String [] result = {"b","c"};
        assertEquals(result, graph.getNeighbourNames("a"));
    }
    
    @Test
    public void testKruskal2(){
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addNode("f");
        graph.addEdge("a","d",15);
        graph.addEdge("b","d",4);
        graph.addEdge("b","e",5);
        graph.addEdge("d","f",5);
        graph.addEdge("a","b",1);
        graph.addEdge("a","c",2);
        graph.addEdge("e","f",1);
        graph.addEdge("d","e",1);
        graph.addEdge("c","d",3);
        answer.addNode("a");
        answer.addNode("b");
        answer.addNode("c");
        answer.addNode("d");
        answer.addNode("e");
        answer.addNode("f");
        answer.addEdge("a","c",2);
        answer.addEdge("a","b",1);
        answer.addEdge("d","e",1);
        answer.addEdge("c","d",3);
        answer.addEdge("d","e",1);
        answer.addEdge("e","f",1);
        answer.kruskal(graph); 
        assertEquals(answer.getNeighbourNames("e"), graph.getNeighbourNames("e"));
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
