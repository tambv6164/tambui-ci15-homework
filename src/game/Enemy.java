package game;

import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    int bulletType;
    int fireCount;

    public Enemy() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.position.set(-50, -50); // nam ngoai man hinh
        this.velocity.set(2,2);
        this.velocity.setAngle(Math.PI / 18);
        this.velocity.setLength(Settings.ENEMY_SPEED); // tang toc enemy
        bulletType = 1;
    }

    @Override // khong them khong sao vi phan mem co the tu dong hieu
    // nhung nen them de code de hieu
    public void run() {
        super.run();
        this.changeVelocity();
        fire();
    }

    private void changeVelocity() {
        if (this.position.x > Settings.BACKGROUND_WIDTH - Settings.ENEMY_WIDTH && this.velocity.x > 0) {
            this.velocity.set(-this.velocity.x, this.velocity.y); // doi huong theo phuong ngang
        }
        if (this.position.x < 0 && this.velocity.x < 0) {
            this.velocity.set(-this.velocity.x, this.velocity.y);
        }
        if (this.position.y > Settings.GAME_HEIGHT - Settings.ENEMY_HEIGHT && this.velocity.y > 0) {
            this.velocity.set(this.velocity.x, -this.velocity.y); // doi huong theo phuong doc
        }
        if (this.position.y < 0 && this.velocity.y < 0) {
            this.velocity.set(this.velocity.x, -this.velocity.y);
        }
    }
    private void fire() {
        fireCount += 1;
        if(fireCount > 20) {
            PlayerBullet bullet = new PlayerBullet();
            bullet.velocity.set(0, 3);
            bullet.loadImageByType(1);
            bullet.position.set(this.position.x, this.position.y);
            fireCount = 0;
        }
    }
}
