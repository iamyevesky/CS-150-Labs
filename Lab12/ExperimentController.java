import java.util.*;
import java.io.*;
/**
 * Main class that controls the Experiment.
 *
 * @author Sena Yevenyo
 * @version December 8, 2019
 */
public class ExperimentController
{
    // instance variables - replace the example below with your own
    private int startLine;
    private static Random random;
    private static Scanner reader = null;
    private static Scanner inReader = null;
    private static PrintWriter writer = null;
    public static void main(String [] args){
        try{
            reader = new Scanner(new File(args[0]));
            inReader = new Scanner(new File(args[1]));
            writer = new PrintWriter(new File(args[2]+".csv"));
        }
        catch(Exception e){
            System.out.println("Data file does not exist");
            return ;
        }
        
        ExperimentController sim = new ExperimentController();
        ArrayList<String []> data = sim.run(reader);
        writeSetup(data);
        String [] stuData = data.get(random.nextInt(data.size()));
        StudentRecord real = new StudentRecord(args[1],args[2],args[0]);
        StudentRecord fake = new StudentRecord("a","b","0");
        while(inReader.hasNext()){
            String [] param = inReader.nextLine().split(" ");
            writeData(data,param, real, fake);
        }
        writer.close();
    }
    
    public static void writeData(ArrayList<String[]> data, String args[], StudentRecord real, StudentRecord fake){
        writer.print(args[0]+" "+args[1]+" "+args[2]);
        writer.print(","+testInsertLinHash(data, Integer.parseInt(args[0]), Float.parseFloat(args[1])));
        writer.print(","+testInsertChainHash(data, Integer.parseInt(args[0]), Integer.parseInt(args[2])));
        writer.print(","+testInsertTreeHash(data));
        writer.print(","+testSearchLinHash(data, Integer.parseInt(args[0]), Float.parseFloat(args[1]), real));
        writer.print(","+testSearchChainHash(data, Integer.parseInt(args[0]), Integer.parseInt(args[2]), real));
        writer.print(","+testSearchTreeHash(data, real));
        writer.print(","+testSearchNALinHash(data, Integer.parseInt(args[0]), Float.parseFloat(args[1]), fake));
        writer.print(","+testSearchNAChainHash(data, Integer.parseInt(args[0]), Integer.parseInt(args[2]), fake));
        writer.println(","+testSearchNATreeHash(data, fake));
    }
    
    public static void writeSetup(ArrayList<String[]> data){
        writer.print(data.size()+",LinearHashInsert,ChainHashInsert,TreeHashInsert,LinearHashSearchSuccessful,ChainHashSearchSuccessful,TreeHashSearchSuccessful,LinearHashSearchUnsuccessful");
        writer.println(",ChainHashSearchUnsuccessful,TreeHashSearchUnsuccessful");
    }
   
    public static float testInsertLinHash(ArrayList<String[]> data, int N, float factor){
        LinearHashRoster roster = new LinearHashRoster(N, factor);
        float start = System.nanoTime();
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testInsertChainHash(ArrayList<String[]> data, int N, int factor){
        ChainHashRoster roster = new ChainHashRoster(N, factor);
        float start = System.nanoTime();
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testInsertTreeHash(ArrayList<String[]> data){
        TreeRoster roster = new TreeRoster();
        float start = System.nanoTime();
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testSearchLinHash(ArrayList<String[]> data, int N, float factor, StudentRecord record){
        LinearHashRoster roster = new LinearHashRoster(N, factor);
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float start = System.nanoTime();
        roster.containsValue(record);
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testSearchChainHash(ArrayList<String[]> data, int N, int factor, StudentRecord record){
        ChainHashRoster roster = new ChainHashRoster(N, factor);
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float start = System.nanoTime();
        roster.containsValue(record);
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testSearchTreeHash(ArrayList<String[]> data, StudentRecord record){
        TreeRoster roster = new TreeRoster();
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float start = System.nanoTime();
        roster.containsValue(record);
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testSearchNALinHash(ArrayList<String[]> data, int N, float factor, StudentRecord record){
        LinearHashRoster roster = new LinearHashRoster(N, factor);
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float start = System.nanoTime();
        roster.containsValue(record);
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testSearchNAChainHash(ArrayList<String[]> data, int N, int factor, StudentRecord record){
        ChainHashRoster roster = new ChainHashRoster(N, factor);
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float start = System.nanoTime();
        roster.containsValue(record);
        float end = System.nanoTime();
        return end - start;
    }
    
    public static float testSearchNATreeHash(ArrayList<String[]> data, StudentRecord record){
        TreeRoster roster = new TreeRoster();
        for(int i=0;i<data.size();i++){
            roster.put(new StudentRecord(data.get(i)[2], data.get(i)[0], data.get(i)[1]));
        }
        float start = System.nanoTime();
        roster.containsValue(record);
        float end = System.nanoTime();
        return end - start;
    }
    
    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {
        // initialise instance variables
        random = new Random();
        startLine = random.nextInt(142857);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public ArrayList<String []> run(Scanner reader)
    {
        int count = 0;
        ArrayList<String []> data = new ArrayList<String[]>(10000);
        while(reader.hasNext()){
            if(count>=startLine){
                String [] args = reader.next().split(",");
                data.add(args);
            }
            count++;
        }
        return data;
    }
    
    
}
