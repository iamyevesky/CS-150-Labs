import java.util.*;
/**
 * Represents a passenger in the rideshare simulation.
 *
 * @author Sena Yevenyo
 * @version December 2, 2019
 */
public class Passenger
{
    private static ArrayList<Integer> waitTime;
    private static ArrayList<Integer> tripTime;
    private static ArrayList<Float> satisfactionArray;
    private float satisfaction;
    private int startWaitTime;
    private int id;
    private int endWaitTime;
    private int startTripTime;
    private int endTripTime;
    private int eta;
    private Driver driver;
    private Node currentNode;
    private Node destination;
    
    /**
     * Initializes arrays for class level data collection
     */
    public static void initClass(){
        waitTime = new ArrayList<Integer>();
        tripTime = new ArrayList<Integer>();
        satisfactionArray = new ArrayList<Float>();
    }
    
    /**
     * Returns the number of Passenger objects used in simulation
     * 
     * @return the number of Passenger objects used in simulation
     */
    public static int getNumOfPassengers(){
        return waitTime.size();
    }
    
    /**
     * Returns the average trip time of Driver objects used in simulation
     * 
     * @return the average trip time of Driver objects used in simulation
     */
    public static float getAverageTripTime(){
        float sum = 0;
        for(int i=0;i<tripTime.size();i++){
            sum+=tripTime.get(i);
        }
        return sum/(float)tripTime.size();
    }
    
