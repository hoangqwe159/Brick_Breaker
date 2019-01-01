package Game.Physics;

import Game.GameObject;
import tklibs.Vector2D;


public class BoxCollider {
    Vector2D position;
    Vector2D anchor;
    int width, height;

    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.anchor = master.anchor;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x;
    }

    public float right() {
        return this.left() + this.width;
    }


    public boolean intersects(BoxCollider other) {
        return     this.top() <= other.bot()
                && this.bot() >= other.top()
                && this.left() <= other.right()
                && this.right() >= other.left();
    }
    public boolean intersectsHW(BoxCollider other) {
        //TODO
        if ((this.position.x - (other.position.x + other.width)) * ((this.position.x + this.width) - other.position.x) < 0
                && (this.position.y - (other.position.y + other.height)) * ((this.position.y + this.height) - other.position.y) < 0 )
            return true; //true
        else
            return false;
    }


}


