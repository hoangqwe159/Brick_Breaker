package game.scene;

import game.GameObject;

public class WelcomeScence extends Scene {
    @Override
    public void init() {
        GameObject.recycleGameObject(BackgroundWelcomeScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
