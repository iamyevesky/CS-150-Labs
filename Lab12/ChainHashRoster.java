import java.util.*;
/**
 * Creates a hash set with chaining implementation.
 *
 * @author Sena Yevenyo
 * @version December 02, 2019
 */
public class ChainHashRoster implements Roster
{
    // instance variables - replace the example below with your own
    private LinkedList<StudentRecord> [] roster;
    private int stored;
    private int maxChain;
    /**
     * Constructor for objects of class ChainHashRoster
     * @param int bucket - Initial size of hash table
     * @param int maxChain - Condition for rehashing. Hashtable rehashes if a chain in the array has a length greater or equal to this value
     */
    public ChainHashRoster(int bucket, int maxChain)
    {
        // initialise instance variables
        roster = new LinkedList[bucket];
        this.maxChain = maxChain;
    }
    
    private void checkRehash(){
        for(int i=0; i<roster.length;i++){
            if(roster[i]!=null){
                if(roster[i].size()>=maxChain){
                    this.rehash();
                    return;
                }
            }
        }
    }
    
    /**
     * Rehashes the ChainHashSet for faster access
     */
    public void rehash(){
        int size = roster.length*2;
        LinkedList [] newHash = new LinkedList[size];
        Collection values = this.values();
        Iterator<StudentRecord> it = values.iterator();
        roster = newHash;
        newHash = null;
        stored = 0;
        while(it.hasNext()){
            this.put(it.next());
        }
    }
    
    /**
     * Returns the length of the storage array of the has table
     * 
     * @returns the length of the storage array of the has table
     */
    public int getArraySize(){
        return roster.length;
    }
    
    /**
     * Removes all stored records from the Roster
     *
     */
    public void clear(){
        roster = new LinkedList[roster.length];
        stored = 0;
    }
    
    /**
     * Returns true if a value in roster is of a specific key input
     *
     * @param  String id - ID of the StudentRecord object
     * @return true if a value in roster has the specific key input
     */
    public boolean containsKey(String id){
        int index = Math.abs(id.hashCode())%roster.length;
        if(roster[index]==null){
            return false;
        }
        ListIterator<StudentRecord> it = roster[index].listIterator(0);
        while(it.hasNext()){
            StudentRecord value = it.next();
            if(value.getID().compareTo(id)==0){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns true if a value in roster is of a specific value input
     *
     * @param  StudentRecord record - the StudentRecord object
     * @return true if a value in roster has the specific value input
     */
    public boolean containsValue(StudentRecord record){
        return containsKey(record.getID());
    }
    
    /**
     * Returns a record of a specific ID if stored in roster
     * Returns null if not
     *
     * @param  String id - ID of the StudentRecord object
     * @return a record of a specific ID if stored in roster
     */
    public StudentRecord get(String id){
        int index = Math.abs(id.hashCode())%roster.length;
        if(roster[index]==null){
            return null;
        }
        ListIterator<StudentRecord> it = roster[index].listIterator(0);
        while(it.hasNext()){
            StudentRecord value = it.next();
            if(value.getID().compareTo(id)==0){
                return value;
            }
        }
        return null;
    }
    
    /**
     * Returns a set object of all keys(i.e IDs) of StudentRecord stored in roster
     *
     * @return a set object of all keys(i.e IDs) of StudentRecord stored in roster
     */
    public Set<String> keySet(){
        Set keys = new HashSet();
        for(int i=0;i<roster.length;i++){
            if(roster[i]!=null){
                ListIterator<StudentRecord> it = roster[i].listIterator(0);
                while(it.hasNext()){
                    keys.add(it.next().getID());
                }
            }
        }
        return keys;
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
        int index = Math.abs(record.getID().hashCode())%roster.length;
        if(roster[index]==null){
            roster[index] = new LinkedList();
        }
        ListIterator<StudentRecord> it = roster[index].listIterator(0);
        while(it.hasNext()){
            StudentRecord value = it.next();
            if(value.getID().compareTo(record.getID())==0){
                roster[index].remove(value);
                roster[index].add(record);
                stored++;
                return value;
            }
        }
        roster[index].add(record);
        stored++;
        return null;
    }
    
    /**
     * Removes the record for ID from the roster, returning the previously stored record
     * for such ID.
     * Returns null if there was not such a record for the ID input
     * @param  String id - ID of StudentRecord object being removed 
     * @return StudentRecord object with such ID.
     */
    public StudentRecord remove(String id){
        int index = Math.abs(id.hashCode())%roster.length;
        if(roster[index]==null){
            return null;
        }
        ListIterator<StudentRecord> it = roster[index].listIterator(0);
        while(it.hasNext()){
            StudentRecord value = it.next();
            if(value.getID().compareTo(id)==0){
                roster[index].remove(value);
                stored--;
                return value;
            }
        }
        return null;
    }
    
    /**
     * Returns the size of the roster. That is, the number of stored records
     *
     * @return the number of stored records
     */
    public int size(){
        return stored;
    }
    
    /**
     * Returns the collection of stored records
     *
     * @return the collection of stored records
     */
    public Collection<StudentRecord> values(){
        Collection values = new HashSet();
        for(int i=0;i<roster.length;i++){
            if(roster[i]!=null){
                if(roster[i]!=null){
                    ListIterator<StudentRecord> it = roster[i].listIterator(0);
                    while(it.hasNext()){
                        values.add(it.next());
                    }
                }
            }
        }
        return values;
    }
}
