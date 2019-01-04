package game.power;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;

public class PowerBall extends GameObject implements Physics {
    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }
}
