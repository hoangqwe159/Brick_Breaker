package game.power;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.AnimationRenderer;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class Rocket extends GameObject implements Physics {
    private BoxCollider boxCollider;

    public Rocket() {
        super();
        this.createRenderer();
        this.createBoxCollider();
        this.acceleration.setY(-0.22f);
//        this.velocity.set(0, -8);
        this.anchor.setY(1f);
        GameObject.midLayer.add(this);
    }

    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    public void createRenderer() {
        this.renderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/rocket"), false, 0);
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }
}
