import java.util.*;
import java.io.*;
/**
 * Write a description of class ExperimentController here.
 *
 * @author Sena Yevenyo
 * @version November 24, 2019
 */
public class ExperimentController
{
    // instance variables - replace the example below with your own
    public static PrintWriter writer;
    public static Scanner reader;
    public static ExperimentController simulator;
    public static String[] nodes = {"a","b","c","d","e","f","g","h","i","j"};
    public static Random random = new Random();
    /**
     * Constructor for objects of class ExperimentController
     */
    public static void main(String [] args){
        String inputFileName = args[0];
        String outputFileName = args[1];
        File dataFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        writer = null;
        reader = null;
        simulator = new ExperimentController();
        try{
            writer = new PrintWriter(outputFile);
            reader = new Scanner(dataFile);
        }catch(Exception e){
            System.out.println(e);
        }
        
        String[] probabilities = reader.nextLine().split(" ");
        writer.println(", timeConnectedAdjacencyListImplementation, timeConnectedAdjacencyMatrixImplementation, timeKruskalAdjacencyListImplementation, timeKruskalAdjacencyMatrixImplementation");
        simulator.run(probabilities);
        writer.close();
        reader.close();
    }
    
    /**
     * Constructor for objects of class ExperimentController
     */
    public ExperimentController()
    {
        // initialise instance variables
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void run(String [] prob)
    {
        for(int i=0;i<prob.length;i++){ 
            float probNum = Float.parseFloat(prob[i]);
            if(0<probNum && 1.00-probNum>0){
                writer.print(probNum);
                writer.print(", ");
                ListUndirectedWeightedGraph listGraph = createListGraph(probNum);
                MatrixUndirectedWeightedGraph matrixGraph = createMatrixGraph(probNum);
                writer.print(testConnected(listGraph));
                writer.print(", ");
                writer.print(testConnected(matrixGraph));
                writer.print(", ");
                writer.print(testKruskal(listGraph));
                writer.print(", ");
                writer.println(testKruskal(matrixGraph));
            } 
        }
    }
    
    public ListUndirectedWeightedGraph createListGraph(float prob){
        ListUndirectedWeightedGraph graph = new ListUndirectedWeightedGraph();
        for(int i=0;i<nodes.length;i++){
            graph.addNode(nodes[i]);
        }
        
        for(int i=0;i<nodes.length;i++){
            for(int j=i;j<nodes.length;j++){
                if(random.nextDouble()<prob){
                    graph.addEdge(nodes[i], nodes[j], random.nextInt(8)+2);
                }
            }
        }
        return graph;
    }
    
    public MatrixUndirectedWeightedGraph createMatrixGraph(float prob){
        MatrixUndirectedWeightedGraph graph = new MatrixUndirectedWeightedGraph();
        for(int i=0;i<nodes.length;i++){
            graph.addNode(nodes[i]);
        }
        
        for(int i=0;i<nodes.length;i++){
            for(int j=i;j<nodes.length;j++){
                if(random.nextDouble()<prob){
                    graph.addEdge(nodes[i], nodes[j], random.nextInt(8)+2);
                }
            }
        }
        return graph;
    }
    
    public float testConnected(ListUndirectedWeightedGraph graph){
        float output = (float) Integer.MIN_VALUE;
        float [] times = new float[100];
        int sum = 0;
        for(int i=0;i<times.length;i++){
            float startTime = System.nanoTime();
            boolean state = graph.isConnected();
            float endTime = System.nanoTime();
            if(state){
                times[i] = endTime - startTime;
            }else{
                times[i] = startTime- endTime;
            }
        }
        
        for(int i=0;i<times.length;i++){
            sum+=times[i];
        }
        output = sum/(float)100;
        return output;
    }
    
    public float testKruskal(ListUndirectedWeightedGraph graph){
        float output = (float) Integer.MIN_VALUE;
        float [] times = new float[100];
        int sum = 0;
        for(int i=0;i<times.length;i++){
            float startTime = System.nanoTime();
            boolean state = graph.kruskal(graph);
            float endTime = System.nanoTime();
            if(state){
                times[i] = endTime - startTime;
            }else{
                times[i] = startTime- endTime;
            }
        }
        
        for(int i=0;i<times.length;i++){
            sum+=times[i];
        }
        output = sum/(float)100;
        return output;
    }
    
    public float testConnected(MatrixUndirectedWeightedGraph graph){
        float output = (float) Integer.MIN_VALUE;
        float [] times = new float[100];
        int sum = 0;
        for(int i=0;i<times.length;i++){
            float startTime = System.nanoTime();
            boolean state = graph.isConnected();
            float endTime = System.nanoTime();
            if(state){
                times[i] = endTime - startTime;
            }else{
                times[i] = startTime- endTime;
            }
        }
        
        for(int i=0;i<times.length;i++){
            sum+=times[i];
        }
        output = sum/(float)100;
        return output;
    }
    
    public float testKruskal(MatrixUndirectedWeightedGraph graph){
        float output = (float) Integer.MIN_VALUE;
        float [] times = new float[100];
        int sum = 0;
        for(int i=0;i<times.length;i++){
            float startTime = System.nanoTime();
            boolean state = graph.kruskal(graph);
            float endTime = System.nanoTime();
            if(state){
                times[i] = endTime - startTime;
            }else{
                times[i] = startTime- endTime;
            }
        }
        
        for(int i=0;i<times.length;i++){
            sum+=times[i];
        }
        output = sum/(float)100;
        return output;
    }
}
