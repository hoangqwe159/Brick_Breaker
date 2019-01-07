package game.paddle;

import game.*;
import game.brick.*;
import game.maps.Map;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.power.Rocket;
import game.renderer.SingleimageRenderer;
import game.scene.GameOverScene;
import game.scene.Scene;
import game.scene.SceneStage1;
import tklibs.SpriteUtils;

public class Paddle extends GameObject implements Physics {

    BoxCollider boxCollider;
    FrameCounter fireCounter;
    int maxVelocity;

    public Paddle() {
        // game.paddle.paddle.playerName; // co the goi y het ben canvas
        super();
        this.maxVelocity = 7;
        this.fireCounter = new FrameCounter(0);
        this.createRenderer();
        this.position.set(Setting.PADDLE_START_POSITION_X, Setting.PADDLE_START_POSITION_Y);
        this.anchor.set(0f,0f);
        this.createBoxCollider();
        GameObject.midLayer.add(this);
    }

    private void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/paddle/0.png"));
    }

    public static Paddle getPaddle() {
        for (int i = 0; i < GameObject.gameObjects.size(); i++){
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Paddle) {
                return (Paddle)gameObject;
            }
        }
        return null;
    }

    public void fire() {
        if (this.fireCounter.count()) {
            if (Scene.currentScene.rocketLeft > 0) {
                if (GameWindow.isFirePress) {
                    GameObject.recycleGameObject(Rocket.class).position.set(this.position.clone().addThis(this.renderer.getCurrentImageSize().clone().scaleThis(0.5f)));
                    Scene.currentScene.rocketLeft -= 1;
                    this.fireCounter.reset();
                }
            }
        }
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.fire();
        this.hitAb();
        this.limitGameObjectPosition();
    }
    //TODO continue editing

    public void hitAb() {
        GameObject.resolveCollision(AbilityBrickType0_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType0_2.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType3.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType4.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType5_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType5_2.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType7_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType7_2.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType8.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType9_1.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType9_2.class, this.getBoxCollider(), true);
    }

    private void move() {
        if (GameWindow.isLeftPress == GameWindow.isRightPress) {
            this.acceleration.set(0, 0);
            this.velocity.set(0, 0);
        }
        else {
            if (GameWindow.isLeftPress) {
                this.acceleration.set(Setting.PADDLE_VECLOCITY_LEFT);
            }
            if (GameWindow.isRightPress) {
                this.acceleration.set(Setting.PADDLE_VECLOCITY_RIGHT);
            }
//        this.velocity.setLength(Setting.PADDLE_VECLOCITY_DOWN.y);
        }
    }

    @Override
    public void limitVelocity() {
        if (this.velocity.getLength() > this.maxVelocity) {
            this.velocity.setLength(this.maxVelocity);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }

    private void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY, 0.99f, 0.1f);
    }

    @Override
    public void destroy() {
        super.destroy();
        Scene.signNewScene(new GameOverScene());
    }

}

//Gioi han di chuyen cho player
//Vector 2D: diem(x, y) vector (x, y)

// Polymorphisim
// override and overload

// Dong giooi ke thua da hinh
// BTVN
// Ban nhieu vien (nhieu huong)
// Ban nhieu loai doan
// Nang cap duong dan

// Setting