import java.util.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DriverTest.
 *
 * @author  Sena Yevenyo
 * @version December 02, 2019
 */
public class DriverTest
{
    Driver driver0;
    Driver driver1;
    Driver driver2;
    Driver driver3;
    Passenger passenger0;
    Network graph0 = new Network(15);
    /**
     * Default constructor for test class DriverTest
     */
    public DriverTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,2);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        driver0 = new Driver(0, graph0.getNode(0));
        passenger0 = new Passenger(graph0.getNode(4), graph0.getNode(14), driver0);
    }
    
    @Test
    public void testGetID(){
        assertEquals(0, driver0.getID());
    }
    
    @Test
    public void testSetPassenger(){
        driver0.setCustomer(passenger0);
        assertEquals(passenger0, driver0.getCustomer());
    }
    
    @Test
    public void testGetLoc(){
        assertEquals(graph0.getNode(0), driver0.getLoc());
    }
    
    @Test
    public void testGo0(){
        driver0.go(graph0);
        driver0.go(graph0);
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(1);
        answer.add(2);
        assertEquals(true, answer.contains(driver0.getLoc().getID()));
    }
    
    @Test
    public void testGo1(){
        driver0 = new Driver(0, graph0.getNode(2));
        driver0.setCustomer(passenger0);
        for(int i=0;i<6;i++){
           driver0.go(graph0); 
        }
        assertEquals(graph0.getNode(4), driver0.getLoc());
    }
    
    @Test
    public void testGo2(){
        driver0 = new Driver(0, graph0.getNode(2));
        driver0.setCustomer(passenger0);
        for(int i=0;i<17;i++){
           driver0.go(graph0); 
        }
        assertEquals(graph0.getNode(14), driver0.getLoc());
    }
    
    @Test
    public void testGo3(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,6);
        graph0.createEdge(0,2,6);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        driver0 = new Driver(0, graph0.getNode(0));
        for(int i=0;i<2;i++){
           driver0.go(graph0); 
        }
        driver0.setCustomer(passenger0);
        for(int i=0;i<4;i++){
           driver0.go(graph0); 
        }
        //After six steps driver should have moved to node 1 or 2 but since a customer was assigned less than halfway through its journey, it returned back.
        //Thus should be at node 0, after 4 steps after assignment since it has not traversed the whole path betweeon node 0 and node 1 or 2
        assertEquals(graph0.getNode(0), driver0.getLoc());
    }
    
    @Test
    public void testGo4(){
        graph0 = new Network(15);
        graph0.createEdge(0,1,6);
        graph0.createEdge(0,2,6);
        graph0.createEdge(1,3,9);
        graph0.createEdge(1,4,2);
        graph0.createEdge(2,5,7);
        graph0.createEdge(2,6,3);
        graph0.createEdge(3,7,4);
        graph0.createEdge(3,8,7);
        graph0.createEdge(4,9,8);
        graph0.createEdge(4,10,10);
        graph0.createEdge(5,11,10);
        graph0.createEdge(5,12,9);
        graph0.createEdge(6,13,1);
        graph0.createEdge(6,14,2);
        driver0 = new Driver(0, graph0.getNode(0));
        for(int i=0;i<4;i++){
           driver0.go(graph0); 
        }
        driver0.setCustomer(passenger0);
        for(int i=0;i<2;i++){
           driver0.go(graph0); 
        }
        assertEquals(driver0.getLoc().getID()==1 || driver0.getLoc().getID()==2, true);
        //After six steps driver should have moved to node 1 or 2 but since a customer was assigned more than halfway through its journey, it moves to the desired destination anyways.
        //Thus should not be at node 0, after 2 steps after assignment since it has traversed the whole path betweeon node 0 and node 1 or 2
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
