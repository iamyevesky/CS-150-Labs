import java.util.*;
import java.io.*;
/**
 * A class that represents a restaurant
 *
 * @author Sena Yevenyo
 * @version September 28, 2019
 */
public class Restaurant
{
    // instance variables
    String logFilename = null;
    String filename = null;
    PrintWriter writer = null;
    int maxNumOfCashiers;
    int maxNumOfCooks;
    int leftNumOfCashiers;
    int leftNumOfCooks;
    int totalNumOfCustomers = 0;
    Queue<Order> orderList;
    Queue<Order> checkoutList;
    Food food;
    Queue<Customer> waitingToOrderCustomers;
    Queue<Customer> waitingForOrderCustomers;
    Queue<Customer> waitingToCheckoutCustomers;
    LinkedList<Cook> cookList;
    LinkedList<Cashier> cashierList;
    /**
     * Constructor for objects of class Restaurant
     */
    public Restaurant(String filename,Food food, int numOfCashiers, int numOfCooks){
        logFilename = filename+"_Log"+".txt";
        this.filename = filename+".txt";
        this.food = food;
        maxNumOfCashiers = numOfCashiers;
        maxNumOfCooks = numOfCooks;
        leftNumOfCashiers = maxNumOfCashiers;
        leftNumOfCooks = maxNumOfCooks;
        orderList = new PriorityQueue<Order>(1, idOrderComparator);
        checkoutList = new PriorityQueue<Order>(1, idOrderComparator);
        waitingToOrderCustomers = new PriorityQueue<Customer>(1, idCustomerComparator);
        waitingForOrderCustomers = new PriorityQueue<Customer>(1, idCustomerComparator);
        waitingToCheckoutCustomers = new PriorityQueue<Customer>(1, idCustomerComparator);
        cookList = new LinkedList<Cook>();
        cashierList = new LinkedList<Cashier>();
        try{
            writer = new PrintWriter(new File(logFilename));
        }catch(Exception e){
            System.err.println(e);
        }
        
        for(int i=0;i<maxNumOfCooks;i++){
            cookList.add(new Cook(i, this.food));
        }

        for(int i=0;i<maxNumOfCashiers;i++){
            cashierList.add(new Cashier(i));
        }
    }

    /**
     * Receive customers into the restaurant
     *
     * @param numOfCustomers customers to be received by restaurant
     * @param isBusy status of operating nature of restaurant (if busy or not)
     */
    public void receiveCustomers(int numOfCustomers, float isBusy)
    {
        int init = totalNumOfCustomers;
        for(int i =0;i<numOfCustomers;i++){
            waitingToOrderCustomers.add(new Customer(totalNumOfCustomers, this.food, isBusy));
            totalNumOfCustomers++;
        }
        //Print data
        writer.println("Time "+GlobalClock.time());
        writer.println("++++++++++++++++++++++++++++++++++++++++++++");
        writer.println();
        
        writer.println("Stage 1. Customers received");
        int diff = totalNumOfCustomers - init;
        writer.print(diff+" customers entered. ");
        writer.println("Total customers entered: "+totalNumOfCustomers);
        writer.println("Total customers waiting to order: "+waitingToOrderCustomers.size());
        writer.println("Total customers waiting for order: "+waitingForOrderCustomers.size());
        writer.println("Total customers waiting to checkout: "+waitingToCheckoutCustomers.size());
        int total = waitingToOrderCustomers.size() + waitingForOrderCustomers.size() + waitingToCheckoutCustomers.size();
        writer.println("Total customers currently in restaurant: "+total);
        writer.println();
        writer.println("===================================================================================");
        writer.println();
    }

    /**
     * Accepts waiting customers orders in the restaurant
     *
     */
    public void acceptOrders(){
        writer.println("Stage 2. Orders accepted");
        int init = waitingToOrderCustomers.size();
        Iterator it = waitingToOrderCustomers.iterator();
        while(leftNumOfCashiers>0 && it.hasNext()){
            Customer temp = waitingToOrderCustomers.poll();
            writer.println("Customer "+temp.getID()+" ordered meal");
            orderList.add(new Order(temp.getID(),temp.getFood(), temp.getOrderNum()));
            waitingForOrderCustomers.add(temp);
            leftNumOfCashiers--;
        }
        leftNumOfCashiers = maxNumOfCashiers;
        //Print data
        int diff = init - waitingToOrderCustomers.size();
        writer.println();
        writer.println("Data from acceptOrders()");
        writer.println();
        writer.println(diff+" orders processed for execution");
        writer.println(waitingToOrderCustomers.size()+" customers left to order");
        writer.println();
        writer.println("===================================================================================");
        writer.println();
    }

