package main;

public class Player {
    KeyInput keyInput = new KeyInput();
    final int PLAYER_SIZE = 50;
    final int JUMP_STRENGTH = -17;
    final int CANVAS_WIDTH = 800;
    final int CANVAS_HEIGHT = 800;
    final int TERMINAL_VEL = 35;
    public int playerX = 200;
    public int playerY = CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;
    public int playerHorizontalSpeed = 0;
    public int playerVerticalSpeed = 0;
    public int gravity = 1;
    public int jumpDelay = 0;
    public boolean buttonHeld = false;
    public boolean onGround;

    public void playerMove() {

        fall();

        if (keyInput.leftPressed){
            playerHorizontalSpeed = -2;
        }else{
            playerHorizontalSpeed = 0;
        }
        if (keyInput.rightPressed){
            playerHorizontalSpeed = 2;
        }
        if (keyInput.rightPressed && keyInput.leftPressed){
            playerHorizontalSpeed = 0;
        }

        playerCollisions();
    }

    public void fall(){

        if (keyInput.upPressed && !buttonHeld && onGround) {
            buttonHeld = true;
            onGround = false;
            jumpDelay = 35;
            playerVerticalSpeed = JUMP_STRENGTH;
        }

        if (!keyInput.upPressed){
            buttonHeld = false;
        }

        if (playerVerticalSpeed < TERMINAL_VEL) {
            playerVerticalSpeed += gravity;
        }
        playerY += playerVerticalSpeed;

    }

    public void playerCollisions(){

        if (playerX < 0){
            playerX = 0;
        }
        if (playerX + PLAYER_SIZE > CANVAS_WIDTH){
            playerX = CANVAS_WIDTH - PLAYER_SIZE;
        }
        if (playerY < 0){
            playerY = 0;
            playerVerticalSpeed *= -1;
        }
        if (playerY > CANVAS_HEIGHT){
            playerY = 0;
        }
    }


}
