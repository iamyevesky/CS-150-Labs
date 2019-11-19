import java.util.*;
import java.io.*;
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    // instance variables - replace the example below with your own
    private FoodByType container;
    private static Scanner reader;
    private static String fileToBeRead = "food.txt";
    /**
     * Constructor for objects of class Controller
     */
    public Controller()
    {
        // initialise instance variables
        container = new FoodByType("Breakfast");
    }
    
    
    public static void main(String args[]){
        if(args.length!=0)fileToBeRead = args[0]+".txt"; 
        Controller control = new Controller();
        control.run(fileToBeRead);
    }
    
    public void run(String filename){
        try{
            reader = new Scanner(new File(filename));
        }catch(Exception e){
            System.out.println(".txt format of input file does not exist or input argument is empty");
            System.out.print(e);
        }
        
        while(reader.hasNext()){
            Food food = new Food();
            for(int i=0;i<4;i++){
                if(i==0)food.setMeal(reader.next());
                else if(i==1) food.setType(reader.next());
                else if(i==2) food.setName(reader.next());
                else if(i==3) food.setPrice(Integer.parseInt(reader.next()));
            }
            if(container.add(food)){
            System.out.println("Addition of food successful");
            }else{
            System.out.println("Addition of food not successful");
            }
        }
        
        // container.display("V", 9999);
        // container.display("O", 9999);
        // container.display("GF", 9999);
        // container.display("VGF", 9999);
    }
}
