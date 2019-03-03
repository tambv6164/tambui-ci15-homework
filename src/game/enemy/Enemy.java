package game.enemy;

import game.GameObject;
import game.player.Player;
import game.Settings;
import game.Vector2D;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    int bulletType;
    int fireCount;

    public Enemy() {
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.position.set(-50, -50); // nam ngoai man hinh
        this.velocity.set(2,2);
        this.velocity.setAngle(Math.PI / 18);
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
        if(fireCount > 10) {
            // 1. Tao ra vien dan
//            EnemyBullet bullet = new EnemyBullet(); // thay bằng hàm recycle để recycle bullet
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position);

            // 2. Tinh toan vector tro tu Enemy den Player
            Player player = GameObject.find(Player.class);
            Vector2D enemyToPlayer = player.position.clone();
            enemyToPlayer.minus(this.position.x, this.position.y);
            enemyToPlayer.setLength(4);

            // Dat bullet velocity = vector vua tinh toan
            bullet.velocity.set(enemyToPlayer);
            fireCount = 0;
        }
    }
}
