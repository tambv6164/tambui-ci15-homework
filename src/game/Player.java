package game;

import tklibs.SpriteUtils;

import java.util.Random;

public class Player extends GameObject {
    int fireCount;
    int bulletType;
    int changeBulletCount;
    Random random;

    public Player () {
        this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.position.set(200, 500);
        fireCount = 0;
        bulletType = 1;
        changeBulletCount = 0;
        random = new Random();
    }

    @Override
    public void run() {
        super.run();
        move();
        limit();
        fire();
        changeBulletType();
    }

    private void move() {
        int vX = 0;
        int vY = 0;

        if (GameWindow.isUpPress) {
            vY --;
        }
        if (GameWindow.isDownPress) {
            vY ++;
        }
        if (GameWindow.isLeftPress) {
            vX --;
        }
        if (GameWindow.isRightPress) {
            vX ++;
        }

        this.velocity.set(vX, vY);
        this.velocity.setLength(1); // khi nguoi choi di cheo
        // thi quang duong di duoc dung bang 1, khong phai bang duong cheo
    }

    private void limit() {
        if (position.y < 0) {
            position.y = 0;
        }
        if (position.y > Settings.GAME_HEIGHT - Settings.PLAYER_HEIGHT) {
            position.y = Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT;
        }
        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > Settings.BACKGROUND_WIDTH - Settings.PLAYER_WIDTH) {
            position.x = Settings.BACKGROUND_WIDTH - Settings.PLAYER_WIDTH;
        }
    }

    private void fire() {
        fireCount += 1;
        if (GameWindow.isFirePress && fireCount > 20) {
//            // tao ra mot vien dan 1 lan ban
////            PlayerBullet bullet = new PlayerBullet();
////            bullet.position.set(position.x, position.y);
////            bullets.add(bullet);

            // tao ra nhieu vien 1 lan ban
            int numberBullet = 3;
            double startAngle = -Math.PI / 4;
            double offsetAngle = Math.PI / 2 / (numberBullet - 1); // offset > goc giua 2 duong dan
            for (int i = 0; i < numberBullet; i++) {
                PlayerBullet bullet = new PlayerBullet();
                bullet.loadImageByType(bulletType);
                bullet.position.set(this.position.x, this.position.y);
                bullet.velocity.setAngle(startAngle - i * offsetAngle);
            }
            fireCount = 0;
        }
    }

    private void changeBulletType() {
        changeBulletCount++;
        if (changeBulletCount > 300) {
            bulletType = 1 + random.nextInt(3);
            changeBulletCount = 0;
        }
    }
}
