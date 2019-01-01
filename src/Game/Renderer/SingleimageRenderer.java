package Game.Renderer;

import Game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SingleimageRenderer extends Renderer {
    BufferedImage image;

    public SingleimageRenderer(BufferedImage image) {
        this.image = image;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image
                , (int) (master.position.x - this.image.getWidth() * master.anchor.x)
                , (int) (master.position.y - this.image.getHeight() * master.anchor.y)
                , null );
    }
}
