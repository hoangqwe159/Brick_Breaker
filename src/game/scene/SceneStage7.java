package game.scene;

import game.GameObject;

public class SceneStage7 extends Scene {
    @Override
    public void init() {

    }

    @Override
    public void clear() {
//        GameObject.clearAll();
        Scene.signNewScene(new SceneStage8());
    }

    @Override
    public void checkBrickLeft() {

    }
}
