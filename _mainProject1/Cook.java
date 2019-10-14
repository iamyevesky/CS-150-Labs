
/**
 * A class that represents the function of a cook in a restaurant.
 *
 * @author Sena Yevenyo
 * @version September 28, 2019
 */
public class Cook
{
    // instance variables
    public final static float SALARY = (float) 15.40;
    public static int numberOfCookObjects = 0;
    private boolean available;
    private boolean done;
    private int leftCookTime;
    private int id;
    private Food foodMade;
    /**
     * Constructor for objects of class Cook
     */
    public Cook(int id, Food food)
    {
        // initialise instance variables
        this.id = id;
        foodMade = food;
        available = true;
        done = false;
        leftCookTime = -1;
        numberOfCookObjects++;
    }
    
    /**
     * Obtains the total cost of Cook staff in the Restaurant 
     * at the end of the simulation
     * 
     * @return total cost of Cook objects utilization in restaurant.
     */
    public static float obtainCookCost(){
        return SALARY*((float) GlobalClock.time()/ (float) 60.0)* (float)numberOfCookObjects;
    } 
    
    /**
     * Checks if the cook is available to cook next meal or still cooking.
     *
     * @return the status of availability of the cook
     */
    public boolean checkAvailability()
    {
        return available;
    }
    
    /**
     * Continues the task the Cook object is currently undergoing. 
     *
     */
    public void cook(){
        if(leftCookTime>0) {
            leftCookTime--;
        }
        else if(leftCookTime == 0){
            done = true;
            available = true;
        }
    }   
    
    /**
     * Checks if the cook is done with current task.
     *
     * @return the status of availability of the cook
     */
    public boolean doneCooking(){
        return done;
    }
    
    /**
     * Returns cook's ID
     *
     * @return int ID, unique to Cook object
     */
    public int getID(){
        return id;
    }
    
    /**
     * Obtains meal to be made from order
     *
     * @param food to be made
     */
    public void getTask(Food food){
        leftCookTime = food.getCookTime();
        done = false;
        available = false;
    }
    
    /**
     * Resets the 'done' attribute of a Cook object 
     *
     */
    public void reset(){
        done = false;
    }
}
