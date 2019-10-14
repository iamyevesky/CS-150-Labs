import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class MyListStringContainerTest.
 *
 * @author  Sena Yevenyo
 * @version September 28, 2019
 */
public class MyListStringContainerTest
{
    /**
     * Default constructor for test class MyListStringContainerTest
     */
    public MyListStringContainerTest()
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
    public void testAddToFront(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        assertEquals("[890, abc]", list.toString());
    }
    
    @Test
    public void testAddToBack(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        assertEquals("[890, abc, def]", list.toString());
    }
    
    @Test
    public void testSize0(){
        MyListStringContainer list = new MyListStringContainer();
        assertEquals(0,list.size());
    }
    
    @Test
    public void testSize1(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        assertEquals(2, list.size());
    }
    
    @Test
    public void testToString0(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        assertEquals("[890, abc]", list.toString());
    }
    
    @Test
    public void testToString1(){
        MyListStringContainer list = new MyListStringContainer();
        assertEquals("[]", list.toString());
    }
    
    @Test
    public void testLinearSearch0(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        list.addToBack("ghi");
        assertEquals(3, list.linearSearch("hi"));
    }
    
    @Test
    public void testLinearSearch1(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        list.addToBack("ghi");
        assertEquals(-1, list.linearSearch("pm"));
    }
    
    @Test
    public void testLinearSearchIterator0(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        list.addToBack("ghi");
        assertEquals(3, list.linearSearchIterator("hi"));
    }
    
    @Test
    public void testLinearSearchIterator1(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        list.addToBack("ghi");
        assertEquals(-1, list.linearSearchIterator("pm"));
    }
    
    @Test
    public void testGet0(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        list.addToBack("ghi");
        assertEquals("def",list.get(2));
    }
    
    @Test
    public void testGet1(){
        MyListStringContainer list = new MyListStringContainer();
        assertEquals(null,list.get(0));
    }
    
    @Test
    public void testGet2(){
        MyListStringContainer list = new MyListStringContainer();
        list.addToFront("abc");
        list.addToFront("890");
        list.addToBack("def");
        list.addToBack("ghi");
        assertEquals(null,list.get(5));
    }
}
