import java .awt  .Canvas;
import java .awt  .Graphics;
import java .awt  .Color;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.*;
/**
 * Class that controls the game and simulation.
 *
 * @author Sena Yevenyo
 * @version October 21, 2019
 */
public class SimulationController extends Canvas
{
    // instance variables - replace the example below with your own
    /**
     * Reserve of every player before starting game
     */
    public static final int MAX_RESERVE = 3000;
    private int RESERVE = MAX_RESERVE;
    private int priceUltimateMiner = 150;
    private int priceSuperMiner = 120;
    private int priceMinerBuilder = 130;
    private int priceDigger = 50;
    private int priceSearcher = 10;
    
    private static int mapWidth;
    private static int mapHeight;
    private static int seed;
    private JFrame frame = null;
    private int squareSize = 25;
    private int gridSize = 30;
    private int parkSizeX, parkSizeY;
    private Map map;
    private int numOfSearchers;
    private int numOfDiggers;
    private int numOfMinerBuilders;
    private int numOfSuperMiners;
    private int numOfUltimateMiners;
    private int setGUI;
    
    private String genFilename = null;
    private String logFilename = null;
    private String dataFilename = null;
    private PrintWriter logWriter = null;
    private PrintWriter dataWriter = null;
    private PrintWriter simWriter = null;
    private File logData = null;
    private File dataFile = null;
    private Scanner reader = null;
    /**
     * Main method of the program.
     * 
     * Runs a for loop simulating the GlobalClock.tick() in the final program.
     */
    public static void main(String args[]){
        String fileName = null;
        SimulationController simul = null;
        if(args.length>0){
            fileName = args[0];
            seed = Integer.parseInt(args[1]);
        }
        simul = new SimulationController(fileName);
    }

    /**
     * Constructor for objects of class SimulationController
     */
    public SimulationController(String filename)
    {
        // initialise instance variables
        try{
            reader = new Scanner(new File(filename));
        }catch(Exception e){
            System.out.println(".txt format of input file does not exist or input argument is empty");
            System.out.print(e);
        }
        int runLoop = 0;
        for(int i=0;i<10;i++){
            if(reader.hasNext()){
                if(i==0) genFilename = reader.next();
                else if(i==1) numOfSearchers = Integer.parseInt(reader.next());
                else if(i==2) numOfDiggers = Integer.parseInt(reader.next());
                else if(i==3) numOfMinerBuilders = Integer.parseInt(reader.next());
                else if(i==4) numOfSuperMiners = Integer.parseInt(reader.next());
                else if(i==5) numOfUltimateMiners = Integer.parseInt(reader.next());
                else if(i==6) mapWidth = Integer.parseInt(reader.next());
                else if(i==7) mapHeight = Integer.parseInt(reader.next());
                else if(i==8) setGUI = Integer.parseInt(reader.next());
                else if(i==9) runLoop = Integer.parseInt(reader.next());
            }
        }
        
        
        
        String simFilename = genFilename+"_data.csv";
        try{
            File simData = new File(simFilename);
            simWriter = new PrintWriter(simData);
            Dwarf.setWriter(logWriter, dataWriter);
        }catch(Exception e){
                System.err.println(e);
        }
            
        this.start(runLoop);
    }

