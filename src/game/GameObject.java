package game;

import game.player.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    // static - quản lý đối tượng
    public static ArrayList<GameObject> objects = new ArrayList<>();

    // Nhiệm vụ: Trả ra 1 GameObject
    // 1. Tìm trong objects, nếu có phần tử thỏa mãn thì reset phần tử đó rồi trả ra
    // 2. Nếu không tìm thấy phần tử thỏa mãn thì tạo mới rồi trả ra
    public static <E extends GameObject> E recycle(Class<E> cls) {
        E result = findInactive(cls);
        // Nếu tìm thấy đối tượng thỏa mãn
        if (result != null) {
            result.reset();
            return result;
        }
        // Nếu không tìm thấy
        try {
            // tao ra một đối tượng mới nếu không tìm thấy đối tượng thỏa mãn
            return cls.getConstructor().newInstance(); //tương đương return result = new (E) - tạo mới đối tượng
        } catch (Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E findInactive(Class<E> cls) {
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (!object.active
                    && object.getClass().isAssignableFrom(cls)) {
                result = (E) object;
            }
        }
        return result;
    }

    public static <E extends GameObject> E find(Class<E> cls) {
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active
                    && object.getClass().isAssignableFrom(cls)) {
                // tuong duong instanceOf: kiểm tra xem biến object có được sinh ra từ class E không
                result = (E) object;
                // ép kiểu dữ liệu của object thành class E mà nó được sinh ra
                // vì gán result = object thì nó báo lỗi vì 2 kiểu dữ liệu đang khác nhau
            }
        }
        return result;
    }

    // non-static - định nghĩa đối tượng
    public BufferedImage image;
    public  ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int changeImageCount;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;

    public GameObject() {
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.active = true;
        objects.add(this);
    }

    public void render(Graphics g) {
        if (this.image != null) {
            this.renderSingleImage(g);
        } else if (this.images != null) {
            this.renderAnimation(g);
        }
    }

    private void renderAnimation(Graphics g) {
        BufferedImage currentImage = images.get(currentImageIndex);
        g.drawImage(currentImage, (int) position.x, (int) position.y, null);

        changeImageCount++;
        if (changeImageCount > 10) {
            currentImageIndex++;
            if (currentImageIndex >= images.size()) {
                currentImageIndex = 0;
            }
            changeImageCount = 0;
        }
    }

    private void renderSingleImage(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }

    public void run() {
        this.position.add(this.velocity.x, this.velocity.y);
    }

    public void deactive() {
        this.active = false;
    }

    public void reset() {
        this.active = true;
    }
}
