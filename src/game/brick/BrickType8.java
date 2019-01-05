package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType8 extends Brick {
    public BrickType8() {
        this.velocity.set(0,0);
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
    public void triggerSpecialEffectWhenHit() {
        AbilityBrickType8 abilityBrickType8 = GameObject.recycleGameObject(AbilityBrickType8.class);
        abilityBrickType8.position.set(this.position);
        abilityBrickType8.velocity.set(0, 5);
    }
}
