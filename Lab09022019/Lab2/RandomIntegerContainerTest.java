

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomIntegerContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RandomIntegerContainerTest
{
    private RandomIntegerContainer instance;
    /**
     * Default constructor for test class RandomIntegerContainerTest
     */
    public RandomIntegerContainerTest()
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
        instance = new RandomIntegerContainer();
        instance.addToFront(new Integer(5));
        // instance.addToFront(new Integer(6));
        // instance.addToFront(new Integer(7));
        // instance.addToFront(new Integer(55));
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
    public void testGet(){
        Integer[] answer  = {new Integer(5)};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testAddToFront(){
        instance.addToFront(new Integer(34));
        Integer[] answer = {new Integer(34),new Integer(5)};
        assertEquals(answer, instance.get());
    }
}
