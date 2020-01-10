import java.util.*;
import java.io.*;
/**
 * Top level class for the simulation.
 * The main function of this class when executed runs the simulation
 *
 * @author Sena Yevenyo
 * @version December 7, 2019
 */
public class SimulationController
{
    // instance variables - replace the example below with your own
    
    public static void main(String [] args){
        String inputFilename = args[0];
        Scanner reader = null;
        try{
            reader = new Scanner(new File(inputFilename));
        }catch(Exception e){
            System.out.println("Input data file does not exist");
        }
        if(reader == null) return;
        
        String outputFilename = reader.nextLine();
        ArrayList<String> sims = new ArrayList<String>();
        while(reader.hasNext()){
            sims.add(reader.nextLine());
        }
        
        Data.initDataClass(outputFilename);
        SimulationController simObject = new SimulationController();
        simObject.run(sims, outputFilename);
    }
    
    /**
     * Constructor for objects of class SimulationController
     */
    public SimulationController()
    {
        
    }
    
    /**
     * Runs simulation based on input data
     * 
     * @param ArrayList<String> values - parameters for multiple simulations
     * @param String outputFilename - name of output file containing data of multiple simulations
     */
    public void run(ArrayList<String> values, String outputFilename){
        Data.initData();
        System.out.println("Starting simulation");
        System.out.println("===========================");
        System.out.println("");
        for(int i=0;i<values.size();i++){
            String [] args = values.get(i).split(",");
            String simName = args[0];
            int size = Integer.parseInt(args[1]);
            float bFactor = Float.parseFloat(args[2]);
            int min = Integer.parseInt(args[3]);
            int max = Integer.parseInt(args[4]);
            int drivers = Integer.parseInt(args[5]);
            float prob = Float.parseFloat(args[6]);
            int hops = Integer.parseInt(args[7]);
            System.out.println(simName+" started");
            Data.initLogRange(outputFilename+simName);
            Data.logPrintln("Starting simulation "+simName);
            Data.logPrintln("=======================");
            Data.logPrintln();
            Passenger.initClass();
            Network network = new Network(size, bFactor, min, max);
            Driver.initNetwork(network);
            Driver.initDrivers(drivers);
            GlobalClock.run(360, prob, hops, network, min, max);
            Data.writeRange(network.rangeDistr());
            Data.writeData(simName, network);
            Data.logRangeClose();
            network = null;
            Data.logPrintln("Simulation done: "+simName);
            Data.logPrintln("=======================");
            System.out.println("");
            System.gc();
        }
        Data.dataClose();
    }
}
