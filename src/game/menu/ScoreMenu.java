package game.menu;

import game.GameObject;
import game.renderer.TextRenderer;
import game.scene.Scene;
import game.Setting;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreMenu extends GameObject {
    TextRenderer scoreRenderer;
    BufferedImage enemyImage;
    public ScoreMenu() {
        this.scoreRenderer = new TextRenderer(Scene.score + ""
                , Color.white
                , Setting.FONT_LG);
        this.renderer = this.scoreRenderer;
        this.position.set(200, 50);
        GameObject.midLayer.add(this);
        this.enemyImage = SpriteUtils.loadImage("assets/images/background/score.png");
    }

    @Override
    public void run() {
        super.run();
        this.scoreRenderer.text = Scene.score + "";
    }

    @Override
    public void render(Graphics g) {
        super.render(g); //this.renderer.render() ve drawString
        g.drawImage(this.enemyImage, (int) this.position.x - 150 , (int) this.position.y - 35, null);
    }
}
