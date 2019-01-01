package Game.Scene;


import Game.FrameCounter;
import Game.GameObject;
import Game.GameWindow;
import Game.Renderer.SingleimageRenderer;
import Game.Setting;
import tklibs.SpriteUtils;

public class BackgroundWelcomeScene extends GameObject {
    FrameCounter idleCounter;
    public BackgroundWelcomeScene() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/background/press_key_paint.png"));
        this.position.set(Setting.SCREEN_WIDTH / 2, Setting.SCREEN_HEIGHT / 2);
        this.idleCounter = new FrameCounter(30);
        GameObject.botLayer.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (this.idleCounter.count() && GameWindow.isAnyKeyPress) {
            Scene.signNewScene(new SceneStage1());
        }
    }
}
