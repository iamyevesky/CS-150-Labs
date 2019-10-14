import java.util.*;
import java.io.PrintWriter;
import java.io.File;
/**
 * Tests the time taken for all the searches of MyListStringContainer to run.
 *
 * @author Sena Yevenyo
 * @version September 28, 2019
 */
public class ExperimentController
{

    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {
    }
    
    public static void main(String[] args){
        ExperimentController instance = new ExperimentController();
        String fileName = null;
        int avgBy = 0;
        int [] numberOfItems = null;
        int numOfMethodsToTest = 4;
        try{
            fileName = args[0];
            avgBy = Integer.parseInt(args[1]);
            numberOfItems = new int[args.length-2];
            for(int i=2;i<args.length;i++){
                numberOfItems[i-2] = Integer.parseInt(args[i]);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        
        System.out.println("No errors in input");
        System.out.println("File name: "+fileName);
        System.out.println("Average values by: "+avgBy);
        System.out.println("NumberOfItems data: "+Arrays.toString(numberOfItems));
        
        System.out.println("Creating float times[][][] array");
        float times[][][] = new float[numberOfItems.length][numOfMethodsToTest][avgBy];
        System.out.println("Creating float sum[][] array");
        float sum [][] = new float[numberOfItems.length][numOfMethodsToTest];
        
        System.out.println("Filling float times[][][] with data");
        
        for(int i=0;i<numberOfItems.length;i++){
            for(int j=0;j<numOfMethodsToTest;j++){
                if(j==0){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToLinearSearchWithoutIteratorFound(numberOfItems[i],1000);
                    }
                }else if(j==1){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToLinearSearchWithoutIteratorNotFound(numberOfItems[i],1000);
                    }
                }else if(j==2){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToLinearSearchWithIteratorFound(numberOfItems[i],1000);
                    }
                }else if(j==3){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToLinearSearchWithIteratorNotFound(numberOfItems[i],1000);
                    }
                }
            }
            System.out.println("times["+i+"] filled");
            System.out.println("Data:");
            System.out.println(Arrays.toString(times[i][0]));
            System.out.println(Arrays.toString(times[i][1]));
            System.out.println(Arrays.toString(times[i][2]));
            System.out.println(Arrays.toString(times[i][3]));
        }
        
        System.out.println("Finding sum of time for each method");
        for(int i=0;i<numberOfItems.length;i++){
            for(int j=0;j<numOfMethodsToTest;j++){
                //Computing sums of runtime of each method
                if(j==0){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToLinearSearchWithoutIteratorFound "+sum[i][j]);
                }else if(j==1){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToLinearSearchWithoutIteratorNotFound "+sum[i][j]);
                }else if(j==2){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToLinearSearchWithIteratorFound "+sum[i][j]);
                }else if(j==3){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToLinearSearchWithIteratorNotFound "+sum[i][j]);
                }
            }
                
            for(int j=0;j<numOfMethodsToTest;j++){
                //Turn sum into averages
                sum[i][j]=sum[i][j]/((float)avgBy);
            }
        }
        
        System.out.println("Average time of values:");
        for(int l=0;l<numberOfItems.length;l++){
            System.out.println(Arrays.toString(sum[l]));
        }
        
        System.out.println("Writing data into files");
        try{
                PrintWriter writer = new PrintWriter(new File(fileName));
                for(int i =0;i<numberOfItems.length;i++){
                    writer.print(", "+numberOfItems[i]);
                }
                writer.println();
                System.out.println("Headers done!");
                String [] array = new String[8];
                array[0] = "timeToLinearSearchWithoutIteratorFound";
                array[1] = "timeToLinearSearchWithoutIteratorNotFound";
                array[2] = "timeToLinearSearchWithIteratorFound";
                array[3] = "timeToLinearSearchWithIteratorNotFound";
                for(int i=0;i<numOfMethodsToTest;i++){
                    writer.print(array[i]);
                    for(int j=0;j<numberOfItems.length;j++){
                        writer.print(", "+sum[j][i]);
                    }
                    writer.println();
                }
                writer.close();
                System.out.println("Writing done!");
        }catch(Exception e){
                System.err.println(e);
        }
    }
    
    /**
     * Returns time taken for linearSearch() to run (linearSearch without iterator)
     * with member present
     * 
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run insertionSort() for an unsorted list;
     */
     public float timeToLinearSearchWithoutIteratorFound(int numberOfItems, int seed){
        MyListStringContainer instance = new MyListStringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(random.nextString());
        }
        
        Random rdnum = new Random(2345);
        int index = ((rdnum.nextInt(101)*(instance.size()-1))/100);
        long startTime = System.currentTimeMillis();
        instance.linearSearch(instance.get(index));
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for linearSearch() to run (linearSearch without iterator)
     * with member not present
     * 
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run insertionSort() for an unsorted list;
     */
     public float timeToLinearSearchWithoutIteratorNotFound(int numberOfItems, int seed){
        MyListStringContainer instance = new MyListStringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        String notPresent = "abcde";
        
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(random.nextString());
        }
        
        long startTime = System.currentTimeMillis();
        instance.linearSearch(notPresent);
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for linearSearchIterator() to run (linearSearch with iterator)
     * with member present
     * 
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run insertionSort() for an unsorted list;
     */
     public float timeToLinearSearchWithIteratorFound(int numberOfItems, int seed){
        MyListStringContainer instance = new MyListStringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(random.nextString());
        }
        
        Random rdnum = new Random(2345);
        int index = ((rdnum.nextInt(101)*(instance.size()-1))/100);
        long startTime = System.currentTimeMillis();
        instance.linearSearchIterator(instance.get(index));
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for linearSearch() to run (linearSearch without iterator)
     * with member not present
     * 
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run insertionSort() for an unsorted list;
     */
     public float timeToLinearSearchWithIteratorNotFound(int numberOfItems, int seed){
        MyListStringContainer instance = new MyListStringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        String notPresent = "abcde";
        
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(random.nextString());
        }
        
        long startTime = System.currentTimeMillis();
        instance.linearSearchIterator(notPresent);
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
}
