package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType9_2 extends Brick {
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/9_2.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        AbilityBrickType9_2 abilityBrickType9_2 = GameObject.recycleGameObject(AbilityBrickType9_2.class);
        abilityBrickType9_2.position.set(this.position);
        abilityBrickType9_2.velocity.set(0, 5);
    }
}
