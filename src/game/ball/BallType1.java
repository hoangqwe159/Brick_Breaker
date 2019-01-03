package game.ball;

import game.brick.AbilityBrickType3;
import game.brick.BrickType1;
import game.brick.BrickType2;
import game.brick.BrickType3;
import game.GameObject;
import game.physics.BoxCollider;
import game.paddle.Paddle;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;


public class BallType1 extends Ball {

    public BallType1() {
        this.maxVelocity = 10;
        this.position.set(360, 400);
        this.velocity.set(3 , -5);
        this.anchor.set(0, 0);
        GameObject.midLayer.add(this);
    }
    public void limitVelocity() {
        if (this.velocity.getLength() > this.maxVelocity) {
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
        this.limitVelocity();
        super.run();
        Paddle paddle = GameObject.findIntercepts(Paddle.class, this.getBoxCollider());
        if (paddle != null){
            paddle.getBoxCollider().resolveCollision(this.boxCollider);
        }

        BrickType1 brick1 = GameObject.findIntercepts(BrickType1.class, this.getBoxCollider());
        if (brick1 != null) {
            brick1.getBoxCollider().resolveCollision(this.boxCollider);
            brick1.destroy();
        }

        BrickType2 brick2 = GameObject.findIntercepts(BrickType2.class, this.boxCollider);
        if (brick2 != null) {
            brick2.getBoxCollider().resolveCollision(this.boxCollider);
        }

        BrickType3 brick3 = GameObject.findIntercepts(BrickType3.class, this.boxCollider);
        if (brick3 != null) {
            brick3.getBoxCollider().resolveCollision(this.boxCollider);
            brick3.destroy();
        }

        AbilityBrickType3 ab3 = GameObject.findIntercepts(AbilityBrickType3.class, this.boxCollider);
        if (ab3 != null) {
            this.destroy();
        }

        this.limitBallType1Position();
    }

    private void limitBallType1Position() {
        if (this.position.x < 0) {
            this.position.set(0, this.position.y);
            this.velocity.scaleX(-1);
        }
        if (this.position.x > 800 -30) {
            this.position.set(800 -30, this.position.y);
            this.velocity.scaleX(-1);
        }

        if (this.position.y < 0) {
            this.position.set(this.position.x, 0);
            this.velocity.scaleY(-1);
        }

        if (this.position.y > 600) {
            this.destroy();
        }
    }
}
