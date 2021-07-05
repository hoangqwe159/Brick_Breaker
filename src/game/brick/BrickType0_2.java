package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType0_2 extends Brick {
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
        AbilityBrickType0_2 abilityBrickType0_2 = GameObject.recycleGameObject(AbilityBrickType0_2.class);
        abilityBrickType0_2.position.set(this.position);
        abilityBrickType0_2.velocity.set(0, 5);
    }
}
