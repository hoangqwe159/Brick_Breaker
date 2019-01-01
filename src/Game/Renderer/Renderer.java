package Game.Renderer;

import Game.GameObject;
import Game.GameWindow;

import java.awt.*;

public abstract class Renderer {
    public abstract void render(Graphics g, GameObject master);

    public void reset() {

    }
}
