import java.util.*;
/**
 * Contains an ArrayList <String> of numbers in String.
 *
 * @author Sena Yevenyo
 * @version September 16, 2019
 */
public class StringContainer
{
    // instance variables - replace the example below with your own
    private ArrayList<String> array;
    /**
     * Constructor for objects of class StringContainer
     */
    public StringContainer()
    {
        // initialise instance variables
        array = new ArrayList<String>(0);
    }

    /**
     * Adds an int to the end of the StringContainer object
     *
     * @param  y  int parameter to be added
     */
    public void add(String y)
    {
        // Add string to the end of array
        array.add(y);
    }
    
    /**
     * Performs insertion sort on a StringContainer object
     *
     */
    public void insertionSort()
    {
        // Check Section 4.3 of Zybook
        for(int i = 1; i<array.size();i++){
            int j = i;
            String temp = null;
            while(j>0 && array.get(j).compareTo(array.get(j-1))<0){
                temp = array.get(j);
                array.set(j, array.get(j-1));
                array.set(j-1, temp);
                j--;
            }
        }
    }
    
    /**
     * Performs selection sort on a StringContainer object
     *
     */
    public void selectionSort()
    {
        // Check Section 4.2 of Zybook
        String temp = null;
        String shortStringValue = null;
        int shortIndex = 0;
        for(int i=0;i<array.size()-1;i++){
            shortStringValue = array.get(i);
            shortIndex = i;
            for(int j=i+1;j<array.size();j++){
                if(shortStringValue.compareTo(array.get(j))>0) {
                    shortStringValue = array.get(j);
                    shortIndex = j;
                }
            }
            temp = array.get(i);
            array.set(i, shortStringValue);
            array.set(shortIndex, temp);
        }
    }
    
    /**
     * Perform linear search on a StringContainer object
     *
     * @param key String object to be searched
     */
    public boolean linearSearch(String key)
    {
        // For each element of the ArrayList<String> array,
        // Compare the value of each element to the key
        // Return True if element is the same
        // Return False if no element is found at the end of the list
        for(int i=0;i<array.size();i++){
            if(key.compareTo(array.get(i))==0) return true;
        }
        return false;
    }
    
    /**
     * Perform binary search on a StringContainer object
     *
     * @param key String object to be searched
     */
    public boolean binarySearch(String key)
    {
        //Check Section 3.2 of Zybook
        int low =0;
        int high = array.size()-1;
        int mid = (low+high)/2;
        
        while(low<=high){
            if(key.compareTo(array.get(mid))>0){
                low = mid+1;
                mid = (low+high)/2;
            }
            else if(key.compareTo(array.get(mid))<0){
                high = mid-1;
                mid = (low+high)/2;
            }
            else return true;
        }
        return false;
    }
    
    public String toString(){
        String output = "[";
        for(int i=0;i<array.size()-1;i++){
            output+=array.get(i);
            output+=",";
        }
        if(array.size()-1>=0) output+=array.get(array.size()-1);
        output+="]";
        return output;
    }
    
    /**
     * Returns a String from a specific index
     *
     * @param int index, index of String object to be returned
     */
    public String get(int index){
        return array.get(index);
    }
    
    /**
     * Returns the size of the SrtingContainer
     *
     */
    public int size(){
        return array.size();
    }
}
