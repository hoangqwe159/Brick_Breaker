package Game.Enemy;

import Game.GameObject;

public class EnemySummoner extends GameObject{
    EnemyType1 enemy1;
    public EnemySummoner(int x, int y) {
        this.summonType1(x, y);
    }
    public void summonType1(int x, int y) {
        enemy1 = GameObject.recycleGameObject(EnemyType1.class);
        enemy1.position.set(x, y);
    }
}