    /**
     * Executes waiting orders in the restaurant
     *
     */
    public void executeOrders(){
        Iterator it0 = orderList.iterator();
        Iterator it1 = cookList.iterator();
        int init = orderList.size();
        writer.println("Stage 5. Executing orders");
        if(leftNumOfCooks==0) writer.println("0 cooks available. No order executed.");
        for(int i=0; i<orderList.size() && leftNumOfCooks>0; i++){
            Order temp0 = orderList.poll(); 
            int num = temp0.getMaxNumOrder();
            while(it1.hasNext()&&temp0.getNumOrder()>0){
                Cook temp1 = (Cook) it1.next();
                writer.println("Cook "+temp1.getID()+" availability: "+temp1.checkAvailability());
                if(temp1.checkAvailability()){
                    temp1.getTask(temp0.getFoodExecute());
                    if(!checkoutList.contains(temp0)) {
                        writer.println("Order "+temp0.getID()+" has been added to checkoutList");
                        checkoutList.add(temp0);
                    }
                    if(temp0.isReceived()) {
                        writer.println("Order number: "+temp0.getID()+" has been processed");
                    }
                    leftNumOfCooks--;
                }
            }
            //No cook is available if numOfOrder stays the same.
            if(num==temp0.getNumOrder()) {
                writer.println("Order number: "+temp0.getID()+" was not processed");
                writer.println("No cooks available");
                orderList.add(temp0);
                break;
            }
            else if(num!=temp0.getNumOrder()&&!temp0.isReceived()){
                writer.println("Order number "+temp0.getID()+" was partially processed");
                orderList.add(temp0);
                break;
            }
        }
        //For cooks who are done and did not receive order for next round of meals.
        //done variable should be reset to false.
        Iterator it2 = cookList.iterator();
        while(it2.hasNext()){
            Cook temp3 = (Cook) it2.next();
            if(temp3.doneCooking()){
                temp3.reset();
            }
        }
        //leftNumOfCooks = maxNumOfCooks;
        writer.println();
        writer.println("Data from executeOrders()");
        writer.println();
        int diff = init - orderList.size();
        writer.println(diff+" orders processed");
        writer.println(orderList.size()+" orders left to process");
        writer.println();
        writer.println("===================================================================================");
        writer.println();
    }

    /**
     * Runs to order Cook objects to continue cooking meals.
     *
     */
    public void cookMeals(){
        writer.println("Stage 3. Cooks making meals");
        Iterator it0 = cookList.iterator();
        while(it0.hasNext()){
            Cook temp = (Cook) it0.next();
            temp.cook();
            if(!temp.doneCooking()&&!temp.checkAvailability()) {
                writer.println("Cook "+temp.getID()+" still cooking meal.");
            }else{
                if(temp.doneCooking())writer.println("Cook "+temp.getID()+" done cooking!");
                else if(temp.checkAvailability()) writer.println("Cook "+temp.getID()+" available");
                leftNumOfCooks++;
            }
        }
        writer.println();
        writer.println("Data from cookMeals()");
        writer.println();
    }

    /**
     * Obtains completed meals from cooks
     *
     */
    public void receiveDoneOrders(){
        int init = checkoutList.size();
        Iterator it0 = cookList.iterator();
        Iterator it1 = checkoutList.iterator();
        writer.println("Stage 4. Customers receiving orders");
        for(int i=0; i<checkoutList.size(); i++){
            Order temp1 = checkoutList.poll();
            while(it0.hasNext()){
                Cook temp0 = (Cook) it0.next();
                if(temp0.doneCooking()){
                    writer.println("Cook "+temp0.getID()+" is done cooking.");
                    temp1.updateOrder();
                    leftNumOfCooks++;
                }
                if(temp1.isDone()){
                    writer.println("Order "+temp1.getID()+" is done!");
                    Iterator it2 = waitingForOrderCustomers.iterator();
                    if(it2.hasNext()) {
                        Customer temp2 = waitingForOrderCustomers.poll();
                        temp2.receiveOrder();
                        writer.println("Customer "+temp2.getID()+" has received order!");
                        waitingToCheckoutCustomers.add(temp2);
                    }
                    break;
                }
            }
            //If order was not done, then while loop breaks
            if(!temp1.isDone()) {
                writer.println("Order "+temp1.getID()+" not done cooking!");
                checkoutList.add(temp1);
                break;
            }
        }

        //Print data
        writer.println();
        writer.println("Data from receiveDoneOrders()");
        writer.println();
        int diff = init - checkoutList.size();
        writer.println(diff+" orders received by customers");
        writer.println(waitingForOrderCustomers.size()+" customers left receive order");
        writer.println();
        writer.println("===================================================================================");
        writer.println();
    }

