import java.util.*;
/**
 * A class that simulates a customer in a restaurant.
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Customer
{
    // instance variables
    private int id;
    private float resStatus;
    private Food foodToOrder;
    private int numOfOrders;
    private float satisfaction;
    private int initTime;
    private int orderTime;
    private int checkoutTime;
    private float timeSpent;
    private boolean orderDone;
    private Random random = new Random();
    /**
     * Constructor for objects of class Customer
     */
    public Customer(int id, Food food, float isBusy)
    {
        this.id = id;
        foodToOrder = food;
        orderDone = false;
        Random random = new Random();
        numOfOrders = random.nextInt(food.getHOrderNum()-foodToOrder.getLOrderNum()+1)+foodToOrder.getLOrderNum();
        initTime = GlobalClock.time();
        resStatus = isBusy;
        satisfaction = (float)100.0;
    }

    /**
     * Returns food order by customer
     *
     * @return Food food to order
     */
    public Food getFood()
    {
        orderTime = GlobalClock.time();
        return foodToOrder;
    }
    
    /**
     * Returns food order by customer
     *
     * @return Food food to order
     */
    public int getID(){
        return id;
    }
    
    /**
     * Obtains order number from customer
     *
     * @return number of orders from customer
     */
    public int getOrderNum()
    {
        return numOfOrders;
    }
    
    /**
     * Enables the Customer object to receive order made.
     *
     */
    public void receiveOrder(){
        orderDone = true; 
    }
    
    /**
     * Obtains satisfaction,time spent and order number from customer
     *
     * @return number of orders from customer
     */
    public float[] checkout(){
        checkoutTime = GlobalClock.time();
        float [] data = new float[4];
        
        //Update satisfaction and time values
        int timeSpentToOrder = orderTime - initTime;
        int timeSpentWaitingForOrder = checkoutTime - orderTime;
        float satisfactionA = (float) 0.00;
        float satisfactionB = (float) 0.00;
        
        if(timeSpentToOrder<15)  satisfactionA = (float)0.50*((float) timeSpentToOrder);
        else satisfactionA = (float)1.00*((float) timeSpentToOrder);
        
        if(timeSpentWaitingForOrder<15)  satisfactionB =(float)0.25*((float)timeSpentWaitingForOrder);
        else satisfactionB = (float)0.50*((float)timeSpentWaitingForOrder);
        
        satisfaction = satisfaction - satisfactionA - satisfactionB;
        timeSpent = (float)(checkoutTime - initTime);
        
        data[0] = satisfaction;
        data[1] = timeSpent;
        data[2] = numOfOrders;
        data[3] = resStatus;
        return data;
    }
}
