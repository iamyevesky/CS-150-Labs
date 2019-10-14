
/**
 * A class that represents a pizza meal
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Pizza extends Food
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Pizza
     */
    public Pizza()
    {
        lowOrderNum = 1;
        highOrderNum = 2;
        cookTime = 12;
        PRICE = (float)10.00;
    }
    
    public String toString(){
        return "Pizza";
    }
}
