import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paint extends JComponent{

    final int CANVAS_WIDTH = 800;
    final int CANVAS_HEIGHT = 800;
    final int PLAYER_SIZE = 20;

    int playerX = CANVAS_WIDTH / 2 - PLAYER_SIZE / 2;
    int playerY = CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;
    class JPanelTest extends JPanel{
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.RED);
            g2.fillOval(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
        }
    }
}
