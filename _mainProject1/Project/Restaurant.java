import java.util.*;
/**
 * A class that represents a restaurant
 *
 * @author Sena Yevenyo
 * @version September 28, 2019
 */
public class Restaurant
{
    // instance variables
    int maxNumOfCashiers;
    int maxNumOfCheckInScreens;
    int maxNumOfCooks;
    int leftNumOfCashiers;
    int leftNumOfCooks;
    int leftNumOfCheckInScreens;
    int totalNumOfCustomers = 0;
    Queue<Order> orderList;
    Queue<Order> checkoutList;
    Food food;
    Queue<Customer> waitingToOrderCustomers;
    Queue<Customer> waitingForOrderCustomers;
    Queue<Customer> waitingToCheckoutCustomers;
    LinkedList<Cook> cookList;
    LinkedList<Cashier> cashierList;
    LinkedList<OrderScreen> screenList;
    /**
     * Constructor for objects of class Restaurant
     */
    public Restaurant(Food food, int numOfCashiers, int numOfCooks, int numOfScreens){
        this.food = food;
        maxNumOfCashiers = numOfCashiers;
        maxNumOfCooks = numOfCooks;
        maxNumOfCheckInScreens = numOfScreens;
        leftNumOfCashiers = maxNumOfCashiers;
        leftNumOfCooks = maxNumOfCooks;
        leftNumOfCheckInScreens = maxNumOfCheckInScreens;
        orderList = new PriorityQueue<Order>(1, idOrderComparator);
        checkoutList = new PriorityQueue<Order>(1, idOrderComparator);
        waitingToOrderCustomers = new PriorityQueue<Customer>(1, idCustomerComparator);
        waitingForOrderCustomers = new PriorityQueue<Customer>(1, idCustomerComparator);
        waitingToCheckoutCustomers = new PriorityQueue<Customer>(1, idCustomerComparator);
        cookList = new LinkedList<Cook>();
        cashierList = new LinkedList<Cashier>();
        screenList = new LinkedList<OrderScreen>();
        for(int i=0;i<maxNumOfCooks;i++){
            cookList.add(new Cook(i, this.food));
        }
        
        for(int i=0;i<maxNumOfCashiers;i++){
            cashierList.add(new Cashier(i));
        }
        
        for(int i=0;i<maxNumOfCheckInScreens;i++){
            screenList.add(new OrderScreen(i));
        }
    }
    
    /**
     * Receive customers into the restaurant
     *
     * @param numOfCustomers customers to be received by restaurant 
     */
    public void receiveCustomers(int numOfCustomers)
    {
        int init = totalNumOfCustomers;
        for(int i =0;i<numOfCustomers;i++){
            waitingToOrderCustomers.add(new Customer(totalNumOfCustomers, this.food));
            totalNumOfCustomers++;
        }
        //Print data
        System.out.println("Stage 1. Customers received");
        int diff = totalNumOfCustomers - init;
        System.out.print(diff+" customers entered. ");
        System.out.println("Total customers entered: "+totalNumOfCustomers);
        System.out.println("Total customers waiting to order: "+waitingToOrderCustomers.size());
        System.out.println("Total customers waiting for order: "+waitingForOrderCustomers.size());
        System.out.println("Total customers waiting to checkout: "+waitingToCheckoutCustomers.size());
        int total = waitingToOrderCustomers.size() + waitingForOrderCustomers.size() + waitingToCheckoutCustomers.size();
        System.out.println("Total customers currently in restaurant: "+total);
        System.out.println();
        System.out.println("===================================================================================");
        System.out.println();
    }
    
    /**
     * Accepts waiting customers orders in the restaurant
     *
     */
    public void acceptOrders(){
        System.out.println("Stage 2. Orders accepted");
        int init = waitingToOrderCustomers.size();
        Iterator it = waitingToOrderCustomers.iterator();
        while(leftNumOfCheckInScreens>0 && it.hasNext()){
            Customer temp = waitingToOrderCustomers.poll();
            System.out.println("Customer "+temp.getID()+" ordered meal");
            orderList.add(new Order(temp.getID(),temp.getFood(), temp.getOrderNum()));
            waitingForOrderCustomers.add(temp);
            leftNumOfCheckInScreens--;
        }
        leftNumOfCheckInScreens = maxNumOfCheckInScreens;
        //Print data
        int diff = init - waitingToOrderCustomers.size();
        System.out.println();
        System.out.println("Data from acceptOrders()");
        System.out.println();
        System.out.println(diff+" orders processed for execution");
        System.out.println(waitingToOrderCustomers.size()+" customers left to order");
        System.out.println();
        System.out.println("===================================================================================");
        System.out.println();
    }
    
