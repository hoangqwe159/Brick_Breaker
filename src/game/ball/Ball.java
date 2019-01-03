package game.ball;

import game.GameObject;
import game.Setting;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.scene.GameOverScene;
import game.scene.Scene;

public abstract class Ball extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public int maxVelocity;
    public Ball() {
        this.createRenderer();
        this.createBoxCollider();
    }

    public abstract void createBoxCollider();

    public abstract void createRenderer();

   // public abstract void hitEnemy();

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }

    @Override
    public void destroy() {
        super.destroy();
        if (GameObject.noBallLeft()) {
            Scene.signNewScene(new GameOverScene());
        }
    }

    @Override
    public void limitGameObjectPosition() {
        if (this.position.x < 0) {
            this.position.set(0, this.position.y);
            this.velocity.scaleX(-1);
        }
        else if (this.position.x > Setting.SCREEN_WIDTH - this.renderer.getCurrentImageSize().x) {
            this.position.set(Setting.SCREEN_WIDTH - this.renderer.getCurrentImageSize().x, this.position.y);
            this.velocity.scaleX(-1);
        }

        if (this.position.y < 0) {
            this.position.set(this.position.x, 0);
            this.velocity.scaleY(-1);
        }

        else if (this.position.y > Setting.SCREEN_HEIGHT) {
            this.destroy();
        }
    }
}
