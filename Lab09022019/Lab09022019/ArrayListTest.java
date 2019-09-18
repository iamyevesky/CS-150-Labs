import java.util.ArrayList;

public class ArrayListTest{
    public static void main(String [] args){
        ArrayListTest r = new ArrayListTest();
        r.run();
    }
    
    public void run(){
        String test = "abab";
        System.out.println(test.compareTo("ab"));
        System.out.println(test.compareTo("az"));
        System.out.println(test.compareTo("bz"));
        System.out.println(test.compareTo("ca"));
        System.out.println(test.compareTo("de"));
        System.out.println(test.compareTo("rp"));
        // ArrayList<String> array = new ArrayList<String>();
        
        // array.add("one");
        // array.add("three");
        // array.add("two");
        
        // for(int i=0;i<array.size(); i++){
            // System.out.println(array.get(i));
        // }
    }
}