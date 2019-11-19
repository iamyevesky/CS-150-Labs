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
 * The test class MapNodeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MapNodeTest
{
    MapNode node0, node1, node2, node3, node4, node5, node6, nodeWater0, nodeWater1, nodeWater2, nodeTunnel3, nodeDwarfs, nodeNoDwarfs;
    Color colorTunnel = new Color(244,164,96);
    Color colorRock = new Color(160,82,45);
    Color colorPit = new Color(128,128,128);
    Color colorLava = new Color(255,0,0);
    Color colorWater = new Color(0,0,255);
    Color colorGold = new Color(212,175,55);
    Dwarf dwarf, dwarf0;
    /**
     * Default constructor for test class MapNodeTest
     */
    public MapNodeTest()
    {
        node0 = new MapNode(0,0,5);//tunnel
        node1 = new MapNode(1,5,2);//gold
        node2 = new MapNode(1,5,3);//water
        node3 = new MapNode(1,5,4);//pit
        node4 = new MapNode(1,5,5);//lava
        node5 = new MapNode(1,5,1);//tunnel
        
        nodeWater0 = new MapNode(15,15,3);
        nodeWater1 = new MapNode(16,15,3);
        nodeWater2 = new MapNode(17,15,3);
        nodeTunnel3 = new MapNode(18,15,1);
        nodeWater0.setLink(nodeWater1);
        nodeWater1.setLink(nodeWater2);
        nodeWater2.setLink(nodeTunnel3);
        nodeDwarfs = new MapNode(1,1,1);
        nodeNoDwarfs = new MapNode(1,2,1); 
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
    public void testContainMiner0(){
        Dwarf dwarf = new Dwarf(1,1,nodeDwarfs,5);
        nodeDwarfs.addDwarf(dwarf);
        assertEquals(true, nodeDwarfs.containMiner(dwarf));
    }
    
    @Test
    public void testContainMiner1(){
        Dwarf dwarf = new Dwarf(1,1,nodeDwarfs,5);
        nodeDwarfs.addDwarf(dwarf);
        assertEquals(false, nodeNoDwarfs.containMiner(dwarf));
    }
    
    @Test
    public void testContainMiners0(){
        Dwarf dwarf = new Dwarf(1,1,nodeDwarfs,5);
        nodeDwarfs.addDwarf(dwarf);
        assertEquals(true, nodeDwarfs.containsMiners());
    }
    
    @Test
    public void testContainMiners1(){
        assertEquals(false, nodeNoDwarfs.containsMiners());
    }
    
    @Test
    public void testInformMiners(){
        Dwarf dwarf = new Dwarf(1,1,nodeDwarfs,5);
        nodeDwarfs.addDwarf(dwarf);
        nodeDwarfs.informGold(node1);
        assertEquals(node1,dwarf.getGoldLoc());
    }
    
    @Test
    public void testSetLink(){
        node0.setLink(node2);
        assertEquals(node2, node0.getLink());
    }
    
    @Test
    public void testGetLink0(){
        assertEquals(nodeWater1, nodeWater0.getLink());
    }
    
    @Test
    public void testGetLink1(){
        assertEquals(nodeWater2, nodeWater1.getLink());
    }
    
    @Test
    public void testDigRiver(){
        nodeWater0.dig();
        assertEquals(nodeWater0.digged()&&nodeWater1.digged()&&nodeWater2.digged()&&!nodeTunnel3.digged(), true);
    }
    
    @Test
    public void testBeenPresent0(){
        Dwarf.setMap(new Map(30,30));
        dwarf = new Dwarf(6,1, node0,1);
        assertEquals(true, node0.beenPresent(dwarf));
    }
    
    @Test
    public void testBeenPresent1(){
        Dwarf.setMap(new Map(30,30));
        dwarf0 = new Dwarf(1,5, node2,1);
        assertEquals(false, node2.beenPresent(dwarf));
    }
    
    @Test
    public void testGetColor0(){
        assertEquals(colorTunnel,node0.getColor());
    }
    
    @Test
    public void testGetColor1(){
        node1.dig();
        assertEquals(colorGold,node1.getColor());
    }
    
    @Test
    public void testGetColor2(){
        node2.dig();
        assertEquals(colorWater,node2.getColor());
    }
    
    @Test
    public void testGetColor3(){
        node3.dig();
        assertEquals(colorPit,node3.getColor());
    }
    
    @Test
    public void testGetColor4(){
        node4.dig();
        assertEquals(colorLava,node4.getColor());
    }
    
    @Test
    public void testGetColor5(){
        node5.dig();
        assertEquals(colorTunnel,node5.getColor());
    }
    
    @Test
    public void testGetColor6(){
        assertEquals(colorRock,node5.getColor());
    }
    
    @Test
    public void testisDigged0(){
        node5.dig();
        assertEquals(true,node5.digged());
    }
    
    @Test
    public void testisDigged1(){
        assertEquals(false,node5.digged());
    }
    
    @Test
    public void testGetFeature0(){
        assertEquals("tunnel",node0.getFeature());
    }
    
    @Test
    public void testGetFeature1(){
        node1.dig();
        assertEquals("gold",node1.getFeature());
    }
    
    @Test
    public void testGetFeature2(){
        node2.dig();
        assertEquals("water",node2.getFeature());
    }
    
    @Test
    public void testGetFeature3(){
        node3.dig();
        assertEquals("pit",node3.getFeature());
    }
    
    @Test
    public void testGetFeature4(){
        node4.dig();
        assertEquals("lava",node4.getFeature());
    }
    
    @Test
    public void testGetFeature5(){
        node5.dig();
        assertEquals("tunnel",node5.getFeature());
    }
    
    @Test
    public void testGetFeature6(){
        assertEquals("rock",node5.getFeature());
    }
    
    @Test
    public void testDigGold0(){
        assertEquals(1,node1.digGold());
    }
    
    @Test
    public void testDigGold1(){
        assertEquals(0,node3.digGold());
    }
    
    @Test
    public void testBuildBridge(){
        node3.dig();
        node3.buildBridge();
        assertEquals("tunnel",node3.getFeature());
    }
    
    @Test
    public void testGetX(){
        assertEquals(1,node1.getX());
    }
    
    @Test
    public void testGetY(){
        assertEquals(5,node1.getY());
    }
    
    @Test
    public void testToString(){
        assertEquals("(0,0)",node0.toString());
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
