package Game.Menu;

import Game.GameObject;

import java.awt.*;

public class BackgroundMenu extends GameObject {
    public BackgroundMenu () {
        this.position.set(0, 0);
        GameObject.midLayer.add(this);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect((int) this.position.x , (int) this.position.y, 800 , 100);
    }
}
