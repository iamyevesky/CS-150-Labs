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
    public void testNextNumber0(){
        //Expected length of number (XXX)XXX-XXX is 12
        int strLength = 12;
        str1 = new RandomStringGenerator(1000);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextNumber().length()==strLength) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextNumber1(){
        str1 = new RandomStringGenerator(1000);
        str2 = new RandomStringGenerator(1000);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextNumber().compareTo(str2.nextNumber())==0) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextNumber2(){
        str1 = new RandomStringGenerator(1000);
        str2 = new RandomStringGenerator(3000);
        boolean output = true;
        for(int i=0;i<50;i++){
            if(str1.nextNumber().compareTo(str2.nextNumber())!=0) output = false;
            else output = true;
        }
        assertEquals(output, false);
    }
    
    @Test
    public void testNextName0(){
        //Expected name length is 4
        int strLength = 4;
        str1 = new RandomStringGenerator(1000);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextName().length()==strLength) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextName1(){
        str1 = new RandomStringGenerator(1000);
        str2 = new RandomStringGenerator(1000);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextName().compareTo(str2.nextName())==0) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextName2(){
        str1 = new RandomStringGenerator(1000);
        str2 = new RandomStringGenerator(3000);
        boolean output = true;
        for(int i=0;i<50;i++){
            if(str1.nextNumber().compareTo(str2.nextNumber())!=0) output = false;
            else output = true;
        }
        assertEquals(output, false);
    }
    
    @Test
    public void testNextID0(){
        //Expected ID is an 8 digit number
        int strLength = 8;
        str1 = new RandomStringGenerator(1000);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(Long.toString(str1.nextID()).length()==strLength) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextID1(){
        str1 = new RandomStringGenerator(1000);
        str2 = new RandomStringGenerator(1000);
        boolean output = false;
        for(int i=0;i<50;i++){
            if(str1.nextID()-str2.nextID()==0) output = true;
            else output = false;
        }
        assertEquals(output, true);
    }
    
    @Test
    public void testNextID2(){
        str1 = new RandomStringGenerator(1000);
        str2 = new RandomStringGenerator(3000);
        boolean output = true;
        for(int i=0;i<50;i++){
            if(str1.nextID()-str2.nextID()!=0) output = false;
            else output = true;
        }
        assertEquals(output, false);
    }
}
