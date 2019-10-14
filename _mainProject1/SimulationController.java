import java.util.*;
/**
 * A mini-simulation that runs the program Restaurant
 *
 * @author Sena Yevenyo
 * @version October 4, 2019
 */
public class SimulationController
{
    private Restaurant resUnderTest;
    private Random random;
    private int startBusyTime;
    private int endBusyTime;
    private int simulationLength = 720;
    /**
     * Constructor for objects of class SimulationController
     */
    public SimulationController(String filename ,int val, int numberOfCashiers, int numOfCooks)
    {
        if(val == 1) resUnderTest = new Restaurant(filename, new Bagel(), numberOfCashiers, numOfCooks);
        else if(val==0) resUnderTest = new Restaurant(filename, new Hoagie(), numberOfCashiers, numOfCooks);
        else if(val==-1) resUnderTest = new Restaurant(filename, new Pizza(), numberOfCashiers, numOfCooks);
        random = new Random();
        startBusyTime = random.nextInt(simulationLength);
        endBusyTime = random.nextInt(simulationLength-startBusyTime)+startBusyTime+1;
    }

    /**
     * Main method of the program.
     * 
     * Runs a for loop simulating the GlobalClock.tick() in the final program.
     */
    public static void main(String args[]){
        String fileName = null;
        SimulationController simul = null;
        // System.out.println(args[0]);
        // System.out.println(args[1]);
        // System.out.println(args[2]);
        // System.out.println(args[3]);
        try{
            fileName = args[0];
            simul = new SimulationController(fileName,Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]));
        }catch(Exception e){
            System.err.println(e);
        }
        simul.run();
    }
    
    /**
     * Starts the simulation of the program
     * 
     * @param filename name of data file into which data is stored
     */
    public void run(){
        while(GlobalClock.time()<simulationLength){//Quant 720 equals 12 hours in real time
            //System.out.println(GlobalClock.time());
            resUnderTest.receiveCustomers(getCustomerNumber(GlobalClock.time()), isBusySession(GlobalClock.time()));
            resUnderTest.acceptOrders();
            resUnderTest.cookMeals();
            resUnderTest.receiveDoneOrders();
            resUnderTest.executeOrders();
            resUnderTest.checkout();
            GlobalClock.tick();
        }
        resUnderTest.readWriteSimulationData();
    }
    
    private int getCustomerNumber(int value){
        if(value<startBusyTime || value> endBusyTime) return random.nextInt(2);
        else return random.nextInt(5)+3;
    }
    
    private float isBusySession(int value){
        if(value<startBusyTime || value> endBusyTime) return (float) 0.0;
        else return (float) 1.0;
    }
}
