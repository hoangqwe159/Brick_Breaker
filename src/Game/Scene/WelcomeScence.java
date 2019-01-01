package Game.Scene;

import Game.GameObject;

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
