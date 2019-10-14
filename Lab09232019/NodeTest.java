

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NodeTest.
 *
 * @author  Sena Yevenyo
 * @version September 28, 2019
 */
public class NodeTest
{
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
    
    @Test
    public void testSetKey(){
        Node node = new Node<String>(0, "abc");
        node.setKey(2);
        assertEquals(2,node.getKey());
    }
    
    @Test
    public void testSetValue(){
        Node node = new Node<Integer>(0, 5);
        node.setValue(15);
        assertEquals(15, node.getValue());
    }
    
    @Test
    public void testGetValue(){
        Node node = new Node<String>(0, "def");
        assertEquals("def", node.getValue());
    }
    
    @Test
    public void testGetKey(){
        Node node = new Node<String>(7, "def");
        assertEquals(7, node.getKey());
    }
    
    @Test
    public void testToString(){
        Node node = new Node<String>(0, "abc");
        assertEquals("(0, abc)", node.toString());
    }
}
