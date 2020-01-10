import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 *
 * @author  Sena Yevenyo
 * @version November 28, 2019
 */
public class NodeTest
{
    Node node0;
    Node node1;
    Node node2;
    Node node3;
    /**
     * Default constructor for test class NodeTest
     */
    public NodeTest()
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
        node0 = new Node(0);
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
    }
    
    @Test
    public void testGetID(){
        assertEquals(0, node0.getID());
    }
    
    @Test
    public void testGetNeighbour0(){
        assertEquals(0, node0.getNeighbours().length);
    }
    
    @Test
    public void testGetNeighbour1(){
        node0.addNeighbour(node1);
        assertEquals(1, node0.getNeighbours().length);
    }
    
    @Test
    public void testAddNeighbour(){
        node0.addNeighbour(node1);
        assertEquals(1,(int) node0.getNeighbours()[0]);
    }
    
    @Test
    public void testGetTimeDiff(){
        assertEquals(Integer.MAX_VALUE, node0.getTimeDiff());
    }
    
    @Test
    public void testSetTimeDiff(){
        node0.setTimeDiff(2);
        assertEquals(2, node0.getTimeDiff());
    }
    
    @Test
    public void testGetBranching(){
        assertEquals(0,node1.getBranching());
    }
    
    @Test
    public void testIncreaseBranching(){
        node1.increaseBranching();
        assertEquals(1,node1.getBranching());
    }
    
    @Test
    public void testDecreaseBranching(){
        node1.increaseBranching();
        node1.increaseBranching();
        node1.decreaseBranching();
        assertEquals(1,node1.getBranching());
    }
    
    @Test
    public void testSetPrevNode(){
        node0.setPrevNode(node1);
        assertEquals(node1, node0.getPrevNode());
    }
    
    @Test
    public void testGetPrevNode(){
        assertEquals(null, node0.getPrevNode());
    }
    
    @Test
    public void testCompareTo0(){
        node0.setTimeDiff(0);
        node1.setTimeDiff(1);
        assertEquals(1, node1.compareTo(node0));
    }
    
    @Test
    public void testCompareTo1(){
        node0.setTimeDiff(0);
        node2.setTimeDiff(2);
        assertEquals(-1, node0.compareTo(node2));
    }
    
    @Test
    public void testCompareTo2(){
        assertEquals(0, node0.compareTo(node0));
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
