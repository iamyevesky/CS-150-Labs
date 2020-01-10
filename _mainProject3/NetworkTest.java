import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NetworkTest.
 *
 * @author Sena Yevenyo
 * @version November 28, 2019
 */
public class NetworkTest
{
    Network graph0;
    Network graph1;
    Network graph2;
    Network graph3;
    /**
     * Default constructor for test class NetworkTest
     */
    public NetworkTest()
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
        graph0 = new Network(10);
        graph1 = new Network(100, 3, 2, 15);
        graph2 = new Network(100, 4, 2, 15);
        graph3 = new Network(100, 5, 2, 15);
    }
    
    @Test
    public void testUpdateNetwork(){
        graph1.updateNetwork();
        assertEquals(true, graph1.getTimeTraversal(15, 20) == graph1.getTimeTraversal(20, 15));
    }
    
    @Test
    public void testGetSize(){
        assertEquals(100, graph1.getSize());
    }
    
    @Test
    public void testGetNumOfEdges0(){
        assertEquals(0, graph0.getEdgeNum());
    }
    
    @Test
    public void testGetAverageBranching(){
        assertEquals(graph1.getAvgBranching(), (float)graph1.getTotalBranching()/(float)graph1.getSize(), 0.01);
    }
    
    @Test
    public void testGetNumOfEdges1(){
        graph0.createEdge(2,0,1);
        graph0.createEdge(2,5,1);
        graph0.createEdge(2,1,1);
        graph0.createEdge(5,1,1);
        graph0.createEdge(1,4,1);
        graph0.createEdge(1,3,1);
        graph0.createEdge(6,5,1);
        graph0.createEdge(4,3,1);
        graph0.createEdge(4,7,1);
        graph0.createEdge(7,9,1);
        graph0.createEdge(7,8,1);
        assertEquals(11, graph0.getEdgeNum());
    }
    
    @Test
    public void testGetNumOfBranches0(){
        assertEquals(0, graph0.getTotalBranching());
    }
    
    @Test
    public void testGetNumOfBranches1(){
        graph0.createEdge(2,0,1);
        graph0.createEdge(2,5,1);
        graph0.createEdge(2,1,1);
        graph0.createEdge(5,1,1);
        graph0.createEdge(1,4,1);
        graph0.createEdge(1,3,1);
        graph0.createEdge(6,5,1);
        graph0.createEdge(4,3,1);
        graph0.createEdge(4,7,1);
        graph0.createEdge(7,9,1);
        graph0.createEdge(7,8,1);
        assertEquals(22, graph0.getTotalBranching());
    }
    
    @Test
    public void testCreateEdge(){
        graph0.createEdge(0,1,2);
        Node [] output = graph0.getNeighbours(0);
        assertEquals(true, output.length == 1 && output[0].getID()==1 && graph0.getTimeTraversal(0,1)==2);
    }
    
    @Test
    public void testCreateEdge0(){
        assertEquals(true, graph0.createEdge(0,1,2));
    }
    
    @Test
    public void testUpdateEdge(){
        graph0.createEdge(0,1,2);
        graph0.updateEdge(1,0,5);
        Node [] output = graph0.getNeighbours(0);
        assertEquals(true, output.length == 1 && output[0].getID()==1 && graph0.getTimeTraversal(0,1)==5);
    }
    
    @Test
    public void testTimeTraversal0(){
        assertEquals(Integer.MAX_VALUE, graph0.getTimeTraversal(0,1));
    }
    
    @Test
    public void testTimeTraversal1(){
        graph0.createEdge(0,1,2);
        assertEquals(2, graph0.getTimeTraversal(1,0));
    }
    
    @Test
    public void getNeighbours0(){
        assertEquals(0, graph0.getNeighbours(0).length);
    }
    
    @Test
    public void getNeighbours1(){
        graph0.createEdge(5,7,15);
        assertEquals(true, graph0.getNeighbours(5).length == 1 && graph0.getNeighbours(5)[0].getID()==7);
    }
    
    @Test
    public void testConnected0(){
        graph0.createEdge(2,0,1);
        graph0.createEdge(2,5,1);
        graph0.createEdge(2,1,1);
        graph0.createEdge(2,5,1);
        graph0.createEdge(5,1,1);
        graph0.createEdge(1,4,1);
        graph0.createEdge(1,3,1);
        graph0.createEdge(6,5,1);
        graph0.createEdge(4,3,1);
        graph0.createEdge(4,7,1);
        graph0.createEdge(7,9,1);
        graph0.createEdge(7,8,1);
        assertEquals(true, graph0.isConnected());
    }
    
    @Test
    public void testConnected1(){
        graph0.createEdge(0,9,1);
        graph0.createEdge(0,3,1);
        graph0.createEdge(0,2,1);
        graph0.createEdge(0,1,1);
        graph0.createEdge(4,8,1);
        graph0.createEdge(4,7,1);
        graph0.createEdge(4,5,1);
        graph0.createEdge(4,6,1);
        assertEquals(false, graph0.isConnected());
    }
    
    @Test
    public void testConnected2(){
        graph0.createEdge(9,0,1);
        graph0.createEdge(9,5,1);
        graph0.createEdge(9,4,1);
        graph0.createEdge(0,5,1);
        graph0.createEdge(0,7,1);
        graph0.createEdge(0,1,1);
        graph0.createEdge(5,7,1);
        graph0.createEdge(5,6,1);
        graph0.createEdge(5,4,1);
        graph0.createEdge(4,8,1);
        graph0.createEdge(7,1,1);
        graph0.createEdge(6,1,1);
        graph0.createEdge(6,8,1);
        graph0.createEdge(8,1,1);
        graph0.createEdge(8,2,1);
        graph0.createEdge(8,3,1);
        assertEquals(true, graph0.isConnected());
    }
    
    @Test
    public void testConnected3(){
        graph0.createEdge(2,3,1);
        graph0.createEdge(2,1,1);
        graph0.createEdge(3,4,1);
        graph0.createEdge(4,1,1);
        graph0.createEdge(0,5,1);
        graph0.createEdge(0,9,1);
        graph0.createEdge(9,8,1);
        graph0.createEdge(8,7,1);
        graph0.createEdge(7,6,1);
        graph0.createEdge(6,5,1);
        assertEquals(false, graph0.isConnected());
    }
    
    @Test
    public void testConnected4(){
        graph0.createEdge(0,5,1);
        graph0.createEdge(0,4,1);
        graph0.createEdge(0,7,1);
        graph0.createEdge(0,3,1);
        graph0.createEdge(0,6,1);
        graph0.createEdge(0,1,1);
        graph0.createEdge(0,2,1);
        graph0.createEdge(5,8,1);
        graph0.createEdge(2,8,1);
        graph0.createEdge(2,9,1);
        graph0.createEdge(1,9,1);
        assertEquals(true, graph0.isConnected());
    }
    
    @Test
    public void testCalculateConnectivity(){
        graph0.createEdge(0,5,1);
        graph0.createEdge(0,4,1);
        graph0.createEdge(0,7,1);
        graph0.createEdge(0,3,1);
        graph0.createEdge(0,6,1);
        graph0.createEdge(0,1,1);
        graph0.createEdge(0,2,1);
        graph0.createEdge(5,8,1);
        graph0.createEdge(2,8,1);
        graph0.createEdge(2,9,1);
        graph0.createEdge(1,9,1);
        assertEquals( 2.2/9.0, graph0.calculateConnectivity(), 0.01);
    }
    
    @Test
    public void testGetRangeDistr0(){
        graph0.createEdge(0,5,1);
        graph0.createEdge(0,4,1);
        graph0.createEdge(0,7,1);
        graph0.createEdge(0,3,1);
        graph0.createEdge(0,6,1);
        graph0.createEdge(0,1,1);
        graph0.createEdge(0,2,1);
        graph0.createEdge(5,8,1);
        graph0.createEdge(2,8,1);
        graph0.createEdge(2,9,1);
        graph0.createEdge(1,9,1);
        int output = 1;
        Integer [] range = graph0.rangeDistr();
        for(int i=0; i<range.length; i++){
            if(range[i]!=1){
                output = 0;
                break;
            }
        }
        assertEquals(1, output);
    }
    
    @Test
    public void testGetRangeDistr1(){
        graph0.createEdge(0,5,5);
        graph0.createEdge(0,4,2);
        graph0.createEdge(0,7,2);
        graph0.createEdge(0,3,7);
        graph0.createEdge(0,6,5);
        graph0.createEdge(0,1,1);
        graph0.createEdge(0,2,14);
        graph0.createEdge(5,8,9);
        graph0.createEdge(2,8,3);
        graph0.createEdge(2,9,6);
        graph0.createEdge(1,9,2);
        int output = 1;
        Integer [] range = graph0.rangeDistr();
        for(int i=1; i<range.length; i++){
            if(range[i]<range[i-1]){
                output = 0;
                break;
            }
        }
        assertEquals(1, output);
    }
    
    @Test
    public void testDijkstra0(){
        graph0.createEdge(9,0,1);
        graph0.createEdge(9,5,6);
        graph0.createEdge(9,4,5);
        graph0.createEdge(0,5,8);
        graph0.createEdge(0,7,7);
        graph0.createEdge(0,1,2);
        graph0.createEdge(5,7,15);
        graph0.createEdge(5,6,9);
        graph0.createEdge(5,4,4);
        graph0.createEdge(4,8,3);
        graph0.createEdge(7,1,1);
        graph0.createEdge(6,1,3);
        graph0.createEdge(6,8,6);
        graph0.createEdge(8,1,3);
        graph0.createEdge(8,2,1);
        graph0.createEdge(8,3,2);
        Deque answer = graph0.dijkstra(9,2);
        Node [] output = new Node[answer.size()];
        output[0] = (Node) answer.poll();
        output[1] = (Node) answer.poll();
        output[2] = (Node) answer.poll();
        output[3] = (Node) answer.poll();
        assertEquals(true, answer.poll()==null && output[0].getID()==0 && output[1].getID()==1 && output[2].getID()==8 && output[3].getID()==2);
    }
    
    @Test
    public void testDijkstra1(){
        graph0.createEdge(2,0,2);
        graph0.createEdge(2,5,1);
        graph0.createEdge(2,1,5);
        graph0.createEdge(5,1,7);
        graph0.createEdge(1,4,9);
        graph0.createEdge(1,3,2);
        graph0.createEdge(6,5,7);
        graph0.createEdge(4,3,1);
        graph0.createEdge(4,7,3);
        graph0.createEdge(7,9,3);
        graph0.createEdge(7,8,2);
        Deque answer = graph0.dijkstra(1,9);
        Node [] output = new Node[answer.size()];
        output[0] = (Node) answer.poll();
        output[1] = (Node) answer.poll();
        output[2] = (Node) answer.poll();
        output[3] = (Node) answer.poll();
        assertEquals(true, answer.poll()==null && output[0].getID()==3 && output[1].getID()==4 && output[2].getID()==7 && output[3].getID()==9);
    }
    
    @Test
    public void testDijkstra2(){
        graph0 = new Network(4);
        graph0.createEdge(0,1,1);
        graph0.createEdge(1,2,2);
        graph0.createEdge(2,3,1);
        Deque answer = graph0.dijkstra(0,3);
        Node [] output = new Node[answer.size()];
        output[0] = (Node) answer.poll();
        output[1] = (Node) answer.poll();
        output[2] = (Node) answer.poll();
        assertEquals(true, answer.poll()==null && output[0].getID()==1 && output[1].getID()==2 && output[2].getID()==3);
    }
    
    @Test
    public void testDijkstra3(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        Deque answer = graph0.dijkstra(0,1);
        Node [] output = new Node[answer.size()];
        output[0] = (Node) answer.poll();
        assertEquals(true, answer.poll()==null && output[0].getID()==1);
    }
    
    @Test
    public void testDijkstra4(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        Deque answer = graph0.dijkstra(0,0);
        Node [] output = new Node[answer.size()];
        assertEquals(true, answer.poll()==null && output.length== 0);
    }
    
    @Test
    public void testMeanTimeTraversal0(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        assertEquals(8.75, graph0.getMeanTimeTraversal(0),0.01);
    }
    
    @Test
    public void testMeanTimeTraversal1(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        assertEquals(11.6, graph0.getMeanTimeTraversal(1),0.01);
    }
    
    @Test
    public void testGetETA0(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        assertEquals(11, graph0.getETA(3,graph0.dijkstra(3,0)));
    }
    
    @Test
    public void testGetETA1(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        assertEquals(10, graph0.getETA(6,graph0.dijkstra(6,1)));
    }
    
    @Test
    public void testGetNodeAtBreath0(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        ArrayList<Integer> answerArray = new ArrayList<Integer>();
        answerArray.add(1);
        answerArray.add(8);
        assertEquals(true, answerArray.contains(graph0.getNodeAtBreadth(7,2).getID()));
    }
    
    @Test
    public void testgetNodeAtBreath1(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        ArrayList<Integer> answerArray = new ArrayList<Integer>();
        answerArray.add(13);
        answerArray.add(2);
        assertEquals(true, answerArray.contains(graph0.getNodeAtBreadth(14,2).getID()));
    }
    
    @Test
    public void randomGraphCreation0(){
        assertEquals(true, graph1.isConnected());
    }
    
    @Test
    public void randomGraphCreation1(){
        assertEquals((float)3.00, graph1.getAvgBranching(), 0.01);
    }
    
    @Test
    public void randomGraphCreation2(){
        graph1 = new Network(100,(float)2.5, 2,15);
        assertEquals((float)2.50, graph1.getAvgBranching(), 0.01);
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
