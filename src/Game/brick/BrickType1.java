package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType1 extends Brick {
    public BrickType1() {
        this.velocity.set(0,0);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, 80, 40, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/0.png"));
    }

    @Override
    public void run() {
        super.run();
//        ball ball = GameObject.findIntercepts(ball.class, this.boxCollider);

    }
}
