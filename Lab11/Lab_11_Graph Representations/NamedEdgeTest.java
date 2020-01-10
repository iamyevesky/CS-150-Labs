
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NamedEdgeTest.
 *
 * @author Sena Yevenyo
 * @version Saturday November 23, 2019
 */
public class NamedEdgeTest
{
    NamedEdge edge0;
    NamedEdge edge1;
    NamedEdge edge2;
    /**
     * Default constructor for test class NamedEdgeTest
     */
    public NamedEdgeTest()
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
        edge0 = new NamedEdge("a","b", (float) 0.5);
        edge1 = new NamedEdge("f","g", (float) 1.2);
        edge2 = new NamedEdge("e","d", (float) 3.0);
    }
    
    @Test
    public void testGetName1(){
        assertEquals("a",edge0.getName1());
    }
    
    @Test
    public void testGetName2(){
        assertEquals("b",edge0.getName2());
    }
    
    @Test
    public void testSetName1(){
        edge1.setName1("a");
        assertEquals("a",edge1.getName1());
    }
    
    @Test
    public void testSetName2(){
        edge1.setName2("z");
        assertEquals("z",edge1.getName2());
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
