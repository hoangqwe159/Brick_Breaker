package game.renderer;

import game.GameObject;
import tklibs.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SingleimageRenderer extends Renderer {
    BufferedImage image;

    public SingleimageRenderer(BufferedImage image) {
        this.image = image;
        this.sizes = new ArrayList<>();
        this.sizes.add(new Vector2D(image.getWidth(), image.getHeight()));
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image
                , (int) (master.position.x - this.image.getWidth() * master.anchor.x)
                , (int) (master.position.y - this.image.getHeight() * master.anchor.y)
                , null);
    }

    @Override
    public Vector2D getCurrentImageSize() {
        return this.sizes.get(0);
    }
}
