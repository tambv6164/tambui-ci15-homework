import game.GamePanel;
import game.GameWindow;
import game.Vector2D;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {

    //    public static int sum(int x, int y) {
//        return x + y;
//    }
//    public static void main(String[] args) {
////        int x = 1;
////        double y = 2.3; // so thuc
////        boolean z = true;
////        String s = "Hello world"; // bat buoc dau ngoac kep
//        System.out.println(sum(2, 3)); // go 'sout' enter la ra
//    }
//    public static double[] equation2(double a, double b, double c) {
//        double[] result = new double[2];
//        if (a == 0) {
//            if (b == 0) {
//                result = null;
//            } else {
//                result[0] = -c/b;
//                result[1] = -c/b;
//            }
//        } else {
//            double delta = b*b - 4*a*c;
//            if (delta < 0) {
//                result = null;
//            } else if (delta == 0) {
//                result[0] = (-b) / (2 * a);
//            } else {
//                result[0] = (-b + Math.sqrt(delta)) / (2 * a);
//                result[1] = (-b - Math.sqrt(delta)) / (2 * a);
//            }
//        }
//        return result;
//    }
//    public static void main(String[] args) {
//        double[] result = equation2(0, 0, 2);
//        if (result == null) {
//            System.out.println("Vo nghiem");
//        } else {
//            System.out.println("x1 = " + result[0]);
//            System.out.println("x2 = " + result[1]);
//        }
//    }
    public static void main(String[] args) {
//        Human human1 = new Human();
//        System.out.println(human1.name);
//        human1.sleep(3);
//
//        Human human2 = new Human("Sam", 13, "0987654321");
//        System.out.println(human2.name);
//        human2.eat();


        //
//        // try/catch - đóng gói những dòng code có khả năng gây lỗi và không làm gián đoạn chương trình
//        try { // có thể bắt nhiều lỗi try catch, lỗi nào xảy ra trước thì sẽ báo lỗi đó và dừng chương trình tại đó
////            int x = 10 / 0;
//            devide(10, 0);
//            RandomAccessFile raf = new RandomAccessFile("i-begin-master.iml", "r");
//        } catch (FileNotFoundException ffex) {
//            System.out.println("lỗi đường dẫn");
//        } catch (Exception exception) {
//            System.out.println("Lỗi chia cho 0");
////            exception.printStackTrace();
//        }
//        System.out.println("Hello");
//    }
//
//    private static int devide(int x, int y) {
//        return x / y;
//    }
//        // GAME
////        JFrame window = new JFrame();
        GameWindow window = new GameWindow();
//        window.setSize(800, 600);
        window.setResizable(false);
        window.setTitle("Game Touhou");

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(800,600));
        window.add(panel);
        window.pack();
        window.setVisible(true);
        panel.gameLoop();

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
