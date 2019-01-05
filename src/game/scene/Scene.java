package game.scene;

public abstract class Scene {
    //static
    public static Scene currentScene;
    public static int score;
    public static int lives;

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
