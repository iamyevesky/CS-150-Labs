
/**
 * A class that represents food
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Food
{
    // instance variables - replace the example below with your own
    protected int lowOrderNum = 0;
    protected int highOrderNum = 0;
    protected int cookTime = 0;
    protected float PRIZE = (float)0.00;
    /**
     * Constructor for objects of class Food
     */
    public Food()
    {
        
    }

    /**
     * Returns the lowest possible order num for the food
     *
     */
    public int getLOrderNum()
    {
        // put your code here
        return lowOrderNum;
    }
    
    /**
     * Returns the highest possible order num for the food
     *
     * @return highOrderNum highest possible order num for the food
     */
    public int getHOrderNum()
    {
        // put your code here
        return highOrderNum;
    }
    
    /**
     * Returns the prize of the meal
     *
     * @return prize of the food class
     */
    public float getPrize()
    {
        // put your code here
        return PRIZE;
    }
    
    /**
     * Returns the cook time of the meal
     *
     * @return cook time of the food class
     */
    public int getCookTime()
    {
        // put your code here
        return cookTime;
    }
}
