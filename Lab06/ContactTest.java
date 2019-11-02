import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class ContactTest.
 *
 * @author  Sena Yevenyo
 * @version October 16,2 019
 */
public class ContactTest
{
    Contact contact0;
    Contact contact1; 
    /**
     * Default constructor for test class ContactTest
     */
    public ContactTest()
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
    public void testGetFirstName(){
        contact0 = new Contact("Wan-Bissaka","Aaron");
        assertEquals("Aaron", contact0.GetFirstName());
    }
    
    @Test
    public void testGetLastName(){
        contact0 = new Contact("Wan-Bissaka","Aaron");
        assertEquals("Wan-Bissaka", contact0.GetLastName());
    }
    
    @Test
    public void testCompareTo0(){
        contact0 = new Contact("Wan-Bissaka","Aaron");
        contact1 = new Contact("Mata","Juan");
        assertEquals(true,contact0.compareTo(contact1)>0);
    }
    
    @Test
    public void testCompareTo1(){
        contact0 = new Contact("Mata","Aaron");
        contact1 = new Contact("Mata","Juan");
        assertEquals(true,contact0.compareTo(contact1)<0);
    }
    
}
