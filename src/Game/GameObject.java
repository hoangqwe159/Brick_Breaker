package Game;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Physics.BoxCollider;
import Game.Physics.Physics;

import Game.Renderer.Renderer;
import tklibs.Vector2D;


public class GameObject {
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
            //object instanced Physics
            //object active
            //
            if (object.active
                    && clazz.isAssignableFrom(object.getClass())
                    && object  instanceof Physics
                    && ((Physics)object).getBoxCollider().intersects(boxCollider)) {
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

    public static <E extends  GameObject> E recycleGameObject(Class<E> clazz) { //Player.class, E = Player
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
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.active) {
                gameObject.run();
            }
        }
        System.out.println(gameObjects.size());

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
    public Renderer renderer;
    public boolean active;
    public Vector2D anchor;

    //ham tao
    public GameObject() {

        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.active = true;
        this.anchor = new Vector2D(0.5f , 0.5f);
    }

    public void run() {
        this.position.addThis(this.velocity);
    }



    public void render (Graphics g){
        if (this.renderer != null) {
            this.renderer.render(g, this);
        }
    }

    public void destroy() {
        this.active = false;
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
