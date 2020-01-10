import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StudentRecordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentRecordTest
{
    StudentRecord rec0;
    StudentRecord rec1;
    StudentRecord rec2;
    StudentRecord rec3;
    /**
     * Default constructor for test class StudentRecordTest
     */
    public StudentRecordTest()
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
        rec0 = new StudentRecord("Cool","Record","1223");
    }
    
    @Test
    public void testGetFirstName(){
        assertEquals("Cool", rec0.getFirstName());
    }
    
    @Test
    public void testGetLastName(){
        assertEquals("Record", rec0.getLastName());
    }
    
    @Test
    public void testGetID(){
        assertEquals("1223", rec0.getID());
    }
    
    @Test
    public void testSetFirstName(){
        rec0.setFirstName("Me");
        assertEquals("Me", rec0.getFirstName());
    }
    
    @Test
    public void testSetLastName(){
        rec0.setLastName("What");
        assertEquals("What", rec0.getLastName());
    }
    
    @Test
    public void testSetID(){
        rec0.setID("121");
        assertEquals("121", rec0.getID());
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
