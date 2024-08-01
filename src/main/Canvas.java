package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Canvas extends JFrame implements Runnable {
    Player playerClass = new Player();
    public int TILE_SIZE = 50;
    public int tileCount = 20;
    public final int CANVAS_WIDTH = TILE_SIZE * tileCount;
    public final int CANVAS_HEIGHT = TILE_SIZE * tileCount;
    public int platformSpeed = 5;
    public int[] spike1 = {CANVAS_WIDTH + TILE_SIZE * 7, CANVAS_WIDTH + TILE_SIZE * 7 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 7 + TILE_SIZE};
    public int[] spike2 = {CANVAS_WIDTH + TILE_SIZE * 8, CANVAS_WIDTH + TILE_SIZE * 8 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 8 + TILE_SIZE};
    public int[] spike3 = {CANVAS_WIDTH + TILE_SIZE, CANVAS_WIDTH + TILE_SIZE + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE + TILE_SIZE};
    public int[] spike4 = {CANVAS_WIDTH + TILE_SIZE * 19, CANVAS_WIDTH + TILE_SIZE * 19 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 19 + TILE_SIZE};
    public int[] spike5 = {CANVAS_WIDTH + TILE_SIZE * 27, CANVAS_WIDTH + TILE_SIZE * 27 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 27 + TILE_SIZE};
    public int[] spike6 = {CANVAS_WIDTH + TILE_SIZE * 28, CANVAS_WIDTH + TILE_SIZE * 28 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 28 + TILE_SIZE};
    public int[] spike7 = {CANVAS_WIDTH + TILE_SIZE * 29, CANVAS_WIDTH + TILE_SIZE * 29 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 29 + TILE_SIZE};
    public int[] spike8 = {CANVAS_WIDTH + TILE_SIZE * 35, CANVAS_WIDTH + TILE_SIZE * 35 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 35 + TILE_SIZE};
    public int[] spike9 = {CANVAS_WIDTH + TILE_SIZE * 36, CANVAS_WIDTH + TILE_SIZE * 36 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 36 + TILE_SIZE};
    public int[] spike10 = {CANVAS_WIDTH + TILE_SIZE * 37, CANVAS_WIDTH + TILE_SIZE * 37 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 37 + TILE_SIZE};
    public int[] spike11 = {CANVAS_WIDTH + TILE_SIZE * 38, CANVAS_WIDTH + TILE_SIZE * 38 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 38 + TILE_SIZE};
    public int[] spike12 = {CANVAS_WIDTH + TILE_SIZE * 39, CANVAS_WIDTH + TILE_SIZE * 39 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 39 + TILE_SIZE};
    public int[] spike13 = {CANVAS_WIDTH + TILE_SIZE * 40, CANVAS_WIDTH + TILE_SIZE * 40 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 40 + TILE_SIZE};
    public int[] spike14 = {CANVAS_WIDTH + TILE_SIZE * 41, CANVAS_WIDTH + TILE_SIZE * 41 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 41 + TILE_SIZE};
    public int[] spike15 = {CANVAS_WIDTH + TILE_SIZE * 42, CANVAS_WIDTH + TILE_SIZE * 42 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 42 + TILE_SIZE};
    public int[] spike16 = {CANVAS_WIDTH + TILE_SIZE * 43, CANVAS_WIDTH + TILE_SIZE * 43 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 43 + TILE_SIZE};
    public int[] spike17 = {CANVAS_WIDTH + TILE_SIZE * 44, CANVAS_WIDTH + TILE_SIZE * 44 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 44 + TILE_SIZE};
    public int[] spike18 = {CANVAS_WIDTH + TILE_SIZE * 45, CANVAS_WIDTH + TILE_SIZE * 45 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 45 + TILE_SIZE};
    public int[] spike19 = {CANVAS_WIDTH + TILE_SIZE * 46, CANVAS_WIDTH + TILE_SIZE * 46 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 46 + TILE_SIZE};
    public int[] spike20 = {CANVAS_WIDTH + TILE_SIZE * 47, CANVAS_WIDTH + TILE_SIZE * 47 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 47 + TILE_SIZE};
    public int[] spike21 = {CANVAS_WIDTH + TILE_SIZE * 55, CANVAS_WIDTH + TILE_SIZE * 55 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 55 + TILE_SIZE};
    public int[] spike22 = {CANVAS_WIDTH + TILE_SIZE * 56, CANVAS_WIDTH + TILE_SIZE * 56 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 56 + TILE_SIZE};
    public int[] spike23 = {CANVAS_WIDTH + TILE_SIZE * 58, CANVAS_WIDTH + TILE_SIZE * 58 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 58 + TILE_SIZE};
    public int[] spike24 = {CANVAS_WIDTH + TILE_SIZE * 59, CANVAS_WIDTH + TILE_SIZE * 59 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 59 + TILE_SIZE};
    public int[] spike25 = {CANVAS_WIDTH + TILE_SIZE * 61, CANVAS_WIDTH + TILE_SIZE * 61 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 61 + TILE_SIZE};
    public int[] spike26 = {CANVAS_WIDTH + TILE_SIZE * 62, CANVAS_WIDTH + TILE_SIZE * 62 + TILE_SIZE / 2, CANVAS_WIDTH + TILE_SIZE * 62 + TILE_SIZE};
    public int[] spikeY = {700, 655, 700};
    public int[] spikeY2 = {500, 545, 500};
    public int[] spikeY3 = {600, 555, 600};
    public int[] spikeY4 = {550, 505, 550};
    public int[] spikeY5 = {500, 455, 500};

    public int[] platformsX = {6, 9, 15, 16, 17, 18, 20, 20, 21, 21, 22, 22, 23, 23, 24,
                                24, 25, 25, 26, 26, 30, 30, 31, 35, 36, 37, 38, 39, 40, 41,
                                42, 43, 44, 45, 46, 47, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                                61, 62, 63, 64, 65, 65, 57, 58, 59, 60, 61, 62, 63, 64, 65,
                                60, 61, 62, 63, 64, 65};
    public int[] platformsY = {650, 650, 650, 650, 650, 650, 600, 650, 600, 650, 600, 650, 600, 650, 600,
                                650, 600, 650, 600, 650, 600, 650, 650, 450, 450, 450, 450, 450, 450, 450,
                                450, 450, 450, 450, 450, 450, 600, 600, 600, 600, 600, 600, 600, 600, 600,
                                600, 600, 600, 600, 600, 650, 550, 550, 550, 550, 550, 550, 550, 550, 550,
                                500, 500, 500, 500, 500, 500};
    public boolean gameOver = false;
    final int FPS = 60;
    ArrayList<Platform> platforms = new ArrayList<>();
    ArrayList<int[]> spikeX = new ArrayList<>();
    ArrayList<Polygon> spikes = new ArrayList<>();
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

        platforms.add(new Platform(0, 700, CANVAS_WIDTH, CANVAS_HEIGHT));
        for (int i = 0; i < platformsX.length; i++) {
            platforms.add(new Platform(CANVAS_WIDTH + TILE_SIZE * platformsX[i], platformsY[i], TILE_SIZE, TILE_SIZE));
        }

        spikeX.add(spike1);
        spikeX.add(spike2);
        spikeX.add(spike3);
        spikeX.add(spike4);
        spikeX.add(spike5);
        spikeX.add(spike6);
        spikeX.add(spike7);
        spikeX.add(spike8);
        spikeX.add(spike9);
        spikeX.add(spike10);
        spikeX.add(spike11);
        spikeX.add(spike12);
        spikeX.add(spike13);
        spikeX.add(spike14);
        spikeX.add(spike15);
        spikeX.add(spike16);
        spikeX.add(spike17);
        spikeX.add(spike18);
        spikeX.add(spike19);
        spikeX.add(spike20);
        spikeX.add(spike21);
        spikeX.add(spike22);
        spikeX.add(spike23);
        spikeX.add(spike24);
        spikeX.add(spike25);
        spikeX.add(spike26);
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
                if (!gameOver) {
                    update();
                }
                repaint();
                delta--; // Returns delta to 0
            }
        }
    }

    public void update() {

        playerClass.playerMove();
        for (int i = 0; i < spike1.length; i++){

            spike1[i] -= platformSpeed;
            spike2[i] -= platformSpeed;
            spike3[i] -= platformSpeed;
            spike4[i] -= platformSpeed;
            spike5[i] -= platformSpeed;
            spike6[i] -= platformSpeed;
            spike7[i] -= platformSpeed;
            spike8[i] -= platformSpeed;
            spike9[i] -= platformSpeed;
            spike10[i] -= platformSpeed;
            spike11[i] -= platformSpeed;
            spike12[i] -= platformSpeed;
            spike13[i] -= platformSpeed;
            spike14[i] -= platformSpeed;
            spike15[i] -= platformSpeed;
            spike16[i] -= platformSpeed;
            spike17[i] -= platformSpeed;
            spike18[i] -= platformSpeed;
            spike19[i] -= platformSpeed;
            spike20[i] -= platformSpeed;
            spike21[i] -= platformSpeed;
            spike22[i] -= platformSpeed;
            spike23[i] -= platformSpeed;
            spike24[i] -= platformSpeed;
            spike25[i] -= platformSpeed;
            spike26[i] -= platformSpeed;
        }
        spikes.clear();
        for (int i = 0; i < spikeX.size(); i++){
            if (i == 7 || i == 8 || i == 9 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19){
                spikes.add(new Polygon(spikeX.get(i), spikeY2, 3));
            }else if (i == 20 || i == 21){
                spikes.add(new Polygon(spikeX.get(i), spikeY3, 3));
            }else if (i == 22 || i == 23){
                spikes.add(new Polygon(spikeX.get(i), spikeY4, 3));
            }else if (i == 24 || i == 25){
                spikes.add(new Polygon(spikeX.get(i), spikeY5, 3));
            } else{
                spikes.add(new Polygon(spikeX.get(i), spikeY, 3));
            }
            if (spikes.get(i).intersects(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE)){
                gameOver = true;
            }
        }

        for (int i = 0; i < platforms.size(); i++){
            platforms.get(i).x -= platformSpeed;
            if (platforms.get(i).x + platforms.get(i).width < 0){
                platforms.get(i).x += platformSpeed - 1;
            }
            if (i == 0){
                platforms.get(i).x += platformSpeed;
            }
            if (collision(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE, platforms.get(i).x, platforms.get(i).y, platforms.get(i).width, platforms.get(i).height)){
                if (playerClass.playerY + playerClass.PLAYER_SIZE <= platforms.get(i).y + 20) {
                    playerClass.playerY = platforms.get(i).y - playerClass.PLAYER_SIZE;
                    playerClass.playerVerticalSpeed = 0;
                }else if (playerClass.playerY == platforms.get(i).y + platforms.get(i).height) {

                }else{
                    gameOver = true;
                }
            }
        }
    }

    public boolean collision(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2){
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

            g2.setColor(new Color(109, 184, 227));
            g2.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

            g2.setColor(new Color(64, 174, 214));
            for (int i = 0; i < CANVAS_WIDTH; i += TILE_SIZE){
                g2.drawLine(i, 0, i, CANVAS_HEIGHT);
            }
            for (int i = 0; i < CANVAS_WIDTH; i += TILE_SIZE){
                g2.drawLine(0, i, CANVAS_WIDTH, i);
            }
            //g2.setColor(new Color(24, 33, 122));
            for (int i = 0; i < spikes.size(); i++){
                g2.setColor(new Color(173, 9, 3));
                g2.fillPolygon(spikes.get(i));
                g2.setColor(new Color(199, 45, 40));
                g2.setStroke(new BasicStroke(3));
                g2.drawPolygon(spikes.get(i));
            }

            g2.setColor(new Color(100, 227, 68));
            g2.fillRect(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE);
            g2.setColor(new Color(72, 153, 43));
            g2.setStroke(new BasicStroke(3));
            g2.drawRect(playerClass.playerX, playerClass.playerY, playerClass.PLAYER_SIZE, playerClass.PLAYER_SIZE);
            g2.setStroke(new BasicStroke(1));
            for (int i = 0; i < platforms.size(); i++){
                if (i == 0){
                    g2.setColor(new Color(8, 22, 92));
                    g2.fillRect(platforms.get(i).x, platforms.get(i).y, platforms.get(i).width, platforms.get(i).height);
                    g2.setColor(new Color(50, 62, 117));
                    g2.setStroke(new BasicStroke(3));
                    g2.drawRect(platforms.get(i).x - 2, platforms.get(i).y - 2, platforms.get(i).width, platforms.get(i).height);
                    g2.setStroke(new BasicStroke(1));
                } else {
                    g2.setColor(new Color(8, 22, 92));
                    g2.fillRect(platforms.get(i).x, platforms.get(i).y, platforms.get(i).width, platforms.get(i).height);
                    g2.setColor(new Color(50, 62, 117));
                    g2.setStroke(new BasicStroke(3));
                    g2.drawRect(platforms.get(i).x - 2, platforms.get(i).y - 2, platforms.get(i).width, platforms.get(i).height);
                    g2.setStroke(new BasicStroke(1));
                }
            }

            if (gameOver){
                g2.setColor(new Color(109, 184, 227));
                g2.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
                g2.setColor(Color.BLACK);
                g2.setFont(new Font("Century Gothic", 1, 100));
                g2.drawString("You Died!", CANVAS_WIDTH / 2 - g2.getFontMetrics().stringWidth("You Died!") / 2, CANVAS_HEIGHT / 3);
            }
        }
    }
}
