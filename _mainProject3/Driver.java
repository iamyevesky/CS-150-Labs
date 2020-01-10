import java.util.*;
/**
 * Represents a driver in the rideshare app network simulation.
 *
 * @author Sena Yevenyo
 * @version December 2, 2019
 */
public class Driver
{
    // instance variables - replace the example below with your own
    private static Driver [] driverList;
    private static Network network;
    private static Random classRandom = new Random();
    private static int lostCustomers;
    
    private int id;
    private Random random;
    private Deque path;
    private String state;
    private String prevState;
    private int betweenTraversal;
    private ArrayList<Float> satisfaction;
    private ArrayList<Integer> tripTime;
    private ArrayList<Integer> waitTime;
    private ArrayList<Integer> lateTime;
    private int numOfPassengers;
    private int travelDistance;
    private Node current;
    private Node next;
    private Passenger passenger;
    
    private boolean available;
    private boolean assigned;
    private boolean pickedUp;
    private boolean utilized;
    
    
    /**
     * Initilaizes the class level network for class level interaction for simulation
     *
     * @param Network roadNetwork - network system for all Drivers in simulation
     */
    public static void initNetwork(Network roadNetwork){
        network = roadNetwork;
    }
    
    /**
     * Initilaizes the Driver objects used in simulation
     *
     * @param int numOfDrivers - number of Drivers used in sumulation
     */
    public static void initDrivers(int numOfDrivers){
        driverList = new Driver[numOfDrivers];
        lostCustomers = 0;
        for(int i=0;i<driverList.length;i++){
            driverList[i] = new Driver(i, network.getNode(classRandom.nextInt(network.getSize())));
        }
    }
    
    /**
     * Returns the number of Driver objects used in simulation
     * 
     * @return the number of Driver objects used in simulation
     */
    public static int getNumOfDrivers(){
        return driverList.length;
    }
    
    /**
     * Returns the fraction of Driver objects utilized in simulation
     * 
     * @return the fraction of Driver objects utilized in simulation
     */
    public static float getUtilizedFraction(){
        float sum = 0;
        for(int i=0;i<driverList.length;i++){
            if(driverList[i].utilized()){
                sum++;
            }
        }
        return sum/(float)driverList.length;
    }
    
    /**
     * Returns the average distance of Driver objects used in simulation
     * 
     * @return the average distance of Driver objects used in simulation
     */
    public static float getAverageDistanceTravelled(){
        float sum = 0;
        for(int i=0;i<driverList.length;i++){
            sum+=driverList[i].getDistanceTravelled();
        }
        return sum/(float)driverList.length;
    }
    
