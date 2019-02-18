import game.GamePanel;
import game.GameWindow;
import game.Vector2D;

import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {

    public static void main(String[] args) {
//        Phần chạy Game

        GameWindow window = new GameWindow();
        window.setResizable(false);
        window.setTitle("Game Touhou");

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800, 600));
        window.add(panel);
        window.pack();
        window.setVisible(true);
        panel.gameLoop();

//        Test phần toán của Vector2D

//        Vector2D s1 = new Vector2D(1,1);
//        System.out.print(s1.getLength());
//        s1.set(1,1);
//        s1.add(1,1);
//        s1.minus(1,1);
//        s1.scale(3);

//        double z = s1.getLength();
//        System.out.println(z);

//        s1.setLength(2.828427125);

//        double angle = s1.getAngle();
//        System.out.println(angle);

//        s1.setAngle(315);

//        System.out.println(s1.x + " " + s1.y);

    }
}
