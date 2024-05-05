package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyChar();

        if (keyPressed == 'w') {
            upPressed = true;
        }
        if (keyPressed == 's') {
            downPressed = true;
        }
        if (keyPressed == 'a') {
            leftPressed = true;
        }
        if (keyPressed == 'd') {
            rightPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyReleased = e.getKeyChar();

        if (keyReleased == 'w') {
            upPressed = false;
        }
        if (keyReleased == 's') {
            downPressed = false;
        }
        if (keyReleased == 'a') {
            leftPressed = false;
        }
        if (keyReleased == 'd') {
            rightPressed = false;
        }
    }

    public void keyTyped(KeyEvent e) {}
}
