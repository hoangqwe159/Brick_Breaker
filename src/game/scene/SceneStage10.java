package game.scene;

import game.GameObject;

public class SceneStage10 extends Scene {
    @Override
    public void init() {

    }

    @Override
    public void clear() {
//        GameObject.clearAll();
        Scene.signNewScene(new GameOverScene());
    }

    @Override
    public void checkBrickLeft() {

    }
}
