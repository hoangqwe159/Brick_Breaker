package game.brick;

import game.GameObject;
import game.paddle.Paddle;
import game.physics.BoxCollider;
import game.renderer.SingleimageRenderer;
import tklibs.ImageProcessing;
import tklibs.SpriteUtils;
import tklibs.Vector2D;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class AbilityBrickType7_2 extends AbilityBrick {

    public AbilityBrickType7_2() {
        GameObject.midLayer.add(this);
        this.position.set(200, 0);
        this.velocity.set(0, 10);
    }
    @Override
    public void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ability/ab7.png"));
    }
    @Override
    public void triggerSpecialEffectWhenHit() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Paddle) {
                ArrayList<Vector2D> clonedSizes = new ArrayList<>(gameObject.renderer.sizes);
                gameObject.renderer.images.clear();
                gameObject.renderer.sizes.clear();
                for (int j = 0; j < gameObject.renderer.originalImages.size(); j++) {
                    gameObject.renderer.images.add(ImageProcessing.scaleImage(gameObject.renderer.originalImages.get(j), (int)(0.7 * clonedSizes.get(j).x), (int)clonedSizes.get(j).y));
                    gameObject.renderer.sizes.add(new Vector2D(gameObject.renderer.images.get(j).getWidth(), gameObject.renderer.images.get(j).getHeight()));
                }
            }
        }
    }
}


