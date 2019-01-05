package game.brick;

import game.GameObject;
import game.ball.Ball;
import game.ball.BallType2;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class AbilityBrickType8 extends AbilityBrick {
    public AbilityBrickType8() {
        GameObject.midLayer.add(this);

        this.velocity.set(0, 5);
    }
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ability/ab8.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        this.position.set(0, 0);
        int currentSize = GameObject.gameObjects.size();
        for (int i = 0; i < currentSize; i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Ball) {
                BallType2 ballType2 = GameObject.recycleGameObject(BallType2.class);
                ballType2.position.set(gameObject.position);
                ballType2.velocity.set(gameObject.velocity);
                gameObject.destroy();
            }
        }
    }
}
