package game.renderer;

import game.GameObject;
import tklibs.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SingleimageRenderer extends Renderer {

    public SingleimageRenderer(BufferedImage image) {
        this.originalImages = new ArrayList<>();
        this.images = new ArrayList<>();
        this.originalImages.add(image);
        this.images.add(image);
        this.sizes = new ArrayList<>();
        this.sizes.add(new Vector2D(image.getWidth(), image.getHeight()));
        this.currentImageIndex = 0;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.images.get(0)
                , (int) (master.position.x - this.images.get(0).getWidth() * master.anchor.x)
                , (int) (master.position.y - this.images.get(0).getHeight() * master.anchor.y)
                , null);
    }

    @Override
    public Vector2D getCurrentImageSize() {
        return this.sizes.get(0);
    }
}
