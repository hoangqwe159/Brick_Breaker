package game.menu;

import game.GameObject;
import game.renderer.TextRenderer;
import game.scene.Scene;
import game.Setting;
import game.scene.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RocketMenu extends GameObject {
    TextRenderer scoreRenderer;
    BufferedImage enemyImage;
    public RocketMenu() {
        this.scoreRenderer = new TextRenderer(Scene.currentScene.rocketLeft + ""
                , Color.white
                , Setting.FONT_LG);
        this.renderer = this.scoreRenderer;
        this.position.set(400, 50);
        GameObject.midLayer.add(this);
        this.enemyImage = SpriteUtils.loadImage("assets/images/Backup/rocket1.png");
    }

    @Override
    public void run() {
        super.run();
        this.scoreRenderer.text = Scene.currentScene.rocketLeft + "";
    }

    @Override
    public void render(Graphics g) {
        super.render(g); //this.renderer.render() ve drawString
        g.drawImage(this.enemyImage, (int) this.position.x - 30 , (int) this.position.y - 35, null);
    }
}
