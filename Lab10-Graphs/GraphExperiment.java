import java.util.*;
import java.io.*;

/**
 * Write a description of class GraphExperiment here.
 *
 * @author Sena Yevenyo
 * @version November 17, 2019
 */
public class GraphExperiment
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        DirectedGraph<String> graph = new DirectedGraph<String>();
        ArrayList<String> itemList = new ArrayList<String>();
        String filename = args[0];
        File file = new File(filename);
        Scanner reader = null;
        try{
            reader = new Scanner(file);
        }catch(Exception e){
            System.out.println(e);
        }
        String[] items = reader.nextLine().split(" ");
        for(String item:items){
            itemList.add(item);
            //System.out.println(item);
        }
        
        for(String item:itemList){
            graph.addNode(item);
        }
        
        while(reader.hasNextLine()){
            String [] parts = reader.nextLine().split(" ");
            graph.addEdge(itemList.get(itemList.indexOf(parts[0])),itemList.get(itemList.indexOf(parts[1])),Integer.parseInt(parts[2]));
            System.out.println(itemList.get(itemList.indexOf(parts[0]))+" "+itemList.get(itemList.indexOf(parts[1]))+" "+Integer.parseInt(parts[2]));
        }
        
        graph.dijkstra(itemList.get(itemList.indexOf(items[0])));
        System.out.println(graph.toString());
    }

    /**
     * Constructor for objects of class GraphExperiment
     */
    public GraphExperiment()
    {
        
    }
}
