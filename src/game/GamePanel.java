package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage backgroundImage;
    BufferedImage playerImage;
    int backgroundX;
    int backgroundY;
    int playerX;
    int playerY;

    public GamePanel() { // nơi triển khai game
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        backgroundX = 0;
        backgroundY = 600 - 3109;
        playerX = 200;
        playerY = 500;
    }

//    extends là kế thừa class cha (JPanel) sang class con (GamePanel)
    @Override // nghĩa là ghi đè
    public void paint(Graphics g) { //Graphics tương đương như cây bút vẽ giúp chúng ta vẽ hình lên panel
//        vẽ hình chữ nhật
//        g.drawRect(0,0,100,100);
//        load ảnh (url là đường dẫn tương đối: Relative Path)
//        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        vẽ ảnh
        g.drawImage(backgroundImage, backgroundX, backgroundY,null);
        g.drawImage(playerImage, playerX, playerY,null);
    }
    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000/60; // khoảng cách giữa 2 lần chạy ở 60fps
        while (true) {
            long currentTime = System.currentTimeMillis();
            // currentTimeMillis là khoảng thời gian từ năm 1970 đến hiện tại, đo bằng mili giây
            if (currentTime - lastTime >= delay) {
                // vẽ ảnh + chạy logic
//                System.out.println(currentTime - lastTime);
                runAll(); // chạy tất cả logic trong game. đưa trỏ chuột vào tên hàm và nhất Alt + Enter để tự động tạo hàm tạo
                renderAll(); // vẽ tất cả ảnh trong game
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() { // vẽ hình
        repaint(); // sẽ gọi lại hàm paint để chạy
    }

    private void runAll() { // chạy logic
        if (backgroundY < 0) {
            backgroundY += 1;
        }
        if (GameWindow.isUpPress && playerY > 0) {
            playerY--;
        }
        if (GameWindow.isDownPress && playerY < 500) {
            playerY++;
        }
        if (GameWindow.isLeftPress && playerX > 0) {
            playerX--;
        }
        if (GameWindow.isRightPress && playerX < 350) {
            playerX++;
        }
    }
}
