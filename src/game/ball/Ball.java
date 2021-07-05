package game.ball;

import game.GameObject;
import game.Setting;
import game.paddle.Paddle;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.scene.GameOverScene;
import game.scene.Scene;
import tklibs.Vector2D;

import java.util.ArrayList;

public abstract class Ball extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public int maxVelocity;
    public int minVelocity;
    public float thresholdVelocity;

    public Ball() {
        this.maxVelocity = 10;
        this.minVelocity = 4;
        this.createRenderer();
        this.createBoxCollider();
    }

    public abstract void createBoxCollider();

    public abstract void createRenderer();

   // public abstract void hitEnemy();

    @Override
    public void limitVelocity() {
        float currentVelocity = this.velocity.getLength();
        if (currentVelocity > this.maxVelocity) {
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
                } else {
                    this.velocity.setX(2f * this.maxVelocity);
                }
            }
            this.velocity.setLength(this.maxVelocity);
        }
        else if (currentVelocity < this.minVelocity) {
            this.velocity.setLength(this.minVelocity);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }

    @Override
    public void destroy() {
        this.active = false;
        this.renderer.images = new ArrayList<>(this.renderer.originalImages);
        this.renderer.sizes.clear();
        for (int i = 0; i < this.renderer.images.size(); i++) {
            this.renderer.sizes.add(new Vector2D(this.renderer.images.get(i).getWidth(), this.renderer.images.get(i).getHeight()));
        }
        Ball.resetBall();
    }

    @Override
    public void limitGameObjectPosition() {
        if (this.position.x < 0) {
            this.position.set(0, this.position.y);
            this.velocity.scaleX(-1);
        }
        else if (this.position.x > Setting.SCREEN_WIDTH - this.renderer.getCurrentImageSize().x) {
            this.position.set(Setting.SCREEN_WIDTH - this.renderer.getCurrentImageSize().x, this.position.y);
            this.velocity.scaleX(-1);
        }

        if (this.position.y < 0) {
            this.position.set(this.position.x, 0);
            this.velocity.scaleY(-1);
        }

        else if (this.position.y > Setting.SCREEN_HEIGHT) {
            this.destroy();
        }
    }

    public static void resetBall() {
        if (GameObject.countBall() == 0) {
            if (Scene.lives > 0) {
                Scene.lives -= 1;
            }
            if (Scene.lives == 0) {
                Scene.signNewScene(new GameOverScene());
            }
            else {
                Paddle paddle = Paddle.getPaddle();
                BallType1 newBall = GameObject.recycleGameObject(BallType1.class);
                newBall.position.set(paddle.position.clone().addX(paddle.renderer.getCurrentImageSize().clone().scaleThis(0.5f).x).subtractThis(newBall.renderer.getCurrentImageSize().x / 2, newBall.renderer.getCurrentImageSize().y));
                newBall.velocity.set(0, 0);
                BallType1.ballIsReset = true;
            }
        }
    }
}
