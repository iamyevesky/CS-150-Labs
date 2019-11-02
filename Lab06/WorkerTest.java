

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorkerTest.
 *
 * @author  Sena Yevenyo
 * @version October 16, 2019
 */
public class WorkerTest
{
    Worker worker0 = new Worker(23842);
    Worker worker1 = new Worker(46432);
    /**
     * Default constructor for test class WorkerTest
     */
    public WorkerTest()
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
    public void testGetID(){
        assertEquals(23842, worker0.getID());
    }
    
    @Test
    public void testCompareTo(){
        assertEquals(true,worker0.compareTo(worker1)<0);
    }
}
