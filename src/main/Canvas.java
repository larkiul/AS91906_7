package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Canvas extends JFrame implements Runnable {

    KeyInput keyInput = new KeyInput();
    Canvas myGraphic;
    final int CANVAS_WIDTH = 800;
    final int CANVAS_HEIGHT = 800;
    final int PLAYER_SIZE = 20;
    final int FPS = 60;
    public int playerX = CANVAS_WIDTH / 2 - PLAYER_SIZE / 2;
    public int playerY = CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;
    public int playerSpeed = 5;
    Thread gameThread;

    public Canvas() {
        setTitle("game");

        this.getContentPane().setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setContentPane(new JPanelTest());


        this.addKeyListener(keyInput);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread != null) {
            System.out.println("fgsd");
        }
    }

    public void playerMove() {
        if (keyInput.upPressed){
            playerY -= playerSpeed;
        }
        if (keyInput.downPressed){
            playerY += playerSpeed;
        }
        if (keyInput.leftPressed){
            playerX -= playerSpeed;
        }
        if (keyInput.rightPressed){
            playerY += playerSpeed;
        }
    }

    class JPanelTest extends JPanel{
        public void paint(Graphics g){

                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(Color.RED);
                g2.fillOval(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
                //image.paintIcon(this, g, 50, 50);
        }
    }
}
