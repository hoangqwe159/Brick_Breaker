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
        this.position.set(300, 50);
        GameObject.midLayer.add(this);
        this.lifeImage = SpriteUtils.loadImage("assets/images/background/lives.png");
    }

    @Override
    public void run() {
        super.run();
        this.livesRenderer.text = Scene.lives + "";
    }

    @Override
    public void render(Graphics g) {
        super.render(g); //this.renderer.render() ve drawString
        g.drawImage(this.lifeImage, (int) this.position.x - 20 , (int) this.position.y -15, null);
    }
}
