import java.awt.Color;
import java.awt.Graphics;

class Bear {

    Color color;
    int   x_location;
    int   y_location;
    int   size;

    Bear() {
    
    x_location = 10;
    y_location = 10;
    size       = 10;

    color = new Color(0, 0, 0);
    }

    public void move() {
        x_location += 4;
        y_location += 4;
    }
    
    public void paint(Graphics g) {

    g.setColor(color);
    g.fillOval(x_location - size,
           y_location - size,
           size * 2,
           size * 2           );
    }
}