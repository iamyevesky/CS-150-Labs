

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class MyLinkedListTest.
 *
 * @author  Sena Yevenyo
 * @version September 29, 2019
 */
public class MyLinkedListTest
{
    /**
     * Default constructor for test class MyLinkedListTest
     */
    public MyLinkedListTest()
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
    public void testSize0(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        assertEquals(3, list.size());
    }
    
    @Test
    public void testSize1(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.remove(0);
        assertEquals(2, list.size());
    }
    
    @Test
    public void testSize2(){
        MyLinkedList list = new MyLinkedList<String>();
        assertEquals(0, list.size());
    }
    
    @Test
    public void testToString(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        assertEquals("[abc, cde, efg]", list.toString());
    }
    
    @Test
    public void testAddFirst0(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.addFirst("789");
        assertEquals("[789, abc, cde, efg, ghi]", list.toString());
    }
    
    @Test
    public void testAddFirst1(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.addFirst("789");
        list.remove(0);
        list.addFirst("567");
        assertEquals("[567, abc, cde, efg, ghi]", list.toString());
    }
    
    @Test
    public void testAddEnd0(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        assertEquals("[abc, cde, efg, ghi]",list.toString());
    }
    
    @Test
    public void testAddEnd1(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(list.size()-1);
        list.addEnd("ijk");
        assertEquals("[abc, cde, efg, ijk]",list.toString());
    }
    
    @Test
    public void testAddEnd2(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(2);
        list.addEnd("ijk");
        assertEquals("[abc, cde, ghi, ijk]",list.toString());
    }
    
    @Test
    public void testAddEnd3(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(0);
        list.addEnd("ijk");
        assertEquals("[cde, efg, ghi, ijk]",list.toString());
    }
    
    @Test
    public void testGet0(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.addEnd("ijk");
        assertEquals("ghi",list.get(3));
    }
    
    @Test
    public void testGet1(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.addEnd("ijk");
        assertEquals("abc",list.get(0));
    }
    
    @Test
    public void testGet2(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.addEnd("ijk");
        assertEquals("ijk",list.get(list.size()-1));
    }
    
    @Test
    public void testGet3(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(list.size()-1);
        list.addEnd("ijk");
        assertEquals("ijk",list.get(list.size()-1));
    }
    
    @Test
    public void testGet4(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(0);
        list.addEnd("ijk");
        assertEquals("cde",list.get(0));
    }
    
    @Test
    public void testGet5(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(2);
        list.addEnd("ijk");
        assertEquals("ijk",list.get(3));
    }
    
    @Test
    public void testGet6(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(2);
        list.addEnd("ijk");
        assertEquals("ghi",list.get(2));
    }
    
    @Test
    public void testGet7(){
        MyLinkedList list = new MyLinkedList<String>();
        assertEquals(null,list.get(3));
    }
    
    @Test
    public void testRemove00(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        assertEquals("efg",list.remove(2));
    }
    
    @Test
    public void testRemove01(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(2);
        assertEquals("[abc, cde, ghi]",list.toString());
    }
    
    @Test
    public void testRemove10(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        assertEquals("abc",list.remove(0));
    }
    
    @Test
    public void testRemove11(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(0);
        assertEquals("[cde, efg, ghi]",list.toString());
    }
    
    @Test
    public void testRemove20(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        assertEquals("ghi",list.remove(list.size()-1));
    }
    
    @Test
    public void testRemove21(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        list.remove(list.size()-1);
        assertEquals("[abc, cde, efg]",list.toString());
    }
    
    @Test
    public void testIteratorhasNext0(){
        MyLinkedList list = new MyLinkedList<String>();
        Iterator it = list.iterator();
        assertEquals(false,it.hasNext());
    }
    
    @Test
    public void testIteratorhasNext1(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        Iterator it = list.iterator();
        assertEquals(true,it.hasNext());
        it.next();
        assertEquals(true,it.hasNext());
        it.next();
        assertEquals(true,it.hasNext());
        it.next();
        assertEquals(true,it.hasNext());
    }
    
    @Test
    public void testIteratorhasNext2(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        Iterator it = list.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        assertEquals(false,it.hasNext());
    }
    
    @Test
    public void testIteratorNext0(){
        MyLinkedList list = new MyLinkedList<String>();
        Iterator it = list.iterator();
        assertEquals(null,it.next());
    }
    
    @Test
    public void testIteratorNext1(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        Iterator it = list.iterator();
        assertEquals("abc",it.next());
        assertEquals("cde",it.next());
        assertEquals("efg",it.next());
        assertEquals("ghi",it.next());
    }
    
    @Test
    public void testIteratorNext2(){
        MyLinkedList list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("cde");
        list.addEnd("efg");
        list.addEnd("ghi");
        Iterator it = list.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        assertEquals(null,it.next());
    }
}
