package game.scene;

import game.GameObject;

public class SceneStage5 extends Scene {
    @Override
    public void init() {

    }

    @Override
    public void clear() {
        GameObject.clearAll();
        Scene.signNewScene(new SceneStage6());
    }
}
