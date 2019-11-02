import java.util.*;
/**
 * Generates random Strings of a specific length
 *
 * @author Sena Yevenyo
 * @version October 16, 2019
 */
public class RandomStringGenerator
{
    // instance variables - replace the example below with your own
    private Random random;
    private String[] alphabets = {"a","b","c","d","e","f","g","h","i"
                                  ,"j","k","l","m","n","o","p","q","r"
                                  ,"s","t","u","v","w","x","y","z"};
    private String[] numbers = {"1","2","3","4","5","6","7","8","9","0"};
    /**
     * Constructor for objects of class RandomStringGenerator
     * 
     * @param long seed, seed for RandomStringGenerator class
     */
    public RandomStringGenerator(long seed)
    {
        // initialise instance variables
        random = new Random(seed);
    }
    
    /**
     * Constructor for objects of class RandomStringGenerator
     * 
     */
    public RandomStringGenerator()
    {
        // initialise instance variables
        random = new Random();
    }
    
    /**
     * Generates a random String number of format (XXX)XXX-XXX
     *
     */
    public String nextNumber()
    {
        String output = "("+nextInt()+")";
        output = output+nextInt()+"-";
        output = output+nextInt();
        return output;
    }
    
    /**
     * Generates a random String number of format XXX
     *
     */
    private String nextInt(){
        String next = random.nextInt((int) Math.pow(10,3))+"";
        if(next.length()<3) {
            //In case number generated length <3
            for(int i =0;i<3-next.length();i++){
                next+="0";
            }
        }else{
            next.substring(3);
        }
        return next;
    }
    
    /**
     * Generates a name of length four of lowercase format
     *
     */
    public String nextName(){
        int nameLength = 4;
        String next = "";
        for(int i=0;i<nameLength;i++){
            next+=alphabets[random.nextInt(alphabets.length)];
        }
        return next;
    }
    
    /**
     * Generates a long number of length 8.
     *
     */
    public long nextID(){
        int idlength = 8;
        //Numbers generated cannot start with 0.
        String next = numbers[random.nextInt(numbers.length-1)];
        for(int i =0;i<idlength-1;i++){
            next+=numbers[random.nextInt(numbers.length)];
        }
        return Long.parseLong(next);
    }
}
