package game.brick;

import game.GameObject;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BrickType6 extends Brick {
    public int counter = 0;
    public BrickType6() {
        this.velocity.set(0,0);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, Float.POSITIVE_INFINITY);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/6/6_0.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
      this.counter++;
      if (this .counter == 1) {
          this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/enemy/6/6_1.png"));
      }

      else if (this.counter == 2) {
          this.destroy();
          this.counter = 0;
      }

    }
}

