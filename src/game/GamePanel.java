package game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    Enemy enemy;

    public GamePanel() { // nơi triển khai game
        background = new Background();
        player = new Player();
        enemy = new Enemy();
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 60; // khoảng cách giữa 2 lần chạy ở 60fps
        while (true) {
            long currentTime = System.currentTimeMillis();
            // currentTimeMillis là khoảng thời gian từ năm 1970 đến hiện tại, đo bằng mili giây
            if (currentTime - lastTime >= delay) {
                runAll(); // chạy tất cả logic trong game. đưa trỏ chuột vào tên hàm và nhất Alt + Enter để tự động tạo hàm tạo
                renderAll(); // vẽ tất cả ảnh trong game
                lastTime = currentTime;
            }
        }
    }

//    extends là kế thừa class cha (JPanel) sang class con (GamePanel)
    @Override // nghĩa là ghi đè
    public void paint(Graphics g) { //Graphics tương đương như cây bút vẽ giúp chúng ta vẽ hình lên panel
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }

    private void runAll() { // chạy logic
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }

    private void renderAll() { // vẽ hình
        repaint(); // sẽ gọi lại hàm paint để chạy
    }
}
