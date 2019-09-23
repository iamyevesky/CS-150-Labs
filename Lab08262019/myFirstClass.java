
/**
 * @brief: First class for CS150L
 * 
 * @author: Sena Yevenyo
 * @version: August 26, 2019
 */
public class myFirstClass
{
    // instance variables - replace the example below with your own
    int x;
    int y;
    
    public static void main(String[] args){
    myFirstClass mfc1 = new myFirstClass();
    mfc1.run();
    }

    /**
     * Constructor for objects of class myFirstClass
     */
    public myFirstClass()
    {
        // initialise instance variables
        this.x = 3;
        this.y = 4;
    }

    /**
     * @brief
     * @param
     */
    public void run()
    {
        // put your code here
        System.out.println("mfc1: "+this.x+" "+this.y);
        x = 100;
        y = 300;
        
        System.out.println("mfc1: "+this.x+" "+this.y);
    }
}
