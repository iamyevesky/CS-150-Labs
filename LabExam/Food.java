
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food
{
    // instance variables - replace the example below with your own
    private int price;
    private String name;
    private String type;
    private String meal;
    /**
     * Constructor for objects of class Food
     */
    public Food()
    {
        // initialise instance variables
        price = -1;
        name = meal = type =null;
    }

    public void setPrice(int newPrice){
        price = newPrice;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setMeal(String newMeal){
        meal = newMeal;
    }
    
    public String getMeal(){
        return meal;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public String getName(){
        return name;
    }
    
    public void setType(String newType){
        type = newType;
    }
    
    public String getType(){
        return type;
    }
    
    public void display(){
        if(meal!=null) System.out.print("Meal: "+meal);
        else System.out.print("Meal not set");
        System.out.print(", ");
        if(name!=null) System.out.print("Name: "+name);
        else System.out.print("Name not set");
        System.out.print(", ");
        if(type!=null) System.out.print("Type: "+type);
        else System.out.print("Type not set");
        System.out.print(", ");
        if(price>=0) System.out.println("Price: "+price);
        else System.out.println("Price not set");
    }
}
