package game.power;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class Rocket extends GameObject implements Physics {
    private BoxCollider boxCollider;

    public Rocket() {
        super();
        this.createRenderer();
        this.createBoxCollider();
        this.velocity.set(0, -3);
        GameObject.midLayer.add(this);
    }

    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ball/0.png"));
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

    @Override
    public void destroy() {
        super.destroy();
        this.velocity.set(0, -3);
    }
}
