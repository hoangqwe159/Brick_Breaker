package game.menu;

import game.GameObject;
import game.renderer.TextRenderer;
import game.scene.Scene;
import game.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LivesMenu extends GameObject {
    TextRenderer livesRenderer;
    BufferedImage lifeImage;
    public LivesMenu() {
        this.livesRenderer = new TextRenderer(Scene.lives + ""
                , Color.white
                , Setting.FONT_LG);
        this.renderer = this.livesRenderer;
        this.position.set(500, 50);
        GameObject.midLayer.add(this);
        this.lifeImage = SpriteUtils.loadImage("assets/images/background/score.png");
    }

    @Override
    public void run() {
        super.run();
        this.livesRenderer.text = Scene.score + "";
    }

    @Override
    public void render(Graphics g) {
        super.render(g); //this.renderer.render() ve drawString
        g.drawImage(this.lifeImage, (int) this.position.x - 150 , (int) this.position.y - 35, null);
    }
}
