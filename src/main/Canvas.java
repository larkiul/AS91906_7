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
    public int playerSpeed = 2;
    Thread gameThread; // This thread allows for the game to be run while all other aspects can still work, like the paint method

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

    public void startGameThread() { // Initialise the thread

        gameThread = new Thread(this);
        gameThread.start(); // Start thread
    }

    public void run() { // Contains code for the thread to run

        /**
         * Game loop 'delta' method
         *
         * Limits the game loop to only be run 60 times per second (FPS)
         * Without this, the game loop would be run as soon as the loop is finished, so it could be run 1 000s or 1 000 000s of times per second
         * Thread has no built-in limiting factor to how many times it's run per second so 'delta' is required
        **/

        double drawInterval = 1000000000 / FPS; // Time between frames, recorded in nanoseconds (1 second = 1 * 10^9 nanoseconds)
        double delta = 0;
        long lastTime = System.nanoTime(); // Records time (in nanoseconds) before loop begins, System.nanoTime() allows for more precise measurements
        long currentTime;

        while (gameThread != null) { // While the thread is active, the game loop is continuously ran

            currentTime = System.nanoTime(); // Finds the current elapsed time
            delta += (currentTime - lastTime) / drawInterval; // Elapsed time is converted to value 0 - 1
            lastTime = currentTime; // Last time is updated

            if (delta >= 1) { // Only once delta reaches 1 or more, is a new frame drawn, this happens 60 times per second in my game
                update();
                repaint();
                delta--; // Returns delta to 0
            }
        }
    }

    public void update() {
        playerMove();
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
            playerX += playerSpeed;
        }
    }

    class JPanelTest extends JPanel{
        public void paint(Graphics g){

                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(Color.RED);
                g2.fillOval(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
        }
    }
}
