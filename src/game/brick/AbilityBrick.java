package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;

public abstract class AbilityBrick extends GameObject implements Physics {
    BoxCollider boxCollider;
    public AbilityBrick() {
        super();
        this.anchor.set(0,0);
        this.createRenderer();
        this.createBoxCollider();
        GameObject.midLayer.add(this);
    }

    public abstract void createBoxCollider();

    public abstract void createRenderer();

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }
}
