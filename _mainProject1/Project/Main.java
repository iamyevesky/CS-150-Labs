
/**
 * A mini-simulation that runs the program Restaurant
 *
 * @author Sena Yevenyo
 * @version October 4, 2019
 */
public class Main
{
    // instance variables - replace the example below with your own
    Food food = new Bagel();
    public Restaurant lafayette = new Restaurant(food, 5, 4, 4);

    /**
     * Constructor for objects of class Main
     */
    public Main()
    {
        
    }

    /**
     * Main method of the program.
     * 
     * Runs a for loop simulating the clock.tick() in the final program.
     */
    public static void main(String args[]){
        Main main = new Main();
        main.run();
    }
    
    public void run(){
        for(int i=0;i<20;i++){
            System.out.println("Time "+i);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            lafayette.receiveCustomers(5);
            lafayette.acceptOrders();
            lafayette.cookMeals();
            lafayette.receiveDoneOrders();
            lafayette.executeOrders();
            lafayette.checkout();
        }
    }
}
