package game.scene;

import game.GameObject;

public class SceneStage3 extends Scene {
    @Override
    public void init() {

    }

    @Override
    public void clear() {
//        GameObject.clearAll();
        Scene.signNewScene(new SceneStage4());
    }

    @Override
    public void checkBrickLeft() {

    }
}
