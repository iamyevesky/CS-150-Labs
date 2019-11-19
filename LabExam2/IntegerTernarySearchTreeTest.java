
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IntegerTernarySearchTreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IntegerTernarySearchTreeTest
{
    IntegerTernarySearchTree<Integer> testObject;
    /**
     * Default constructor for test class IntegerTernarySearchTreeTest
     */
    public IntegerTernarySearchTreeTest()
    {
         testObject = new IntegerTernarySearchTree<Integer>();
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
    
    @Test
    public void testTotal0(){
        testObject.insert(2);
        testObject.insert(3);
        testObject.insert(1);
        testObject.insert(2);
        testObject.insert(5);
        assertEquals(13, testObject.total());
    }
    
    @Test
    public void testTotal1(){
        assertEquals(0, testObject.total());
    }
    
    @Test
    public void testTotal2(){
        testObject.insertMany(2,15);
        testObject.insertMany(3,5);
        testObject.insertMany(1,2);
        testObject.insertMany(4,1);
        testObject.removeDuplicates(2);
        assertEquals(23, testObject.total());
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
