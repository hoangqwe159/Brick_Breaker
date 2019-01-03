package game.ball;

import game.GameObject;
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
}
