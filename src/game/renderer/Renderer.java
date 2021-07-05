package game.renderer;

import game.GameObject;
import tklibs.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Renderer {
    public int currentImageIndex;
    public ArrayList<BufferedImage> originalImages;
    public ArrayList<BufferedImage> images;
    public ArrayList<Vector2D> sizes;

    public abstract void render(Graphics g, GameObject master);

    public Vector2D getCurrentImageSize() {
        return null;
    }

    public void reset() {
    }
}
