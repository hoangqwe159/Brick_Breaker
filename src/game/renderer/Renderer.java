package game.renderer;

import game.GameObject;
import tklibs.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public abstract class Renderer {
    public ArrayList<Vector2D> sizes;

    public abstract void render(Graphics g, GameObject master);

    public Vector2D getCurrentImageSize() {
        return null;
    }

    public void reset() {
    }
}
