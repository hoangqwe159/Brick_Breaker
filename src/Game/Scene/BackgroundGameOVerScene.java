package Game.Scene;

import Game.*;
import Game.Renderer.SingleimageRenderer;
import tklibs.SpriteUtils;

public class BackgroundGameOVerScene extends GameObject {
    FrameCounter idleCounter;
    public BackgroundGameOVerScene() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/background/game_over_paint.png"));
        this.position.set(Setting.SCREEN_WIDTH/2, Setting.SCREEN_HEIGHT/2);
        this.idleCounter = new FrameCounter(30);
        GameObject.botLayer.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (this.idleCounter.count() && GameWindow.isAnyKeyPress) {
            Scene.signNewScene(new WelcomeScence());
        }
    }
}
