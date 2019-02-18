package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bullet {
    BufferedImage image;
    ArrayList<Vector2D> positions;

    public Bullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        positions = new ArrayList<>();
    }

    public void render(Graphics g) {
        for (int i = 0; i < positions.size(); i++) {
            Vector2D position = positions.get(i);
            g.drawImage(
                    image,
                    (int) position.x,
                    (int) position.y,
                    null
            );
        }
    }

    public void run() {
        for (int i = 0; i < positions.size(); i++) {
            Vector2D bulletPosition = positions.get(i);
            bulletPosition.y -= 3;
        }
    }
}