    /**
     * Executes waiting orders in the restaurant
     *
     */
    public void executeOrders(){
        Iterator it0 = orderList.iterator();
        Iterator it1 = cookList.iterator();
        int init = orderList.size();
        System.out.println("Stage 5. Executing orders");
        if(leftNumOfCooks==0) System.out.println("0 cooks available. No order executed.");
        while(leftNumOfCooks>0&&it0.hasNext()){
            Order temp0 = orderList.peek(); 
            int num = temp0.getMaxNumOrder();
            while(it1.hasNext()&&temp0.getNumOrder()>0){
                Cook temp1 = (Cook) it1.next();
                System.out.println("Cook "+temp1.getID()+" availability: "+temp1.checkAvailability());
                if(temp1.checkAvailability()){
                    //temp1.setAvailability(false);
                    temp1.getTask(temp0.getFoodExecute());
                    checkoutList.add(temp0);
                    if(temp0.isReceived()) {
                        System.out.println("Order number: "+temp0.getID()+" has been processed");
                        //checkoutList.add(temp0);
                        orderList.poll();
                    }
                    leftNumOfCooks--;
                }
            }
            //No cook is available if numOfOrder stays the same.
            if(num==temp0.getNumOrder()) {
                System.out.println("Order number: "+temp0.getID()+" was not processed");
                System.out.println("No cooks available");
                break;
            }
            else if(num!=temp0.getNumOrder()&&!temp0.isReceived()){
                System.out.println("Order number "+temp0.getID()+" was partially processed");
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
        leftNumOfCooks = maxNumOfCooks;
        System.out.println();
        System.out.println("Data from executeOrders()");
        System.out.println();
        int diff = init - orderList.size();
        System.out.println(diff+" orders processed");
        System.out.println(orderList.size()+" orders left to process");
        System.out.println();
        System.out.println("===================================================================================");
        System.out.println();
    }
    
    /**
     * Runs to order Cook objects to continue cooking meals.
     *
     */
    public void cookMeals(){
        System.out.println("Stage 3. Cooks making meals");
        Iterator it0 = cookList.iterator();
        while(it0.hasNext()){
            Cook temp = (Cook) it0.next();
            temp.cook();
            if(!temp.doneCooking()) {
                System.out.println("Cook "+temp.getID()+" still cooking meal.");
            }else{
                if(temp.doneCooking())System.out.println("Cook "+temp.getID()+" available");
                else if(temp.checkAvailability()) System.out.println("Cook "+temp.getID()+" available");
            }
        }
        System.out.println();
        System.out.println("Data from cookMeals()");
        System.out.println();
    }
    
    /**
     * Obtains completed meals from cooks
     *
     */
    public void receiveDoneOrders(){
        int init = checkoutList.size();
        Iterator it0 = cookList.iterator();
        Iterator it1 = checkoutList.iterator();
        System.out.println("Stage 4. Customers receiving orders");
        while(it1.hasNext()){
            Order temp1 = checkoutList.peek();
            while(it0.hasNext()){
                Cook temp0 = (Cook) it0.next();
                if(temp0.doneCooking()){
                    System.out.println("Cook "+temp0.getID()+" is done cooking.");
                    temp1.updateOrder();
                    leftNumOfCooks++;
                }
                if(temp1.isDone()){
                    System.out.println("Order "+temp1.getID()+" is done!");
                    checkoutList.poll();
                    System.out.println("Order "+temp1.getID()+" removed");
                    System.out.println("Bug here. Order supposed to move out of checkoutList");
                    System.out.println("Order shows up later after 'Customer "+temp1.getID()+" has received order'");
                    System.out.println("But Order does not move out. Shows up after the above line as 'Order "+temp1.getID()+" not done cooking' Need fixing");
                    
                    Iterator it2 = waitingForOrderCustomers.iterator();
                    if(it2.hasNext()) {
                        Customer temp2 = waitingForOrderCustomers.poll();
                        temp2.receiveOrder();
                        System.out.println("Customer "+temp2.getID()+" has received order!");
                        waitingToCheckoutCustomers.add(temp2);
                    }
                    break;
                }
            }
            //If order was not done, then while loop breaks
            if( (checkoutList.contains(temp1)) && temp1.getID()==checkoutList.peek().getID()) {
                System.out.println("Order "+temp1.getID()+" not done cooking!");
                break;
            }
        }
        //Print data
        System.out.println();
        System.out.println("Data from receiveDoneOrders()");
        System.out.println();
        int diff = init - checkoutList.size();
        System.out.println(diff+" orders received by customers");
        System.out.println(waitingForOrderCustomers.size()+" customers left receive order");
        System.out.println();
        System.out.println("===================================================================================");
        System.out.println();
    }
    
    /**
     * Obtains checks out customers from the restaurant
     *
     */
    public void checkout(){
        int init = waitingToCheckoutCustomers.size();
        System.out.println("Stage 5. Customers checking out.");
        Iterator it0 = cashierList.iterator();
        Iterator it1 = waitingToCheckoutCustomers.iterator();
        while(leftNumOfCashiers>0 && it1.hasNext()){
            Customer temp1 = waitingToCheckoutCustomers.poll();
            Cashier temp0 = (Cashier) it0.next();
            temp0.getInfo(temp1.checkout());
            System.out.println("Customer "+temp1.getID()+" has checked out!");
            leftNumOfCashiers--;
        }
        leftNumOfCashiers = maxNumOfCashiers;
        System.out.println();
        System.out.println("Data from executeOrders()");
        System.out.println();
        int diff = init - waitingToCheckoutCustomers.size();
        System.out.println(diff+" orders received by customers");
        System.out.println(waitingToCheckoutCustomers.size()+" customers left to checkout");
        System.out.println();
        System.out.println("===================================================================================");
        System.out.println();
    }
    
    public static Comparator<Customer> idCustomerComparator = new Comparator<Customer>(){
        @Override
        public int compare(Customer c1, Customer c2){
            return (int) (c1.getID() - c2.getID());
        }};
    
    public static Comparator<Order> idOrderComparator = new Comparator<Order>(){
        @Override
        public int compare(Order o1, Order o2){
            return (int) (o1.getID() - o2.getID());
        }};
}
