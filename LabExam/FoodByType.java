import java.util.*;
/**
 * Write a description of class FoodByType here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FoodByType
{
    // instance variables - replace the example below with your own
    private LinkedList<Food> container;
    private String mealType;
    /**
     * Constructor for objects of class FoodByType
     */
    public FoodByType(String meal)
    {
        // initialise instance variables
        container = new LinkedList();
        mealType = meal;
    }
    
    public boolean add(Food item){
        if(item.getMeal().compareTo(mealType)==0){
            container.add(item);
            return true;
        }
        return false;
    }
    
    /**
       * Displays the items in the FoodByType container of specific type and budget
         *
         *
          * @param Type type of meal to be displayed
            * @param Budget maximum price of the meal 
              */
    public void display(String type, int budget){
        System.out.println("Printing meals of type: "+type+" and within budget "+budget);
        System.out.println("============================================================");
        System.out.println();
        for(int i=0;i<container.size();i++){
            if(container.get(i).getType().compareTo(type)==0 && container.get(i).getPrice()<=budget){
                container.get(i).display();
                System.out.println();
            }
        }
    }
}