    /**
     * Returns the minimum distance of Driver objects used in simulation
     * 
     * @return the minimum distance of Driver objects used in simulation
     */
    public static int getMinimumDistanceTravelled(){
        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<driverList.length;i++){
            if(minimum>driverList[i].getDistanceTravelled()){
                minimum = driverList[i].getDistanceTravelled();
            }
        }
        return minimum;
    }
    
    /**
     * Returns the maximum distance of Driver objects used in simulation
     * 
     * @return the maximum distance of Driver objects used in simulation
     */
    public static int getMaximumDistanceTravelled(){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<driverList.length;i++){
            if(max<driverList[i].getDistanceTravelled()){
                max = driverList[i].getDistanceTravelled();
            }
        }
        return max;
    }
    
    
    /**
     * Assigns customers to available Driver objects at a specific distance in simulation
     * depending on a probability value
     * 
     * @param float prob - probability value that determines if a Passenger will be assigned to a Driver object or not.
     * @param int distance - Distance the Driver object has to cover for each task which are
     * from getting from its current location to the passenger's location and
     * getting from passenger's location to the passenger's destination
     */
    public static int assignCustomers(float prob, int distance){
        int assigned = 0;
        for(int i=0;i<driverList.length;i++){
            if(classRandom.nextDouble()<prob){
                if(driverList[i].isAvailable()){
                    Node driverLoc = driverList[i].getLoc();
                    Node passengerLoc = network.getNodeAtBreadth(driverLoc.getID(),distance);
                    Node destination = network.getNodeAtBreadth(passengerLoc.getID(),distance);
                    driverList[i].setCustomer(new Passenger(passengerLoc, destination, driverList[i]));
                    assigned++;
                }else{
                    lostCustomers++;
                }
            }
        }
        return assigned;
    }
    
    /**
     * Executes the state system function that determines the action of all Driver objects in simulation
     *
     */
    public static void goDrivers(){
        for(int i=0;i<driverList.length;i++){
            driverList[i].go(network);
        }
    }
    
    /**
     * Returns the average of the total satisfaction of all Drivers in the simulation.
     * 
     * @return the average of the total satisfaction of all Drivers in the simulation.
     */
    public static float getAvgLateTime(){
        float sum = 0;
        for(int i=0;i<driverList.length;i++){
            sum+=driverList[i].getLateTime();
        }
        return sum/driverList.length;
    }
    
    public static int getLostCustomers(){
        return lostCustomers;
    }
    
    /**
     * Constructor for objects of class Driver
     * @param int id - unique int ID of the Driver object
     * @param Node location - initial location of object in network
     */
    public Driver(int id, Node location)
    {
        current = location;
        random = new Random();
        this.id = id;
        satisfaction = new ArrayList<Float>();
        tripTime = new ArrayList<Integer>();
        waitTime = new ArrayList<Integer>();
        lateTime = new ArrayList<Integer>();
        available = true;
        utilized = false;
        state = "notMoving";
    }

    /**
     * Returns the ID of the Driver object
     *
     * @return a unique int ID of the Driver object
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * Returns the availability of Driver object
     *
     * @return the availability of Driver object
     */
    public boolean isAvailable()
    {
        return available;
    }
    
    /**
     * Returns true if the Driver object was used in the simulation
     *
     * @return true if the Driver object was used in the simulation
     */
    public boolean utilized()
    {
        return utilized;
    }
    
    /**
     * Sets the passenger object for the Driver object
     *
     * @param Passeger passeger - passenger object for the Driver object
     */
    public void setCustomer(Passenger passenger){
        this.passenger = passenger;
        this.passenger.startWait();
        available = false;
        assigned = true;
        utilized = true;
        Data.logPrintln("Driver "+this.getID()+" has been assigned a new customer");
    }
    
    /**
     * Gets the passenger object for the Driver object
     *
     * @return the passenger object for the Driver object
     */
    public Passenger getCustomer(){
        return passenger;
    }
    
    /**
     * Returns the current location of the Driver object
     *
     * @return the current location of the Driver object
     */
    public Node getLoc(){
        return current;
    }
    
    /**
     * Returns the time spent in traversing between two nodes location of the Driver object
     *
     * @return the time spent in traversing between two nodes in the road network
     */
    public int getTimeBetweenTraversal(){
        return betweenTraversal;
    }
    
    /**
     * Returns the next destination location of the Driver object
     *
     * @return the next destination location of the Driver object
     */
    public Node getNext(){
        return next;
    }
    
    /**
     * Returns the total distance travelled by Driver object
     *
     * @return the total distance travelled by Driver object
     */
    public int getDistanceTravelled(){
        return travelDistance;
    }
    
    /**
     * Returns the average late time of the Driver object
     *
     * @return the average late time of the Driver object
     */
    public float getLateTime(){
        float sum = 0;
        for(int i=0;i<lateTime.size();i++){
            sum+=lateTime.get(i);
        }
        return sum/(float)lateTime.size();
    }
    
    /**
     * State system that determines the action of the Driver object based on current and previous states
     *
     * @param Network network - Road network the Driver object belongs
     */
    public void go(Network network){
        if(available && state.compareTo("notMoving")==0){
            Node [] possibleNodes = network.getNeighbours(current.getID());
            next = possibleNodes[random.nextInt(possibleNodes.length)];
            Data.logPrintln("Driver "+this.getID()+" is available and at "+current.getID());
            Data.logPrintln("Driver "+this.getID()+" next location is vertex "+next.getID());
            state = "moving";
            prevState = "notMoving";
        }
        else if(available && state.compareTo("moving")==0){
            //Continue
        }
        else if(assigned && state.compareTo("notMoving")==0){
            path = network.dijkstra(current.getID(),passenger.getLoc().getID());
            next = (Node) path.poll();
            state = "movingToCustomer";
            prevState = "notMoving";
            Data.logPrintln("Driver "+this.getID()+" is assigned and at "+current.getID());
            Data.logPrintln("Driver "+this.getID()+" next location is vertex "+next.getID());
        }
        else if(assigned && state.compareTo("moving")==0){
            int weight = network.getTimeTraversal(current.getID(), next.getID());
            if(betweenTraversal>=((float)weight/2.0)){
                state = "movingToCustomer";
                prevState = "moving";
            }
            else{
                state = "moveBack";
                prevState = "moving";
            }
            Data.logPrintln("Driver "+this.getID()+" is assigned and at "+current.getID()+" but moving towards "+next.getID());
            if(state.compareTo("moveBack")==0){
                Data.logPrintln("Driver "+this.getID()+" decides to move back");
            }
            else{
                Data.logPrintln("Driver "+this.getID()+" decides to keep "+state);
            }
        }
        else if(assigned && state.compareTo("moveBack")==0){
            //Continue
        }
        else if(assigned && state.compareTo("movingToCustomer")==0){
            //Continue
        }
        else if(assigned && state.compareTo("arrived")==0){
            path = network.dijkstra(current.getID(),passenger.getDestination().getID());
            assigned = false;
            pickedUp = true;
            next = (Node) path.poll();
            state = "movingToDestination";
            prevState = "arrived";
            passenger.endWait();
            passenger.calculateETA(network);
            passenger.startTrip();
            Data.logPrintln("Driver "+this.getID()+"has arrived at Passenger location at "+current.getID()+" and begins trip");
            Data.logPrintln("Driver "+this.getID()+" next location is vertex "+next.getID());
        }
        else if(pickedUp && state.compareTo("notMoving")==0){
            path = network.dijkstra(current.getID(),passenger.getDestination().getID());
            next = (Node) path.poll();
            state = "movingToDestination";
            prevState = "notMoving";
            Data.logPrintln("Driver "+this.getID()+" has picked up passenger and currently at "+current.getID());
            Data.logPrintln("Driver "+this.getID()+" next location is vertex "+next.getID());
        }
        else if(pickedUp && state.compareTo("movingToDestination")==0){
            //Continue
        }
        else if(pickedUp && state.compareTo("tripDone")==0){
            state = "notMoving";
            pickedUp = false;
            available = true;
            prevState = "tripDone";
            passenger.endTrip();
            passenger.sampleData();
            satisfaction.add(passenger.getSatisfaction());
            tripTime.add(passenger.getTripTime());
            waitTime.add(passenger.getWaitTime());
            lateTime.add(passenger.getTripTime()-passenger.getETA());
            Data.logPrintln("Driver "+this.getID()+" has completed trip and dropped off passenger at "+current.getID());
        }
        
        switch(state){
            case "moving":
                betweenTraversal++;
                if(betweenTraversal>=network.getTimeTraversal(current.getID(), next.getID())){
                    Data.logPrintln("Driver "+this.getID()+" successfully moves to "+next.getID()+" from "+current.getID());
                    betweenTraversal = 0;
                    current = next;
                    next = null;
                    state = "notMoving";
                    prevState = "moving";
                    travelDistance++;
                }
                
                if(next != null){
                    Data.logPrintln("Driver "+this.getID()+" moves one step towards "+next.getID());
                    Data.logPrintln("Time left: "+(network.getTimeTraversal(current.getID(), next.getID())-betweenTraversal));
                }
                
                break;
            case "moveBack":
                betweenTraversal--;
                if(betweenTraversal==0){
                    state = "notMoving";
                    prevState = "moveBack";
                    Data.logPrintln("Driver "+this.getID()+" successfully moves back to "+current.getID());
                }
                Data.logPrintln("Driver "+this.getID()+" is assigned and moves one step back towards "+current.getID());
                Data.logPrintln("Time left: "+betweenTraversal);
                break;
            case "movingToCustomer":
                betweenTraversal++;
                if(betweenTraversal>=network.getTimeTraversal(current.getID(), next.getID())){
                    Data.logPrintln("Driver "+this.getID()+" successfully moves to "+next.getID()+" from "+current.getID());
                    betweenTraversal = 0;
                    current = next;
                    next = null;
                    state = "notMoving";
                    prevState = "moving";
                }
                
                if(current.getID() == passenger.getLoc().getID()){
                    Data.logPrintln("Driver "+this.getID()+" has arrived to Passenger's location");
                    state = "arrived";
                    prevState = "moving";
                }
                
                if(next != null){
                    Data.logPrintln("Driver "+this.getID()+" moves towards passenger by one step to "+next.getID());
                    Data.logPrintln("Time left: "+(network.getTimeTraversal(current.getID(), next.getID())-betweenTraversal));
                }
                
                break;
            case "movingToDestination":
                betweenTraversal++;
                if(betweenTraversal>=network.getTimeTraversal(current.getID(), next.getID())){
                    Data.logPrintln("Driver "+this.getID()+" successfully moves to "+next.getID()+" from "+current.getID());
                    betweenTraversal = 0;
                    current = next;
                    next = null;
                    state = "notMoving";
                    prevState = "movingToDestination";
                    travelDistance++;
                }
                
                if(current.getID() == passenger.getDestination().getID()){
                    Data.logPrintln("Driver "+this.getID()+" has arrived to Passenger's destination");
                    state = "tripDone";
                    prevState = "movingToDestination";
                }
                
                if(next != null){
                    Data.logPrintln("Driver "+this.getID()+" moves towards destination by one step to "+next.getID());
                    Data.logPrintln("Time left: "+(network.getTimeTraversal(current.getID(), next.getID())-betweenTraversal));
                }
                break;
            default:
                //Do nothing
        }
    }
}
