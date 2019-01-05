package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class AbilityBrickType4 extends AbilityBrick {

    public AbilityBrickType4() {
        this.position.set(400, 400);
        this.velocity.set(0, 10);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/Backup/powerup/0.png"));
    }
}
