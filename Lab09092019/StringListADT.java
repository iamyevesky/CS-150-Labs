
/**
 * Abstract class StringListADT - Bears similar functionality as List data structure
 *
 * @author Sena Yevenyo
 * @version September 9, 2019
 */
public abstract class StringListADT
{

    /**
     * Inserts the value of x at the end of the list
     *
     * @param  String x Value to be inserted
     */
    public abstract void append(String x);
    
    public abstract String toString();
    
    /**
     * Returns true if list has no data
     *
     */
    public abstract boolean isEmpty();
    
}
