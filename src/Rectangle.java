import tklibs.Vector2D;

public class Rectangle {
    Vector2D position;
    int width, height;

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
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
     public boolean intersects(Rectangle other) {
        return     this.top() <= other.bot()
                && this.bot() >= other.top()
                && this.left() <= other.right()
                && this.right() >= other.left();
     }
    public boolean intersectsHW(Rectangle other) {
        //TODO
        if ((this.position.x - (other.position.x + other.width)) * ((this.position.x + this.width) - other.position.x) < 0
            && (this.position.y - (other.position.y + other.height)) * ((this.position.y + this.height) - other.position.y) < 0 )
            return true; //true
        else
            return false;
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(0, 0), 5, 5);
        Rectangle rect2 = new Rectangle(new Vector2D(6, 6), 5, 5);
        Rectangle rect3 = new Rectangle(new Vector2D(3, 3), 5, 5);

        System.out.println(rect1.intersects(rect2)); //false
        System.out.println(rect1.intersects(rect3)); //true
        System.out.println(rect2.intersects(rect3)); //true
    }
}
