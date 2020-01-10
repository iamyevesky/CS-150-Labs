
/**
 * This class simulates the global time for the whole simulation.
 * Time is measured in 'ticks' or 'quants'.
 * One quant is teaken as 60 seconds in real world time.
 * Global time increases by one quant for every experiment loop.
 *
 * @author Sena Yevenyo
 * @version October 7, 2019.
 */
public class GlobalClock
{
    // instance variables - replace the example below with your own
    private static int time = 0;

    /**
     * Constructor for objects of class GlobalClock
     */
    public GlobalClock()
    {
        
    }

    /**
     * Returns the value of global time
     *
     * @return global quant time
     */
    public static int time()
    {
        // put your code here
        return time;
    }
    
    /**
     * Increases the time of the simulation
     * 
     */
    public static void tick(){
        time++;
    }
    
    /**
     * Resets the value of global time
     *
     */
    public static void reset()
    {
        // put your code here
        time = 0;
    }
    
    /**
     * Runs a single simulation for a specific amount of clock ticks
     * 
     * @param int time - Period of simulation in clock ticks
     * @param float prob - Probability at which new Passenegrs are added to simulation
     * @param Network network - Road network for simulation
     * @param int min - Minimum edge weight of simulation
     * @param int max - Maximum edge weight of simulation
     */
    public static void run(int time, float prob, int hops, Network network, int min, int max){
        while(GlobalClock.time()<time){
            Data.logPrintln("Time "+GlobalClock.time());
            Data.logPrintln("=======================");
            Data.logPrintln();
            if(GlobalClock.time()%60==0 && GlobalClock.time()!=0){
                network.updateNetwork();
                Data.logPrintln("Map updated");
            }
            Data.logPrint(Driver.assignCustomers(prob, hops)+"");
            Data.logPrintln(" drivers assigned");
            Driver.goDrivers();
            Data.logPrintln();
            Data.logPrintln("Time "+GlobalClock.time()+" event done");
            Data.logPrintln("=======================");
            Data.logPrintln();
            GlobalClock.tick();
        }
        GlobalClock.reset();
    }
}