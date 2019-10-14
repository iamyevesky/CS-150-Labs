import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RandomStringGeneratorTest.
 *
 * @author  Sena Yevenyo
 * @version September 21, 2019
 */
public class RandomStringGeneratorTest
{
    RandomStringGenerator str1;
    RandomStringGenerator str2;
    /**
     * Default constructor for test class RandomStringGeneratorTest
     */
    public RandomStringGeneratorTest()
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
    
    //Testing for the randomness of the String numbers generated for this
    //method is unneccesary since it has been documented that Java uses a
    //pseudorandom number generator for its Random class so we do not have to test that.
    
    //We would test if the function gives the length of string desired
    //We would also test if two RandomStringGenerator objects generate
    //the same sequence of strings if they are equal.
    @Test
    public void testNextString0(){
        int strLength = 3;
        str1 = new RandomStringGenerator(1000,strLength);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextString().length()==strLength) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextString1(){
        int strLength = 5;
        str1 = new RandomStringGenerator(1000,strLength);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextString().length()==strLength) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextString2(){
        int strLength = 5;
        str1 = new RandomStringGenerator(1000,strLength);
        str2 = new RandomStringGenerator(1000,strLength);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextString().compareTo(str2.nextString())==0) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextString3(){
        int strLength = 5;
        str1 = new RandomStringGenerator(1000,strLength);
        str2 = new RandomStringGenerator(3000,strLength);
        boolean output = true;
        for(int i=0;i<50;i++){
            if(str1.nextString().compareTo(str2.nextString())!=0) output = false;
            else output = true;
        }
        assertEquals(output, false);
    }
}
