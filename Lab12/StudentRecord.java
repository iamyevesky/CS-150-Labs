
/**
 * Represents a student record.
 *
 * @author Sena Yevenyo
 * @version December 2, 2019
 */
public class StudentRecord
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;
    private String ID;
    /**
     * Constructor for objects of class StudentRecord object
     * @param String first - First name of StudentRecord object
     * @param String second - Second name of StudentRecord object
     * @param String ID - Identification of StudentRecord object
     */
    public StudentRecord(String first, String last, String id)
    {
        this.firstName = first;
        this.lastName = last;
        this.ID = id;
    }

    /**
     * Returns the first name of the StudentRecord object
     *
     * @return String object - the first name of the StudentRecord object
     */
    public String getFirstName()
    {
        // put your code here
        return firstName;
    }
    
    /**
     * Returns the last name of the StudentRecord object
     *
     * @return String object - the last name of the StudentRecord object
     */
    public String getLastName()
    {
        // put your code here
        return lastName;
    }
    
    /**
     * Returns the ID of the StudentRecord object
     *
     * @return String object - the ID of the StudentRecord object
     */
    public String getID()
    {
        // put your code here
        return ID;
    }
    
    /**
     * Sets the first name of the StudentRecord object
     *
     * @param String first - the first name of the StudentRecord object
     */
    public void setFirstName(String first)
    {
        // put your code here
        firstName = first;
    }
    
    /**
     * Sets the last name of the StudentRecord object
     *
     * @param String last - the last name of the StudentRecord object
     */
    public void setLastName(String last)
    {
        // put your code here
        lastName = last;
    }
    
    /**
     * Sets the ID of the StudentRecord object
     *
     * @param String id - the id of the StudentRecord object
     */
    public void setID(String id)
    {
        // put your code here
        ID = id;
    }
}
