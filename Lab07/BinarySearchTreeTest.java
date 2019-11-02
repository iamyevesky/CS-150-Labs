

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BinarySearchTreeTest.
 *
 * @author  Sena Yevenyo
 * @version October 27,2019
 */
public class BinarySearchTreeTest
{
    BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
    /**
     * Default constructor for test class BinarySearchTreeTest
     */
    public BinarySearchTreeTest()
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
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
    }

    @Test
    public void testEmpty(){
        tree.empty();
        assertEquals(true, tree.isEmpty());
    }
    
    @Test
    public void testContains0(){
        assertEquals(true, tree.contains(5));
    }
    
    @Test
    public void testContains1(){
        assertEquals(true, tree.contains(3));
    }
    
    @Test
    public void testContains2(){
        assertEquals(true, tree.contains(7));
    }
    
    @Test
    public void testContains3(){
        assertEquals(true, tree.contains(1));
    }
    
    @Test
    public void testContains4(){
        assertEquals(true, tree.contains(4));
    }
    
    @Test
    public void testContains5(){
        assertEquals(true, tree.contains(6));
    }
    
    @Test
    public void testContains6(){
        assertEquals(true, tree.contains(6));
    }
    
    @Test
    public void testContains7(){
        assertEquals(false, tree.contains(15));
    }
    
    @Test
    public void testInsert0(){
        tree.empty();
        assertEquals(true, tree.insert(1));
    }
    
    @Test
    public void testInsert1(){
        tree.empty();
        tree.insert(1);
        assertEquals(true, tree.insert(5));
    }
    
    @Test
    public void testInsert2(){
        tree.empty();
        tree.insert(1);
        tree.insert(5);
        assertEquals(false, tree.insert(5));
    }
    
    @Test
    public void testFindMax(){
        assertEquals(8, (int)tree.findMax());
    }
    
    @Test
    public void testFindMin(){
        assertEquals(1, (int)tree.findMin());
    }
    
    @Test
    public void numOfElementsDepthTest0(){
        assertEquals(2,tree.numOfElementsDepth(1));
    }
    
    @Test
    public void numOfElementsDepthTest1(){
        assertEquals(4,tree.numOfElementsDepth(2));
    }
    
    @Test
    public void numOfElementsDepthTest3(){
        assertEquals(1,tree.numOfElementsDepth(0));
    }
    
    @Test
    public void numOfElementsDepthTest4(){
        assertEquals(0,tree.numOfElementsDepth(4));
    }
    
    @Test
    public void testInOrderString(){
        assertEquals("[1, 3, 4, 5, 6, 7, 8]",tree.inOrderString());
    } 
    
    @Test
    public void testPreOrderString(){
        assertEquals("[5, 3, 1, 4, 7, 6, 8]",tree.preOrderString());
    } 
    
    @Test
    public void testPostOrderString(){
        assertEquals("[1, 4, 3, 6, 8, 7, 5]",tree.postOrderString());
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
