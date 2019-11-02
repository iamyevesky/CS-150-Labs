import java.util.*;
/**
 * Write a description of class Worker here.
 *
 * @author Sena Yevenyo
 * @version October 15,2019
 */
public class Worker extends Person
{
    // instance variables - replace the example below with your own
    private long id;

    /**
     * Constructor for objects of class Worker
     */
    public Worker(long id)
    {
        // initialise instance variables
        this.id = id;
    }
    
    /**
     * Returns the id of the Worker object
     *
     * @return  the id of the Worker object
     */
    public long getID(){
        return id;
    }
    
    /**
     * Returns the difference between the id of the workers
     * The difference is 1 if the Worker object being compared
     * has an id number greater than that of the variable of the method
     * and -1 if condition is vice-versa. Returns 0 if equal
     *
     * @return the difference between the id of workers 
     */
    public int compareTo(Worker b){
        return workerComparator.compare(this,b);
    }
    
    /**
     * Prints the Worker object
     *  
     *  @return the id of the worker in paranthesis
     */
    public String toString(){
        return "("+id+")";
    }
    public static Comparator<Worker> workerComparator = new Comparator<Worker>(){
        @Override
        public int compare(Worker c1, Worker c2){
            int output = (int) (c1.getID()-c2.getID());
            if(output>0) return 1;
            else if(output<0) return -1;
            else if(output==0) return 0;
            return 0;
        }
    };
}
