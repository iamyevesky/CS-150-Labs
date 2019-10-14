import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String [] args){
        MyLinkedList<String> list = new MyLinkedList<String>();
        list.addFirst("abc");
        list.addEnd("def");
        list.addFirst("bcd");
        System.out.println(list);
        Iterator it = list.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        it.remove();
        System.out.println(it.hasNext());
        System.out.println(list);
    }
}
