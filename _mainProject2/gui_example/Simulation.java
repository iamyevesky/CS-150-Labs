import java.awt.Canvas;
import java.util.concurrent.TimeUnit;

public class Simulation {

    public static void main(String[] args) {

        Jellystone park = new Jellystone();
        Yogi   y = new Yogi();
        Booboo b = new Booboo();
        
        park.add(y);
        park.add(b);
    
        try {
            for(int cnt = 0; cnt < 20; cnt++) {
                y.move();
                park.repaint();
                TimeUnit.SECONDS.sleep(1);
                b.move();
                park.repaint();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

}