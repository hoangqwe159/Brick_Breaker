package game.brick;

import game.GameObject;

public class BrickSummoner extends GameObject{
    public BrickSummoner() {
    }
    public static void summonType1(int x, int y) {
        GameObject.recycleGameObject(BrickType1.class).position.set(x, y);
    }

    public static void summonType2(int x, int y) {
        GameObject.recycleGameObject(BrickType2.class).position.set(x, y);
    }
    public static void summonType3(int x, int y) {
        GameObject.recycleGameObject(BrickType3.class).position.set(x, y);
    }
}
