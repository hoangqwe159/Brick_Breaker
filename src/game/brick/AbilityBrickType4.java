package game.brick;

import game.GameObject;
import game.ball.Ball;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

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
                GameObject.recycleGameObject(gameObject.getClass()).position.set(gameObject.position);
                GameObject.gameObjects.get(currentSize).velocity.setAngle((float)(gameObject.velocity.getAngle() + Math.PI / 9));
            }
        }
    }
}
