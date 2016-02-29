import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class StartTheBounce implements ActionListener
{
    public static final int WIDTH = 875;
    public static final int HEIGHT = 675;
    JFrame j;
    ArrayList<BallComponent> rList;
    public void start() {
        j = new JFrame("My bouncy balls");
        j.setSize(WIDTH,HEIGHT);
        BallComponent b = new BallComponent(0);
        rList = new ArrayList<BallComponent>();
        j.setResizable(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Timer t = new Timer(25, b);
        //Timer randT = new Timer(25, this);
        class dirListener implements KeyListener {
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_UP: b.decDy();
                    break;
                    case KeyEvent.VK_DOWN: b.incDy();
                    break;
                    case KeyEvent.VK_LEFT: b.decDx();
                    break;
                    case KeyEvent.VK_RIGHT: b.incDx();
                    break;
                    case KeyEvent.VK_N: 
                    BallComponent rand = new BallComponent(1); 
                    rList.add(rand);
                    j.add(rand);
                    j.setVisible(true);
                    t.addActionListener(rand);
                    default: break;
                }
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
        }
        j.addKeyListener(new dirListener());
        j.add(b);
        j.setVisible(true);
        
        
        t.start();
        
    }
    
    public void actionPerformed(ActionEvent e) {
        for (BallComponent b : rList) {
            b.move();
            j.setVisible(true);
        }
    }
    
}
