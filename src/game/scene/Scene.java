package game.scene;

import game.Background;
import game.GameObject;
import game.ball.BallType1;
import game.menu.BackgroundMenu;
import game.menu.LivesMenu;
import game.menu.RocketMenu;
import game.menu.ScoreMenu;
import game.paddle.Paddle;

public abstract class Scene {
    //static
    public static Scene currentScene;
    public static int score;
    public static int lives = 2;

    public static void signNewScene(Scene newScene) {
        if (currentScene != null)
            currentScene.clear();
        newScene.init();
        currentScene = newScene;
    }
    //phuong thuc
    public abstract void init();

    public abstract void clear();
}
