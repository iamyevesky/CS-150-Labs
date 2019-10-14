import java.util.*;
/**
 * A class that represents the functioning of a cashier in a fast food restaurant.
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Cashier
{
    public final static float SALARY = (float) 7.50;
    public static int numberOfCashierObjects = 0;
    public static int customersCheckedOut = 0;
    public static ArrayList<Float> timeAverageArray = new ArrayList<Float>(0);
    public static ArrayList<Float> timeBusyArray = new ArrayList<Float>(0);
    public static ArrayList<Float> timeNormalArray = new ArrayList<Float>(0);
    public static ArrayList<Float> satisfactionAverageArray = new ArrayList<Float>(0);
    public static ArrayList<Float> satisfactionBusyArray = new ArrayList<Float>(0);
    public static ArrayList<Float> satisfactionNormalArray = new ArrayList<Float>(0);
    public static ArrayList<Float> numOfOrdersArray = new ArrayList<Float>(0);
    private boolean available;
    private int id;
    /**
     * Constructor for objects of class Cashier
     */
    public Cashier(int id)
    {
        this.id = id;
        numberOfCashierObjects++;
    }
    
    /**
     * Obtains the total cost of Cashier staff in the Restaurant 
     * at the end of the simulation
     * 
     * @return total cost of Cashier objects utilization in restaurant.
     */
    public static float obtainCashierCost(){
        return SALARY*((float)GlobalClock.time()/(float) 60.0)* (float)numberOfCashierObjects;
    }
    
    /**
     * Obtains customer satisfaction of all Customer objects from entrance into the restaurant to 
     * the end of checkout.
     * 
     * @return float of average customer satisfaction.
     */
    public static float obtainAverageSatisfaction(){
        float sum = 0;
        for(int i=0;i<satisfactionAverageArray.size();i++){
            sum+=satisfactionAverageArray.get(i);
        }
        return sum/(float) satisfactionAverageArray.size();
    }
    
    /**
     * Obtains customer satisfaction of all Customer objects from entrance into the restaurant to 
     * the end of checkout during busy time operation.
     * 
     * @return float of average customer satisfaction.
     */
    public static float obtainBusySatisfaction(){
        float sum = 0;
        for(int i=0;i<satisfactionBusyArray.size();i++){
            sum+=satisfactionBusyArray.get(i);
        }
        return sum/(float) satisfactionBusyArray.size();
    }
    
    /**
     * Obtains customer satisfaction of all Customer objects from entrance into the restaurant to 
     * the end of checkout during normal time operation.
     * 
     * @return float of average customer satisfaction.
     */
    public static float obtainNormalSatisfaction(){
        float sum = 0;
        for(int i=0;i<satisfactionNormalArray.size();i++){
            sum+=satisfactionNormalArray.get(i);
        }
        return sum/(float) satisfactionNormalArray.size();
    }
    
    /**
     * Obtains average wait-time of all Customer objects from entrance into the restaurant to 
     * the end of checkout.
     * 
     * @return float of average time spent.
     */
    public static float obtainAverageTimeSpent(){
        float sum = 0;
        for(int i=0;i<timeAverageArray.size();i++){
            sum+=timeAverageArray.get(i);
        }
        return sum/(float) timeAverageArray.size();
    }
    
    /**
     * Obtains average wait-time of all Customer objects from entrance into the restaurant to 
     * the end of checkout during busy time operation.
     * 
     * @return float of average time spent.
     */
    public static float obtainBusyTimeSpent(){
        float sum = 0;
        for(int i=0;i<timeBusyArray.size();i++){
            sum+=timeBusyArray.get(i);
        }
        return sum/(float) timeBusyArray.size();
    }
    
    /**
     * Obtains average wait-time of all Customer objects from entrance into the restaurant to 
     * the end of checkout during normal time operation.
     * 
     * @return float of average time spent.
     */
    public static float obtainNormalTimeSpent(){
        float sum = 0;
        for(int i=0;i<timeNormalArray.size();i++){
            sum+=timeNormalArray.get(i);
        }
        return sum/(float) timeNormalArray.size();
    }
    
    /**
     * Obtains the total amount of food ordered by Customer objects.
     * 
     * @return total num of orders.
     */
    public static int numOfOrders(){
        int sum = 0;
        for(int i=0;i<numOfOrdersArray.size();i++){
            sum+=numOfOrdersArray.get(i);
        }
        return sum;
    }
    
    /**
     * Obtains the total amount of Customer objects who checked out.
     * 
     * @return total num of Customer objects who checked out.
     */
    public static int numOfCustomersChecked(){
        return customersCheckedOut;
    }
    
    /**
     * Obtains customer satisfaction, wait-time and number of orders of a Customer object from entrance into the restaurant to 
     * the end of checkout.
     * 
     * @param float array length of two containing customer satisfaction, time spent and number of meals ordered.
     */
    public void getInfo(float[] array)
    {
        satisfactionAverageArray.add(array[0]);
        timeAverageArray.add(array[1]);
        
        if(array[3]== (float) 1.0){
            satisfactionBusyArray.add(array[0]);
            timeBusyArray.add(array[1]);
        } else{
            satisfactionNormalArray.add(array[0]);
            timeNormalArray.add(array[1]);
        }
        
        numOfOrdersArray.add(array[2]);
        customersCheckedOut++;
    }
}
