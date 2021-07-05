package game.brick;

import game.GameObject;
import game.physics.BoxCollider;

import game.power.Rocket;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

public class AbilityBrickType3 extends AbilityBrick {

    public AbilityBrickType3() {
        this.velocity.set(10, 0);
        GameObject.midLayer.add(this);
    }

    public void hitRocket() {
        Rocket rocket = GameObject.findIntercepts(Rocket.class, this.getBoxCollider());
        if (rocket != null) {
            rocket.destroy();
            this.destroy();
            this.velocity.set(10, 0);
        }
    }

    @Override
    public void run() {
        super.run();
        this.hitRocket();
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/enemy/ability_E3"), false);
    }

}
