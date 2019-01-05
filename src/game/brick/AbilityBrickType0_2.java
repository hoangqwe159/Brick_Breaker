package game.brick;

import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import game.scene.Scene;
import tklibs.SpriteUtils;

public class AbilityBrickType0_2 extends AbilityBrick {
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ability/ab0.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        if (Scene.lives > 0) {
            Scene.lives -= 1;
        }
    }
}
