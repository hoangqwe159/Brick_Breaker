package game.brick;


import game.FrameCounter;
import game.GameObject;

import game.physics.BoxCollider;
import game.physics.Physics;
import game.scene.Scene;


public abstract class Brick extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;
    public Brick() {
        super();
        this.anchor.set(0, 0);
        this.createRenderer();
        this.fireCounter = new FrameCounter(20);
        this.createBoxCollider();
        GameObject.midLayer.add(this);

    }

    public abstract void createBoxCollider();

    public abstract void createRenderer();


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
        BrickDestroy explosion = GameObject.recycleGameObject(BrickDestroy.class);
        explosion.position.set(this.position.clone().addThis(this.renderer.getCurrentImageSize().scaleThis(0.5f)));
        Scene.score += 50;
    }
}
