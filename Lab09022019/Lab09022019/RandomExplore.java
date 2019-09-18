import​ java.util.*;

public class RandomExplore{
    public static void main(String [] args){
        RandomExplore r = new RandomExplore();
        r.run();
    }
    
    public void run(){
        long seed = 88087987;
        Random random = new Random(seed);
        long startTime = System.currentTimeMillis();
        for(int x=0;x<10;x++){
            System.out.println(100*random.nextDouble());
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("Execute time: "+(stopTime-startTime));
    }
}
