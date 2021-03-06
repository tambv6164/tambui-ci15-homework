package game.player;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    static BufferedImage type1Image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    static BufferedImage type2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
    static BufferedImage type3Image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");

    public PlayerBullet() {
        this.velocity.set(0, -3);
        this.velocity.setLength(Settings.PLAYER_BULLET_SPEED);
    }

    public void loadImageByType(int type) {
        switch (type) {
            case 1:
                this.image = type1Image;
                break;
            case 2:
                this.image = type2Image;
                break;
            case 3:
                this.image = type3Image;
                break;
            default:
                this.image = type1Image;
        }
    }

    @Override
    public void run() {
        super.run();
        deactiveIfNeed();
    }

    private void deactiveIfNeed() {
        if (this.position.y < -30 || this.position.y > Settings.GAME_HEIGHT + 2
            || this.position.x < -30 || this.position.x > Settings.GAME_WIDTH + 2) {
            this.deactive();
        }
    }
}
