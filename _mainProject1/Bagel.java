
/**
 * A class that represents a bagel meal
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Bagel extends Food
{
    /**
     * Constructor for objects of class Bagel
     */
    public Bagel()
    {
        lowOrderNum = 2;
        highOrderNum = 6;
        cookTime = 2;
        PRICE = (float)0.99;
    }
    
    public String toString(){
        return "Bagel";
    }
}
