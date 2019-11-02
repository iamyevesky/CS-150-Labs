import java.util.*;
/**
 * Contact class represents a contact notebook reference of an individual or person.
 * Inherits the abstract Person class
 *
 * @author Sena Yevenyo
 * @version October 15,2019
 */
public class Contact extends Person
{
    // instance variables - replace the example below with your own
    private String number = null;
    private String email = "dummy@domain.net";
    /**
     * Constructor for objects of class Contact
     */
    public Contact( String lastName, String firstName)
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Contact( String lastName, String firstName, String number)
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }
    
    /**
     * Returns the difference between the names of the contacts
     * The difference is 1 if the Contact object being compared
     * has an its last name has a word that comes after
     * that of the last name of the variable of the method alphabetically or first names
     * are compared if last names are the same
     * and -1 if condition is vice-versa. Returns zero if equal
     *
     * @return the difference between the names of workers 
     */
    public int compareTo(Contact b){
        return contactComparator.compare(this,b);
    }
    
    /**
     * Prints the Contact object
     * 
     * @return the last and first name of a Contact object in paranthesis, separated by a comma
     */
    public String toString(){
        return "("+lastName+", "+firstName+")";
    }
    
    
    public static Comparator<Contact> contactComparator = new Comparator<Contact>(){
        @Override
        public int compare(Contact c1, Contact c2){
            int output = c1.GetLastName().compareTo(c2.GetLastName());
            if(output<0) return -1;
            else if(output>0) return 1;
            else if(output==0){
                output = c1.GetFirstName().compareTo(c2.GetFirstName());
                if(output<0) return -1;
                else if(output>0) return 1;
                else if(output==0) return 0;
            } 
            return 0;
        }
    };
}
