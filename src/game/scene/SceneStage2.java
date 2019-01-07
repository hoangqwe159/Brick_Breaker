package game.scene;

import game.GameObject;
import game.maps.Map;

public class SceneStage2 extends Scene {
    @Override
    public void init() {
        this.nextStage = new SceneStage2();
        this.rocketLeft = Integer.MAX_VALUE;
        Map map = Map.load("assets/map/brick_level_10.json");
        map.generate();
    }

    @Override
    public void clear() {
//        GameObject.clearAll();
    }
}
