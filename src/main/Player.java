package main;

public class Player {
    Canvas myCanvas = new Canvas();
    KeyInput keyInput = new KeyInput();
    final int PLAYER_SIZE = 20;
    final int JUMP_STRENGTH = -5;
    public int playerX = myCanvas.CANVAS_WIDTH / 2 + PLAYER_SIZE / 2;
    public int playerY = myCanvas.CANVAS_HEIGHT / 2 - PLAYER_SIZE / 2;
    public int playerHorizontalSpeed = 0;
    public int playerVerticalSpeed = 0;
    public int gravity = 1;
    public void playerMove() {
        fall();
        playerY += playerVerticalSpeed;
        playerX += playerHorizontalSpeed;

        if (keyInput.downPressed){

        }
        if (keyInput.leftPressed){
            playerHorizontalSpeed = -2;
        } else if (!keyInput.leftPressed) {
            playerHorizontalSpeed = 0;
        }
        if (keyInput.rightPressed){
            playerHorizontalSpeed = 2;
        } else if (!keyInput.rightPressed && !keyInput.leftPressed) {
            playerHorizontalSpeed = 0;
        }

        if (playerX < 0){
            playerX = 0;
        }
        if (playerX + PLAYER_SIZE > myCanvas.CANVAS_WIDTH){
            playerX = myCanvas.CANVAS_WIDTH - PLAYER_SIZE;
        }
        if (playerY < 0){
            playerY = 0;
            playerVerticalSpeed *= -1;
        }
        if (playerY + PLAYER_SIZE * 2 > myCanvas.ground){
            playerY =  myCanvas.ground - PLAYER_SIZE;
        }




    }

    public void accelerate(double accelerationX, double accelerationY){

    }

    public void fall(){

        if (keyInput.upPressed && playerY + PLAYER_SIZE == myCanvas.ground) {
            playerVerticalSpeed = -20;
            //playerY -= playerVerticalSpeed;
            System.out.println("hye");
        }
        if (playerY + PLAYER_SIZE < myCanvas.ground) {
            if (!keyInput.upPressed) {
                playerVerticalSpeed += gravity;
                playerY += playerVerticalSpeed;
            }
        }
    }
}
