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
    private Food foodToOrder;
    private int numOfOrders;
    private float satisfaction;
    private float timeSpent;
    private boolean orderDone;
    private Random random = new Random();
    /**
     * Constructor for objects of class Customer
     */
    public Customer(int id, Food food)
    {
        this.id = id;
        foodToOrder = food;
        orderDone = false;
        Random random = new Random();
        numOfOrders = random.nextInt(food.getHOrderNum()-foodToOrder.getLOrderNum()+1)+foodToOrder.getLOrderNum();
        satisfaction = (float)100.0;
        timeSpent = 0;
    }

    /**
     * Returns food order by customer
     *
     * @return Food food to order
     */
    public Food getFood()
    {
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
        float [] data = new float[3];
        data[0] = satisfaction;
        data[1] = timeSpent;
        data[2] = numOfOrders;
        return data;
    }
}
