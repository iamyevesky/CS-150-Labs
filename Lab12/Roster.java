import java.util.*;
/**
 * Provides methods of interaction with any class that stores StudentRecord.
 *
 * @author Sena Yevenyo
 * @version December 02, 2019
 */
public interface Roster
{
    /**
     * Removes all stored records from the Roster
     *
     */
    void clear();
    
    /**
     * Returns true if a value in roster is of a specific key input
     *
     * @param  String id - ID of the StudentRecord object
     * @return true if a value in roster has the specific key input
     */
    boolean containsKey(String id);
    
    /**
     * Returns true if a value in roster is of a specific value input
     *
     * @param  StudentRecord record - the StudentRecord object
     * @return true if a value in roster has the specific value input
     */
    boolean containsValue(StudentRecord record);
    
    /**
     * Returns a record of a specific ID if stored in roster
     * Returns null if not
     *
     * @param  String id - ID of the StudentRecord object
     * @return a record of a specific ID if stored in roster
     */
    StudentRecord get(String id);
    
    /**
     * Returns a set object of all keys(i.e IDs) of StudentRecord stored in roster
     *
     * @return a set object of all keys(i.e IDs) of StudentRecord stored in roster
     */
    Set<String> keySet();
    
    /**
     * Adds a StudentRecord object to the roster, returning the previously stored
     * record for the StudentRecord object's ID.
     * Returns null if there was no StudentRecord object in the roster for the
     * StudentRecord object being added 
     *
     * @param StudentRecord record - record being added
     * @return the roster previously stored with the same ID as the object being added
     */
    StudentRecord put(StudentRecord record);
    
    /**
     * Removes the record for ID from the roster, returning the previously stored record
     * for such ID.
     * Returns null if there was not such a record for the ID input
     * @param  String id - ID of StudentRecord object being removed 
     * @return StudentRecord object with such ID.
     */
    StudentRecord remove(String id);
    
    /**
     * Returns the size of the roster. That is, the number of stored records
     *
     * @return the number of stored records
     */
    int size();
    
    /**
     * Returns the collection of stored records
     *
     * @return the collection of stored records
     */
    Collection<StudentRecord> values();
}
