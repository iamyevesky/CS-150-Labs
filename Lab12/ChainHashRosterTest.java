import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChainHashRosterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ChainHashRosterTest
{
    ChainHashRoster roster; 
    /**
     * Default constructor for test class ChainHashRosterTest
     */
    public ChainHashRosterTest()
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
        roster = new ChainHashRoster(4, 3);
    }
    
    @Test
    public void testRehash0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.rehash();
        assertEquals(8, roster.getArraySize());
    }
    
    @Test
    public void testRehash1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.rehash();
        assertEquals(rec0, roster.get("12"));
    }
    
    @Test
    public void testRehash2(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.rehash();
        assertEquals(rec1, roster.get("14"));
    }
    
    @Test
    public void testRehash3(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.rehash();
        assertEquals(null, roster.get("13"));
    }
    
    @Test
    public void testSize0(){
        assertEquals(0, roster.size());
    }
    
    @Test
    public void testSize1(){
        roster.put(new StudentRecord("a","b","12"));
        assertEquals(1, roster.size());
    }
    
    @Test
    public void testSize2(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("12");
        assertEquals(8, roster.size());
    }
    
    @Test
    public void testClear(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.clear();
        assertEquals(0, roster.size());
    }
    
    @Test
    public void testContainsKey0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(true, roster.containsKey("12"));
    }
    
    @Test
    public void testContainsKey1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(false, roster.containsKey("11"));
    }
    
    @Test
    public void testContainsKey2(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("12");
        assertEquals(false, roster.containsKey("12"));
    }
    
    @Test
    public void testContainsKey3(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.clear();
        assertEquals(false, roster.containsKey("12"));
    }
    
    @Test
    public void testContainsValue0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(true, roster.containsValue(rec0));
    }
    
    @Test
    public void testContainsValue1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(false, roster.containsValue(rec1));
    }
    
    @Test
    public void testContainsValue2(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove(rec0.getID());
        assertEquals(false, roster.containsValue(rec0));
    }
    
    @Test
    public void testContainsValue3(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.clear();
        assertEquals(false, roster.containsValue(rec0));
    }
    
    @Test
    public void testGet0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(rec0, roster.get("12"));
    }
    
    @Test
    public void testGet1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(null, roster.get("13"));
    }
    
    @Test
    public void testGet2(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("12");
        assertEquals(null, roster.get("12"));
    }
    
    @Test
    public void testGet3(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.clear();
        assertEquals(null, roster.get("12"));
    }
    
    @Test
    public void testPut0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(rec0, roster.get("12"));
    }
    
    @Test
    public void testPut1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        assertEquals(9, roster.size());
    }
    
    @Test
    public void testPut2(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("16");
        assertEquals(8, roster.size());
    }
    
    @Test
    public void testKeySet0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        HashSet answer = new HashSet();
        answer.add("12");
        answer.add("14");
        answer.add("15");
        answer.add("16");
        answer.add("17");
        answer.add("110");
        answer.add("423");
        answer.add("324432");
        answer.add("343");
        assertEquals(true, answer.equals(roster.keySet()));
    }
    
    @Test
    public void testKeySet1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("14");
        HashSet answer = new HashSet();
        answer.add("12");
        answer.add("15");
        answer.add("16");
        answer.add("17");
        answer.add("110");
        answer.add("423");
        answer.add("324432");
        answer.add("343");
        assertEquals(true, answer.equals(roster.keySet()));
    }
    
    @Test
    public void testValueSet0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        HashSet answer = new HashSet();
        answer.add(rec0);
        answer.add(rec1);
        answer.add(rec2);
        answer.add(rec3);
        answer.add(rec4);
        answer.add(rec5);
        answer.add(rec6);
        answer.add(rec7);
        answer.add(rec8);
        assertEquals(true, answer.equals(roster.values()));
    }
    
    @Test
    public void testValueSet1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("14");
        HashSet answer = new HashSet();
        answer.add(rec0);
        answer.add(rec2);
        answer.add(rec3);
        answer.add(rec4);
        answer.add(rec5);
        answer.add(rec6);
        answer.add(rec7);
        answer.add(rec8);
        assertEquals(true, answer.equals(roster.values()));
    }
    
    @Test
    public void testRemove0(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("14");
        assertEquals(8, roster.size());
    }
    
    @Test
    public void testRemove1(){
        StudentRecord rec0 = new StudentRecord("a","b","12");
        StudentRecord rec1 = new StudentRecord("c","d","14");
        StudentRecord rec2 = new StudentRecord("e","f","15");
        StudentRecord rec3 = new StudentRecord("c","g","16");
        StudentRecord rec4 = new StudentRecord("c","t","17");
        StudentRecord rec5 = new StudentRecord("c","d","110");
        StudentRecord rec6 = new StudentRecord("t","d","423");
        StudentRecord rec7 = new StudentRecord("f","s","324432");
        StudentRecord rec8 = new StudentRecord("z","d","343");
        roster.put(rec0);
        roster.put(rec1);
        roster.put(rec2);
        roster.put(rec3);
        roster.put(rec4);
        roster.put(rec5);
        roster.put(rec6);
        roster.put(rec7);
        roster.put(rec8);
        roster.remove("11");
        assertEquals(9, roster.size());
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
