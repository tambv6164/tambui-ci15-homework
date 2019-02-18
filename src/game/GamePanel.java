package game;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Background background;
    BufferedImage playerImage;
    Vector2D playerPosition;
    BufferedImage bulletImage;
    ArrayList<Vector2D> bulletPositions; // một mảng chứa các vị trí của các viên đạn
    int fireCount;

    public GamePanel() { // nơi triển khai game
        background = new Background();
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        playerPosition = new Vector2D(200, 500);
//        playerX = 200;
//        playerY = 500;
        bulletImage = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        bulletPositions = new ArrayList<>();
//        bulletPositions.add(new Vector2D(200,400)); // thêm 1 viên đạn vào để test
//        bulletPosition.add() // thêm phần tử vào mảng
//        bulletPosition.get() // lẩy ra phần tử ở một vị trí cụ thể
//        bulletPosition.size() // kích thước của mảng
        fireCount = 0;
    }

//    extends là kế thừa class cha (JPanel) sang class con (GamePanel)
    @Override // nghĩa là ghi đè
    public void paint(Graphics g) { //Graphics tương đương như cây bút vẽ giúp chúng ta vẽ hình lên panel
//        vẽ hình chữ nhật
//        g.drawRect(0,0,100,100);
//        load ảnh (url là đường dẫn tương đối: Relative Path)
//        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        vẽ background
        background.render(g);
        // vẽ player
        g.drawImage(playerImage,
                (int) playerPosition.x,
                (int) playerPosition.y,
                null
        );
        // duyệt toàn mảng bullerPositions để vẽ ra các viên đạn
        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            g.drawImage(
                    bulletImage,
                    (int) bulletPosition.x,
                    (int) bulletPosition.y,
                    null
            );
        }
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
        background.run();
        playerRun();
        bulletsRuns();
    }

    private void bulletsRuns() {
        for (int i = 0; i < bulletPositions.size(); i++) {
            Vector2D bulletPosition = bulletPositions.get(i);
            bulletPosition.y -= 3;
        }
    }

    private void playerRun() {
        playerMove();
        playerLimit();
        playerFire();
    }

    private void playerFire() {
        fireCount += 1;
        if (GameWindow.isFirePress && fireCount > 20) {
            Vector2D bulletPosition = new Vector2D(playerPosition.x, playerPosition.y);
            bulletPositions.add(bulletPosition);
            fireCount = 0;
        }
    }

    private void playerLimit() {
        if (playerPosition.y < 0) {
            playerPosition.y = 0;
        }
        if (playerPosition.y > 600 - 48) {
            playerPosition.y = 600 - 48;
        }
        if (playerPosition.x < 0) {
            playerPosition.x = 0;
        }
        if (playerPosition.x > 384 - 32) {
            playerPosition.x = 384 - 32;
        }
    }

    private void playerMove() {
        if (GameWindow.isUpPress) {
            playerPosition.y -= 1;
        }
        if (GameWindow.isDownPress) {
            playerPosition.y += 1;
        }
        if (GameWindow.isLeftPress) {
            playerPosition.x -= 1;
        }
        if (GameWindow.isRightPress) {
            playerPosition.x += 1;
        }
    }

}
