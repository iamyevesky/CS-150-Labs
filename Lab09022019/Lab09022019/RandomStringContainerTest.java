

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomStringContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RandomStringContainerTest
{
    private RandomStringContainer randomSt1;
    private RandomStringContainer instance;

    /**
     * Default constructor for test class RandomStringContainerTest
     */
    public RandomStringContainerTest()
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
        randomSt1 = new RandomStringContainer();
        randomSt1.addSorted("ab");
        randomSt1.addSorted("cd");
        randomSt1.addSorted("za");
        randomSt1.addSorted("fg");
        randomSt1.get();
        randomSt1.prependSorted("ab");
        randomSt1.get();
        randomSt1.addToFront("abcd");
        randomSt1.addToBack("ppacd");
        randomSt1.selectionSort();
        randomSt1.get();
        
        instance = new RandomStringContainer();
        instance.addToFront("za");
        instance.addToFront("pp");
        instance.addToFront("mi");
        instance.addToFront("cd");
        instance.get();
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
    public void testSelectionSort0()
    {
        instance.selectionSort();
        String [] answer = {"cd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }

    @Test
    public void testPrependSorted0()
    {
        instance.selectionSort();
        instance.prependSorted("zz");
        String answer [] = {"cd","mi","pp","za","zzcd"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testPrependSorted1()
    {
        instance.selectionSort();
        instance.prependSorted("ab");
        String answer [] = {"abcd","cd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testPrependSorted2()
    {
        instance.selectionSort();
        instance.prependSorted("cd");
        String answer [] = {"cd","cdcd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testPrependSorted3()
    {
        instance.selectionSort();
        instance.prependSorted("pp");
        String answer [] = {"cd","mi","pp","ppcd","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testAddSorted0()
    {
        instance.selectionSort();
        instance.addSorted("de");
        String answer [] = {"cd","de","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testAddSorted1()
    {
        instance.selectionSort();
        instance.addSorted("ab");
        String answer [] = {"ab","cd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testAddSorted2()
    {
        instance.selectionSort();
        instance.addSorted("cd");
        String answer [] = {"cd","cd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testAddSorted3()
    {
        instance.selectionSort();
        instance.addSorted("zz");
        String answer [] = {"cd","mi","pp","za","zz"};
        assertEquals(answer, instance.get());
    }
   
    @Test
    public void testAddToFront0()
    {
        instance.selectionSort();
        instance.addToFront("zz");
        String answer [] = {"zz","cd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testAddToBack0()
    {
        instance.selectionSort();
        instance.addToBack("zw");
        String answer [] = {"cd","mi","pp","za","zw"};
        assertEquals(answer, instance.get());
    }
    
    @Test
    public void testGet(){
        instance.selectionSort();
        String answer [] = {"cd","mi","pp","za"};
        assertEquals(answer, instance.get());
    }
}



