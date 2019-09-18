import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CellTest.
 *
 * @author  Sena Yvenyo
 * @version September 9 ,2019
 */
public class CellTest
{
    private Cell cell1;
    private Cell cell2;
    /**
     * Default constructor for test class CellTest
     */
    public CellTest()
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
        cell1 = new Cell();
        cell2 = new Cell();
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
        cell1.append("ab");
        cell1.append("bc");
        cell1.append("da");
        String answer = "abbcda";
        assertEquals(answer, cell1.toString());
    }
    
    @Test
    public void testAppend1()
    {
        String answer = "";
        assertEquals(answer, cell1.toString());
    }
    
    @Test
    public void testToString0()
    {
        cell1.append("ab");
        cell1.append("bc");
        cell1.append("da");
        String answer = "abbcda";
        assertEquals(answer, cell1.toString());
    }
    
    @Test
    public void testToString1()
    {
        String answer = "";
        assertEquals(answer, cell1.toString());
    }
    
}
