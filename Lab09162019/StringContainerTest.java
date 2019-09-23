import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StringContainerTest.
 *
 * @author  Sena Yevenyo
 * @version September 21, 2019
 */
public class StringContainerTest
{
    StringContainer strCnt1 = new StringContainer();
    /**
     * Default constructor for test class StringContainerTest
     */
    public StringContainerTest()
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
    public void testToString0(){
        strCnt1.add("1234");
        strCnt1.add("8954");
        strCnt1.add("5463");
        strCnt1.add("2378");
        strCnt1.add("4567");
        String answer = "[1234,8954,5463,2378,4567]";
        assertEquals(answer,strCnt1.toString());
    }
    
    @Test
    public void testToString1(){
        String answer = "[]";
        assertEquals(answer,strCnt1.toString());
    }
    
    @Test
    public void testAdd(){
        strCnt1.add("1234");
        strCnt1.add("8654");
        strCnt1.add("5463");
        strCnt1.add("2578");
        strCnt1.add("4568");
        String answer = "[1234,8654,5463,2578,4568]";
        assertEquals(answer,strCnt1.toString());
    }
    
    @Test
    public void testSelectionSort(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        String answer = "[1234,4568,4578,6744,7463]";
        strCnt1.selectionSort();
        assertEquals(answer,strCnt1.toString());
    }
    
    @Test
    public void testInsertionSort(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        String answer = "[1234,4568,4578,6744,7463]";
        strCnt1.insertionSort();
        assertEquals(answer,strCnt1.toString());
    }
    
    @Test
    public void testBinarySearch0(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        strCnt1.selectionSort();
        boolean answer = true;
        assertEquals(answer,strCnt1.binarySearch("6744"));
    }
    
    @Test
    public void testBinarySearch1(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        strCnt1.selectionSort();
        boolean answer = false;
        assertEquals(answer,strCnt1.binarySearch("5345"));
    }
    
    @Test
    public void testBinarySearch2(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        strCnt1.selectionSort();
        boolean answer = true;
        assertEquals(answer,strCnt1.binarySearch("1234"));
    }
    
    @Test
    public void testBinarySearch3(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        strCnt1.selectionSort();
        boolean answer = true;
        assertEquals(answer,strCnt1.binarySearch("7463"));
    }
    
    @Test
    public void testLinearSearch0(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        boolean answer = true;
        assertEquals(answer,strCnt1.linearSearch("6744"));
    }
    
    @Test
    public void testLinearSearch1(){
        strCnt1.add("1234");
        strCnt1.add("6744");
        strCnt1.add("7463");
        strCnt1.add("4578");
        strCnt1.add("4568");
        boolean answer = false;
        assertEquals(answer,strCnt1.linearSearch("5345"));
    }
}
