package game;

public class Vector2D {
    public double x;
    public double y;

    // hàm tạo rỗng
    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }
    // hàm tạo đầy đủ
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // TODO: continue upgrading ...
    // BTVN
    public Vector2D clone() {

        return null;
    }

    public void set(double x, double y) {
        // gán giá trị mới
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        // cộng x, y vào vector đc gọi
        this.x += x;
        this.y += y;
    }

    public void minus(double x, double y) {
        // trừ x, y vào vector được gọi
        this.x -= x;
        this.y -= y;
    }

    public void scale(double rate) {
        // nhân rate vào vector được gọi
        this.x *= rate;
        this.y *= rate;
    }

    public double getLength() {
        // trả về độ dài vector được gọi
        double z;
        z = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
        return z;
    }

    public void setLength(double length) {
        // thay đổi độ dài vector bằng độ dài truyền vào, giữ nguyên hướng
        double z = this.getLength();
        double rate = length/z;
        this.x *= rate;
        this.y *= rate;
    }

    public double getAngle() {
        // trả vè góc tạo bởi vector và trục x
        double z = this.getLength();
        double angle;

        if (x > 0 && y > 0) {
            angle = Math.toDegrees(Math.asin(this.y / z));
        } else if (x < 0 && y > 0) {
            angle = Math.toDegrees(Math.asin(this.y / z)) + 90;
        } else if (x < 0 && y < 0) {
            angle = Math.toDegrees(Math.asin(this.y / z)) + 270;
        } else {
            angle = Math.toDegrees(Math.asin(this.y / z)) + 360;
        }
        return angle;
    }

    public void setAngle(double angle){
        // truyền vào 1 góc mới, vetor sẽ quay theo góc mới, giữ nguyên độ dài
        double z = this.getLength();
        double ra = Math.toRadians(angle);
        double sin = Math.sin(ra);
        double cos = Math.cos(ra);

        this.x = z*cos;
        this.y = z*sin;
        System.out.println(ra);
    }

}
