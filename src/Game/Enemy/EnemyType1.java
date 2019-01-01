package Game.Enemy;

import Game.Ball.Ball;
import Game.GameObject;
import Game.Physics.BoxCollider;
import Game.Renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class EnemyType1 extends Enemy {
    public EnemyType1() {
        this.velocity.set(0,0);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, 80, 40);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/0.png"));
    }

    @Override
    public void run() {
        super.run();
//        Ball ball = GameObject.findIntercepts(Ball.class, this.boxCollider);

    }
}
