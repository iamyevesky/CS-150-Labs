import java .awt  .Canvas;
import java .awt  .Graphics;
import java .awt  .Color;
import javax.swing.JFrame;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class DwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DwarfTest
{
    Map map = new Map(30,30);
    Dwarf dwarfSearcher, dwarfDigger, dwarfMinerBuilder, dwarfSuperMiner, dwarfUltimateMiner, dwarfSuperMiner1;
    MapNode pitNode = new MapNode(4,4,4);
    MapNode goldNode = new MapNode(6,6,2);
    /**
     * Default constructor for test class DwarfTest
     */
    public DwarfTest()
    {
        Dwarf.setMap(map);
        dwarfSearcher = new Dwarf(0,0,map.get(0,0),1);
        dwarfDigger = new Dwarf(1,2,map.get(0,0),2);
        dwarfMinerBuilder = new Dwarf(2,5,map.get(0,0),3);
        dwarfSuperMiner = new Dwarf(1,1,pitNode,4);
        dwarfUltimateMiner = new Dwarf(1,1,goldNode,5);
        dwarfSuperMiner1 = new Dwarf(1,1,goldNode,5);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Dwarf.setMap(map);
        pitNode = new MapNode(4,4,4);
        goldNode = new MapNode(6,6,2);
        new MapNode(6,6,2);
        dwarfSearcher = new Dwarf(0,0,map.get(0,0),1);
        dwarfDigger = new Dwarf(1,2,map.get(0,0),2);
        dwarfMinerBuilder = new Dwarf(2,5,map.get(0,0),3);
        dwarfSuperMiner = new Dwarf(1,1,pitNode,4);
        dwarfUltimateMiner = new Dwarf(1,1,goldNode,5);
        dwarfSuperMiner1 = new Dwarf(1,1,goldNode,5);
    }
    
    @Test
    public void testGetDiff(){
        assertEquals(0,dwarfSearcher.getDiff());
    }
    
    @Test
    public void testGetDiff1(){
        assertEquals(5,dwarfMinerBuilder.getDiff());
    }
    
    @Test
    public void testGetID(){
        assertEquals(0,dwarfSearcher.getID());
    }
    
    @Test
    public void testGetID1(){
        assertEquals(2,dwarfMinerBuilder.getID());
    }
    
    @Test
    public void testSetDiff(){
        dwarfSearcher.setDiff(13);
        assertEquals(13,dwarfSearcher.getDiff());
    }
    
    @Test
    public void testIsDeleted0(){
        assertEquals(false,dwarfSearcher.isDeleted());
    }
    
    @Test
    public void testIsDeleted1(){
        pitNode.dig();
        dwarfSuperMiner.go();
        assertEquals(true, dwarfSuperMiner.isDeleted());
    }
    
    @Test
    public void testDigGold0(){
        goldNode.dig();
        dwarfUltimateMiner.go();
        assertEquals(1, dwarfUltimateMiner.getCarry());
    }
    
    @Test
    public void testDigGold1(){
        goldNode.dig();
        dwarfSuperMiner1.go();
        assertEquals(1, dwarfSuperMiner1.getCarry());
    }
    
    @Test
    public void testDigGold2(){
        dwarfMinerBuilder.go();
        assertEquals(0, dwarfMinerBuilder.getCarry());
    }
    
    @Test
    public void testGo0(){
        dwarfMinerBuilder.go();
        dwarfMinerBuilder.go();
        dwarfMinerBuilder.go();
        assertEquals("(3,0)",dwarfMinerBuilder.getPos());
    }
    
    @Test
    public void testGo1(){
        dwarfDigger.go();
        assertEquals("(1,0)",dwarfDigger.getPos());
    }
    
    @Test
    public void testGo2(){
        dwarfMinerBuilder.go();
        assertEquals("(1,0)",dwarfMinerBuilder.getPos());
    }
    
    @Test
    public void testGo3(){
        dwarfSearcher.go();
        dwarfSearcher.go();
        dwarfSearcher.go();
        assertEquals("(0,0)",dwarfSearcher.getPos());
    }
    
    @Test
    public void testCompareTo(){
        assertEquals(-5,dwarfSearcher.compareTo(dwarfMinerBuilder));
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
