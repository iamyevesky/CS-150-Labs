import java .awt  .Color;
import java.util.*;
/**
 * Represents a grid on the map of a mine.
 *
 * @author Sena Yevenyo
 * @version October 21, 2019
 */
public class MapNode
{
    // instance variables - replace the example below with your own
    private static int seed;
    
    private int vectorX;
    private Random random;
    private int vectorY;
    private String feature;
    private Color color;
    private int value = 0;
    private boolean isDigged;
    private TreeSet dwarfTree = new TreeSet(DwarfIDComparator);
    private TreeSet minerTree = new TreeSet(DwarfIDComparator);
    //default color for rock
    private Color defaultColor = new Color(160,82,45);
    private MapNode riverLink = null; 
    
    /**
     * Sets the value of the seed for the Random object in Map class
     * @param int value, seed input for MapNode class
     */
    public static void setSeed(int value){
        seed = value;
    }
    
    /**
     * Constructor for objects of class MapNode
     */
    public MapNode(int posX, int posY, int feature)
    {
        // initialise instance variables
        vectorX = posX;
        vectorY = posY;
        random = new Random(seed);
        if(posX==0&&posY==0) {
            this.feature = "tunnel";
            color = new Color(244,164,96);
            isDigged = true;
        }else{
            switch(feature){
                //1 is for ground/tunnel
                case 1: color = new Color(244,164,96); this.feature = "tunnel";
                break;
                //2 is for gold
                case 2: color = new Color(212,175,55); this.feature = "gold"; value = random.nextInt(5)+1;
                break;
                //3 is for water
                case 3: color = new Color(0,0,255); this.feature = "water";
                break;
                //4 is for pit
                case 4: color = new Color(128,128,128); this.feature = "pit";
                break;
                //5 is for lava
                case 5: color = new Color(255,0,0); this.feature = "lava";
                break;
                default: color = new Color(255,255,255); this.feature = "error";
            }
            isDigged = false;
        }
    }

    /**
     * Octains color of MapNode object
     *
     * @return Color variable of MapNode
     */
    public Color getColor()
    {
        // put your code here
        if(!isDigged) return defaultColor;
        return color;
    }
    
    /**
     * Obtains feature of a MapNode object
     *
     * @return the feature of a map in String format
     */
    public String getFeature()
    {
        // put your code here
        if(!isDigged) return "rock";
        return feature;
    }
    
    /**
     * Checks if a MapNode object has been dug
     *
     * @return the boolean value that shows if a MapNode object has been dug 
     */
    public boolean digged()
    {
        // put your code here
        return isDigged;
    }
    
    /**
     * Digs a mapNode object
     *
     */
    public void dig(){
        isDigged = true;
        digRiverRecursive(this.getLink());
    }
    
    /**
     * Covers a mapNode object that has been mistakenly dig (used in digRiverRecursive) 
     *
     */
    private void cover(){
        isDigged = false;
    }
    
    private void digRiverRecursive(MapNode node){
        if(node == null){
            return;
        }
        else{
            node.dig();
            if(node.getFeature().compareTo("water")!=0){
                node.cover();
            }
        }
    }
    
    /**
     * Digs gold treasure from a node
     *
     * @return value of int 1, until gold supplies last
     */
    public int digGold(){
        if(feature.compareTo("gold")==0 && (value!=0)){
            value--;
            if(value==0) {
                feature = "tunnel";
                color = new Color(244,164,96);
            }
            return 1;
        }else return 0;
    }
    
    /**
     * Builds a bridge over MapNode objects with Pit feature 
     *
     */
    public void buildBridge(){
        if(feature.compareTo("pit")==0){
            feature = "tunnel";
            color = new Color(244,164,96);
        }
    }
    
    
    public String toString(){
        return "("+vectorX+","+vectorY+")";
    }
    
    /**
     * Returns the X position of a Dwarf object
     *
     * @return x position of Dwarf object
     */
    public int getX()
    {
        // put your code here
        return vectorX;
    }
    
    /**
     * Returns the Y position of a Dwarf object
     *
     * @return y position of Dwarf object
     */
    public int getY()
    {
        // put your code here
        return vectorY;
    }
    
    /**
     * Adds a Dwarf object to a location on Map(on MapNode object)
     *
     * @param Dwarf to be added
     */
    public void addDwarf(Dwarf dwarf){
        dwarfTree.add(dwarf);
        if(dwarf.getType().compareTo("searcher")!=0 && dwarf.getType().compareTo("digger")!=0){
            minerTree.add(dwarf);
        }
    }
    
    /**
     * Removes a Dwarf object of Miner from a location on Map(on MapNode object)
     *
     * @param Dwarf to be removed
     */
    public void removeDwarf(Dwarf dwarf){
        if(minerTree.isEmpty()== false){
            if(minerTree.contains(dwarf)){
                minerTree.remove(dwarf);
            }
        }
    }
    
    /**
     * Checks if there are miners present on a location on Map(on MapNode object)
     *
     * @return Boolean value indicating presence or absence of Dwarfs on the node
     */
    public boolean containsMiners(){
        return !minerTree.isEmpty();
    }
    
    /**
     * Checks if there is a Miner on a location on Map(on MapNode object)
     *
     * @return Boolean value indicating presence or absence of Dwarf object on node
     */
    public boolean containMiner(Dwarf dwarf){
        return minerTree.contains(dwarf);
    }
    
    /**
     * Inform Dwarf objects of the presence of gold on a MapNode object 
     * 
     */
    public void informGold(MapNode mapNode){
        Iterator it = minerTree.iterator();
        while(it.hasNext()){
            Dwarf miner = (Dwarf) it.next();
            miner.setGoldLoc(mapNode);
        }
    }
    
    /**
     * Checks if a Dwarf object has been present at a location on the map
     *
     * @param Dwarf to be checked
     */
    public boolean beenPresent(Dwarf dwarf){
        if(dwarfTree.isEmpty()== false){
            if(dwarfTree.contains(dwarf)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Sets link node for MapNode with water feature
     *
     * @param link of MapNode with water feature
     */
    public void setLink(MapNode linkObject){
        riverLink = linkObject;
    }
    
    /**
     * Returns link node for MapNode with water feature
     *
     * @return link of MapNode with water feature
     */
    public MapNode getLink(){
        return riverLink;
    }
    
    public static Comparator<Dwarf> DwarfIDComparator = new Comparator<Dwarf>(){
            @Override
            public int compare(Dwarf c1, Dwarf c2){
                if(c1==null) return c2.getID();
                else if(c2==null) return c1.getID();
                return (int) (c1.getID() - c2.getID());
            }
    };
}


