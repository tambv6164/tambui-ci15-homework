package game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;

    public GamePanel() {
        background = new Background();
        player = new Player();
    }

    @Override
    public void paint(Graphics g) {
        background.render(g);
        player.render(g);
    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000/60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay) {
                runAll();
                renderAll();
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }

    private void runAll() {
        background.run();
        player.run();
    }
}
