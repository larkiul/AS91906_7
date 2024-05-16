package main;

public class Player {
    KeyInput keyInput = new KeyInput();
    final int PLAYER_SIZE = 20;
    final int JUMP_STRENGTH = -15;
    final int CANVAS_WIDTH = 800;
    final int CANVAS_HEIGHT = 800;
    int ground = 700;
    public int playerX = CANVAS_WIDTH / 2 + PLAYER_SIZE / 2;
    public int playerY = CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;
    public int playerHorizontalSpeed = 0;
    public int playerVerticalSpeed = 0;


    public int gravity = 1;
    public void playerMove() {
        fall();
        //playerY += playerVerticalSpeed;
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
        if (playerY + PLAYER_SIZE > ground){
            playerY =  ground - PLAYER_SIZE;
        }

    }

    public void accelerate(double accelerationX, double accelerationY){

    }

    public void fall(){

        if (keyInput.upPressed && playerY + PLAYER_SIZE == ground) {
            playerVerticalSpeed = JUMP_STRENGTH;
            playerY += playerVerticalSpeed;
            System.out.println("hye");
        }
        if (playerY + PLAYER_SIZE < ground) {

            playerVerticalSpeed += gravity;
            playerY += playerVerticalSpeed;

        }
    }
}
