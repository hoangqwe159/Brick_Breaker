package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType9_1 extends Brick {
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/9_1.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        AbilityBrickType9_1 abilityBrickType9_1 = GameObject.recycleGameObject(AbilityBrickType9_1.class);
        abilityBrickType9_1.position.set(this.position);
        abilityBrickType9_1.velocity.set(0, 5);
    }
}
