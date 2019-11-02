import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ContactListTest.
 *
 * @author  Sena Yevenyo
 * @version October 16, 2019
 */
public class ContactListTest
{
    private ContactList list;
    /**
     * Default constructor for test class ContactListTest
     */
    public ContactListTest()
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
        list = new ContactList();
        assertEquals(list.printData(), "[]");
    }
    
    @Test
    public void testPrintDataAndAddElement(){
        list = new ContactList();
        list.addElement(new Contact("Brown", "Aaron"));
        list.addElement(new Contact("Fedora", "Leslie"));
        list.addElement(new Contact("Magnus", "Carta"));
        list.addElement(new Contact("Xhosa", "Zitrone"));
        assertEquals(list.printData(), "[(Brown, Aaron), (Fedora, Leslie), (Magnus, Carta), (Xhosa, Zitrone)]");
    }
    
    @Test
    public void testQuickSort0(){
        list = new ContactList();
        list.addElement(new Contact("Abc", "Efg"));
        list.addElement(new Contact("Abc", "Def"));
        list.addElement(new Contact("Def", "Pqr"));
        list.addElement(new Contact("Zpn", "IiG"));
        list.addElement(new Contact("Tgif", "Mtwtf"));
        list.addElement(new Contact("Ddr", "Eghf"));
        list.quickSort();
        assertEquals(list.printData(), "[(Abc, Def), (Abc, Efg), (Ddr, Eghf), (Def, Pqr), (Tgif, Mtwtf), (Zpn, IiG)]");
    }
    
    @Test
    public void testQuickSort1(){
        list = new ContactList();
        list.addElement(new Contact("A", "A"));
        list.addElement(new Contact("A", "B"));
        list.addElement(new Contact("D", "A"));
        list.addElement(new Contact("A", "C"));
        list.addElement(new Contact("C", "B"));
        list.addElement(new Contact("E", "G"));
        list.quickSort();
        assertEquals(list.printData(), "[(A, A), (A, B), (A, C), (C, B), (D, A), (E, G)]");
    }
    
    @Test
    public void testMergeSort0(){
        list = new ContactList();
        list.addElement(new Contact("Abc", "Efg"));
        list.addElement(new Contact("Abc", "Def"));
        list.addElement(new Contact("Def", "Pqr"));
        list.addElement(new Contact("Zpn", "IiG"));
        list.addElement(new Contact("Tgif", "Mtwtf"));
        list.addElement(new Contact("Ddr", "Eghf"));
        list.mergeSort();
        assertEquals(list.printData(), "[(Abc, Def), (Abc, Efg), (Ddr, Eghf), (Def, Pqr), (Tgif, Mtwtf), (Zpn, IiG)]");
    }
    
    @Test
    public void testMergeSort1(){
        list = new ContactList();
        list.addElement(new Contact("A", "A"));
        list.addElement(new Contact("A", "B"));
        list.addElement(new Contact("D", "A"));
        list.addElement(new Contact("A", "C"));
        list.addElement(new Contact("C", "B"));
        list.addElement(new Contact("E", "G"));
        list.mergeSort();
        assertEquals(list.printData(), "[(A, A), (A, B), (A, C), (C, B), (D, A), (E, G)]");
    }
}
