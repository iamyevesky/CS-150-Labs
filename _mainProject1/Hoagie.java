
/**
 * A class that represents a hoagie meal
 *
 * @author Sena Yevenyo
 * @version September 29, 2019
 */
public class Hoagie extends Food
{

    /**
     * Constructor for objects of class Hoagie
     */
    public Hoagie()
    {
        lowOrderNum = 1;
        highOrderNum = 5;
        cookTime = 5;
        PRICE = (float)4.20;
    }
    
    public String toString(){
        return "Hoagie";
    }
}
