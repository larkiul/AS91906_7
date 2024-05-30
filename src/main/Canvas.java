package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Canvas extends JFrame implements Runnable {

    Platform platOne = new Platform(100, 600, 100, 20);
    Platform platTwo = new Platform(600, 600, 100, 20);
    Platform ground = new Platform(0, 700, 800, 100);
    Player playerClass = new Player();
    public final int CANVAS_WIDTH = 800;
    public final int CANVAS_HEIGHT = 800;

    final int FPS = 60;

    //public int ground = 700;
    Thread gameThread; // This thread allows for the game to be run while all other aspects can still work, like the paint method

    public Canvas() {
        setTitle("game");

        this.getContentPane().setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setContentPane(new JPanelTest());


        this.addKeyListener(playerClass.keyInput);
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

        playerClass.playerMove();


    }





    class JPanelTest extends JPanel{
        public void paint(Graphics g){

            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(Color.RED);
            g2.fillOval(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE);

            g2.setColor(Color.BLACK);
            g2.fillRect(platOne.x, platOne.y, platOne.width, platOne.height);
            g2.fillRect(platTwo.x, platTwo.y, platTwo.width, platTwo.height);
            g2.fillRect(ground.x, ground.y, ground.width, ground.height);
        }
    }
}
