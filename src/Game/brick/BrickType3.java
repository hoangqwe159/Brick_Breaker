package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType3 extends Brick {
    public BrickType3() {
        this.velocity.set(0,0);
        GameObject.midLayer.add(this);
    }
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/pacman_brick.png"));
    }

    @Override
    public void destroy() {
        super.destroy();
        AbilityBrickType3 ability3 = GameObject.recycleGameObject(AbilityBrickType3.class);
        ability3.position.set(0, 300);
    }
}
