package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType7_1 extends Brick {

    public BrickType7_1() {
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
        AbilityBrickType7_1 ability7_1 = GameObject.recycleGameObject(AbilityBrickType7_1.class);
        ability7_1.position.set(this.position);
        ability7_1.velocity.set(0, 5);
    }
}
