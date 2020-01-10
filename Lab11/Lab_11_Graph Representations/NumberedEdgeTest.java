

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NumberedEdgeTest.
 *
 * @author  Sena Yevenyo
 * @version November 23, 2019
 */
public class NumberedEdgeTest
{
    NumberedEdge edge0;
    NumberedEdge edge1;
    NumberedEdge edge2;
    /**
     * Default constructor for test class NumberedEdgeTest
     */
    public NumberedEdgeTest()
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
        edge0 = new NumberedEdge(0,1, (float) 0.5);
        edge1 = new NumberedEdge(5,6, (float) 1.2);
        edge2 = new NumberedEdge(4,3, (float) 3.0);
    }
    
    @Test
    public void testGetName1(){
        assertEquals(0,edge0.getNode1());
    }
    
    @Test
    public void testGetName2(){
        assertEquals(1,edge0.getNode2());
    }
    
    @Test
    public void testSetName1(){
        edge1.setNode1(0);
        assertEquals(0,edge1.getNode1());
    }
    
    @Test
    public void testSetName2(){
        edge1.setNode2(26);
        assertEquals(26,edge1.getNode2());
    }
    
    @Test
    public void testGetWeight(){
        assertEquals((float) 0.5,edge0.getWeight(),(float) 0.1);
    }
    
    @Test
    public void testSetWeight(){
        edge0.setWeight((float) 15.0);
        assertEquals((float) 15.0 ,edge0.getWeight(), (float) 0.1);
    }
    
    @Test
    public void testCompareTo0(){
        assertEquals(-1,edge0.compareTo(edge2));
    }
    
    @Test
    public void testCompareTo1(){
        assertEquals(1,edge2.compareTo(edge1));
    }
    
    @Test
    public void testCompareTo2(){
        edge2.setWeight((float) 3.0);
        edge1.setWeight((float) 3.0);
        assertEquals(0,edge2.compareTo(edge1));
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
