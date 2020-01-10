
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerTest.
 *
 * @author Sena Yevenyo
 * @version December 02, 2019
 */
public class PassengerTest
{
    Passenger passenger0;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Driver uni;
    Network graph0 = new Network(15);

    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest()
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
        Passenger.initClass();
        graph0.createEdge(0,1,2);
        graph0.createEdge(0,2,5);
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
        uni = new Driver(0,graph0.getNode(0));
        passenger0 = new Passenger(graph0.getNode(0),graph0.getNode(7),uni);
        
        GlobalClock.reset();
    }

    @Test
    public void testGetLoc(){
        assertEquals(graph0.getNode(0), passenger0.getLoc());
    }
    
    @Test
    public void testGetDestination(){
        assertEquals(graph0.getNode(7), passenger0.getDestination());
    }
    
    @Test
    public void testGetDriver0(){
        assertEquals(uni, passenger0.getDriver());
    }
    
    @Test
    public void testCalculateAndGetETA(){
        passenger0.calculateETA(graph0);
        assertEquals(15, passenger0.getETA());
    }
    
    @Test
    public void testGetWaitTime(){
        GlobalClock.tick();
        passenger0.startWait();
        GlobalClock.tick();
        GlobalClock.tick();
        passenger0.endWait();
        assertEquals(2, passenger0.getWaitTime());
    }
    
    @Test
    public void testGetTripTime(){
        GlobalClock.tick();
        passenger0.startTrip();
        GlobalClock.tick();
        GlobalClock.tick();
        GlobalClock.tick();
        passenger0.endTrip();
        assertEquals(3, passenger0.getTripTime());
    }
    
    @Test
    public void testGetSatisfaction0(){
        passenger0.calculateETA(graph0);
        passenger0.startWait();
        for(int i=0;i<15;i++){
            GlobalClock.tick();
        }
        passenger0.endWait();
        passenger0.startTrip();
        for(int i=0;i<15;i++){
            GlobalClock.tick();
        }
        passenger0.endTrip();
        passenger0.sampleData();
        assertEquals(4.75, passenger0.getSatisfaction(), 0.001);
    }
    
    @Test
    public void testGetSatisfaction1(){
        passenger0.calculateETA(graph0);
        passenger0.startWait();
        for(int i=0;i<5;i++){
            GlobalClock.tick();
        }
        passenger0.endWait();
        passenger0.startTrip();
        for(int i=0;i<15;i++){
            GlobalClock.tick();
        }
        passenger0.endTrip();
        passenger0.sampleData();
        assertEquals(5.0, passenger0.getSatisfaction(), 0.001);
    }
    
    @Test
    public void testGetSatisfaction2(){
        passenger0.calculateETA(graph0);
        passenger0.startWait();
        for(int i=0;i<30;i++){
            GlobalClock.tick();
        }
        passenger0.endWait();
        passenger0.startTrip();
        for(int i=0;i<20;i++){
            GlobalClock.tick();
        }
        passenger0.endTrip();
        passenger0.sampleData();
        assertEquals(3.50, passenger0.getSatisfaction(), 0.001);
    }
    
    @Test
    public void testGetSatisfaction3(){
        passenger0.calculateETA(graph0);
        passenger0.startWait();
        for(int i=0;i<30;i++){
            GlobalClock.tick();
        }
        passenger0.endWait();
        passenger0.startTrip();
        for(int i=0;i<45;i++){
            GlobalClock.tick();
        }
        passenger0.endTrip();
        passenger0.sampleData();
        assertEquals(1.50, passenger0.getSatisfaction(), 0.001);
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
