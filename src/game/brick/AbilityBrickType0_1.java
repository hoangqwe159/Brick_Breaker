package game.brick;

import game.GameObject;
import game.paddle.Paddle;
import game.physics.BoxCollider;
import game.renderer.AnimationRenderer;
import game.renderer.SingleimageRenderer;
import game.scene.Scene;
import tklibs.SpriteUtils;

public class AbilityBrickType0_1 extends AbilityBrick {
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
        Scene.lives += 1;
    }
}
