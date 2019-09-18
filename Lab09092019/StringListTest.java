import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StringListTest.
 *
 * @author  Sena Yevenyo
 * @version September 9 ,2019
 */
public class StringListTest
{
    private StringList stringlist1 = new StringList();
    private StringList stringlist2 = new StringList();
    /**
     * Default constructor for test class StringListTest
     */
    public StringListTest()
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
    public void testAppend0()
    {
        stringlist1.append("ab");
        stringlist1.append("bc");
        stringlist1.append("da");
        String answer = "abbcda";
        assertEquals(answer, stringlist1.toString());
    }
    
    @Test
    public void testToString0()
    {
        stringlist1.append("ab");
        stringlist1.append("bc");
        stringlist1.append("da");
        String answer = "abbcda";
        assertEquals(answer, stringlist1.toString());
    }
    
    @Test
    public void testToString1()
    {
        String answer = "";
        assertEquals(answer, stringlist1.toString());
    }
    
    @Test
    public void testIsEmpty0()
    {
        boolean answer = true;
        assertEquals(answer, stringlist1.isEmpty());
    }
    
    @Test
    public void testIsEmpty1()
    {
        stringlist1.append("ab");
        boolean answer = false;
        assertEquals(answer, stringlist1.isEmpty());
    }
}
