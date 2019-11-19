
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    String [] ones = {"one","two","three","four","five","six","seven","eight","nine"};
    String [] tens = {"ten", "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    String [] nextTens = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String sampleMethod(int y)
    {
        String val = ""+y;
        
        if(val.length()==1){
            return ones[Integer.parseInt(val)];
        }
        
        else if(val.length()==2){
            Character first = val.charAt(0);
            Character last = val.charAt(1);
            switch(first){
                case '1':
                         return tens[Integer.parseInt(last+" ")];
                default:
                        return nextTens[Integer.parseInt(first+"")] + " "+ ones[Integer.parseInt(last+"")];
            }
        }
    }
    
    private String ones(String val){
        return ones[Integer.parseInt(val)];
    }
    
    private String tens(String val){
        Character first = val.charAt(0);
        Character last = val.charAt(1);
        switch(first){
            case '1':
                     return tens[Integer.parseInt(last+" ")];
            default:
                    return nextTens[Integer.parseInt(first+"")] + " "+ones(last+"");
        }
    }
    
    
    private String hundreds(String val){
        Character first = val.charAt(0);
        return ones[Integer.parseInt(first+"")]+ " hundred "+tens(val.substring(1));
    }
    
    private String thousands(String val){
        String rest = val.substring(val.length()-3);
        String first = val.substring(0,val.length()-3);
        if(first.length()==1){
            return ones(first) + " thousand " + hundreds(rest);
        }
        else if(first.length()==2){
            return tens(first) + " thousand " + hundreds(rest);
        }
        else{
            return hundreds(first) + " thousand "+hundreds(rest);
        }
    }
    
    private String millions(String val){
        St
    } 
}
