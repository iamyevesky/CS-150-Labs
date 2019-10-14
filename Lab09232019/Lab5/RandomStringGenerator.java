import java.util.*;
/**
 * Generates random Strings of a specific length
 *
 * @author Sena Yevenyo
 * @version September 16, 2019
 */
public class RandomStringGenerator
{
    // instance variables - replace the example below with your own
    private Random random;
    private int lengthStr;

    /**
     * Constructor for objects of class RandomStringGenerator
     * 
     * @param long seed, seed for Random class
     * @param lengthStr, length of String to be generated
     */
    public RandomStringGenerator(long seed, int lengthStr)
    {
        // initialise instance variables
        random = new Random(seed);
        this.lengthStr = lengthStr;
    }

    /**
     * Generates a random String with a specific length dpeneding on the instantiation of
     * RandomStringGenerator
     *
     */
    public String nextString()
    {
        String output = random.nextInt((int) Math.pow(10,lengthStr))+"";
        if(output.length()<lengthStr) {
            //In case number generated length <lengthStr
            for(int i =0;i<lengthStr-output.length();i++){
                output+="0";
            }
        }else{
            output.substring(lengthStr);
        }
        return output;
    }
}
