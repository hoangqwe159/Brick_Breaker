package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType5_1 extends Brick {
    public BrickType5_1() {
        this.velocity.set(0,0);
        GameObject.midLayer.add(this);
    }
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/3.png"));
    }

    @Override
    public void destroy() {
        super.destroy();
        GameObject.recycleGameObject(AbilityBrickType5_1.class).position.set(this.position.clone().addThis(this.renderer.getCurrentImageSize().clone().scaleThis(0.5f)));
    }
}
