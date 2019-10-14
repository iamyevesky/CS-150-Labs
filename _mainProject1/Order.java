
/**
 * A class that represents an order sheet in a restaurant.
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Order
{
    // instance variables - replace the example below with your own
    private int numOfOrders;
    private int maxNumOfOrders;
    private int doneOrders;
    private Food food;
    private int id;
    
    /**
     * Constructor for objects of class Order
     */
    public Order(int id, Food food, int orders)
    {
        // initialise instance variables
        this.food = food;
        this.id = id;
        this.maxNumOfOrders = orders;
        this.numOfOrders = maxNumOfOrders;
        doneOrders = 0;
    }

    /**
     * Returns number of orders left in an order
     *
     * @return number of orders on an order sheet
     */
    public int getNumOrder(){
        return numOfOrders;
    }
    
    /**
     * Returns number of orders in an order
     *
     * @return number of orders on an order sheet
     */
    public int getMaxNumOrder(){
        return maxNumOfOrders;
    }
    
    /**
     * Returns food on an order
     *
     * @return number of orders in an order sheet
     */
    public Food getFood(){
        return food;
    }
    
    /**
     * Sets number of orders in an order
     *
     * @param y number of orders on an order sheet
     */
    public void setNumOrder(int y){
        numOfOrders = y;
    }
    
    /**
     * Executes the cooking of one meal on an order sheet.
     *
     * @return number of orders in an order sheet
     */
    public Food getFoodExecute(){
        //Reduce amount of food left to cook
        //Return food
        numOfOrders--;
        return food;
    }
    
    /**
     * Returns true if order has been received by restaurant and starts making the order.
     *
     * @return boolean value showing if an order has been received.
     */
    public boolean isReceived(){
        return numOfOrders==0;
    }
    
    /**
     * Updates order if a meal part of the order has been completed 
     *
     */
    public void updateOrder(){
        doneOrders++;
    }
    
    /**
     * Returns true if order has been completed by restaurant and food is done.
     *
     * @return boolean value showing if an order has been completed.
     */
    public boolean isDone(){
        return doneOrders>=maxNumOfOrders;
    }
    
    /**
     * Returns ID of order (Same as the ID Customer who made the order) 
     *
     * @return ID of the order
     */
    public int getID(){
        return id;
    }
}
