
import java.util.*;
/**
 * Test the runtime of all the methods of RandomStringContainer class
 *
 * @author Sena Yevenyo
 * @version September 9, 2019
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
    
    
                                              
    public static void main(String[] args){
        ExperimentController analyzer = new ExperimentController();
        
        System.out.println("Average time for method AddToBack()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<17001;i=i+1000){
            System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeAddToBack(i,i));
            System.out.println("=====================================");
        }
        System.out.println();
        
        System.out.println("Average time for method toString()");
        System.out.println();
        System.out.println("=====================================");
        System.out.println();
        for(int i=1;i<17001;i=i+1000){
           System.out.println("numberOfItems: "+i+" seed: "+i+" time: "+analyzer.timeAddToBack(i,i));
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
    public float timeAddToBack(int numberOfItems, int seed){
        StringList instance = new StringList();
        Random random = new Random(seed);
        float output = (float) 0.0;
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numberOfItems;i++){
            instance.append(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
    
    public float timeToString(int numberOfItems, int seed){
        StringList instance = new StringList();
        Random random = new Random(seed);
        float output = (float) 0.0;
        for(int i=0;i<numberOfItems;i++){
            instance.append(twoLetterWords[random.nextInt(twoLetterWords.length)]);
        }
        long startTime = System.currentTimeMillis();
        instance.toString();
        long stopTime = System.currentTimeMillis();
        output = (float)(stopTime-startTime);
        return output;
    }
}
