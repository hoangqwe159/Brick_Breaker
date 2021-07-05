package game.scene;

import game.GameObject;

public class GameOverScene extends Scene{
    @Override
    public void init() {
        GameObject.recycleGameObject(BackgroundGameOverScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }

    @Override
    public void checkBrickLeft() {

    }
}
