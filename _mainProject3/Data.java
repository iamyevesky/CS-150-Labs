import java.util.*;
import java.io.*;
/**
 * The data class collects all important data esential for analysis in other classes,
 * the execution of the tasks in these classes and organizes this data into log files
 * and csv files for analysis
 *
 * @author Sena Yevenyo
 * @version December 4, 2019
 */
public class Data
{
    // instance variables - replace the example below with your own
    private static PrintWriter logFile = null;
    private static PrintWriter dataFile = null;
    private static PrintWriter rangeFile = null;
    private static String logFilename;
    private static String dataFilename;
    private static String rangeFilename;
    
    public static void initLogRange(String filename){
        logFilename = filename+"_log.txt";
        rangeFilename = filename+"_range.csv";
        try{
            logFile = new PrintWriter(new File(logFilename));
            rangeFile = new PrintWriter(new File(rangeFilename));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void initDataClass(String filename){
        dataFilename = filename+"_data.csv";
        try{
            dataFile = new PrintWriter(new File(dataFilename));
        }catch(Exception e){
            System.out.println(e);
        }
    }
   
    
    public static void writeRange(Integer [] data){
        rangePrintln("Edge, Frequency");
        int i = 0;
        while(i<data.length){
            int freq = 1;
            int value = data[i];
            i++;
            while(i<data.length && data[i] == value){
                freq++;
                i++;
            }
            rangePrintln(value+", "+freq);
        }
    }
    
    public static void initData(){
        dataPrint(", ");
        dataPrint("Number of drivers, ");
        dataPrint("Number of drivers utilized, ");
        dataPrint("Number of passengers, ");
        dataPrint("Number of passengers lost, ");
        dataPrint("Loss frequency of passengers, ");
        dataPrint("Average distance travelled by drivers, ");
        dataPrint("Minimum distance travelled by drivers, ");
        dataPrint("Maximum distance travelled by drivers, ");
        dataPrint("Average wait-time of customers, ");
        dataPrint("Minimum wait-time of customers, ");
        dataPrint("Maximum wait-time of customers, ");
        dataPrint("Average trip time, ");
        dataPrint("Minimum trip time, ");
        dataPrint("Maximum trip time, ");
        dataPrint("Average satisfaction of customers, ");
        dataPrint("Minimum satisfaction of customers, ");
        dataPrint("Maximum satisfaction of customers, ");
        dataPrint("Number of vertices, ");
        dataPrint("Connectivity factor, ");
        dataPrint("Branching factor, ");
        dataPrint("Average range value, ");
        dataPrintln("Average mean-time traversal");
    }
    
    public static void writeData(String text,Network network){
        dataPrint(text+", ");
        dataPrint(Driver.getNumOfDrivers()+", ");
        dataPrint(Driver.getUtilizedFraction()+", ");
        dataPrint(Passenger.getNumOfPassengers()+", ");
        dataPrint(Driver.getLostCustomers()+", ");
        dataPrint((float) Driver.getLostCustomers()/(float)(Passenger.getNumOfPassengers()+Driver.getLostCustomers())+", ");
        dataPrint(Driver.getAverageDistanceTravelled()+", ");
        dataPrint(Driver.getMinimumDistanceTravelled()+", ");
        dataPrint(Driver.getMaximumDistanceTravelled()+", ");
        dataPrint(Passenger.getAverageWaitTime()+", ");
        dataPrint(Passenger.getMinWaitTime()+", ");
        dataPrint(Passenger.getMaxWaitTime()+", ");
        dataPrint(Passenger.getAverageTripTime()+", ");
        dataPrint(Passenger.getMinTripTime()+", ");
        dataPrint(Passenger.getMaxTripTime()+", ");
        dataPrint(Passenger.getAverageSatisfaction()+", ");
        dataPrint(Passenger.getMinSatisfaction()+", ");
        dataPrint(Passenger.getMaxSatisfaction()+", ");
        dataPrint(network.getSize()+", ");
        dataPrint(network.calculateConnectivity()+", ");
        dataPrint(network.getAvgBranching()+", ");
        dataPrint(network.getAvgEdge()+", ");
        dataPrintln(network.getAvgMeanTimeTraversal()+"");
    }
    
    public static void logRangeClose(){
        logFile.close();
        rangeFile.close();
    }
    
    public static void dataClose(){
        dataFile.close();
    }
    
    public static void logPrintln(String text){
        if(logFile!=null){
            logFile.println(text); 
        }
    }
    
    public static void logPrint(String text){
        if(logFile!=null){
            logFile.print(text);
        }
    }
    
    public static void logPrintln(){
        if(logFile!=null){
            logFile.println();
        }
    }
    
    public static void dataPrintln(String text){
        if(dataFile!=null){
            dataFile.println(text);
        }
    }
    
    public static void dataPrint(String text){
        if(dataFile!=null){
            dataFile.print(text);
        }
    }
    
    public static void dataPrintln(){
        if(dataFile!=null){
            dataFile.println();
        }
    }
    
    public static void rangePrintln(String text){
        if(rangeFile!=null){
            rangeFile.println(text);
        }
    }
    
    public static void rangePrint(String text){
        if(rangeFile!=null){
            rangeFile.print(text);
        }
    }
    
    public static void rangePrintln(){
        if(rangeFile!=null){
            rangeFile.println();
        }
    }
}
