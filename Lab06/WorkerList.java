import java.util.*;
/**
 * A class that stores Worker objects
 *
 * @author Sena Yevenyo
 * @version October 16,2019
 */
public class WorkerList extends SortedList
{
    private ArrayList<Worker> workerList = new ArrayList<Worker>(); 
    /**
     * Constructor for objects of class WorkerList
     */
    public WorkerList()
    {
        // initialise instance variables
    }

    /**
     * Adds a Worker object to the WorkerList container
     *
     * @param Worker worker, object to be added
     */
    public void addElement(Worker worker){
        workerList.add(worker);
    }

    /**
     * Prints out the WorkerList Container 
     *
     * @param Worker worker, object to be added
     */
    public String printData(){
        String output = "[";
        for(int i =0;i<workerList.size()-1;i++){
            output+=workerList.get(i)+", ";
        }
        if(workerList.size()>0)output+=workerList.get(workerList.size()-1);
        output+="]";
        return output;
    }

    /**
     * Sorts the container by merge sort
     *
     */
    public void mergeSort(){
        mergeSortRecursive(0,workerList.size()-1);
    }

    /**
     * Recursive version of merge sort
     * @param i refers to the beginning index of the subset of the workerList to be sorted
     * @param k refers to the end index of the subset of the workerList to be sorted
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
     * @param i refers to the beginning index of the subset of workerList to be merged
     * @param j refers to the index that separates the left partition and right partitions to be merged
     * @param k refers to the end index of the subset of the workerList to be merged
     */
    private void merge(int i, int j, int k){
        int mergeSize = k-i+1;
        ArrayList<Worker> mergedWorkers = new ArrayList<Worker>();
        int mergeIndex = 0;

        int leftIndex = i;
        int rightIndex = j+1;

        while(leftIndex<=j && rightIndex<=k){
            if(workerList.get(leftIndex).compareTo(workerList.get(rightIndex))<=0) {
                mergedWorkers.add(workerList.get(leftIndex));
                leftIndex++;
            }else{
                mergedWorkers.add(workerList.get(rightIndex));
                rightIndex++;
            }
        }

        while(leftIndex<=j){
            mergedWorkers.add(workerList.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=k){
            mergedWorkers.add(workerList.get(rightIndex));
            rightIndex++;
        }

        for(int index = i; index<k+1; index++){
            workerList.set(index, mergedWorkers.get(index-i));
        }
    }

    /**
     * Sorts the container by quick sort
     *
     */
    public void quickSort(){
        quickSortRecursive(0, workerList.size()-1);
    }
    
    /**
     * Recursive version of quick sort
     * @param i refers to the beginning index of the subset of the workerList to be sorted
     * @param k refers to the end index of the subset of the workerList to be sorted
     */
    private void quickSortRecursive(int i, int k){
        if(i>=k) return;
        int j = partition(i,k);
        quickSortRecursive(i,j);
        quickSortRecursive(j+1,k);
    }
    
    /**
     * Completes the partitioning of the quickSortRecursive function
     * @param i refers to the beginning index of the subset of workerList to be partitioned
     * @param j refers to the index that separates the left partition and right partitions to be merged
     * @param k refers to the end index of the subset of the workerList to be partitioned
     */
    private int partition(int i, int k){
        int l = i;
        int h = k;
        int mid = i+(k-i)/2;
        Worker pivot = workerList.get(mid);
        boolean notDone = true;
        while(notDone){
            while(workerList.get(l).compareTo(pivot)<0){
                l++;
            }
            
            while(workerList.get(h).compareTo(pivot)>0){
                h--;
            }
            if(l>=h) notDone = false;
            else{
                Worker workerL = workerList.get(l);
                Worker workerH = workerList.get(h);
                workerList.set(h, workerL);
                workerList.set(l, workerH);
                l++;
                h--;
            }
        }
        return h;
    }
}
