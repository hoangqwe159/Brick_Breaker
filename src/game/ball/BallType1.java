package game.ball;

import game.GameWindow;
import game.brick.*;
import game.GameObject;
import game.physics.BoxCollider;
import game.paddle.Paddle;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

import java.util.Random;


public class BallType1 extends Ball {
    public static boolean ballIsReset;

    public BallType1() {
        this.thresholdVelocity = 0.1f;
        this.position.set(360, 400);
        this.velocity.set(3 , -5);
        this.anchor.set(0, 0);
        GameObject.midLayer.add(this);
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
        this.launchNewBall();

        GameObject.resolveCollision(Paddle.class, this.getBoxCollider(), false, false, true);
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
                for (int i = 0; i < GameObject.gameObjects.size(); i++){
                    GameObject gameObject = GameObject.gameObjects.get(i);
                    if (gameObject.active && gameObject instanceof Ball) {
                        gameObject.velocity.set(0, -5).addThis(Paddle.getPaddle().velocity).addX(new Random().nextFloat());
                    }
                }
            }
            else {
                Paddle paddle = Paddle.getPaddle();
                this.position.set(paddle.position.clone().addX(paddle.renderer.getCurrentImageSize().x / 2).subtractThis(this.renderer.getCurrentImageSize().x / 2, this.renderer.getCurrentImageSize().y));
            }
        }
    }
}
