package game.brick;

import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import game.scene.Scene;
import game.scene.SceneStage1;
import tklibs.SpriteUtils;

public class AbilityBrickType9_2 extends AbilityBrick {
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ability/ab9.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        Scene.currentScene.rocketLeft -= 2;
        if (Scene.currentScene.rocketLeft < 0) {
            Scene.currentScene.rocketLeft = 0;
        }
    }
}
