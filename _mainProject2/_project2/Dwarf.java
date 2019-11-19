    import java .awt  .Canvas;
    import java .awt  .Graphics;
    import java .awt  .Color;
    import javax.swing.JFrame;
    import java.util.*;
    import java.io.*;
    /**
     * A class that offers template for the instantiation of Dwarf miners.
     *
     * @author Sena Yevenyo
     * @version October 21, 2019
     */
    public class Dwarf implements Comparable<Dwarf>
    {
        // instance variables - replace the example below with your own
        /**
         * Maximum amount of gold value a Dwarf object can carry
         */
        private static final int CARRY_MAX = 30;
        private static Queue <Dwarf> dwarfQueue = new PriorityQueue<Dwarf>(1);
        private static Queue <Dwarf> nDwarfQueue = new PriorityQueue<Dwarf>(1);
        private static int numOfDwarfsSearchers;
        private static int numOfDwarfsDiggers;
        private static int numOfDwarfsMinerBuilders;
        private static int numOfDwarfsSuperMiners;
        private static int numOfDwarfsUltimateMiners;
        private static int totalMiners;
        private static SimulationController simulator;
        
        private static Map map;
        private static ArrayList<Integer> diffArray = new ArrayList<Integer>(1);
        private static Random random = new Random();
        private static PrintWriter logWriter = null;
        private static PrintWriter dataWriter = null;
        private static Color dwarfColor = new Color(255,255,255);
        
        private static int totalGold;
        private static int diedByLava;
        private static int diedByPit;
        private static int diedByRiver;
        private static ArrayList<int []> dwarfData = new ArrayList<int[]>(1); 
        
        private String state;
        private int vectorX;
        private int vectorY;
        private MapNode currPos;
        private ArrayList<MapNode> edgeNodes = new ArrayList<MapNode>(4);
        private Stack<MapNode> prevLoc = new Stack();
        
        private int id;
        private int diff;
        private int numType;
        private boolean delete;
        private int totalGoldMined;
        private int deathInt;
        private Color color;
        private String type;
        private MapNode goldModeLoc = null;
        /**
         * Sets the number of dwarfs for a simulation
         * 
         * @param int numberOfSearchers for the simulation
         * @param int numberOfDiggers for the simulation
         * @param int numberOfMinerBuilders for the simulation
         * @param int numberOfSuperMiners for the simulation
         * @param int numberOfUltimateMiners for the simulation
         */
        public static void setNumOfDwarfs(int numOfSearchers, int numOfDiggers, int numOfMinerBuilders, int numOfSuperMiners, int numOfUltimateMiners){
            numOfDwarfsSearchers = numOfSearchers;
            numOfDwarfsDiggers = numOfDiggers;
            numOfDwarfsMinerBuilders = numOfMinerBuilders;
            numOfDwarfsSuperMiners = numOfSuperMiners;
            numOfDwarfsUltimateMiners = numOfUltimateMiners;
            totalMiners = numOfDwarfsSearchers + numOfDwarfsDiggers + numOfDwarfsSuperMiners + numOfDwarfsMinerBuilders + numOfDwarfsUltimateMiners;
            dwarfData = new ArrayList<int[]>(totalMiners);
            for(int i=0;i<totalMiners;i++){
                int [] data = new int[4];
                dwarfData.add(data);
            }
        }
        
        /**
         * Sets the map for a simulation
         * 
         * @param map for the simulation
         */
        public static void setMap(Map value){
            map = value;
        }
        
        /**
         * Sets the PrintWriter object of simulation, into which log data is written
         * 
         * @param PrintWriter for log data
         */
        public static void setWriter(PrintWriter logWriteObject, PrintWriter dataWriteObject){
            logWriter = logWriteObject;
            dataWriter = dataWriteObject;
        }
        
        /**
         * Initializes global Dwarf objects in Dwarf class for class-level simulation. 
         *  
         */
        public static void initDwarfs(int seed){
            printToWriter("+++Adding dwarfs to simulation+++");
            printToWriter();
            totalGold = 0;
            diedByLava = 0;
            diedByPit = 0;
            diedByRiver = 0;
            random = new Random(seed);
            for(int i=0;i<totalMiners;i++){
                Dwarf newDwarf = null;
                if(i<numOfDwarfsSearchers)  newDwarf = new Dwarf(i, i, map.get(0,0),1);
                else if(i<numOfDwarfsDiggers+numOfDwarfsSearchers) newDwarf = new Dwarf(i, i, map.get(0,0),2);
                else if(i<numOfDwarfsDiggers+numOfDwarfsSearchers+numOfDwarfsMinerBuilders) newDwarf = new Dwarf(i, i, map.get(0,0),3);
                else if(i<numOfDwarfsDiggers+numOfDwarfsSearchers+numOfDwarfsMinerBuilders+numOfDwarfsSuperMiners) newDwarf = new Dwarf(i, i, map.get(0,0),4);
                else if(i<totalMiners) newDwarf = new Dwarf(i, i, map.get(0,0),5);
                dwarfQueue.add(newDwarf);
                diffArray.add(i);
                printToWriter("Dwarf "+newDwarf.getID()+" has been added to simulation!");
            }
            
            printToWriter("===================================================");
            printToWriter();
        }
        
        /**
         * Returns the total amount of Gold obtained in a simulation 
         *  
         *  @return int value of total amount of Gold obtained in a simulation 
         */
        public static int getTotalGold(){
            return totalGold;
        }
        
        /**
         * Enables next-Dwarf-in-queue to crawl over map and take actions.
         * 
         * @param canvas input to update movement of Dwarfs.
         * @param int setGUI to choose if GUI should be on or off
         */
        public static void goDwarfs(SimulationController canvas, int setGUI){
            Dwarf dwarf = dwarfQueue.poll();
            simulator = canvas;
            printToWriter("Dwarf "+dwarf.getID()+" about to go!");
            dwarf.go();
            int initDiff = dwarf.getDiff();
            diffArray.remove(Integer.valueOf(initDiff));
            printToWriter();
            if(!dwarf.isDeleted()){
                dwarf.setDiff(diffArray.get(random.nextInt(diffArray.size())));
                nDwarfQueue.add(dwarf);
                diffArray.add(initDiff);
            }else{//Dwarf is dead
                dwarfData.set(dwarf.getID(),dwarf.getData());
            }
            
            if(canvas!=null && setGUI == 1) canvas.repaint();
            
            if(dwarfQueue.peek()==null){
                dwarfQueue = nDwarfQueue;
                nDwarfQueue = null;
                nDwarfQueue = new PriorityQueue<Dwarf>(1);
                printToWriter();
                printToWriter("All dwarfs completed task!");
                printToWriter("===================================================");
                printToWriter();
            }
        }
        
        /**
         * Prints data of individual dwarf into a .csv file.
         * 
         */
        public static void printDwarfData(){
            printToDataWriter("ID,Type,TotalGoldMined,Death,Time");
            for(int i=0;i<dwarfData.size();i++){
                String death = "Did not die";
                String function = null;
                int[] data = dwarfData.get(i);
                if(data[1]==1){
                    death = "River";
                }else if(data[1]==2){
                    death = "Lava";
                }else if(data[1]==3){
                    death = "Pit";
                }
                
                switch(data[2]){
                //1 is for blue(Searcher)
                case 1: function = "searcher";
                break;
                //2 is for Red(Digger)
                case 2: function = "digger";
                break;
                //3 is for Green(MinerBuilder)
                case 3: function = "minerBuilder";
                break;
                //4 is for Purple(SuperMiner)
                case 4: function = "superMiner";
                break;
                //5 is for Yellow(UltimateMiner)
                case 5: function = "ultimateMiner";
                break;
                default: function = "error";
            }
                
                printToDataWriter(i+","+function+","+data[0]+","+death+","+data[3]);
            }
        }
        
        /**
         * Draws Dwarf objects on map canvas
         * 
         * @param Graphics object that draws Dwarf objects
         */
        public static void paintDwarfs(Graphics g){
            for(Dwarf dwarf:dwarfQueue){
                //printToWriter("Dwarf "+dwarf.getID()+" about to be painted!");
                dwarf.paint(g);
            }
            for(Dwarf dwarf:nDwarfQueue){
                //printToWriter("Dwarf "+dwarf.getID()+" about to be painted!");
                dwarf.paint(g);
            }
        }
        
        /**
         * Writes text into log files
         * 
         * @param text to be written into log file
         */
        private static void printToWriter(String text){
            if(logWriter!=null) {
                logWriter.println(text);
            }
        }
        
        /**
         * Writes empty line into log files
         * 
         */
        private static void printToWriter(){
            if(logWriter!=null){
                logWriter.println();
            }
        }
        
        /**
         * Writes text into data files
         * 
         * @param text to be written into data file
         */
        private static void printToDataWriter(String text){
            if(dataWriter!=null) {
                dataWriter.println(text);
            }
        }
        
        /**
         * Writes empty line into data files
         * 
         */
        private static void printToDataWriter(){
            if(dataWriter!=null){
                dataWriter.println();
            }
        }
        
        /**
         * Performs afterwork of simulation. Collects all final data from Dwarf elements
         * 
         */
        public static void endSimulation(){
            while(!dwarfQueue.isEmpty()){
                Dwarf dwarf = dwarfQueue.poll();
                dwarfData.set(dwarf.getID(),dwarf.getData());
            }
            
            while(!nDwarfQueue.isEmpty()){
                Dwarf dwarf = nDwarfQueue.poll();
                dwarfData.set(dwarf.getID(),dwarf.getData());
            }
            printDwarfData();
            dataWriter.close();
        }
        
        /**
         * Gets the total number of Dwarf objects who died by the Pit feature 
         * 
         * @return int value of Dwarf objects terminated by the Pit feature of the Map
         */
        public static int getDiedByPit(){
            return diedByPit;
        }
        
        /**
         * Gets the total number of Dwarf objects who died by the Lava feature 
         * 
         * @return int value of Dwarf objects terminated by the Lava feature of the Map
         */
        public static int getDiedByLava(){
            return diedByLava;
        }
        
        /**
         * Gets the total number of Dwarf objects who died by the River feature 
         * 
         * @return int value of Dwarf objects terminated by the River feature of the Map
         */
        public static int getDiedByRiver(){
            return diedByRiver;
        }
        
        /**
         * Constructor for objects of class Dwarf
         */
        public Dwarf(int id, int diff, MapNode node, int type)
        {
            // initialise instance variables
            
            switch(type){
                //1 is for blue(Searcher)
                case 1: color = new Color(0,0,255); this.type = "searcher";
                break;
                //2 is for Red(Digger)
                case 2: color = new Color(255,0,0); this.type = "digger";
                break;
                //3 is for Green(MinerBuilder)
                case 3: color = new Color(0,255,0); this.type = "minerBuilder";
                break;
                //4 is for Purple(SuperMiner)
                case 4: color = new Color(255,0,255); this.type = "superMiner";
                break;
                //5 is for Yellow(UltimateMiner)
                case 5: color = new Color(255,255,0); this.type = "ultimateMiner";
                break;
                default: color = new Color(255,255,255); this.type = "error";
            }
            
            numType = type;
            totalGoldMined = 0;
            deathInt = 0;
            currPos = node;
            prevLoc.push(currPos);
            currPos.addDwarf(this);
            this.id = id;
            this.diff = diff;
            state = "stay";
            delete = false;
            for(int i=0;i<4;i++) edgeNodes.add(null);
            updatePos();
        }
        
        /**
         * Determines the state of the Dwarf object and executes action based on state (Moore's Machine implementation)
         *
         *
         */
        public void go()
        {
            if(this.getType().compareTo("searcher")==0){
                goSearcher();
            }else if(this.getType().compareTo("digger")==0){
                goDigger();
            }else if(this.getType().compareTo("minerBuilder")==0){
                goMinerBuilder();
            }else if(this.getType().compareTo("superMiner")==0){
                goSuperMiner();
            }else if(this.getType().compareTo("ultimateMiner")==0){
                goUltimateMiner();
            }
        }
        
        /**
         * Determines the state of the Dwarf object who is an Ultimate Miner and executes action based on state (Moore's Machine implementation)
         *
         *
         */
        public void goUltimateMiner()
        {
            String currString = currPos.toString();
            printToWriter("Dwarf "+this.getID()+" current position = "+currPos.toString());
            MapNode nextNode = null;
            
            //River feature implementation
            checkRiverFeature(currString);
            
            //Determine state
            if(currPos == null) state = "die"; //flowed out of map
            else if(currPos.getFeature().compareTo("lava")==0||currPos.getFeature().compareTo("pit")==0) state = "die";
            else if(currPos.getFeature().compareTo("gold")==0) state = "mine";
            else if(goldModeLoc != null) {
                nextNode = goldModeLoc;
                state = "goldMode";
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("rock")==0) {
                state = "digRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("rock")==0) {
                state = "digBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("rock")==0) {
                state = "digLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("rock")==0) {
                state = "digTop";
                nextNode = edgeNodes.get(3);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("pit")==0) {
                state = "buildRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("pit")==0) {
                state = "buildBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("pit")==0) {
                state = "buildLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("pit")==0) {
                state = "buildTop";
                nextNode = edgeNodes.get(3);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("tunnel")==0 && edgeNodes.get(1).beenPresent(this)==false) {
                state = "moveBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("tunnel")==0 && edgeNodes.get(0).beenPresent(this)==false) {
                state = "moveRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("tunnel")==0 && edgeNodes.get(2).beenPresent(this)==false) {
                state = "moveLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("tunnel")==0 && edgeNodes.get(3).beenPresent(this)==false) {
                state = "moveTop";
                nextNode = edgeNodes.get(3);
            }
            else {
                state = "stay";
            }
            
            
            //Determine output/action
            switch(state){
                case "mine": 
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs gold!");
                    dwarfNodeInteractGold();
                    break;
                case "die":
                    simulator.reduceReserve(CARRY_MAX*10);
                    this.delete = true;
                    if(currPos==null){
                        diedByRiver++;
                        deathInt = 1;
                    }
                    else if(currPos.getFeature().compareTo("lava")==0){
                        diedByLava++;
                        deathInt = 2;
                    }
                    else if(currPos.getFeature().compareTo("pit")==0){
                        diedByPit++;
                        deathInt = 3;
                    }
                    
                    if(currPos!=null){
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" falls into "+currPos.getFeature()+" and dies!");
                    }
                    else{
                       printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" flows off the map by River at "+currString+" and dies!"); 
                    }
                    break;
                case "goldMode":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" jumps at the shout at Searcher at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "digRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "buildRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "buildBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "buildLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "buildTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "moveRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;    
                case "moveBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                default:
                    MapNode prevPos = null;
                    if(!prevLoc.empty()){
                        prevPos = prevLoc.pop();
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" treks back. Moves from current position "+currPos.toString()+" to previous position "+prevPos.toString()+".");
                        currPos = prevPos;
                        updatePos();
                    }
                    else{
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" stays at current position "+currPos.toString()+".");
                    }
                    break;
            }
        }
        
        /**
         * Determines the state of the Dwarf object who is a SuperMiner and executes action based on state (Moore's Machine implementation)
         *
         *
         */
        public void goSuperMiner()
        {
            String currString = currPos.toString();
            printToWriter("Dwarf "+this.getID()+" current position = "+currPos.toString());
            MapNode nextNode = null;
            
            //River feature implementation
            checkRiverFeature(currString);
            
            //Determine state
            if(currPos == null) state = "die"; //flowed out of map
            else if(currPos.getFeature().compareTo("lava")==0||currPos.getFeature().compareTo("pit")==0) state = "die";
            else if(currPos.getFeature().compareTo("gold")==0) state = "mine";
            else if(goldModeLoc != null) {
                nextNode = goldModeLoc;
                state = "goldMode";
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("rock")==0) {
                state = "digRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("rock")==0) {
                state = "digBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("rock")==0) {
                state = "digLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("rock")==0) {
                state = "digTop";
                nextNode = edgeNodes.get(3);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).beenPresent(this)==false) {
                state = "moveBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).beenPresent(this)==false) {
                state = "moveRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).beenPresent(this)==false) {
                state = "moveLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).beenPresent(this)==false) {
                state = "moveTop";
                nextNode = edgeNodes.get(3);
            }
            else {
                state = "stay";
            }
            
            
            //Determine output/action
            switch(state){
                case "mine": 
                    //Super Miners dig gold twice
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs gold!");
                    dwarfNodeInteractGold();
                    break;
                case "die":
                    simulator.reduceReserve(CARRY_MAX*10);
                    this.delete = true;
                    if(currPos==null){
                        diedByRiver++;
                        deathInt = 1;
                    }
                    else if(currPos.getFeature().compareTo("lava")==0){
                        diedByLava++;
                        deathInt = 2;
                    }
                    else if(currPos.getFeature().compareTo("pit")==0){
                        diedByPit++;
                        deathInt = 3;
                    }
                    
                    if(currPos!=null){
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" falls into "+currPos.getFeature()+" and dies!");
                    }
                    else{
                       printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" flows off the map by River at "+currString+" and dies!"); 
                    }
                    break;
                case "goldMode":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" jumps at the shout at Searcher at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "digRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "moveRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;    
                case "moveBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                default:
                    MapNode prevPos = null;
                    if(!prevLoc.empty()){
                        prevPos = prevLoc.pop();
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" treks back. Moves from current position "+currPos.toString()+" to previous position "+prevPos.toString()+".");
                        currPos = prevPos;
                        updatePos();
                    }
                    else{
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" stays at current position "+currPos.toString()+".");
                    }
                    break;
            }
        }
        
        
        /**
         * Determines the state of the Dwarf object who is a MinerBuilder and executes action based on state (Moore's Machine implementation)
         *
         *
         */
        public void goMinerBuilder()
        {
            String currString = currPos.toString();
            printToWriter("Dwarf "+this.getID()+" current position = "+currPos.toString());
            MapNode nextNode = null;
            
            //River feature implementation
            checkRiverFeature(currString);
            
            //Determine state
            if(currPos == null) state = "die"; //flowed out of map
            else if(currPos.getFeature().compareTo("lava")==0||currPos.getFeature().compareTo("pit")==0) state = "die";
            else if(currPos.getFeature().compareTo("gold")==0) state = "mine";
            else if(goldModeLoc != null) {
                nextNode = goldModeLoc;
                state = "goldMode";
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("rock")==0) {
                state = "digRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("rock")==0) {
                state = "digBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("rock")==0) {
                state = "digLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("rock")==0) {
                state = "digTop";
                nextNode = edgeNodes.get(3);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("pit")==0) {
                state = "buildRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("pit")==0) {
                state = "buildBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("pit")==0) {
                state = "buildLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("pit")==0) {
                state = "buildTop";
                nextNode = edgeNodes.get(3);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("tunnel")==0 && edgeNodes.get(1).beenPresent(this)==false) {
                state = "moveBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("tunnel")==0 && edgeNodes.get(0).beenPresent(this)==false) {
                state = "moveRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("tunnel")==0 && edgeNodes.get(2).beenPresent(this)==false) {
                state = "moveLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("tunnel")==0 && edgeNodes.get(3).beenPresent(this)==false) {
                state = "moveTop";
                nextNode = edgeNodes.get(3);
            }
            else {
                state = "stay";
            }
            
            
            //Determine output/action
            switch(state){
                case "mine": 
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs gold!");
                    dwarfNodeInteractGold();
                    break;
                case "die":
                    simulator.reduceReserve(CARRY_MAX*10);
                    this.delete = true;
                    if(currPos==null){
                        diedByRiver++;
                        deathInt = 1;
                    }
                    else if(currPos.getFeature().compareTo("lava")==0){
                        diedByLava++;
                        deathInt = 2;
                    }
                    else if(currPos.getFeature().compareTo("pit")==0){
                        diedByPit++;
                        deathInt = 3;
                    }
                    
                    if(currPos!=null){
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" falls into "+currPos.getFeature()+" and dies!");
                    }
                    else{
                       printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" flows off the map by River at "+currString+" and dies!"); 
                    }
                    break;
                case "goldMode":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" jumps at the shout at Searcher at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "digRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "buildRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "buildBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "buildLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "buildTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" builds a bridge over pit at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractBuild(nextNode);
                    break;
                case "moveRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;    
                case "moveBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                default:
                    MapNode prevPos = null;
                    if(!prevLoc.empty()){
                        prevPos = prevLoc.pop();
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" treks back. Moves from current position "+currPos.toString()+" to previous position "+prevPos.toString()+".");
                        currPos = prevPos;
                        updatePos();
                    }
                    else{
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" stays at current position "+currPos.toString()+".");
                    }
                    break;
            }
        }
        
        
        /**
         * Determines the state of the Dwarf object who is a digger and executes action based on state (Moore's Machine implementation)
         *
         *
         */
        public void goDigger()
        {
            String currString = currPos.toString();
            printToWriter("Dwarf "+this.getID()+" current position = "+currPos.toString());
            MapNode nextNode = null;
            
            //River feature implementation
            checkRiverFeature(currString);
            
            //Determine state
            if(currPos == null) state = "die"; //flowed out of map
            else if(currPos.getFeature().compareTo("lava")==0||currPos.getFeature().compareTo("pit")==0) state = "die";
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("rock")==0) {
                state = "digRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("rock")==0) {
                state = "digBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("rock")==0) {
                state = "digLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("rock")==0) {
                state = "digTop";
                nextNode = edgeNodes.get(3);
            }
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("tunnel")==0 && edgeNodes.get(1).beenPresent(this)==false) {
                state = "moveBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("tunnel")==0 && edgeNodes.get(0).beenPresent(this)==false) {
                state = "moveRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("tunnel")==0 && edgeNodes.get(2).beenPresent(this)==false) {
                state = "moveLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("tunnel")==0 && edgeNodes.get(3).beenPresent(this)==false) {
                state = "moveTop";
                nextNode = edgeNodes.get(3);
            }
            else {
                state = "stay";
            }
            
            //Determine output/action
            switch(state){
                case "die":
                    simulator.reduceReserve(0);
                    this.delete = true;
                    if(currPos==null){
                        diedByRiver++;
                        deathInt = 1;
                    }
                    else if(currPos.getFeature().compareTo("lava")==0){
                        diedByLava++;
                        deathInt = 2;
                    }
                    else if(currPos.getFeature().compareTo("pit")==0){
                        diedByPit++;
                        deathInt = 3;
                    }
                    
                    if(currPos!=null){
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" falls into "+currPos.getFeature()+" and dies!");
                    }
                    else{
                       printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" flows off the map by River at "+currString+" and dies!"); 
                    }
                    break;
                case "digRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "digTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" digs through rock at "+nextNode.toString()+" and moves from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractDig(nextNode);
                    break;
                case "moveRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;    
                case "moveBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                default:
                    MapNode prevPos = null;
                    if(!prevLoc.empty()){
                        prevPos = prevLoc.pop();
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" treks back. Moves from current position "+currPos.toString()+" to previous position "+prevPos.toString()+".");
                        currPos = prevPos;
                        updatePos();
                    }
                    else{
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" stays at current position "+currPos.toString()+".");
                    }
                    break;
            }
        }
        
        
        
        /**
         * Determines the state of the Dwarf object who is a searcher and executes action based on state (Moore's Machine implementation)
         *
         *
         */
        public void goSearcher()
        {
            String currString = currPos.toString();
            printToWriter("Dwarf "+this.getID()+" current position = "+currPos.toString());
            MapNode nextNode = null;
            
            //River feature implementation
            checkRiverFeature(currString);
            
            //Determine state
            if(currPos == null) state = "die"; //flowed out of map
            else if(currPos.getFeature().compareTo("lava")==0||currPos.getFeature().compareTo("pit")==0) state = "die";
            else if(currPos.getFeature().compareTo("gold")==0) state = "shout";
            else if(edgeNodes.get(1)!=null && edgeNodes.get(1).getFeature().compareTo("tunnel")==0 && edgeNodes.get(1).beenPresent(this)==false) {
                state = "moveBottom";
                nextNode = edgeNodes.get(1);
            }
            else if(edgeNodes.get(0)!=null && edgeNodes.get(0).getFeature().compareTo("tunnel")==0 && edgeNodes.get(0).beenPresent(this)==false) {
                state = "moveRight";
                nextNode = edgeNodes.get(0);
            }
            else if(edgeNodes.get(2)!=null && edgeNodes.get(2).getFeature().compareTo("tunnel")==0 && edgeNodes.get(2).beenPresent(this)==false) {
                state = "moveLeft";
                nextNode = edgeNodes.get(2);
            }
            else if(edgeNodes.get(3)!=null && edgeNodes.get(3).getFeature().compareTo("tunnel")==0 && edgeNodes.get(3).beenPresent(this)==false) {
                state = "moveTop";
                nextNode = edgeNodes.get(3);
            }
            else {
                state = "stay";
            }
            
            //Determine output/action
            switch(state){
                case "die":
                    simulator.reduceReserve(0);
                    this.delete = true;
                    if(currPos==null){
                        diedByRiver++;
                        deathInt = 1;
                    }
                    else if(currPos.getFeature().compareTo("lava")==0){
                        diedByLava++;
                        deathInt = 2;
                    }
                    else if(currPos.getFeature().compareTo("pit")==0){
                        diedByPit++;
                        deathInt = 3;
                    }
                    
                    if(currPos!=null){
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" falls into "+currPos.getFeature()+" and dies!");
                    }
                    else{
                       printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" flows off the map by River at "+currString+" and dies!"); 
                    }
                    break;
                case "shout":
                    //Insert code
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" finds Gold at "+currString+" and inform nearby Dwarfs!"); 
                    for(int i = currPos.getX()-1;i<=currPos.getX()+1;i++){
                        for(int j = currPos.getY()-1;j<=currPos.getY()+1;j++){
                            if(map.get(i,j).containsMiners()){
                                map.get(i,j).informGold(currPos);
                            }
                        }
                    }
                    break;
                case "moveRight":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;    
                case "moveBottom":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveLeft":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                case "moveTop":
                    printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" moves into "+nextNode.getFeature()+" from "+currPos.toString()+" to "+nextNode.toString()+".");
                    dwarfNodeInteractMove(nextNode);
                    break;
                default:
                    MapNode prevPos = null;
                    if(!prevLoc.empty()){
                        prevPos = prevLoc.pop();
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" treks back. Moves from current position "+currPos.toString()+" to previous position "+prevPos.toString()+".");
                        currPos = prevPos;
                        updatePos();
                    }
                    else{
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" stays at current position "+currPos.toString()+".");
                    }
                    break;
            }
        }
        
        private void dwarfNodeInteractGold(){
            int init = totalGoldMined;
            totalGoldMined+=currPos.digGold();
            totalGoldMined+=currPos.digGold();
            totalGold += totalGoldMined-init;
            map.reduceGoldLeft();
        }
        
        private void dwarfNodeInteractMove(MapNode nextNode){
            currPos.removeDwarf(this);
            currPos = nextNode;
            prevLoc.push(currPos);
            currPos.addDwarf(this);
            updatePos();
        }
        
        private void dwarfNodeInteractBuild(MapNode nextNode){
            simulator.reduceReserve(5);
            currPos.removeDwarf(this);
            currPos = nextNode;
            currPos.buildBridge();
            prevLoc.push(currPos);
            currPos.addDwarf(this);
            updatePos();
        }
        
        private void dwarfNodeInteractDig(MapNode nextNode){
            currPos.removeDwarf(this);
            currPos = nextNode;
            currPos.dig();
            prevLoc.push(currPos);
            currPos.addDwarf(this);
            updatePos();
        }
        
        /**
         * Paints visualization of Dwarf object on canvas
         */
        public void paint(Graphics g) {
            g.setColor(dwarfColor);
            g.fillOval(vectorX-10,vectorY-10,20,20);
            g.setColor(color);
            g.fillOval(vectorX-5,vectorY-5,10,10);
            g.setColor(new Color(0,0,255));
            g.drawString(Integer.toString(this.getID()),vectorX-10, vectorY+10);
        }
    
        private void updatePos(){
            vectorX = 30*currPos.getX()+15;
            vectorY = 30*currPos.getY()+15;
        
            if(currPos.getY()>0){
                edgeNodes.set(3,map.get(currPos.getX(),currPos.getY()-1));//top
            }
            else edgeNodes.set(3,null);//top
        
            if(currPos.getX()>0){
                edgeNodes.set(2,map.get(currPos.getX()-1,currPos.getY()));//left
            }
            else edgeNodes.set(2,null);//left
        
            if(currPos.getX()<map.getWidth()-1){
                edgeNodes.set(0,map.get(currPos.getX()+1,currPos.getY()));//right
            }
            else edgeNodes.set(0,null);//right
        
            if(currPos.getY()<map.getHeight()-1){
                edgeNodes.set(1,map.get(currPos.getX(),currPos.getY()+1));//down
            }
            else edgeNodes.set(1,null);//down
        }
        
        /**
         * Returns the difference factor used to sort out Dwarf objects in a Queue 
         * 
         * @return difference factor of Dwarf object
         */
        public int getDiff(){
            return diff;
        }
        
        /**
         * Returns the ID of the Dwarf object
         * 
         * @return ID of the Dwarf object
         */
        public int getID(){
            return id;
        }
        
        /**
         * Sets the difference factor used to sort out Dwarf objects in a Queue 
         * 
         * @param difference factor of Dwarf object
         */
        public void setDiff(int value){
            diff = value;
        }
        
        /**
         * Returns true if Dwarf object has been terminated in the simulation
         * 
         * @return boolean value determining the existence of object in Simulation
         */
        public boolean isDeleted(){
            return delete;
        }
        
        /**
         * Returns the total amount of gold mined by the Dwarf object
         * 
         * @return amount of treasure carried by Dwarf object
         */
        public int getCarry(){
            return totalGoldMined;
        }
        
        /**
         * Returns the current postion of the Dwarf object
         * 
         * @return Position of the Dwarf object
         */
        public String getPos(){
            return currPos.toString();
        }
        
        /**
         * Returns the total data of Dwarf (Total number of Gold mined and way of death)
         * 
         * @return int array containing total number of gold mined and integer indicating way of death
         */
        public int[] getData(){
            int [] output = new int[4];
            output[0] = totalGoldMined;
            output[1] = deathInt;
            output[2] = numType;
            output[3] = GlobalClock.time();
            return output;
        }
        
        /**
         * Returns the type of Dwarf of the Dwarf object
         * 
         * @return String type of Dwarf
         */
        public String getType(){
            return type;
        }
        
        /**
         * Sets the gold location to arrive to during Gold Mode
         * 
         */
        public void setGoldLoc(MapNode node){
            goldModeLoc = node;
        }
        
        /**
         * Returns the gold location to arrive to during Gold Mode
         * 
         */
        public MapNode getGoldLoc(){
            return goldModeLoc;
        }
        
        private void checkRiverFeature(String currString){
            if(currPos.getFeature().compareTo("water")==0){
                //Delete previous locations to prevent teleporting when treking back
                while(!prevLoc.empty()){
                    prevLoc.pop();
                }
                
                for(int i=0;i<3;i++){
                    MapNode link = currPos.getLink();
                    if(link!=null){
                        String feature = link.getFeature();
                        if(feature.compareTo("water")==0){
                            currPos = link;
                            updatePos();
                        }
                    }
                    else{
                        currPos = null;
                        break;
                    }
                }
                if(currPos!=null){
                        printToWriter("Dwarf "+this.getID()+"("+this.getType()+")"+" flows down River from "+currString+" to "+currPos.toString());
                    }
            }
        }
        
        
        /**
         * Compares two Dwarf objects based on difference factor
         * Returns the current postion of the Dwarf object
         * @param Dwarf object to be compared to object
         * @return difference in the difference factor of the input Dwarf object
         */
        @Override
        public int compareTo(Dwarf object){
            return (int) (diff - object.getDiff());
        }
}
