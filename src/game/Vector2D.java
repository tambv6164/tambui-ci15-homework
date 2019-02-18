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
        // gán x, y mới cho vector đc gọi
    }

    public void add(double x, double y) {
        // cộng x, y vào vector đc gọi
    }

    public void minus(double x, double y) {
        // trừ x, y vào vector được gọi
    }

    public void scale(double rate) {
        // nhân rate vào vector được gọi
    }

    public double getLength() {
        // trả về độ dài vector được gọi
        return 0;
    }

    public void setLength(double length) {
        // thay đổi độ dài vector bằng độ dài truyền vào, giữ nguyên hướng
    }

    public double getAngle() {
        // trả vè góc tạo bởi vector và trục x
        return 0;
    }

    public void setAngle(double angle){
        // truyền vào 1 góc mới, vetor sẽ quay theo góc mới, giữ nguyên độ dài
    }

}
