package game.brick;

import game.GameObject;
import game.ball.Ball;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;
import tklibs.Vector2D;

public class AbilityBrickType5 extends AbilityBrick {

    public AbilityBrickType5() {
        this.velocity.setY(10);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/Backup/powerup/0.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        this.position.set(0, 0);
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Ball) {
                for (Vector2D size : gameObject.renderer.sizes) {
                }
            }
        }
    }
}
