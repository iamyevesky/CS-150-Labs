import java.util.*;
/**
 * Test the runtime of all the methods of RandomStringContainer class
 *
 * @author Sena Yevenyo
 * @version (September 8, 2019
 */
public class ExperimentController
{
    // instance variables - replace the example below with your own
    private static String [] twoLetterWords = {"aa","ab","ad","ae","ag","ah","ai","al","am"
                                              ,"an","ar","as","at","aw","ax","ay","ba","be"
                                              ,"bi","bo","by","da","de","do","ed","ef","eh"
                                              ,"el","em","en","er","es","et","ew","ex","fa"
                                              ,"fe","gi","go","ha","he","hi","hm","ho","id"
                                              ,"if","in","is","it","jo","ka","ki","la","li"
                                              ,"lo","ma","me","mi","mm","mo","mu","my","na"
                                              ,"ne","no","nu","od","oe","of","oh","oi","ok"
                                              ,"om","on","op","or","os","ow","ox","oy","pa"
                                              ,"pe","pi","po","qi","re","sh","si","so","ta"
                                              ,"te","ti","to","uh","um","un","up","us","ut"
                                              ,"we","wo","xi","xu","ya","ye","yo","za"};
    
    /**
    * 
    * Runs ExperimentController
    */
    public static void main(String[] args){
        ExperimentController analyzer = new ExperimentController();
        
        System.out.println("Average time for method AddToFront()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<1700001;i=i+100000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeAddToFront(i,i));
           System.out.println("=====================================");
        }
        System.out.println();
        
        System.out.println("Average time for method AddToBack()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<1700001;i=i+100000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeAddToBack(i,i));
           System.out.println("=====================================");
        }
        System.out.println();
        
        System.out.println("Average time for method AddSorted()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<17001;i=i+1000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeAddSorted(i,i));
           System.out.println("=====================================");
        }
        System.out.println();
        
        System.out.println("Average time for method PrependSorted()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<17001;i=i+1000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timePrependSorted(i,i));
           System.out.println("=====================================");
        }
        System.out.println();
        
        System.out.println("Average time for method timeSortofUnsortedList()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<17001;i=i+1000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeSortofUnsortedList(i,i));
           System.out.println("=====================================");
        }
        System.out.println();
        
        System.out.println("Average time for method timeSortofSortedList()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<17001;i=i+1000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeSortofSortedList(i,i));
           System.out.println("=====================================");
        }
        System.out.println();
    }
    /**
     * Returns time taken for addToFront() to run
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run addToFront();
     */
    public float timeAddToFront(int numberOfItems, int seed)
    {
        Random random = new Random(seed);
        float output = (float) 0.0;
        RandomStringContainer instance = new RandomStringContainer();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfItems;i++){
            instance.addToFront(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for addToBack() to run
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run addToBack();
     */
    public float timeAddToBack(int numberOfItems, int seed){
        Random random = new Random(seed);
        float output = (float) 0.0;
        RandomStringContainer instance = new RandomStringContainer();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for addSorted() to run
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run addSorted();
     */
    public float timeAddSorted(int numberOfItems, int seed){
        Random random = new Random(seed);
        float output = (float) 0.0;
        RandomStringContainer instance = new RandomStringContainer();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfItems;i++){
            instance.addSorted(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for addPrependSorted() to run
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run addPrependSorted();
     */
    public float timePrependSorted(int numberOfItems, int seed){
        Random random = new Random(seed);
        float output = (float) 0.0;
        RandomStringContainer instance = new RandomStringContainer();
        instance.addToFront(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfItems;i++){
            instance.prependSorted(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for selectionSort() on an unsorted list to run
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run selectionSort() on an unsorted list
     */
    public float timeSortofUnsortedList(int numberOfItems, int seed){
        Random random = new Random(seed);
        float output = (float) 0.0;
        RandomStringContainer instance = new RandomStringContainer();
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long startTime = System.currentTimeMillis();
        instance.selectionSort();
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
    
    /**
     * Returns time taken for selectionSort() on an sorted list to run
     *
     * @param numberOfItems Number of data entries
     * @param seed Seed for Random class
     * @return output Time taken to run selectionSort() on an sorted list
     */
    public float timeSortofSortedList(int numberOfItems, int seed){
        Random random = new Random(seed);
        float output = (float) 0.0;
        RandomStringContainer instance = new RandomStringContainer();
        for(int i=0;i<numberOfItems;i++){
            instance.addToBack(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        instance.selectionSort();
        long startTime = System.currentTimeMillis();
        instance.selectionSort();
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
}