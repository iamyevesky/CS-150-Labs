import java .awt  .Canvas;
import java .awt  .Graphics;
import java .awt  .Color;
import javax.swing.JFrame;
import java .util .ArrayList;

public class Jellystone extends Canvas {

    JFrame frame;
    int    grid_size;
    int    park_size;

    ArrayList<Bear> bears = new ArrayList<Bear>();

    Jellystone() {

        frame     = new JFrame("Jellystone Park");

	grid_size = 20;
	park_size = 400;

	this.setSize(park_size, park_size);

	frame.add(this);
	frame.pack();
	frame.setVisible(true);
    }

    public void paint(Graphics g) {

	g.setColor(Color.green);

	int x_grid_loc = park_size / 50;
	int y_grid_loc = park_size / 50;

	for(int x = 0; x < x_grid_loc; x++){
	    System.out.println(x * 50 + 25);
	    for(int y = 0; y < y_grid_loc; y++)
		
		g.fillRect((x * 50 + 25) - grid_size,
			   (y * 50 + 25) - grid_size,
			   grid_size * 2,
			   grid_size * 2);
	}

	for(Bear b: bears) {
	    b.paint(g);
	}
    }

    public void add(Bear b) {
	bears.add(b);
    }
}