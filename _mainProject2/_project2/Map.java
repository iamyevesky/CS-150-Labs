import java .awt  .Canvas;
import java .awt  .Graphics;
import java .awt  .Color;
import javax.swing.JFrame;
import java.util.*;
/**
 * A class that represents the map of the game.
 *
 * @author Sena Yevenyo
 * @version October 21 2019 
 */
public class Map
{
    // instance variables - replace the example below with your own
    private int numOfGold;
    private int squareSize = 25;
    private int gridSize = 30; 
    private int parkSizeX, parkSizeY, mapWidth, mapHeight;
    private ArrayList<ArrayList<MapNode>> mapArray;
    
    
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        // initialise instance variables
        mapWidth = 30;
        mapHeight = 30;
        numOfGold = 0;
        parkSizeX = mapWidth*gridSize;
        parkSizeY = mapHeight*gridSize;
        mapArray = new ArrayList<ArrayList<MapNode>>();
        for(int i=0;i<mapWidth;i++){
            mapArray.add(new ArrayList<MapNode>());
            for(int j=0;j<mapHeight;j++){
                mapArray.get(i).add(new MapNode(i,j,1));
            }
        }
    }
    
    /**
     * Constructor for objects of class Map
     */
    public Map(int x, int y)
    {
        // initialise instance variables
        mapWidth = x;
        mapHeight = y;
        numOfGold = 0;
        parkSizeX = mapWidth*gridSize;
        parkSizeY = mapHeight*gridSize;
        mapArray = new ArrayList<ArrayList<MapNode>>();
        for(int i=0;i<mapWidth;i++){
            mapArray.add(new ArrayList<MapNode>());
            for(int j=0;j<mapHeight;j++){
                mapArray.get(i).add(new MapNode(i,j,1));
            }
        }
    }
    
    /**
     * Creates a River feature on the map
     * @param int x is the X location of River on Map
     * @param int y is the Y location of River on Map
     * @param length is how long the River feature is
     * @param String nature is how the River behaves. Input "topDown" shows River flows from top to bottom. "leftRight" means river flows from left to right. 
     * 
     */
    public void createRiver(int x, int y, int length, String nature){
        if(nature.compareTo("topDown")==0){
            for(int i=length-1;i>=0;i--){
                this.set(x, y+i, new MapNode(x, y+i, 3));
                MapNode currNode = this.get(x,y+i);
                if(currNode!=null){
                    currNode.setLink(this.get(x, y+1+i));
                }
            }
        }else if(nature.compareTo("leftRight")==0){
            for(int i=length-1;i>=0;i--){
                this.set(x+i,y, new MapNode(x+i, y, 3));
                MapNode currNode = this.get(x+i,y);
                if(currNode!=null){
                    currNode.setLink(this.get(x+1+i, y));
                }
            } 
        }
    }
    
    /**
     * Creates a Lava feature on the map
     * @param int x is the X location of Lava on Map
     * @param int y is the Y location of Lava on Map
     * 
     */
    public void createLava(int x, int y){
        this.set(x,y, new MapNode(x,y,5));
    }
    
    /**
     * Creates a Pit feature on the map
     * @param int x is the X location of Pit on Map
     * @param int y is the Y location of Pit on Map
     * 
     */
    public void createPit(int x, int y){
        this.set(x,y, new MapNode(x,y,4));
    }
    
    /**
     * Creates a Gold feature on the map
     * @param int x is the X location of Gold on Map
     * @param int y is the Y location of Gold on Map
     * 
     */
    public void createGold(int x, int y){
        this.set(x,y, new MapNode(x,y,2));
        numOfGold++;
    }
    
    /**
     * Paints visualization of Map object on canvas
     */
    public void paint(Graphics g) {
        for(int x = 0; x < mapWidth; x++){
            for(int y = 0; y < mapHeight; y++){
            g.setColor(mapArray.get(x).get(y).getColor());
            g.fillRect((x*gridSize)+((gridSize-squareSize)/2),
               (y*gridSize)+((gridSize-squareSize)/2),
                squareSize,
                squareSize);
            }
        }
    }
    
    /**
     * Obtains a MapNode object at a specific index on the map.
     * 
     * @param index of the node as shown in Cartesian form (x,y)
     * @ return MapNode object at specific input index
     */
    public MapNode get(int x, int y){
        if(x>=0 && x<this.getWidth() && y>=0 && y<this.getHeight()){
            return mapArray.get(x).get(y);
        }
        return null;
    }
    
    /**
     * Sets a MapNode object at a specific index on the map.
     * 
     * @param int x, int y, index of the node as shown in Cartesian form (x,y)
     * @param MapNode node to be inserted
     */
    public void set(int x, int y, MapNode node){
        if(x>=0 && x<this.getWidth() && y>=0 && y<this.getHeight()){
            mapArray.get(x).set(y,node);
        }
    }
    
    /**
     * Rerurns width of the map.
     * 
     * @return width of map.
     */
    public int getWidth(){
        return mapWidth;
    }
    
    /**
     * Rerurns height of the map.
     * 
     * @return height of map.
     */
    public int getHeight(){
        return mapHeight;
    }
    
    /**
     * Returns the amount of gold left in a map
     * @return int value num of Gold left in Map
     */
    public int getGoldLeft(){
        return numOfGold;
    }
    
    /**
     * Reduces the amount of gold left in a map
     */
    public void reduceGoldLeft(){
        numOfGold--;
    }
}