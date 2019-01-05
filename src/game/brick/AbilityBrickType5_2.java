package game.brick;

import game.GameObject;
import game.ball.Ball;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.ImageProcessing;
import tklibs.SpriteUtils;
import tklibs.Vector2D;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AbilityBrickType5_2 extends AbilityBrick {

    public AbilityBrickType5_2() {
        this.velocity.setY(10);
        GameObject.midLayer.add(this);
    }

    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/Backup/powerup/0.png"));
    }

    @Override
    public void triggerSpecialEffectWhenHit() {
        this.position.set(0, 0);
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Ball) {
                ArrayList<Vector2D> clonedSizes = new ArrayList<>(gameObject.renderer.sizes);
                gameObject.renderer.images.clear();
                gameObject.renderer.sizes.clear();
                for (int j = 0; j < gameObject.renderer.originalImages.size(); j++) {
                    gameObject.renderer.images.add(ImageProcessing.scaleImage(gameObject.renderer.originalImages.get(j), (int)(0.7 * clonedSizes.get(j).x), (int)(0.7 * clonedSizes.get(j).y)));
                    gameObject.renderer.sizes.add(new Vector2D(gameObject.renderer.images.get(j).getWidth(), gameObject.renderer.images.get(j).getHeight()));
                }
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        this.velocity.setY(10);
    }
}
