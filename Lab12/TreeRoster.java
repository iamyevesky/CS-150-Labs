import java.util.*;
/**
 * Creates a hash set with a TreeMap implementation.
 *
 * @author Sena Yevenyo
 * @version December 02, 2019
 */
public class TreeRoster extends TreeMap<String, StudentRecord> implements Roster
{
    // instance variables - replace the example below with your own
    
    public TreeRoster(){
        super();
    }
    
    /**
     * Removes all stored records from the Roster
     *
     */
    public void clear(){
        super.clear();
    }
    
    /**
     * Returns true if a value in roster is of a specific key input
     *
     * @param  String id - ID of the StudentRecord object
     * @return true if a value in roster has the specific key input
     */
    public boolean containsKey(String id){
        return super.containsKey(id);
    }
    
    /**
     * Returns true if a value in roster is of a specific value input
     *
     * @param  StudentRecord record - the StudentRecord object
     * @return true if a value in roster has the specific value input
     */
    public boolean containsValue(StudentRecord record){
        return super.containsValue(record);
    }
    
    /**
     * Returns a record of a specific ID if stored in roster
     * Returns null if not
     *
     * @param  String id - ID of the StudentRecord object
     * @return a record of a specific ID if stored in roster
     */
    public StudentRecord get(String id){
        return super.get(id);
    }
    
    /**
     * Returns a set object of all keys(i.e IDs) of StudentRecord stored in roster
     *
     * @return a set object of all keys(i.e IDs) of StudentRecord stored in roster
     */
    public Set<String> keySet(){
        return super.keySet();
    }
    
    /**
     * Adds a StudentRecord object to the roster, returning the previously stored
     * record for the StudentRecord object's ID.
     * Returns null if there was no StudentRecord object in the roster for the
     * StudentRecord object being added 
     *
     * @param StudentRecord record - record being added
     * @return the roster previously stored with the same ID as the object being added
     */
    public StudentRecord put(StudentRecord record){
        return super.put(record.getID(), record);
    }
    
    /**
     * Removes the record for ID from the roster, returning the previously stored record
     * for such ID.
     * Returns null if there was not such a record for the ID input
     * @param  String id - ID of StudentRecord object being removed 
     * @return StudentRecord object with such ID.
     */
    public StudentRecord remove(String id){
        return super.remove(id);
    }
    
    /**
     * Returns the size of the roster. That is, the number of stored records
     *
     * @return the number of stored records
     */
    public int size(){
        return super.size();
    }
    
    /**
     * Returns the collection of stored records
     *
     * @return the collection of stored records
     */
    public Collection<StudentRecord> values(){
        return super.values();
    }
}
