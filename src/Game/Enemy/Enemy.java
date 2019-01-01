package Game.Enemy;


import Game.FrameCounter;
import Game.GameObject;

import Game.Menu.ScoreMenu;
import Game.Physics.BoxCollider;
import Game.Physics.Physics;
import Game.Scene.Scene;


public abstract class Enemy extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider boxCollider;
    public Enemy () {
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
        return boxCollider;
    }

    @Override
    public void destroy() {
        super.destroy();
        EnemyExplosion explosion = GameObject.recycleGameObject(EnemyExplosion.class);
        explosion.position.set(this.position);
        Scene.score += 50;
    }
}
