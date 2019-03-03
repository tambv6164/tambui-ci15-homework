import game.Vector2D;

public class Rectangle {
    Vector2D position; // vị trí góc trên bên trái hình chữ nhật ()
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle(int x, int y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * @param other
     * @return true: nếu hcn được gọi (this) có phần giao với hcn truyền vào (other)
     * @return false: nếu 2 hcn khong giao nhau
     */
    public boolean intersects(Rectangle other) {
        double a = this.position.x;
        double b = this.position.x + this.width;
        double c = this.position.y;
        double d = this.position.y + this.height;

        double a1 = other.position.x;
        double b1 = other.position.x + other.width;
        double c1 = other.position.y;
        double d1 = other.position.y + other.height;

        if ((a < a1 && a1 < b && c < c1 && c1 < d) || (a < a1 && a1 < b && c < d1 && d1 < d)
                || (a < b1 && b1 < b && c < c1 && c1 < d) || (a < b1 && b1 < b && c < d1 && d1 < d)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0, 0, 100, 100);
        Rectangle rect2 = new Rectangle(50, 50, 100, 100);
        Rectangle rect3 = new Rectangle(200, 200, 100, 100);
        System.out.println(rect1.intersects(rect2) + " " + true);
        System.out.println(rect1.intersects(rect3) + " " + false);
    }
}
