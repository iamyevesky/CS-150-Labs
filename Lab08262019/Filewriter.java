import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
/**
 * Writes words and letters per line for every line of a .txt document
 *
 * @author Sena Yevenyo
 * @version August 26, 2019
 */
public class Filewriter
{
    public static void main(String [] args){
        Filewriter fw = new Filewriter();
        fw.run();
    }

    public void run(){
        try{
        PrintWriter writer = new PrintWriter(new File("output.txt"));
        File input = new File("input.txt");
        Scanner reader = new Scanner(input);
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            String [] lineArray = line.split(" ");
            int lineLength = lineArray.length;
            String lastWord = lineArray[lineLength-1];
            int numOfLetters = 0;
            for(int i=0;i<lineArray.length;i++){
                numOfLetters+=lineArray[i].length();
            }
            writer.println("Words: "+lineLength+" "+"Letters: "+numOfLetters+" "+"Last: "+lastWord);
        }
        reader.close();
        writer.close();
        System.out.println("Done!");
    }catch(Exception e){
        System.out.println(e);
    }
    }
}
