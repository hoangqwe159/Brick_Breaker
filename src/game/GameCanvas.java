package game;


import game.scene.Scene;
import game.scene.WelcomeScene;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    public GameCanvas() {

        Scene.signNewScene(new WelcomeScene());

    }

    public void run() {
        long lastTime = 0;
        long delay = 1000 / 60;

        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay) {
                GameObject.runAll();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
    int count = 0;
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,Setting.SCREEN_WIDTH,Setting.SCREEN_HEIGHT);

        GameObject.renderAll(g);

    }
}
