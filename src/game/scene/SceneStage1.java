package game.scene;

import game.Background;


import game.ball.BallType1;
import game.brick.AbilityBrickType5_1;
import game.brick.BrickSummoner;
import game.GameObject;

import game.explosion.Particle;
import game.menu.BackgroundMenu;
import game.menu.LivesMenu;
import game.menu.RocketMenu;
import game.menu.ScoreMenu;
import game.paddle.Paddle;
import tklibs.Vector2D;

import javax.sound.sampled.Clip;


public class SceneStage1 extends Scene {
    public static int rocketLeft;
    int count = 0;
    Clip music;

    @Override
    public void init() {
        SceneStage1.rocketLeft = 0;
        GameObject.recycleGameObject(Background.class);
        GameObject.recycleGameObject(Paddle.class);
        GameObject.recycleGameObject(BackgroundMenu.class);
        GameObject.recycleGameObject(ScoreMenu.class);
        GameObject.recycleGameObject(BallType1.class);
        GameObject.recycleGameObject(LivesMenu.class);
        GameObject.recycleGameObject(RocketMenu.class);
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
            BrickSummoner.summonType9_1(100 + 40 * i , 520);
            BrickSummoner.summonType9_2(100 + 40 * i , 560);
        }
        BrickSummoner.summonType3(100 + 40 * 4 , 200);
//        Map map = Map.load("assets/map/brick_level_2.json");
//        map.generate();
    }

    @Override
    public void clear() {
        GameObject.clearAll();
//        Scene.signNewScene(new SceneStage2());
    }
}
