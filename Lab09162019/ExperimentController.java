import java.util.*;
import java.io.PrintWriter;
import java.io.File;
/**
 * Tests the time taken for all the methods of StringContainer to run.
 *
 * @author Sena Yevenyo
 * @version September 16, 2019
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
        float times[][][] = new float[numberOfItems.length][8][avgBy];
        System.out.println("Creating float sum[][] array");
        float sum [][] = new float[numberOfItems.length][8];
        
        System.out.println("Filling float times[][][] with data");
        for(int i=0;i<numberOfItems.length;i++){
            for(int j=0;j<8;j++){
                if(j==0){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToInsertionSortUnsorted(numberOfItems[i],1000);
                    }
                }else if(j==1){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToInsertionSortSorted(numberOfItems[i],1000);
                    }
                }else if(j==2){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToSelectionSortUnsorted(numberOfItems[i],1000);
                    }
                }else if(j==3){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToSelectionSortSorted(numberOfItems[i],1000);
                    }
                }else if(j==4){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToLinearSearchFound(numberOfItems[i],1000);
                    }
                }else if(j==5){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToLinearSearchNotFound(numberOfItems[i],1000);
                    }
                }else if(j==6){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToBinarySearchFound(numberOfItems[i],1000);
                    }
                }else if(j==7){
                    for(int k=0;k<avgBy;k++){
                        times[i][j][k] = instance.timeToBinarySearchNotFound(numberOfItems[i],1000);
                    }
                }
            }
            System.out.println("times["+i+"] filled");
            System.out.println("Data:");
            System.out.println(Arrays.toString(times[i][0]));
            System.out.println(Arrays.toString(times[i][1]));
            System.out.println(Arrays.toString(times[i][2]));
            System.out.println(Arrays.toString(times[i][3]));
            System.out.println(Arrays.toString(times[i][4]));
            System.out.println(Arrays.toString(times[i][5]));
            System.out.println(Arrays.toString(times[i][6]));
            System.out.println(Arrays.toString(times[i][7]));
        }
        
        
        System.out.println("Finding sum of time for each method");
        for(int i=0;i<numberOfItems.length;i++){
            for(int j=0;j<8;j++){
                //Computing sums of runtime of each method
                if(j==0){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToInsertionSortUnsorted "+sum[i][j]);
                }else if(j==1){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToInsertionSortSorted "+sum[i][j]);
                }else if(j==2){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToSelectionSortUnsorted "+sum[i][j]);
                }else if(j==3){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToSelectionSortSorted "+sum[i][j]);
                }else if(j==4){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToLinearSearchFound "+sum[i][j]);
                }else if(j==5){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToLinearSearchNotFound "+sum[i][j]);
                }else if(j==6){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToBinarySearchFound "+sum[i][j]);
                }else if(j==7){
                    for(int k=0;k<avgBy;k++){
                        sum[i][j]+=times[i][j][k];
                    }
                    System.out.println("Sum of time for "+numberOfItems[i]+" items for timeToBinarySearchNotFound "+sum[i][j]);
                } 
            }
            
            for(int j=0;j<8;j++){
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
                array[0] = "timetoInsertionSortUnsorted";
                array[1] = "timetoInsertionSortSorted";
                array[2] = "timetoSelectionSortUnsorted";
                array[3] = "timetoSelectionSortSorted";
                array[4] = "timetoLinearSortFound";
                array[5] = "timetoLinearSortNotFound";
                array[6] = "timetoBinarySortFound";
                array[7] = "timetoBinarySortNotFound";
                
                for(int i=0;i<8;i++){
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
     * Returns time taken for insertionSort() to run for an unsorted StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run insertionSort() for an unsorted list;
     */
     public float timeToInsertionSortUnsorted(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random.nextString());
        }
        
        long startTime = System.currentTimeMillis();
        instance.insertionSort();
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for insertionSort() to run for an sorted StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run insertionSort() for a sorted list;
     */
    public float timeToInsertionSortSorted(int numberOfItems, int seed){
       StringContainer instance = new StringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random.nextString());
        }
        instance.insertionSort();
        long startTime = System.currentTimeMillis();
        instance.insertionSort();
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for selectionSort() to run for an unsorted StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run selectionSort() for an unsorted list;
     */
    public float timeToSelectionSortUnsorted(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random.nextString());
        }
        
        long startTime = System.currentTimeMillis();
        instance.selectionSort();
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for selectionSort() to run for an sorted StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run selectionSort() for a sorted list;
     */
    public float timeToSelectionSortSorted(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random.nextString());
        }
        instance.selectionSort();
        long startTime = System.currentTimeMillis();
        instance.selectionSort();
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken linearSearch() to find for a String in a StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to find for a String in a StringContainer object;
     */
    public float timeToLinearSearchFound(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random.nextString());
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
     * Returns time taken linearSearch() to conclude a String is not in a StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to conclude a String is not in a StringContainer object
     */
    public float timeToLinearSearchNotFound(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random0 = new RandomStringGenerator(seed, 5);
        String notPresent = "abcde";
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random0.nextString());
        }
        instance.insertionSort();
        long startTime = System.currentTimeMillis();
        instance.linearSearch(notPresent);
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken binaryrSearch() to find for a String in a StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to find for a String in a StringContainer object;
     */
    public float timeToBinarySearchFound(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random = new RandomStringGenerator(seed, 5);
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random.nextString());
        }
        Random rdnum = new Random(2345);
        int index = ((rdnum.nextInt(101)*(instance.size()-1))/100);
        long startTime = System.currentTimeMillis();
        instance.binarySearch(instance.get(index));
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken binarySearch() to conclude a String is not in a StringContainer object
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to conclude a String is not in a StringContainer object
     */
    public float timeToBinarySearchNotFound(int numberOfItems, int seed){
        StringContainer instance = new StringContainer();
        RandomStringGenerator random0 = new RandomStringGenerator(seed, 5);
        String notPresent = "abcde";
        long output = (long) 0.0;
        
        for(int i=0;i<numberOfItems;i++){
            instance.add(random0.nextString());
        }
        instance.insertionSort();
        long startTime = System.currentTimeMillis();
        instance.binarySearch(notPresent);
        long stopTime = System.currentTimeMillis();
        output = (long)(stopTime-startTime);
        return output;
    }
}
