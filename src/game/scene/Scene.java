package game.scene;

import game.Background;
import game.GameObject;
import game.ball.BallType1;
import game.menu.BackgroundMenu;
import game.menu.LivesMenu;
import game.menu.RocketMenu;
import game.menu.ScoreMenu;
import game.paddle.Paddle;
import game.particle.ParticleExplosion;
import tklibs.Vector2D;

public abstract class Scene {
    //static
    public static Scene currentScene;
    public static int score;
    public static int lives = 9999;
    public Scene nextStage;
    public int rocketLeft;
    public boolean ready = false;

    public Scene() {
        GameObject.recycleGameObject(Background.class);
        Paddle paddle = GameObject.recycleGameObject(Paddle.class);
        GameObject.recycleGameObject(BackgroundMenu.class);
        GameObject.recycleGameObject(ScoreMenu.class);
        BallType1 newBall = GameObject.recycleGameObject(BallType1.class);
        newBall.position.set(paddle.position.clone().addX(-paddle.renderer.getCurrentImageSize().clone().scaleThis(0.5f).x).subtractThis(newBall.renderer.getCurrentImageSize().x / 2, newBall.renderer.getCurrentImageSize().y));
        newBall.velocity.set(0, 0);
        BallType1.ballIsReset = true;
        GameObject.recycleGameObject(LivesMenu.class);
        GameObject.recycleGameObject(RocketMenu.class);
        ParticleExplosion.generateParticle(500, new Vector2D(0, 0), false);
    }

    public static void signNewScene(Scene newScene) {
        if (currentScene != null) {
            currentScene.clear();
        }
        newScene.init();
        currentScene = newScene;
    }
    //phuong thuc
    public abstract void init();

    public abstract void clear();

    public void checkBrickLeft() {
        if (GameObject.countBrick() == 0) {
            GameObject.clearAll();
//            BackgroundProgress loadingScreen = GameObject.recycleGameObject(BackgroundProgress.class);
//            loadingScreen.currentScene = this.nextStage;
            Scene.signNewScene(this.nextStage);
        }
    }
}
