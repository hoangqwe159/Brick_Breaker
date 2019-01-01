package Game.Scene;

import Game.GameObject;

public class GameOverScene extends Scene{
    @Override
    public void init() {
        GameObject.recycleGameObject(BackgroundGameOVerScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
