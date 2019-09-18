import java.util.*;
/**
 * Contains an ArrayList<String>
 * @author Sena Yevenyo
 * @version September 8, 2019
 */
public class RandomStringContainer
{
    // instance variables - replace the example below with your own
    private ArrayList<String> array;
    private int arrayLength;

    /**
     * Constructor for objects of class RandomStringContainer
     */
    public RandomStringContainer()
    {
        //Creates empty ArrayList<String>
       array = new ArrayList<String>(0);
       arrayLength = 0;
    }

    /**
     * Takes one String parameter and inserts as the first
     * element of the arrayList
     *
     * @param String item, String parameter to be inserted
     */
    public void addToFront(String item)
    {
        //Adds item to the fromt of list
        array.add(0,item);
        arrayLength++;
    }
    
    /**
     * Takes one String parameter and inserts as the last
     * element of the arrayList
     *
     * @param String item, String parameter to be inserted
     */
    public void addToBack(String item)
    {
        //Add item to back of the list
        array.add(item);
        arrayLength++;
    }
    
    /**
     * Takes one String parameter and inserts at the correct
     * location of a sorted ArrayList that keeps the ArrayList sorted
     *
     * @param String item, String parameter to be inserted
     */
    public void addSorted(String item)
    {
        // Loop through the ArrayList and find the correct location index to insert item
        // Move all items at and after the index up by one index
        // Insert item at the correct location index
        int diff = 0;
        if (!array.isEmpty()){
            for(int i=0;i<array.size();i++){
                diff = item.compareTo(array.get(i));
                if(diff<=0 && i>0) {insert(i,item);break;}
                else if(diff>0 && i+1==array.size()) {array.add(item);break;}
                else if(diff<=0 && i==0) {addToFront(item);break;}
            }
            arrayLength++;
        }else{
            array.add(item);
            arrayLength++;
        }
        
    }
    
    /**
     * Takes one String parameter and prepends String parameter
     * to the first String in the ArrayList
     *
     * @param String item, String parameter to be prepended
     */
    public void prependSorted(String item)
    {
        // Finds the first item in the ArrayList
        // Concantenate item + first item of ArrayList
        // Loop through the ArrayList and find the correct location index to insert concatString
        // Move all items at and after the index up by one index
        // Insert concatString at the correct location index
        String newItem = item+array.get(0);
        addSorted(newItem);
        
    }
    
    /**
    * 
    * Sorts ArrayList<String>
    *
    */
    public void selectionSort()
    {
        // Use the sorting algorithm in textbook Section 4.2
        for (int i=array.size()-1;i>0;i--){
            int indexLargest = i;
            for (int j=i-1;j>=0;j--){
                if((array.get(j)).compareTo(array.get(indexLargest))>0){
                    indexLargest = j;
                }
            }
            
            String temp = array.get(i);
            array.set(i,array.get(indexLargest));
            array.set(indexLargest,temp);
        }
    }
    
    /**
    * 
    * Returns ArrayList<String> as String[] array
    * @return String[] array output Elements of ArrayList<String> as String[] array
    */
    public String [] get(){
        //Return array
        String [] output = new String[array.size()];
        for (int i=0;i<array.size();i++) output[i] = array.get(i);
        return output;
    }
    
    /**
    * 
    * Inserts a String ArrayList<String> at an index
    * @param item String to be inserted
    */
    private void insert(int index, String item){
        if(index>=0 && index<array.size()) array.add(index,item);
    }
}