    /**
     * Begins the simulation for input number of loops
     * 
     * @param runLoop number of times for loop
     */
    public void start(int runLoop){
        simWriter.println("numOfSearchers,numOfDiggers,numOfMinerBuilders,numOfSuperMiners,numOfUltimateMiners,TotalGoldMined,Seed,DiedByLava,DiedByPit,DIedByRiver,Time");
        for(int i=0;i<runLoop;i++){
            RESERVE-= (priceSearcher*numOfSearchers + priceDigger*numOfDiggers + priceSuperMiner*numOfSuperMiners + priceMinerBuilder*numOfMinerBuilders + (priceUltimateMiner*numOfUltimateMiners));
            logFilename = genFilename+"_log"+i+".txt";
            dataFilename = genFilename+"_dataDwarf"+i+".csv";
            try{
                logData = new File(logFilename);
                dataFile = new File(dataFilename);
                dataWriter = new PrintWriter(dataFile);
                logWriter = new PrintWriter(logData);
                Dwarf.setWriter(logWriter, dataWriter);
            }catch(Exception e){
                System.err.println(e);
            }
            
            MapNode.setSeed(seed);
            map = new Map(mapWidth,mapHeight);
            createMap1(map);
            Dwarf.setNumOfDwarfs(numOfSearchers,numOfDiggers,numOfMinerBuilders, numOfSuperMiners, numOfUltimateMiners);
            Dwarf.setMap(map);
            Dwarf.initDwarfs(seed);
            
            if(setGUI==1){
                frame = new JFrame("Gold mine");
                parkSizeX = mapWidth*gridSize;
                parkSizeY = mapHeight*gridSize;
                this.setSize(parkSizeX, parkSizeY+30);
                frame.add(this);
                frame.setSize(parkSizeX,parkSizeY);
                frame.setVisible(true);
            }
            
            logWriter.println("+++Starting simulation+++");
            System.out.println("+++Starting simulation+++");
            logWriter.println("+++Dwarfs about to start!+++");
            System.out.println("+++Dwarfs about to start!+++");
            logWriter.println();
            logWriter.println("===================================================");
            logWriter.println();
            while(GlobalClock.time()<10000 && RESERVE>0 && map.getGoldLeft()>0){
                logWriter.println("Time "+GlobalClock.time());
                logWriter.println();
                Dwarf.goDwarfs(this, setGUI);
                try{
                    if(setGUI == 1) TimeUnit.MILLISECONDS.sleep(100);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
                GlobalClock.tick();
            }
            
            simWriter.println(numOfSearchers+","+numOfDiggers+","+numOfMinerBuilders+","+numOfSuperMiners+","+numOfUltimateMiners+","+Dwarf.getTotalGold()+","+seed+","+Dwarf.getDiedByLava()+","+Dwarf.getDiedByPit()+","+Dwarf.getDiedByRiver()+","+GlobalClock.time());
            Dwarf.endSimulation();
            logWriter.println();
            logWriter.println("Simulation completed");
            logWriter.println("===================================================");
            logWriter.println();
            System.out.println("Simulation completed for Run "+i);
            logWriter.close();
            GlobalClock.reset();
            this.resetReserve();
        }
        simWriter.close();
    }
    
    private void createMap1(Map map){
        map.createRiver(1,1,10,"topDown");
        map.createRiver(28,28,10,"topDown");
        map.createRiver(22,1,5,"leftRight");
        map.createRiver(19,22,12,"leftRight");
        map.createLava(5,7);
        map.createLava(6,10);
        map.createLava(10,19);
        map.createLava(23,7);
        map.createLava(15,15);
        map.createLava(23,9);
        map.createLava(26,6);
        map.createLava(29,1);
        map.createLava(7,21);
        map.createLava(3,26);
        map.createLava(5,23);
        map.createLava(14,22);
        map.createLava(1,29);
        map.createLava(9,18);
        map.createLava(29,29);
        map.createPit(4,3);
        map.createPit(11,10);
        map.createPit(21,5);
        map.createPit(6,15);
        map.createPit(13,8);
        map.createPit(7,7);
        map.createPit(24,18);
        map.createPit(28,7);
        map.createPit(20,19);
        map.createPit(2,16);
        map.createPit(13,15);
        map.createPit(3, 21);
        map.createPit(21,21);
        map.createPit(18,22);
        map.createGold(13,6);
        map.createGold(21,9);
        map.createGold(8,6);
        map.createGold(21,21);
        map.createGold(20,6);
        map.createGold(29,2);
        map.createGold(19,17);
        map.createGold(17,23);
        map.createGold(13,19);
        map.createGold(1,17);
        map.createGold(2,27);
        map.createGold(3,14);
        map.createGold(9,15);
        map.createGold(23,28);
        map.createGold(18,18);
        map.createGold(17,17);
        map.createGold(24,11);
        map.createGold(12,21);
    }
    
    private void createMap2(Map map){
        map.createRiver(1,1,10,"topDown");
        map.createRiver(28,28,10,"topDown");
        map.createLava(5,7);
        map.createLava(16,8);
        map.createLava(3,9);
        map.createLava(18,16);
        map.createLava(23,4);
        map.createLava(29,29);
        map.createPit(4,3);
        map.createPit(11,10);
        map.createPit(21,5);
        map.createPit(6,15);
        map.createPit(13,8);
        map.createGold(13,6);
        map.createGold(21,9);
        map.createGold(8,6);
        map.createGold(21,21);
    }
    
    private void createMap3(Map map){
        map.createRiver(1,1,10,"topDown");
        map.createRiver(28,28,10,"topDown");
        map.createLava(5,7);
        map.createLava(16,8);
        map.createLava(3,9);
        map.createLava(18,16);
        map.createLava(23,4);
        map.createLava(29,29);
        map.createPit(4,3);
        map.createPit(11,10);
        map.createPit(21,5);
        map.createPit(6,15);
        map.createPit(13,8);
        map.createGold(13,6);
        map.createGold(21,9);
        map.createGold(8,6);
        map.createGold(21,21);
    }
    
    public void reduceReserve(int value){
        RESERVE = RESERVE - value;
    }
    
    public void resetReserve(){
        RESERVE = MAX_RESERVE;
    }
    
    public void paint(Graphics g){
        map.paint(g);
        Dwarf.paintDwarfs(g);
    }
    
    public void update(Graphics g){
        map.paint(g);
        Dwarf.paintDwarfs(g);
    }
}
