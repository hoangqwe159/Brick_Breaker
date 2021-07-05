package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType7_2 extends Brick {

    public BrickType7_2() {
        GameObject.midLayer.add(this);
    }
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/1.png"));
    }

    @Override
    public void destroy() {
        super.destroy();
        AbilityBrickType7_2 ability7_2 = GameObject.recycleGameObject(AbilityBrickType7_2.class);
        ability7_2.position.set(this.position);
        ability7_2.velocity.set(0, 5);
    }
}
