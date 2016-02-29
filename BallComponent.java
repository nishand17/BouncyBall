import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
public class BallComponent extends JComponent implements ActionListener
{
    private int x,y,dx,dy,dimension;
    Color c;
    public BallComponent(int type) {
        x = StartTheBounce.WIDTH/2;
        y = StartTheBounce.HEIGHT/2;
        Random gen = new Random();
        switch(type) {
            case 0://user
            dx = 0;
            dy = 0;
            c = Color.BLACK;
            break;
            
            case 1: //random
            int n = gen.nextInt(1);
            if(n == 0) {
                dx = -gen.nextInt(20)+1;
                dy = -gen.nextInt(20)+1;
            }
            else {
                dx = gen.nextInt(20)+1;
                dy = gen.nextInt(20)+1;
            }

            c = Color.RED;
            break;
            default: break;
        }
        dimension = 15;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(c);
        Ellipse2D.Double ball = new Ellipse2D.Double(x,y,dimension,dimension);
        g2.fill(ball);
        g2.draw(ball);
    }

    public void actionPerformed(ActionEvent e) {
        move();
    }

    public void move() {
        if(x<dimension-10 || x> StartTheBounce.WIDTH-20) flipDx();
        if(y<dimension-10 || y> StartTheBounce.HEIGHT-30) flipDy();
        x+=dx;
        y+=dy;
        repaint();
    }

    public void incDx() {
        dx+=2;
    }

    public void decDx() {
        dx-=2;
    }

    public void incDy() {
        dy+=2;
    }

    public void decDy() {
        dy-=2;
    }

    public void flipDx() {
        dx = dx*(-1);
    }

    public void flipDy() {
        dy = dy*(-1);
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public int getdX() {
        return dx;
    }

    public int getdY() {
        return dy;
    }

    public void modXY() {
        x+=dx;
        y+=dy;
    }
}
