package game.physics;

import game.GameObject;
import game.renderer.TextRenderer;
import tklibs.Vector2D;

public class BoxCollider {
    public Vector2D topLeft;
    Vector2D anchor;
    public  Vector2D botRight;
    Vector2D velocity;
    String shape;
    int width, height;
    float mass;

    public BoxCollider(GameObject master) {
        this(master, master.renderer.getCurrentImageSize());
    }

    public BoxCollider(GameObject master, String shape) {
        this(master, master.renderer.getCurrentImageSize(), shape);
    }

    public BoxCollider(GameObject master, float mass) {
        this(master, master.renderer.getCurrentImageSize(), mass);
    }

    public BoxCollider(GameObject master, String shape, float mass) {
        this(master, master.renderer.getCurrentImageSize(), shape, mass);
    }

    public BoxCollider(GameObject master, Vector2D size) {
        this(master, (int)size.x, (int)size.y, "rectangle", 1);
    }

    public BoxCollider(GameObject master, Vector2D size, String shape) {
        this(master, (int)size.x, (int)size.y, shape, 1);
    }

    public BoxCollider(GameObject master, Vector2D size, float mass) {
        this(master, (int)size.x, (int)size.y, "rectangle", mass);
    }

    public BoxCollider(GameObject master, Vector2D size, String shape, float mass) {
        this(master, (int)size.x, (int)size.y, shape, mass);
    }

    public BoxCollider(GameObject master, int width, int height) {
        this(master, width, height, "rectangle", 1);
    }

    public BoxCollider(GameObject master, int width, int height, float mass) {
        this(master, width, height, "rectangle", mass);
    }

    public BoxCollider(GameObject master, int width, int height, String shape) {
        this(master, width, height, "rectangle", 1);
    }

    public BoxCollider(GameObject master, int width, int height, String shape, float mass) {
        this.topLeft = master.position;
        this.botRight = master.position.clone().addThis(width, height);
//        System.out.println(this.topLeft);
//        System.out.println(this.botRight);
        this.anchor = master.anchor;
        this.velocity = master.velocity;
        this.shape = shape;
        this.mass = mass;
        this.width = width;
        this.height = height;
    }

    public boolean isColliding(BoxCollider other) {
        if (this.shape.equals("circle") && other.shape.equals("circle")) {
            return this.topLeft.clone().addThis(this.botRight).getDistTo(other.topLeft.clone().addThis(other.botRight)) <= this.width + other.width;
        }
        if (this.botRight.x < other.topLeft.x || this.topLeft.x > other.botRight.x) {
            return false;
        }
        if (this.botRight.y < other.topLeft.y || this.topLeft.y > other.botRight.y) {
            return false;
        }
        if (this.shape.equals("rectangle")) {
            if (other.shape.equals("rectangle")) {
                return true;
            }
            else if (other.shape.equals("circle")) {
                Vector2D otherCenter = other.topLeft.clone().addThis(other.botRight).scaleThis(0.5f);
                if (otherCenter.x <= this.topLeft.x) {
                    if (otherCenter.y <= this.topLeft.y) {
                        return 2 * otherCenter.getDistTo(this.topLeft) <= other.width;
                    }
                    if (otherCenter.y >= this.botRight.y) {
                        return 2 * otherCenter.getDistTo(this.topLeft.clone().addY(this.height)) <= other.width;
                    }
                }
                else if (otherCenter.x >= this.botRight.x) {
                    if (otherCenter.y <= this.topLeft.y) {
                        return 2 * otherCenter.getDistTo(this.topLeft.clone().addX(this.width)) <= other.width;
                    }
                    if (otherCenter.y >= this.botRight.y) {
                        return 2 * otherCenter.getDistTo(this.botRight) <= other.width;
                    }
                }
                return true;
            }
        }
        return other.isColliding(this);
    }

    public void resolveCollision(BoxCollider other) {
        Vector2D normal = this.normal(other);
        System.out.println(normal);
        if (normal != null) {
            float normVel = other.velocity.clone().subtractThis(this.velocity).dot(normal);
            if (normVel <= 0) {
                float j = -2f * normVel;
                j /= 1 / this.mass + 1 / other.mass;
                Vector2D impulse = normal.scaleThis(j);
                other.velocity.addThis(impulse.scaleThis(1 / other.mass));
                this.velocity.subtractThis(impulse.scaleThis(1 / this.mass));
            }
        }
    }

    public Vector2D normal(BoxCollider other) {
        if (this.shape.equals("rectangle")) {
            if (other.shape.equals("rectangle")) {
                if (other.botRight.y - other.velocity.y <= this.topLeft.y) {
                    return new Vector2D(0, -1);
                }
                if (other.topLeft.y - other.velocity.y >= this.botRight.y) {
                    return new Vector2D(0, 1);
                }
                if (other.botRight.x - other.velocity.x <= this.topLeft.x) {
                    return new Vector2D(-1, 0);
                }
                if (other.topLeft.x - other.velocity.x >= this.botRight.x) {
                    return new Vector2D(1, 0);
                }
            }
            else if (other.shape.equals("circle")) {
                Vector2D otherCenter = other.topLeft.clone().addThis(other.botRight).scaleThis(0.5f);
                if (otherCenter.x <= this.topLeft.x) {
                    if (otherCenter.y <= this.topLeft.y) {
                        return otherCenter.subtractThis(this.topLeft).setLength(1);
                    }
                    if (otherCenter.y < this.botRight.y) {
                        return otherCenter.set(-1, 0);
                    }
                    float height = this.botRight.y - this.topLeft.y;
                    return otherCenter.subtractThis(this.topLeft.clone().addY(height)).setLength(1);
                }
                if (otherCenter.x < this.botRight.x) {
                    if (otherCenter.y <= this.topLeft.y) {
                        return otherCenter.set(0, -1);
                    }
                    return otherCenter.set(0, 1);
                }
                if (otherCenter.y <= this.topLeft.y) {
                    float width = this.botRight.x - this.topLeft.x;
                    return otherCenter.subtractThis(this.topLeft.clone().addX(width)).setLength(1);
                }
                if (otherCenter.y < this.botRight.y) {
                    return otherCenter.set(1, 0);
                }
                return otherCenter.subtractThis(this.botRight).setLength(1);
            }
        }
        else if (this.shape.equals("circle")) {
            if (other.shape.equals("rectangle")) {
                return other.normal(this).scaleThis(-1);
            }
            else if (other.shape.equals("circle")) {
                return other.topLeft.clone().addThis(other.botRight).subtractThis(this.topLeft.clone().addThis(this.botRight)).setLength(1);
            }
        }
        return null;
    }

//    public float top() {
//        return this.position.y;
//    }
//
//    public float bot() {
//        return this.top() + this.height;
//    }
//
//    public float left() {
//        return this.position.x;
//    }
//
//    public float right() {
//        return this.left() + this.width;
//    }
//
//    public boolean isColliding(BoxCollider other) {
//        return this.top() <= other.bot()
//                && this.bot() >= other.top()
//                && this.left() <= other.right()
//                && this.right() >= other.left();
//    }
//    public boolean intersectsHW(BoxCollider other) {
//        //TODO
//        if ((this.position.x - (other.position.x + other.width)) * ((this.position.x + this.width) - other.position.x) < 0
//                && (this.position.y - (other.position.y + other.height)) * ((this.position.y + this.height) - other.position.y) < 0 )
//            return true; //true
//        else
//            return false;
//    }

}
