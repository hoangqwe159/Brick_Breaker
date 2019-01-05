package game.scene;

import game.Background;


import game.ball.BallType1;
import game.maps.Map;
import game.power.Rocket;
import game.brick.AbilityBrickType4;
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
        SceneStage1.rocketLeft = 0;
        GameObject.recycleGameObject(Background.class);
        GameObject.recycleGameObject(Paddle.class);
        GameObject.recycleGameObject(BackgroundMenu.class);
        GameObject.recycleGameObject(ScoreMenu.class);
        GameObject.recycleGameObject(BallType1.class);
        GameObject.recycleGameObject(AbilityBrickType4.class);
        GameObject.recycleGameObject(Rocket.class);
//        BrickSummoner.summonType1(100 + 80 * 1 , 100 + 40 * 1);
//        BrickSummoner.summonType2(100 + 80 * 2 , 100 + 40 * 1);
        //       BrickSummoner.summonType3(0 , 100 + 40 * 1);
        Map map = Map.load("assets/map/brick_level_2.json");
        map.generate();


//        for (int i = 0; i < 8; i++) {
//            for (int k = 1; k < 3; k++) {
//                BrickSummoner.summonType1(100 + 80 * i , 100 + 40 * k);
//            }
//        }
//
//        for (int i = 0; i < 8; i++) {
//            BrickSummoner.summonType2(100 + 80 * i , 100 + 40 * 3);
//        }
//
//        for (int i = 0; i < 8; i++) {
//            BrickSummoner.summonType3(100 + 80 * i , 100);
//        }




//        this.count++;
//        if (this.count > 100) {
//            new BrickSummoner();
//            this.count = 0;
//        }
//        GameObject.recycleGameObject(BackgroundMenu.class);
//        GameObject.recycleGameObject(ScoreMenu.class);
//        this.music = AudioUtils.loadSound("assets/music/1.wav");

//
//        FloatControl musicControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);// lay ra cai control
//        musicControl.setValue(-10);
//
//        AudioUtils.replay(this.music);

    }

//        BrickType1 enemy1 =  GameObject.recycleGameObject(BrickType1.class);
//        enemy1.position.set(300, 200);


    @Override
    public void clear() {
        GameObject.clearAll();
        Scene.score = 0;

    }
}
