package Game.Scene;

import Game.Background;


import Game.Ball.BallType1;
import Game.Enemy.EnemySummoner;
import Game.GameObject;

import Game.Menu.BackgroundMenu;
import Game.Menu.ScoreMenu;
import Game.Player.Player;


import javax.sound.sampled.Clip;


public class SceneStage1 extends Scene {
    int count = 0;
    Clip music;
    EnemySummoner summon;
    @Override
    public void init() {
        GameObject.recycleGameObject(Background.class);
        GameObject.recycleGameObject(Player.class);
        GameObject.recycleGameObject(BackgroundMenu.class);
        GameObject.recycleGameObject(ScoreMenu.class);
        GameObject.recycleGameObject(BallType1.class);


        int i = 0;
        int k = 0;
        for (i = 0; i < 8; i++) {
            for (k = 0; k < 4; k++) {
                this.summon = new EnemySummoner(100 + 80 * i , 100 + 40 * k);
            }

        }




//        this.count++;
//        if (this.count > 100) {
//            new EnemySummoner();
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

//        EnemyType1 enemy1 =  GameObject.recycleGameObject(EnemyType1.class);
//        enemy1.position.set(300, 200);


    @Override
    public void clear() {
        GameObject.clearAll();
        Scene.score = 0;

    }
}
