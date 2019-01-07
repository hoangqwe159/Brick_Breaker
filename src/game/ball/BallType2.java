package game.ball;

import game.FrameCounter;
import game.brick.*;
import game.GameObject;
import game.physics.BoxCollider;
import game.paddle.Paddle;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;


public class BallType2 extends Ball {

    public FrameCounter frameCounter;

    public BallType2() {
        this.thresholdVelocity = 0.1f;
        this.position.set(360, 400);
        this.velocity.set(3, -5);
        this.anchor.set(0, 0);
        this.frameCounter = new FrameCounter(600);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ball/axit_ball.png"));
    }

    @Override
    public void run() {
        super.run();
        GameObject.resolveCollision(Paddle.class, this.getBoxCollider());
        Brick.destroyAllBricks(this.getBoxCollider());
        if (this.frameCounter.count()) {
            BallType1 new_ball = GameObject.recycleGameObject(BallType1.class);
            new_ball.position.set(this.position);
            new_ball.velocity.set(this.velocity);
            this.destroy();
        }

        AbilityBrickType3 ab3 = GameObject.findIntercepts(AbilityBrickType3.class, this.boxCollider);
        if (ab3 != null) {
            this.destroy();
        }
        this.limitGameObjectPosition();
    }
}
