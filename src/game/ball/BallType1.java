package game.ball;

import game.GameWindow;
import game.brick.*;
import game.GameObject;
import game.physics.BoxCollider;
import game.paddle.Paddle;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;


public class BallType1 extends Ball {
    public static boolean ballIsReset;

    public BallType1() {
        BallType1.ballIsReset = false;
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
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ball/0.png"));
    }

    @Override
    public void run() {
        super.run();
        this.limitVelocity();
        this.launchNewBall();

        GameObject.resolveCollision(Paddle.class, this.getBoxCollider());
        GameObject.resolveCollision(BrickType0_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType0_2.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType2.class, this.getBoxCollider());
        GameObject.resolveCollision(BrickType3.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType4.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType5_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType5_2.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType6.class, this.getBoxCollider());
        GameObject.resolveCollision(BrickType7_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType7_2.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType8.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType9_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(BrickType9_2.class, this.getBoxCollider(), true);


        AbilityBrickType3 ab3 = GameObject.findIntercepts(AbilityBrickType3.class, this.boxCollider);
        if (ab3 != null) {
            this.destroy();
        }
        this.limitGameObjectPosition();
    }

    public void launchNewBall() {
        if (BallType1.ballIsReset) {
            if (GameWindow.isNewBallPress) {
                BallType1.ballIsReset = false;
                this.velocity.set(0, -5);
            }
            if (GameWindow.isLeftPress || GameWindow.isRightPress) {
                Paddle paddle = Paddle.getPaddle();
                this.position.set(paddle.position.clone().addX(paddle.renderer.getCurrentImageSize().x / 2).subtractThis(this.renderer.getCurrentImageSize().x / 2, this.renderer.getCurrentImageSize().y));
            }
        }
    }
}