    /**
     * Obtains checks out customers from the restaurant
     *
     */
    public void checkout(){
        int init = waitingToCheckoutCustomers.size();
        writer.println("Stage 5. Customers checking out.");
        Iterator it0 = cashierList.iterator();
        Iterator it1 = waitingToCheckoutCustomers.iterator();
        while(leftNumOfCashiers>0 && it1.hasNext()){
            Customer temp1 = waitingToCheckoutCustomers.poll();
            Cashier temp0 = (Cashier) it0.next();
            temp0.getInfo(temp1.checkout());
            writer.println("Customer "+temp1.getID()+" has checked out!");
            leftNumOfCashiers--;
        }
        leftNumOfCashiers = maxNumOfCashiers;
        writer.println();
        writer.println("Data from executeOrders()");
        writer.println();
        int diff = init - waitingToCheckoutCustomers.size();
        writer.println(diff+" orders received by customers");
        writer.println(waitingToCheckoutCustomers.size()+" customers left to checkout");
        writer.println();
        writer.println("===================================================================================");
        writer.println();
    }
    
    /**
     * Writes data from simulation of the Restaurant into a file.
     *
     * @param filename: Filename into which data is stored.  
     */
    public void readWriteSimulationData(){
        PrintWriter dataWriter = null;
        
        float revenue = (float) Cashier.numOfOrders() * (float) food.getPrice();
        float cost = Cashier.obtainCashierCost()+Cook.obtainCookCost();
        float profit = revenue - cost;
        float staffUtilIndex = (float) Cashier.obtainAverageSatisfaction()/cost;
        writer.close();
        
        try{
            dataWriter = new PrintWriter(new File(filename));
        }catch(Exception e){
            System.err.println("Error");
        }
        
        dataWriter.println("Food of restaurant, "+food);
        dataWriter.println("Food price, "+food.getPrice());
        dataWriter.println("Simulation runtime in quants, 720");
        dataWriter.println("Order volumes, "+Cashier.numOfOrders());
        dataWriter.println("Number of customers welcomed, "+totalNumOfCustomers);
        dataWriter.println("Number of customers checked out, "+Cashier.numOfCustomersChecked());
        dataWriter.println("Number of cashiers, "+maxNumOfCashiers);
        dataWriter.println("Number of cooks, "+maxNumOfCooks);            
        dataWriter.println("Revenue generated, "+revenue);
        dataWriter.println("Cost incurred, "+cost);
        dataWriter.println("Profits generated, "+profit);
        dataWriter.println("Average customer satisfaction, "+Cashier.obtainAverageSatisfaction());
        dataWriter.println("Average customer satisfaction at busy mode, "+Cashier.obtainBusySatisfaction());
        dataWriter.println("Average customer satisfaction at normal mode, "+Cashier.obtainNormalSatisfaction());
        dataWriter.println("Average wait time per customer, "+Cashier.obtainAverageTimeSpent());
        dataWriter.println("Average wait time per customer in busy mode, "+Cashier.obtainBusyTimeSpent());
        dataWriter.println("Average wait time per customer in normal mode, "+Cashier.obtainNormalTimeSpent());
        dataWriter.println("Staff utilization index, "+staffUtilIndex); 
        dataWriter.close();
        System.out.println("Writing simulation data done!");
        
    }

    public static Comparator<Customer> idCustomerComparator = new Comparator<Customer>(){
            @Override
            public int compare(Customer c1, Customer c2){
                return (int) (c1.getID() - c2.getID());
            }
    };

    public static Comparator<Order> idOrderComparator = new Comparator<Order>(){
            @Override
            public int compare(Order o1, Order o2){
                return (int) (o1.getID() - o2.getID());
            }
    };
}