    /**
     * Returns the minimum trip time of Driver objects used in simulation
     * 
     * @return the minimum trip time of Driver objects used in simulation
     */
    public static int getMinTripTime(){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<tripTime.size();i++){
            if(min>tripTime.get(i)){
                min = tripTime.get(i);
            }
        }
        return min;
    }
    
    /**
     * Returns the maximum trip time of Driver objects used in simulation
     * 
     * @return the maximum trip time of Driver objects used in simulation
     */
    public static int getMaxTripTime(){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<tripTime.size();i++){
            if(max<tripTime.get(i)){
                max = tripTime.get(i);
            }
        }
        return max;
    }
    
    /**
     * Returns the average wait time of Passenger objects used in simulation
     * 
     * @return the average wait time of Passenger objects used in simulation
     */
    public static float getAverageWaitTime(){
        float sum = 0;
        for(int i=0;i<waitTime.size();i++){
            sum+=waitTime.get(i);
        }
        return sum/(float)waitTime.size();
    }
    
    /**
     * Returns the minimum wait time of Passenger objects used in simulation
     * 
     * @return the minimum wait time of Passenger objects used in simulation
     */
    public static int getMinWaitTime(){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<waitTime.size();i++){
            if(min>waitTime.get(i)){
                min = waitTime.get(i);
            }
        }
        return min;
    }
    
    /**
     * Returns the maximum wait time of Passenger objects used in simulation
     * 
     * @return the maximum wait time of Passenger objects used in simulation
     */
    public static int getMaxWaitTime(){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<waitTime.size();i++){
            if(max<waitTime.get(i)){
                max = waitTime.get(i);
            }
        }
        return max;
    }
    
    /**
     * Returns the average satisfaction of Passenger objects used in simulation
     * 
     * @return the average satisfaction of Passenger objects used in simulation
     */
    public static float getAverageSatisfaction(){
        float sum = 0;
        for(int i=0;i<satisfactionArray.size();i++){
            sum+=satisfactionArray.get(i);
        }
        return sum/(float)satisfactionArray.size();
    }
    
    /**
     * Returns the minimum satisfaction of Passenger objects used in simulation
     * 
     * @return the minimum satisfaction of Passenger objects used in simulation
     */
    public static float getMinSatisfaction(){
        float min = Integer.MAX_VALUE;
        for(int i=0;i<satisfactionArray.size();i++){
            if(min>satisfactionArray.get(i)){
                min = satisfactionArray.get(i);
            }
        }
        return min;
    }
    
    /**
     * Returns the maximum satisfaction of Passenger objects used in simulation
     * 
     * @return the maximum satisfaction of Passenger objects used in simulation
     */
    public static float getMaxSatisfaction(){
        float max = Integer.MIN_VALUE;
        for(int i=0;i<satisfactionArray.size();i++){
            if(max<satisfactionArray.get(i)){
                max = satisfactionArray.get(i);
            }
        }
        return max;
    }
    
    /**
     * Constructor for objects of class Passenger
     * @param Node currentNode - location of Customer object
     * @param Node destination - location of destination
     * @param Driver driver - Driver of passenger
     */
    public Passenger(Node currentNode, Node destination, Driver driver)
    {
        this.currentNode = currentNode;
        this.destination = destination;
        this.driver = driver;
        this.id = driver.getID();
        satisfaction = (float) 5.0;
    }
    
    /**
     * Returns the Driver object for the Passenger object 
     *
     * @return the Driver object for the Passenger object
     */
    public Driver getDriver(){
        return driver;
    }
    
    /**
     * Returns the location of the passenger 
     *
     * @return the location of the passenger
     */
    public Node getLoc(){
        return currentNode;
    }
    
    /**
     * Returns the destination of the passenger 
     *
     * @return the destination of the passenger
     */
    public Node getDestination(){
        return destination;
    }
    
    /**
     * Calculates the estimated time arrival of the passenger 
     *
     * @param Network network - Road network the Driver object belongs
     */
    public void calculateETA(Network network){
        eta = network.getETA(currentNode.getID(), network.dijkstra(currentNode.getID(), destination.getID()));
    }
    
    /**
     * Returns the estimated time arrival of the passenger 
     *
     * @return the estimated time arrival of the passenger
     */
    public int getETA(){
        return eta;
    }
    
    /**
     * Records the time the passenger object begins to wait 
     *
     */
    public void startWait(){
        startWaitTime = GlobalClock.time();
    }
    
    /**
     * Records the time the passenger object ends their wait 
     *
     */
    public void endWait(){
        endWaitTime = GlobalClock.time();
    }
    
    /**
     * Records the time the passenger object starts the wait 
     *
     */
    public void startTrip(){
        startTripTime = GlobalClock.time();
    }
    
    /**
     * Records the time the passenger object ends their wait 
     *
     */
    public void endTrip(){
        endTripTime = GlobalClock.time();
    }
    
    public void sampleData(){
        waitTime.add(endWaitTime - startWaitTime);
        tripTime.add(endTripTime - startTripTime);
        int timeForTrip = endTripTime - startTripTime - eta;
        int timeForWait = endWaitTime - startWaitTime;
        //Calculate satisfaction
        if(timeForWait>5 && timeForWait<=15){
           satisfaction-=0.25; 
        }
        else if(timeForWait>15 && timeForWait<=30){
            satisfaction-=1.5;
        }
        else if(timeForWait>30 && timeForWait<=50){
            satisfaction-=3;
        }
        else if(timeForWait>50){
            satisfaction-=5;
        }
        
        if(timeForTrip>5 && timeForTrip<=15){
           satisfaction-=1; 
        }
        else if(timeForTrip>15 && timeForTrip<=30){
            satisfaction-=2;
        }
        else if(timeForTrip>30 && timeForTrip<=50){
            satisfaction-=3;
        }
        else if(timeForTrip>50){
            satisfaction-=5;
        }
        
        if(satisfaction<0){
            satisfaction = 0;
        }
        
        satisfactionArray.add(satisfaction);
    }
    
    /**
     * Returns the wait time of the passenger 
     *
     * @return the wait time of the passenger
     */
    public int getWaitTime(){
        return endWaitTime-startWaitTime;
    }
    
    /**
     * Returns the trip time of the passenger 
     *
     * @return the trip time of the passenger
     */
    public int getTripTime(){
        return endTripTime - startTripTime;
    }
    
    /**
     * Returns the satisfaction of the passenger 
     *
     * @return the satisfaction of the passenger
     */
    public float getSatisfaction(){
        return satisfaction;
    }
}
