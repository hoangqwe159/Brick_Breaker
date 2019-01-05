package game.paddle;

import game.*;
import game.brick.AbilityBrickType4;
import game.brick.AbilityBrickType5;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.power.Rocket;
import game.renderer.SingleimageRenderer;
import game.scene.GameOverScene;
import game.scene.Scene;
import tklibs.SpriteUtils;

public class Paddle extends GameObject implements Physics {

    BoxCollider boxCollider;
    FrameCounter fireCounter;

    public Paddle() {
        // game.paddle.paddle.playerName; // co the goi y het ben canvas
        super();
        this.fireCounter = new FrameCounter(60);
        this.createRenderer();
        this.position.set(Setting.PADDLE_START_POSITION_X, Setting.PADDLE_START_POSITION_Y);
        this.anchor.set(0f,0f);
        this.createBoxCollider();
        GameObject.midLayer.add(this);
    }

    private void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/paddle/0.png"));
    }

    public void fire() {
        if (this.fireCounter.count()) {
            if (GameWindow.isFirePress) {
                GameObject.recycleGameObject(Rocket.class).position.set(this.position.clone().addThis(this.renderer.getCurrentImageSize().clone().scaleThis(0.5f)));
                this.fireCounter.reset();
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
        GameObject.resolveCollision(AbilityBrickType4.class, this.getBoxCollider(), true);
        GameObject.resolveCollision(AbilityBrickType5.class, this.getBoxCollider(), true);
    }

    private void move() {
        this.velocity.set(0, 0);

        if (GameWindow.isLeftPress) {
            this.velocity.addThis(Setting.PADDLE_VECLOCITY_LEFT);
        }
        if (GameWindow.isRightPress) {
            this.velocity.addThis(Setting.PADDLE_VECLOCITY_RIGHT);
        }
        this.velocity.setLength(Setting.PADDLE_VECLOCITY_DOWN.y);
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