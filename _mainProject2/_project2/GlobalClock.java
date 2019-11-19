
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
}
