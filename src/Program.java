import game.GamePanel;
import game.GameWindow;
import game.Settings;
import game.Vector2D;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {

    public static void main(String[] args) {
        // GAME
////        JFrame window = new JFrame();
        GameWindow window = new GameWindow();
        window.setResizable(false);
        window.setTitle("Game Touhou");

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));
        window.add(panel);
        window.pack();
        panel.setBackground(Color.CYAN);
        window.setVisible(true);
        panel.gameLoop();

//        // try/catch - đóng gói những dòng code có khả năng gây lỗi và không làm gián đoạn chương trình
//        try { // có thể bắt nhiều lỗi try catch, lỗi nào xảy ra trước thì sẽ báo lỗi đó và dừng chương trình tại đó
////            int x = 10 / 0;
//            devide(10, 0);
//            RandomAccessFile raf = new RandomAccessFile("i-begin-master.iml", "r");
//        } catch (FileNotFoundException ffex) {
//            System.out.println("lỗi đường dẫn");
//        } catch (Exception exception) { // catch Exception sau cùng, sau các lỗi khác, vì nó là thằng to nhất, bao trùm hết các lỗi kia
//            System.out.println("Lỗi chia cho 0");
////            exception.printStackTrace();
//        }
//        System.out.println("Hello");
//    }
//
//    private static int devide(int x, int y) {
//        return x / y;
//    }
//

        // TÌM HIỂU VỀ ARRAY LIST
//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        Vector2D v1 = new Vector2D(1,1);
//        Vector2D v2 = new Vector2D(2,2);
//        vectors.add(new Vector2D(2,3));
//        vectors.add(new Vector2D(3,3));
//        vectors.add(v1);
//        vectors.add(v2);
//        double max = 0;
//        int maxIndex = 0;
//
//        for (int i = 0; i < vectors.size(); i++) {
//            Vector2D vector = vectors.get(i);
//            if (vector.x + vector.y > max) {
//                max = vector.x + vector.y;
//                maxIndex = i;
//            }
//        }
//        Vector2D vectorMax = vectors.get(maxIndex);
//        System.out.println(vectorMax.x + " " + vectorMax.y);

    }
}
