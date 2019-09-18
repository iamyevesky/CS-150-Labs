
/**
 * Stores a private String variable val and has a single Cell pointer next
 *
 * @author Sena Yevenyo
 * @version September 09, 2019
 */
public class Cell
{
    // instance variables - replace the example below with your own
    private String val;
    private Cell next;

    /**
     * Constructor for objects of class Cell
     */
    public Cell()
    {
        // initialise instance variables
        next = null;
        val = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void append(String x){
        //Check if next is null
        //If true, assign new Cell() to next
        //Set val value to x
        //If false, execute next.append(x)
        if(next==null){
            next = new Cell();
            val = x;
        }else{
            next.append(x);
        }
    }
    
    public String toString(){
        if(next == null){
            return val;
        }
        else{
        return val+next.toString();
        }
    }
}
