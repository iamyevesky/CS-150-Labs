

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GlobalClockTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GlobalClockTest
{
    /**
     * Default constructor for test class GlobalClockTest
     */
    public GlobalClockTest()
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
        GlobalClock.reset();
    }
    
    @Test
    public void testGlobalClockTime(){
        int time = GlobalClock.time();
        assertEquals(0, GlobalClock.time());
    }
    
    @Test
    public void testGlobalClockTick(){
        GlobalClock.tick();
        assertEquals(1, GlobalClock.time());
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