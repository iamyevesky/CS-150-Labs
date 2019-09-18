import java.util.Scanner;
/**
 * @brief: Tests out Scanner lib
 *
 * @author Sena Yevenyo
 * @version 1.0
 */
public class TerminalDemo
{
    //Constructor for objects of class TerminalDemo
    public static void main(String[] args){
        TerminalDemo demo = new TerminalDemo();
        demo.run();
    }
    
    public void run(){
        Scanner reader = new Scanner(System.in);
        String name = null;
        int age;
        
        try{
            System.out.print("Name: ");
            name = reader.next();
            System.out.println("Name entered :"+name);
            
            System.out.print("Age: ");
            age = reader.nextInt();
            System.out.println("Age is: "+age);
        }catch(Exception e){
            System.out.println("Exception occured "+e);
        }
    }
}
