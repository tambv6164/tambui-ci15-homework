import game.GamePanel;
import game.GameWindow;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

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

        // GAME
//        JFrame window = new JFrame();
        GameWindow window = new GameWindow();
        window.setSize(800, 600);
        window.setResizable(false);
        window.setTitle("Game Touhou");

        GamePanel panel = new GamePanel();
        window.add(panel);
        window.setVisible(true);
        panel.gameLoop();
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
    }
}
