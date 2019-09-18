
/**
 * Bears similar functionalities as the List data structure
 *
 * @author Sena Yevenyo
 * @version September 9, 2019
 */
public class StringList extends StringListADT
{
    // instance variables - replace the example below with your own
    private Cell root;

    /**
     * Constructor for objects of class StringList
     */
    public StringList()
    {
        // initialise instance variables
        root = null;
    }

    /**
     * Inserts the value of x at the end of the list
     *
     * @param  String x Value to be inserted
     */
    public void append(String x){
        //Check if root is null
        //If true, create a new Cell and assign to root
        //If false, call root.append(String x);
        if(root == null) root = new Cell();
        root.append(x);
    }
    
    public String toString(){
        //Check if root is null
        //If true, return empty String
        //If false, return root.toString()
        if(root!=null) return root.toString();
        return "";
    }
    
    /**
     * Returns true if list has no data
     *
     */
    public boolean isEmpty(){
        //Return true if root is null
        //Return false if not.
        return root == null;
    }
}
