package game;
import java.awt.*;
import java.util.ArrayList;

import game.ball.Ball;
import game.physics.BoxCollider;
import game.physics.Physics;

import game.renderer.Renderer;
import tklibs.Vector2D;


public class GameObject {

    public Vector2D size;

    //static quan li
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> topLayer = new ArrayList<>();
    public static ArrayList<GameObject> midLayer = new ArrayList<>();
    public static ArrayList<GameObject> botLayer = new ArrayList<>();

    // E co the la moi thu
    // Nhung muon e ke thua game object
    public static <E extends GameObject> E findIntercepts(Class<E> clazz, BoxCollider boxCollider) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            // object instanced clazz
            //object instanced physics
            //object active
            //
            if (object.active
                    && clazz.isAssignableFrom(object.getClass())
                    && object instanceof Physics
                    && ((Physics)object).getBoxCollider().isColliding(boxCollider)) {
                return (E)object;
            }
        }
        return null;
    }

    public static <E extends GameObject> E findInactive(Class<E> clazz) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject object = gameObjects.get(i);
            if (!object.active
            && clazz.isAssignableFrom(object.getClass())) {
                return (E) object;
            }
        }
        return null;
    }

    public static <E extends  GameObject> E recycleGameObject(Class<E> clazz) { //paddle.class, E = paddle
        //find inactive if true => return
        //else create
        E inactiveGameObject = findInactive(clazz);
        if (inactiveGameObject != null) {
            inactiveGameObject.reset();
            return inactiveGameObject;
        }
        try {
            E gameObject = clazz.newInstance(); //new E()
            gameObjects.add(gameObject);
            return gameObject;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void clearAll() {
        gameObjects.clear();
        topLayer.clear();
        midLayer.clear();
        botLayer.clear();
    }
    public static void runAll() {
        System.out.println(gameObjects.size());
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.active) {
                gameObject.run();
            }
        }
//        System.out.println(gameObjects.size());

    }

    public static void renderAll(Graphics g) {
        for (int i = 0; i <botLayer.size(); i++) {
            GameObject gameObject = botLayer.get(i);
            if (gameObject.active) {
                gameObject.render(g);
            }
        }
        for (int i = 0; i <midLayer.size(); i++) {
            GameObject gameObject = midLayer.get(i);
            if (gameObject.active) {
                gameObject.render(g);
            }
        }
        for (int i = 0; i <topLayer.size(); i++) {
            GameObject gameObject = topLayer.get(i);
            if (gameObject.active) {
                gameObject.render(g);
            }
        }
    }

    //thuoc tinh;
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D oldVelocity;
    public Vector2D acceleration;
    public Renderer renderer;
    public boolean active;
    public Vector2D anchor;

    //ham tao
    public GameObject() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.oldVelocity = new Vector2D();
        this.acceleration = new Vector2D();
        this.active = true;
        this.anchor = new Vector2D(0.5f , 0.5f);
    }

    public static int countBall() {
        int count = 0;
        for (int i = 0; i < GameObject.gameObjects.size(); i++){
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.active && gameObject instanceof Ball) {
                count += 1;
            }
        }
        return count;
    }

    public static boolean noBallLeft() {
        return GameObject.countBall() == 0;
    }

    public static <E extends GameObject> E resolveCollision(Class<E> clazz, BoxCollider boxCollider) {
        return GameObject.resolveCollision(clazz, boxCollider, false, true);
    }

    public static <E extends GameObject> E resolveCollision(Class<E> clazz, BoxCollider boxCollider, boolean destroy) {
        return GameObject.resolveCollision(clazz, boxCollider, destroy, true);
    }

    public static <E extends GameObject> E resolveCollision(Class<E> clazz, BoxCollider boxCollider, boolean destroy, boolean trigger) {
        E object = GameObject.findIntercepts(clazz, boxCollider);
        if (object != null) {
            ((Physics) object).getBoxCollider().resolveCollision(boxCollider);
            if (destroy) {
                object.destroy();
            }
            if (trigger) {
                object.triggerSpecialEffectWhenHit();
            }
        }
        return object;
    }

    public void run() {
        this.updatePosition();
    }

    private void updatePosition() {
        this.updateVelocity();
        this.position.addThis(this.velocity.clone().addThis(this.oldVelocity).scaleThis(0.5f));
    }

    private void updateVelocity() {
        this.oldVelocity = this.velocity;
        this.velocity.addThis(this.acceleration);
    }

    public void render (Graphics g){
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

    public void limitGameObjectPosition() {
        if (this.position.x < 0) {
            this.position.set(0, this.position.y);
        }
        else if (this.position.x > Setting.SCREEN_WIDTH - this.renderer.getCurrentImageSize().x) {
            this.position.set(Setting.SCREEN_WIDTH - this.renderer.getCurrentImageSize().x, this.position.y);
        }

        if (this.position.y < 0) {
            this.position.set(this.position.x, 0);
        }

        else if (this.position.y > Setting.SCREEN_HEIGHT - this.renderer.getCurrentImageSize().y) {
            this.position.set(this.position.x, Setting.SCREEN_HEIGHT - this.renderer.getCurrentImageSize().y);
        }
    }

    public void triggerSpecialEffectWhenHit() {
    }

    public void destroy() {
        this.active = false;
        this.velocity.set(0, 0);
    }
    //TODO
    //reset phai tac dong len position, velocity,...
    public void reset() {
        this.active = true;
    }
}

//Phan biet type vc Class
//Generic

//HCN (position, width height)
// BTVN tim diem giao
// Truu tuong trong Java abstract, interface, implement
// Abstract level (Google)
// Recycle GmaeObject
// Loi nhung con ko active trong list Gameobject duoc loi ra dung lai
//(Recycle => tao moi duoc gioi han) vs (Delete + Tao moi lai)
//Object pooling
