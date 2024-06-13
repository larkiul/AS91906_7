package main;

public class Player {
    KeyInput keyInput = new KeyInput();
    Platform ground = new Platform(0, 700, 800, 100);
    Platform platOne = new Platform(100, 600, 100, 20);
    Platform platTwo = new Platform(600, 600, 100, 20);
    final int PLAYER_SIZE = 20;
    final int JUMP_STRENGTH = -15;
    final int CANVAS_WIDTH = 800;
    final int CANVAS_HEIGHT = 800;
    final int TERMINAL_VEL = 35;
    //int ground = 700;
    public int playerX = CANVAS_WIDTH / 2 + PLAYER_SIZE / 2;
    public int playerY = CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;
    public int playerHorizontalSpeed = 0;
    public int playerVerticalSpeed = 0;
    public int gravity = 1;
    public int jumpDelay = 0;
    public boolean buttonHeld = false;

    public void playerMove() {

        fall();

        playerX += playerHorizontalSpeed;

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

        if (keyInput.upPressed && playerY + PLAYER_SIZE == ground.y && jumpDelay == 0 && !buttonHeld) {
            buttonHeld = true;
            jumpDelay = 35;
            playerVerticalSpeed = JUMP_STRENGTH;
            playerY += playerVerticalSpeed;
        }

        if (!keyInput.upPressed){
            buttonHeld = false;
        }

        if (playerY + PLAYER_SIZE < ground.y) {
            if (playerVerticalSpeed < TERMINAL_VEL) {
                playerVerticalSpeed += gravity;
            }
            playerY += playerVerticalSpeed;
        }

        if (jumpDelay > 0){
            jumpDelay--;
        }
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
        if (playerY + PLAYER_SIZE > ground.y){
            playerY = ground.y - PLAYER_SIZE;
        }

        if (collisionTop(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE, 600, 600, 100, 20)){
            //System.out.println("hello");
            if (playerY + PLAYER_SIZE >= platOne.y && playerY + PLAYER_SIZE <= platOne.y + platOne.height / 2) {
                playerY = platTwo.y - PLAYER_SIZE;
            }
            if (playerY <= platTwo.y + platTwo.height && playerY >= platTwo.y + platTwo.height / 2) {
                playerY = platTwo.y + platTwo.width;
            }
            if (playerY + PLAYER_SIZE >= 600) {
                //playerY = platTwo.y - PLAYER_SIZE;
            }
            if (playerY + PLAYER_SIZE >= 600) {
                //playerY = platTwo.y - PLAYER_SIZE;
            }
        }



    }

    public Boolean collisionTop(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2){
        if (x1 + w1 >= x2 && x1 <= x2 + w2 && y1 + h1 > y2 && y1 <= y2 + h2){
            return true;
        } else {
            return false;
        }
    }
}
