package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Canvas extends JFrame implements Runnable {
    Player playerClass = new Player();
    public final int CANVAS_WIDTH = 800;
    public final int CANVAS_HEIGHT = 800;
    public int platformSpeed = 3;
    final int FPS = 60;
    ArrayList<Platform> platforms = new ArrayList<Platform>();
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

        platforms.add(new Platform(0, 700, CANVAS_WIDTH, 100));
        platforms.add(new Platform((int) (Math.floor(Math.random() * CANVAS_WIDTH) + CANVAS_WIDTH), (int) (Math.floor(Math.random() * 200) + 500), 100, 10));
        platforms.add(new Platform((int) (Math.floor(Math.random() * CANVAS_WIDTH) + CANVAS_WIDTH), (int) (Math.floor(Math.random() * 200) + 500), 100, 10));
        platforms.add(new Platform((int) (Math.floor(Math.random() * CANVAS_WIDTH) + CANVAS_WIDTH), (int) (Math.floor(Math.random() * 200) + 500), 100, 10));
        platforms.add(new Platform((int) (Math.floor(Math.random() * CANVAS_WIDTH) + CANVAS_WIDTH), (int) (Math.floor(Math.random() * 200) + 500), 100, 10));
        platforms.add(new Platform((int) (Math.floor(Math.random() * CANVAS_WIDTH) + CANVAS_WIDTH), (int) (Math.floor(Math.random() * 200) + 500), 100, 10));
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

        //System.out.println(platforms);

        for (int i = 0; i < platforms.size(); i++){
            platforms.get(i).x -= platformSpeed;
            if (platforms.get(i).x + platforms.get(i).width < 0){
                platforms.get(i).x = (int) (Math.floor(Math.random() * CANVAS_WIDTH) + CANVAS_WIDTH);
                platforms.get(i).y = (int) (Math.floor(Math.random() * 200) + 500);
            }
            if (i == 0){
                platforms.get(i).x += platformSpeed;
            }
            if (collision(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE, platforms.get(i).x, platforms.get(i).y, platforms.get(i).width, platforms.get(i).height) && playerClass.playerVerticalSpeed > 0){
                playerClass.playerY = platforms.get(i).y  - playerClass.PLAYER_SIZE;
                playerClass.playerVerticalSpeed = 0;
            }
        }
    }

    public Boolean collision(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2){
        if (x1 + w1 >= x2 && x1 <= x2 + w2 && y1 + h1 > y2 && y1 <= y2 + h2){
            return true;
        } else {
            return false;
        }
    }

    class JPanelTest extends JPanel{
        public void paint(Graphics g){

            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;



            g2.setColor(Color.BLACK);

            for (int i = 0; i < platforms.size(); i++){
                g2.fillRect(platforms.get(i).x, platforms.get(i).y, platforms.get(i).width, platforms.get(i).height);
            }
            g2.setColor(Color.RED);
            g2.fillRect(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE);
        }
    }
}
