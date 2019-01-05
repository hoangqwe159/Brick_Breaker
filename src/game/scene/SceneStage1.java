package game.scene;

import game.Background;


import game.ball.BallType1;
import game.brick.AbilityBrickType5_1;
import game.brick.BrickSummoner;
import game.GameObject;

import game.menu.BackgroundMenu;
import game.menu.ScoreMenu;
import game.paddle.Paddle;

import javax.sound.sampled.Clip;


public class SceneStage1 extends Scene {
    public static int rocketLeft;
    int count = 0;
    Clip music;

    @Override
    public void init() {
        Scene.lives = 2;
        SceneStage1.rocketLeft = 0;
        GameObject.recycleGameObject(Background.class);
        GameObject.recycleGameObject(Paddle.class);
        GameObject.recycleGameObject(BackgroundMenu.class);
        GameObject.recycleGameObject(ScoreMenu.class);
        GameObject.recycleGameObject(BallType1.class);
        for (int i = 0; i < 8; i++) {
            BrickSummoner.summonType0_1(100 + 40 * i, 40);
            BrickSummoner.summonType0_2(100 + 40 * i, 80);
            BrickSummoner.summonType1(100 + 40 * i , 120);
            BrickSummoner.summonType2(100 + 40 * i , 160);
            BrickSummoner.summonType4(100 + 40 * i , 240);
            BrickSummoner.summonType5_1(100 + 40 * i , 280);
            BrickSummoner.summonType5_2(100 + 40 * i , 320);
            BrickSummoner.summonType6(100 + 40 * i , 360);
            BrickSummoner.summonType7_1(100 + 40 * i , 400);
            BrickSummoner.summonType7_2(100 + 40 * i , 440);
            BrickSummoner.summonType8(100 + 40 * i , 480);
        }
        BrickSummoner.summonType3(100 + 40 * 4 , 200);
//        Map map = Map.load("assets/map/brick_level_2.json");
//        map.generate();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
        Scene.score = 0;
    }
}
