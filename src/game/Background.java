package game;

import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;
import tklibs.Vector2D;

import java.awt.image.BufferedImage;

public class Background extends GameObject {

    public Background() {
        super(); //this.position = new tklibs.Vector2D();
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/background.png");
        this.renderer = new SingleimageRenderer(image);
        this.position = new Vector2D(0, 0);
        this.velocity.set(0, 0);
        this.anchor.set(0,0);
        GameObject.botLayer.add(this);
    }
    @Override
    public void run(){
    }
}
