import java.util.*;
/**
 * Write a description of class RandomIntegerContainer here.
 *
 * @Sena Yevenyo (your name)
 * @version September 7, 2019
 */
public class RandomIntegerContainer
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> array;

    /**
     * Constructor for objects of class RandomIntegerContainer
     */
    public RandomIntegerContainer()
    {
        array = new ArrayList<Integer>(0);
    }

    /**
     * Takes one Integer parameter and inserts as the first
     * element of the arrayList
     *
     * @param String item, Integer parameter to be inserted
     */
    public void addToFront(Integer item){
        array.add(0,item);
    }
    
    /**
    * 
    * Returns ArrayList<String> as Integer[] array
    * @return Integer[] array output Elements of ArrayList<String> as String[] array
    */
    public Integer[] get(){
        Integer[] output = new Integer[array.size()];
        for (int i=0;i<array.size();i++) output[i] = array.get(i);
        return output;
    } 
}
