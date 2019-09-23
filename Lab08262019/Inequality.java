import java.util.Scanner;
/**
 * Compare two values of feet and inches
 * produces a boolean value of 'true' if
 * same and 'false' if not.
 * 
 * @author Sena Yevenyo
 * @version August 26, 2019
 */
public class Inequality{
    public static void main(String[] args){
        Inequality inq = new Inequality();
        inq.run();
    }
    /**
     * Runs the object program
     */
    public void run(){
        Scanner reader = new Scanner(System.in);
        String [] instr = {"First number: ","Second number: ", "Operator: ", "Third number: ", "Fourth number: "};
        int [] feet = {0,0};
        float [] inch = {(float) 0.0, (float) 0.0};
        int loops = 0;
        String operator = null;
        try{
        System.out.println("Number of calculations: ");
        loops = reader.nextInt();
        for(int i =0;i<loops;i++){
            for (int j =0;j<instr.length;j++){
                System.out.println(instr[j]);
                if(j==0) {feet[0] = reader.nextInt();}
                else if(j==1) {inch[0] = reader.nextFloat();}
                else if(j==2) {operator = reader.next();}
                else if(j==3) {feet[1] = reader.nextInt();}
                else if(j==4) {inch[1] = reader.nextFloat();}
            }
            if ((operator.equals("gte"))||(operator.equals("gt"))||(operator.equals("lte"))||(operator.equals("lt"))){
                boolean feetEqual = feet[0]==feet[1];
                boolean inchEqual = ((inch[0]-inch[1])<=(float)0.001)&&((inch[0]-inch[1])>=(float)-0.001);
                if(feetEqual){
                    boolean inchBoolGT = ((inch[0]-inch[1])>(float)0.001);
                    boolean inchBoolLT = ((inch[0]-inch[1])<(float)-0.001);
                    if(inchBoolLT && (operator.equals("lt")||operator.equals("lte"))) System.out.println("true");
                    else if(inchBoolGT && (operator.equals("gt")||operator.equals("gte"))) System.out.println("true");
                    else if(inchEqual && (operator.equals("gte")||operator.equals("lte"))) System.out.println("true");
                    else System.out.println("false");
                }else{
                    boolean feetBool = feet[0]<feet[1];
                    if(feetBool && (operator.equals("lt")||operator.equals("lte"))) System.out.println("true");
                    else if(!feetBool && (operator.equals("gt")||operator.equals("gte"))) System.out.println("true");
                    else System.out.println("false");
                }
            }else{
                System.out.println("Undefined operator");
            }
        }
        reader.close();
        }catch(Exception e){
                System.out.println("Exception: "+e);
        }
        }
    }
