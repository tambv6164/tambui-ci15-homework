package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    Vector2D position;
    Bullet bullet;
    int fireCount;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        position = new Vector2D(200, 500);
        bullet = new Bullet();
        fireCount = 0;
    }

    public void render(Graphics g) {
        g.drawImage(image,
                (int) position.x,
                (int) position.y,
                null
        );
        bullet.render(g);
    }

    public void run() {
        move();
        limit();
        fire();
        bullet.run();
    }
    public void fire() {
        fireCount += 1;
        if (GameWindow.isFirePress && fireCount > 20) {
            Vector2D bulletPosition = new Vector2D(position.x, position.y);
            bullet.positions.add(bulletPosition);
            fireCount = 0;
        }
    }

    public void limit() {
        if (position.y < 0) {
            position.y = 0;
        }
        if (position.y > 600 - 48) {
            position.y = 600 - 48;
        }
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > 384 - 32) {
            position.x = 384 - 32;
        }
    }

    public void move() {
        if (GameWindow.isUpPress) {
            position.y -= 1;
        }
        if (GameWindow.isDownPress) {
            position.y += 1;
        }
        if (GameWindow.isLeftPress) {
            position.x -= 1;
        }
        if (GameWindow.isRightPress) {
            position.x += 1;
        }
    }
}
