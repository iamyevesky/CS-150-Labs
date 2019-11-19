import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MapTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MapTest
{
    Map map0, map1, map2;
    /**
     * Default constructor for test class MapTest
     */
    public MapTest()
    {
        map0 = new Map();
        map1 = new Map(20,20);
        map2 = new Map(30,50);
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
    
    @Test
    public void testCreateLava(){
        map0.createLava(15,15);
        map0.get(15,15).dig();
        assertEquals("lava", map0.get(15,15).getFeature());
    }
    
    @Test
    public void testCreatePit(){
        map0.createPit(15,15);
        map0.get(15,15).dig();
        assertEquals("pit", map0.get(15,15).getFeature());
    }
    
    @Test
    public void testCreateRiver0(){
        map0.createRiver(15,15,3,"topDown");
        map0.get(15,15).dig();
        assertEquals("water", map0.get(15,15).getFeature());
    }
    
    @Test
    public void testCreateRiver1(){
        map0.createRiver(15,15,3,"topDown");
        map0.get(15,15).dig();
        assertEquals("water", map0.get(15,16).getFeature());
    }
    
    @Test
    public void testCreateRiver2(){
        map0.createRiver(15,15,3,"topDown");
        map0.get(15,15).dig();
        assertEquals("water", map0.get(15,17).getFeature());
    }
    
    @Test
    public void testCreateRiver3(){
        map0.createRiver(15,15,3,"topDown");
        map0.get(15,15).dig();
        assertEquals("rock", map0.get(15,18).getFeature());
    }
    
    @Test
    public void testGetWidth0(){
        assertEquals(30, map0.getWidth());
    }
    
    @Test
    public void testGetWidth1(){
        assertEquals(20, map1.getWidth());
    }
    
    @Test
    public void testGetWidth2(){
        assertEquals(30, map2.getWidth());
    }
    
    @Test
    public void testGetHeight0(){
        assertEquals(30, map0.getHeight());
    }
    
    @Test
    public void testGetHeight1(){
        assertEquals(20, map1.getHeight());
    }
    
    @Test
    public void testGetHeight2(){
        assertEquals(50, map2.getHeight());
    }
    
    @Test
    public void testGet0(){
        MapNode node = map0.get(0,0);
        assertEquals("(0,0)",node.toString());
    }
    
    @Test
    public void testGet1(){
        MapNode node = map0.get(5,6);
        assertEquals("(5,6)",node.toString());
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
