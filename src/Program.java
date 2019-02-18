import game.GamePanel;
import game.GameWindow;
import game.Vector2D;

import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {

    public static void main(String[] args) {

        GameWindow window = new GameWindow();
        window.setResizable(false);
        window.setTitle("Game Touhou");

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800, 600));
        window.add(panel);
        window.pack();
        window.setVisible(true);
        panel.gameLoop();

    }
}
