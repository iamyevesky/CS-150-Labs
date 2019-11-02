

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WorkerListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WorkerListTest
{
    private WorkerList list;
    /**
     * Default constructor for test class WorkerListTest
     */
    public WorkerListTest()
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
    
    @Test
    public void testPrintData0(){
        list = new WorkerList();
        assertEquals(list.printData(), "[]");
    }
    
    @Test
    public void testPrintData1(){
        list = new WorkerList();
        list.addElement(new Worker(2));
        list.addElement(new Worker(5));
        list.addElement(new Worker(1));
        list.addElement(new Worker(0));
        list.addElement(new Worker(7));
        list.addElement(new Worker(9));
        list.addElement(new Worker(6));
        assertEquals(list.printData(), "[(2), (5), (1), (0), (7), (9), (6)]");
    }
    
    @Test
    public void testMergeSort0(){
        list = new WorkerList();
        list.addElement(new Worker(2));
        list.addElement(new Worker(5));
        list.addElement(new Worker(1));
        list.addElement(new Worker(0));
        list.addElement(new Worker(7));
        list.addElement(new Worker(9));
        list.addElement(new Worker(6));
        list.mergeSort();
        assertEquals(list.printData(), "[(0), (1), (2), (5), (6), (7), (9)]");
    }
    
    @Test
    public void testMergeSort1(){
        list = new WorkerList();
        list.addElement(new Worker(15));
        list.addElement(new Worker(4));
        list.addElement(new Worker(1));
        list.addElement(new Worker(5));
        list.addElement(new Worker(7));
        list.addElement(new Worker(8));
        list.addElement(new Worker(2));
        list.mergeSort();
        assertEquals(list.printData(), "[(1), (2), (4), (5), (7), (8), (15)]");
    }
    
     @Test
    public void testMergeSort2(){
        list = new WorkerList();
        list.addElement(new Worker(9));
        list.addElement(new Worker(4));
        list.addElement(new Worker(1));
        list.addElement(new Worker(0));
        list.addElement(new Worker(7));
        list.addElement(new Worker(9));
        list.addElement(new Worker(2));
        list.mergeSort();
        assertEquals(list.printData(), "[(0), (1), (2), (4), (7), (9), (9)]");
    }
    
    @Test
    public void testMergeSort3(){
        list = new WorkerList();
        list.addElement(new Worker(0));
        list.addElement(new Worker(5));
        list.addElement(new Worker(1));
        list.addElement(new Worker(2));
        list.addElement(new Worker(7));
        list.addElement(new Worker(9));
        list.addElement(new Worker(6));
        list.mergeSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(0), (1), (2), (5), (6), (7), (9)]");
    }
    
    @Test
    public void testMergeSort4(){
        list = new WorkerList();
        list.addElement(new Worker(10));
        list.addElement(new Worker(8));
        list.addElement(new Worker(7));
        list.addElement(new Worker(6));
        list.addElement(new Worker(4));
        list.addElement(new Worker(3));
        list.addElement(new Worker(1));
        list.mergeSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(1), (3), (4), (6), (7), (8), (10)]");
    }
    
    @Test
    public void testQuickSort0(){
        list = new WorkerList();
        list.addElement(new Worker(2));
        list.addElement(new Worker(5));
        list.addElement(new Worker(1));
        list.addElement(new Worker(0));
        list.addElement(new Worker(7));
        list.addElement(new Worker(9));
        list.addElement(new Worker(10));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(0), (1), (2), (5), (7), (9), (10)]");
    }
    
    @Test
    public void testQuickSort1(){
        list = new WorkerList();
        list.addElement(new Worker(10));
        list.addElement(new Worker(2));
        list.addElement(new Worker(4));
        list.addElement(new Worker(6));
        list.addElement(new Worker(3));
        list.addElement(new Worker(9));
        list.addElement(new Worker(5));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(2), (3), (4), (5), (6), (9), (10)]");
    }
    
    @Test
    public void testQuickSort2(){
        list = new WorkerList();
        list.addElement(new Worker(10));
        list.addElement(new Worker(8));
        list.addElement(new Worker(7));
        list.addElement(new Worker(6));
        list.addElement(new Worker(4));
        list.addElement(new Worker(3));
        list.addElement(new Worker(1));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(1), (3), (4), (6), (7), (8), (10)]");
    }
    
    @Test
    public void testQuickSort3(){
        list = new WorkerList();
        list.addElement(new Worker(5));
        list.addElement(new Worker(2));
        list.addElement(new Worker(7));
        list.addElement(new Worker(3));
        list.addElement(new Worker(9));
        list.addElement(new Worker(5));
        list.addElement(new Worker(4));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(2), (3), (4), (5), (5), (7), (9)]");
    }
    
    @Test
    public void testQuickSort4(){
        list = new WorkerList();
        list.addElement(new Worker(0));
        list.addElement(new Worker(5));
        list.addElement(new Worker(1));
        list.addElement(new Worker(2));
        list.addElement(new Worker(7));
        list.addElement(new Worker(9));
        list.addElement(new Worker(6));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(0), (1), (2), (5), (6), (7), (9)]");
    }
    
    @Test
    public void testQuickSort5(){
        list = new WorkerList();
        list.addElement(new Worker(2));
        list.addElement(new Worker(0));
        list.addElement(new Worker(4));
        list.addElement(new Worker(3));
        list.addElement(new Worker(6));
        list.addElement(new Worker(7));
        list.addElement(new Worker(10));
        list.addElement(new Worker(5));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(0), (2), (3), (4), (5), (6), (7), (10)]");
    }
    
    @Test
    public void testQuickSort6(){
        list = new WorkerList();
        list.addElement(new Worker(5));
        list.addElement(new Worker(6));
        list.addElement(new Worker(7));
        list.addElement(new Worker(10));
        list.addElement(new Worker(5));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(5), (5), (6), (7), (10)]");
    }
    
    @Test
    public void testQuickSort7(){
        list = new WorkerList();
        list.addElement(new Worker(2));
        list.addElement(new Worker(0));
        list.addElement(new Worker(4));
        list.addElement(new Worker(5));
        list.addElement(new Worker(6));
        list.quickSort();
        System.out.println(list.printData());
        assertEquals(list.printData(), "[(0), (2), (4), (5), (6)]");
    }
}
