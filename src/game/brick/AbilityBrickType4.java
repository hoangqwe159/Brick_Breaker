package game.brick;

import game.GameObject;
import game.ball.Ball;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

import java.util.ArrayList;

public class AbilityBrickType4 extends AbilityBrick {

    public AbilityBrickType4() {
        this.position.set(400, 400);
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
        int currentSize = GameObject.gameObjects.size();
        for (int i = 0; i < currentSize; i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Ball) {
                Ball object = (Ball)GameObject.recycleGameObject(gameObject.getClass());
                object.renderer.images = new ArrayList<>(gameObject.renderer.images);
                object.renderer.sizes = new ArrayList<>(gameObject.renderer.sizes);
                object.position.set(gameObject.position);
                object.velocity.setLength(gameObject.velocity.getLength()).setAngle((float)(gameObject.velocity.getAngle() + Math.PI / 9));
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        this.velocity.setY(10);
    }
}
