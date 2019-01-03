package game.brick;

import game.GameObject;
import game.physics.BoxCollider;

import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

public class AbilityBrickType3 extends AbilityBrick {

    public AbilityBrickType3() {
        this.velocity.set(10, 0);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/enemy/ability_E3"), false);
    }

}
