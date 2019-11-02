import java.util.*;
/**
 * A class that stores Contact objects
 *
 * @author Sena Yevenyo
 * @version October 16,2019
 */
public class ContactList extends SortedList
{
    private ArrayList<Contact> contactList = new ArrayList<Contact>(); 
    /**
     * Constructor for objects of class ContactList
     */
    public ContactList()
    {
        // initialise instance variables
    }
    
    /**
     * Adds a Contact object to the ContactList container
     *
     * @param Contact contact, object to be added
     */
    public void addElement(Contact contact){
        contactList.add(contact);
    }
    
    /**
     * Prints out the ContactList Container 
     *
     * @param Contact contact, object to be added
     */
    public String printData(){
        String output = "[";
        for(int i =0;i<contactList.size()-1;i++){
            output+=contactList.get(i)+", ";
        }
        if(contactList.size()>0)output+=contactList.get(contactList.size()-1);
        output+="]";
        return output;
    }
    
    /**
     * Sorts the container by merge sort
     *
     */
    public void mergeSort(){
        mergeSortRecursive(0,contactList.size()-1);
    }

    /**
     * Recursive version of merge sort
     * @param i refers to the beginning index of the subset of the contactList to be sorted
     * @param k refers to the end index of the subset of the contactList to be sorted
     */
    private void mergeSortRecursive(int i, int k){
        if(i<k){
            int j = (k+i)/2;
            mergeSortRecursive(i, j);
            mergeSortRecursive(j+1,k);
            merge(i,j,k);
        }
    }

    /**
     * Completes the merge function of the mergeSortRecursive
     * @param i refers to the beginning index of the subset of contactList to be merged
     * @param j refers to the index that separates the left partition and right partitions to be merged
     * @param k refers to the end index of the subset of the contactList to be merged
     */
    private void merge(int i, int j, int k){
        int mergeSize = k-i+1;
        ArrayList<Contact> mergedContacts = new ArrayList<Contact>();
        int mergeIndex = 0;

        int leftIndex = i;
        int rightIndex = j+1;

        while(leftIndex<=j && rightIndex<=k){
            if(contactList.get(leftIndex).compareTo(contactList.get(rightIndex))<=0) {
                mergedContacts.add(contactList.get(leftIndex));
                leftIndex++;
            }else{
                mergedContacts.add(contactList.get(rightIndex));
                rightIndex++;
            }
        }

        while(leftIndex<=j){
            mergedContacts.add(contactList.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=k){
            mergedContacts.add(contactList.get(rightIndex));
            rightIndex++;
        }

        for(int index = i; index<k+1; index++){
            contactList.set(index, mergedContacts.get(index-i));
        }
    }

    /**
     * Sorts the container by quick sort
     *
     */
    public void quickSort(){
        quickSortRecursive(0, contactList.size()-1);
    }
    
    /**
     * Recursive version of quick sort
     * @param i refers to the beginning index of the subset of the contactList to be sorted
     * @param k refers to the end index of the subset of the contactList to be sorted
     */
    private void quickSortRecursive(int i, int k){
        if(i>=k) return;
        int j = partition(i,k);
        quickSortRecursive(i,j);
        quickSortRecursive(j+1,k);
    }
    
    /**
     * Completes the partitioning of the quickSortRecursive function
     * @param i refers to the beginning index of the subset of contactList to be partitioned
     * @param j refers to the index that separates the left partition and right partitions to be merged
     * @param k refers to the end index of the subset of the contactList to be partitioned
     */
    private int partition(int i, int k){
        int l = i;
        int h = k;
        int mid = i+(k-i)/2;
        Contact pivot = contactList.get(mid);
        boolean notDone = true;
        while(notDone){
            while(contactList.get(l).compareTo(pivot)<0){
                l++;
            }
            
            while(contactList.get(h).compareTo(pivot)>0){
                h--;
            }
            if(l>=h) notDone = false;
            else{
                Contact contactL = contactList.get(l);
                Contact contactH = contactList.get(h);
                contactList.set(h, contactL);
                contactList.set(l, contactH);
                l++;
                h--;
            }
        }
        return h;
    }
}
