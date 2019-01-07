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
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/3.png"));
    }

    @Override
    public void destroy() {
        super.destroy();
        AbilityBrickType3 pacman = GameObject.recycleGameObject(AbilityBrickType3.class);
        pacman.position.set(-this.renderer.getCurrentImageSize().x, this.position.y + 0.5f * (this.renderer.getCurrentImageSize().y - pacman.renderer.getCurrentImageSize().y));
    }
}
