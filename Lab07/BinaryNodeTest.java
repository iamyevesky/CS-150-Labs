

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BinaryNodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BinaryNodeTest
{
    BinaryNode node0 = new BinaryNode<Integer>(1);
    BinaryNode node1 = new BinaryNode<Integer>(2);
    BinaryNode node2 = new BinaryNode<Integer>(3);
    BinaryNode node3 = new BinaryNode<Integer>(4);
    BinaryNode node4 = new BinaryNode<Integer>(5);
    BinaryNode node5 = new BinaryNode<Integer>(6);
    BinaryNode node6 = new BinaryNode<Integer>(7);
    BinaryNode node7 = new BinaryNode<Integer>(8);
    
    
    /**
     * Default constructor for test class BinaryNodeTest
     */
    public BinaryNodeTest()
    {
        node4.parent = null;
        node4.L = node2;
        node2.parent = node4;
        node4.R = node6;
        node6.parent = node4;
        node2.L = node0;
        node0.parent = node2;
        node2.R = node3;
        node3.parent = node2;
        node6.R = node7;
        node7.parent = node6;
        node6.L = node5;
        node5.parent = node6;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        node4.L = node2;
        node2.parent = node4;
        node4.R = node6;
        node6.parent = node4;
        node2.L = node0;
        node0.parent = node2;
        node2.R = node3;
        node3.parent = node2;
        node6.R = node7;
        node7.parent = node6;
        node6.L = node5;
        node5.parent = node6;
    }
    
    @Test
    public void testGetValue0(){
        assertEquals(1, node0.getValue());
    }
    
    @Test
    public void testGetValue1(){
        assertEquals(7, node6.getValue());
    }
    
    @Test
    public void testGetValue2(){
        assertEquals(1, node2.L.getValue());
    }
    
    @Test
    public void testGetHeight0(){
        assertEquals(2,node4.getHeight());
    }
    
    @Test
    public void testGetHeight1(){
        assertEquals(1,node6.getHeight());
    }
    
    @Test
    public void testGetHeight2(){
        assertEquals(0,node0.getHeight());
    }
    
    @Test
    public void testToString(){
        assertEquals("5", node4.toString());
    }
    
    @Test
    public void testGetDepth0(){
        assertEquals(1, node6.getDepth());
    }
    
    @Test
    public void testGetDepth1(){
        assertEquals(2, node0.getDepth());
    }
    
    @Test
    public void testGetDepth2(){
        assertEquals(0, node4.getDepth());
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
