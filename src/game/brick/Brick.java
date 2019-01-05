package game.brick;


import game.FrameCounter;
import game.GameObject;

import game.explosion.Particle;
import game.power.Rocket;
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
        this.hitRocket();
    }

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }

    public void hitRocket() {
        Rocket rocket = GameObject.findIntercepts(Rocket.class, this.getBoxCollider());
        if (rocket != null) {
            rocket.destroy();
            this.destroy();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
//        BrickDestroy explosion = GameObject.recycleGameObject(BrickDestroy.class);
//        explosion.position.set(this.position.clone().addThis(this.renderer.getCurrentImageSize().scaleThis(0.5f)));
        Scene.score += 50;
        Particle.generateParticle(100, this.position.clone().subtractThis(this.anchor.clone().scaleThis(this.renderer.getCurrentImageSize())));
    }

    public static void destroyAllBricks(BoxCollider boxCollider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (object.active
                    && object instanceof Brick
                    && ((Brick)object).getBoxCollider().isColliding(boxCollider)) {
                object.destroy();
            }
        }
    }
}
