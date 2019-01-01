package Game.Ball;

import Game.GameObject;
import Game.Physics.BoxCollider;
import Game.Physics.Physics;

public abstract class Ball extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public Ball() {
        this.createRenderer();
        this.createBoxCollider();
    }

    public abstract void createBoxCollider();

    public abstract void createRenderer();

   // public abstract void hitEnemy();

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
