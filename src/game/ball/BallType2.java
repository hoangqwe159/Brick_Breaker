package game.ball;

import game.brick.*;
import game.GameObject;
import game.physics.BoxCollider;
import game.paddle.Paddle;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;


public class BallType2 extends Ball {

    public BallType2() {
        this.maxVelocity = 10;
        this.thresholdVelocity = 0.2f;
        this.position.set(360, 400);
        this.velocity.set(3 , -5);
        this.anchor.set(0, 0);
        GameObject.midLayer.add(this);
    }
    public void limitVelocity() {
        if (this.velocity.getLength() > this.maxVelocity) {
            if (this.velocity.getLength() > 1.8 * this.maxVelocity) {
                if (Math.abs(this.velocity.y) < this.thresholdVelocity) {
                    if (this.velocity.y != 0) {
                        this.velocity.setY(2f * this.maxVelocity * Math.signum(this.velocity.y) * 0.9f);
                    }
                    else {
                        this.velocity.setY(-2f * this.maxVelocity);
                    }
                }
                else if (Math.abs(this.velocity.x) < this.thresholdVelocity) {
                    if (this.velocity.x != 0) {
                        this.velocity.setX(2f * this.maxVelocity * Math.signum(this.velocity.x) * 0.9f);
                    }
                    else {
                        this.velocity.setX(2f * this.maxVelocity);
                    }
                }
            }
            this.velocity.setLength(this.maxVelocity);
        }
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
        this.limitVelocity();
        super.run();
        GameObject.resolveCollision(Paddle.class, this.getBoxCollider());
        Brick.destroyAllBricks(this.getBoxCollider());

        AbilityBrickType3 ab3 = GameObject.findIntercepts(AbilityBrickType3.class, this.boxCollider);
        if (ab3 != null) {
            this.destroy();
        }
        this.limitGameObjectPosition();
    }
}
