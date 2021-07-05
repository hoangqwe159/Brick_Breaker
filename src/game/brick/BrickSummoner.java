package game.brick;

import game.GameObject;

public class BrickSummoner extends GameObject{
    public BrickSummoner() {
    }
    public static void summonType0_1(int x, int y) {
        GameObject.recycleGameObject(BrickType0_1.class).position.set(x, y);
    }
    public static void summonType0_2(int x, int y) {
        GameObject.recycleGameObject(BrickType0_2.class).position.set(x, y);
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
    public static void summonType4(int x, int y) {
        GameObject.recycleGameObject(BrickType4.class).position.set(x, y);
    }
    public static void summonType5_1(int x, int y) {
        GameObject.recycleGameObject(BrickType5_1.class).position.set(x, y);
    }
    public static void summonType5_2(int x, int y) {
        GameObject.recycleGameObject(BrickType5_2.class).position.set(x, y);
    }
    public static void summonType6(int x, int y) {
        GameObject.recycleGameObject(BrickType6.class).position.set(x, y);
    }
    public static void summonType7_1(int x, int y) {
        GameObject.recycleGameObject(BrickType7_1.class).position.set(x, y);
    }
    public static void summonType7_2(int x, int y) {
        GameObject.recycleGameObject(BrickType7_2.class).position.set(x, y);
    }
    public static void summonType8(int x, int y) {
        GameObject.recycleGameObject(BrickType8.class).position.set(x, y);
    }
    public static void summonType9_1(int x, int y) {
        GameObject.recycleGameObject(BrickType9_1.class).position.set(x, y);
    }
    public static void summonType9_2(int x, int y) {
        GameObject.recycleGameObject(BrickType9_2.class).position.set(x, y);
    }
}
