import java.util.*;
/**
 * Creates a hash set with linear probing implementation.
 *
 * @author Sena Yevenyo
 * @version December 02, 2019
 */
public class LinearHashRoster implements Roster
{
    // instance variables - replace the example below with your own
    private StudentRecord [] roster;
    private int [] emptyStatus; 
    private float loadSize;
    private int stored;
    /**
     * Constructor for objects of class LinearHashRoster
     * 
     * @param int bucket - Initial size of hash table
     * @param int loadSize - Load facor of hash table
     */
    public LinearHashRoster(int bucket, float loadSize)
    {
        // initialise instance variables
        roster = new StudentRecord[bucket];
        emptyStatus = new int[bucket];
        this.loadSize = loadSize; 
    }
    
    private void checkRehash(){
        if((float)stored/(float)roster.length>=0.75){
            this.rehash();
        }
    }
    
    /**
     * Rehashes the LienarHashSet for faster access
     */
    public void rehash(){
        int size = roster.length*2;
        StudentRecord [] newHash = new StudentRecord[size];
        StudentRecord [] oldHash = roster;
        emptyStatus = new int[size];
        roster = newHash;
        newHash = null;
        stored = 0;
        for(int i=0;i<oldHash.length;i++){
            StudentRecord value = oldHash[i];
            if(value!=null){
                this.put(value);
            }
        }
    }
    
    /**
     * Removes all stored records from the Roster
     *
     */
    public void clear(){
        roster = new StudentRecord[roster.length];
        emptyStatus = new int[roster.length];
        stored = 0;
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
     * Returns true if a value in roster is of a specific key input
     *
     * @param  String id - ID of the StudentRecord object
     * @return true if a value in roster has the specific key input
     */
    public boolean containsKey(String id){
        int index = Math.abs(id.hashCode())%roster.length;
        StudentRecord value = null;
        int checked = 0;
        while(checked<roster.length){
            index = index%roster.length;
            value = roster[index];
            if(value==null){
                if(emptyStatus[index]!=0){
                    index++;
                    checked++;
                }else{
                    return false;
                }
            }else{
                if(value.getID().compareTo(id)==0){
                    return true;
                }else{
                    index++;
                    checked++;
                }
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
        StudentRecord value = null;
        int checked = 0;
        while(checked<roster.length){
            index = index%roster.length;
            value = roster[index];
            if(value==null){
                if(emptyStatus[index]!=0){
                    index++;
                    checked++;
                }else{
                    return null;
                }
            }else{
                if(value.getID().compareTo(id)==0){
                    return value;
                }else{
                    index++;
                    checked++;
                }
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
                keys.add(roster[i].getID());
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
        StudentRecord value = roster[index];
        int checked = 0;
        while(checked<roster.length){
            index = index%roster.length;
            value = roster[index];
            if(value==null){
                roster[index] = record;
                emptyStatus[index] = 1;
                stored++;
                checkRehash();
                return value;
            }else{
                if(value.getID().compareTo(record.getID())==0){
                    roster[index] = record;
                    return value;
                }else{
                    index++;
                    checked++;
                }
            }
        }
        checkRehash();
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
        StudentRecord value = roster[index];
        int checked = 0;
        while(checked<roster.length){
            index = index%roster.length;
            value = roster[index];
            if(value==null){
                if(emptyStatus[index]!=0){
                    index++;
                    checked++;
                }else{
                    return null;
                }
            }else{
                if(value.getID().compareTo(id)==0){
                    roster[index] = null;
                    stored--;
                    emptyStatus[index] = -1;
                    return value;
                }else{
                    index++;
                    checked++;
                }
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
                values.add(roster[i]);
            }
        }
        return values;
    }
}
