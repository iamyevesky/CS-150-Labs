import java.util.*;
/**
 * A class that represents the functioning of a cashier in a fast food restaurant.
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Cashier
{
    // instance variables
    public final static float SALARY = (float) 7.50;
    private boolean available;
    private int id;
    private int customersCheckedOut;
    private ArrayList<Float> timeArray;
    private ArrayList<Float> satisfactionArray;
    private ArrayList<Float> numOfOrdersArray;
    /**
     * Constructor for objects of class Cashier
     */
    public Cashier(int id)
    {
        // initialise instance variables
        this.id = id;
        timeArray = new ArrayList<Float>(0);
        satisfactionArray = new ArrayList<Float>(0);
        numOfOrdersArray = new ArrayList<Float>(0);
        customersCheckedOut = 0;
    }

    /**
     * Obtains customer satisfaction and wait-time of customer from entrance into the restaurant to 
     * the end of checkout.
     * 
     * @param float array length of two containing customer satisfaction and time spent.
     */
    public void getInfo(float[] array)
    {
        // put your code here
        satisfactionArray.add(array[0]);
        timeArray.add(array[1]);
        numOfOrdersArray.add(array[2]);
        customersCheckedOut++;
    }
}
