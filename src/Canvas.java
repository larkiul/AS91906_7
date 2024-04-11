

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;


public class Canvas extends JFrame implements ActionListener, KeyListener {
    Canvas myGraphic;
    final int CANVAS_WIDTH = 800;
    final int CANVAS_HEIGHT = 800;
    final int PLAYER_SIZE = 20;
    final String fileName = "burger.jpg";
    ImageIcon image = new ImageIcon(fileName);
    int playerX = CANVAS_WIDTH / 2 - PLAYER_SIZE / 2;
    int playerY = CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;

    public Canvas() {
        System.out.println("hifg");

        setTitle("game");

        this.getContentPane().setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setContentPane(new JPanelTest());


        addKeyListener(this);
    }



    class JPanelTest extends JPanel{
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.RED);
            g2.fillOval(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
            image.paintIcon(this, g, 50, 50);
        }
    }

    public void keyPressed(KeyEvent e){
        int keyPressed = e.getKeyChar();
        System.out.println(keyPressed);
        if (keyPressed == 'w') {
            playerY -= 5;
        }
        if (keyPressed == 's') {
            playerY += 5;
        }
        if (keyPressed == 'a') {
            playerX -= 5;
        }
        if (keyPressed == 'd') {
            playerX += 5;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e){
        System.out.println("dumb");
    }

    public void keyTyped(KeyEvent e){
        System.out.println("dumb");
    }

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        //repaint();
    }
}
