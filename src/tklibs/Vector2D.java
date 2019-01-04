package tklibs;

public class Vector2D {
    public float x;
    public float y;

    // ko co thuoc tinh length va angle => thuoc tinh ao, ko can khai bao
    // x. y quan he vs len angle => !$%@#$
    public Vector2D() {

        this(0, 0); //this (0,0)
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;

    }
//    public Vector2D(float x, float y, float a, float b){
//        this.x = x;
//        this.y = y;
//        this.a = a;
//        this.b = b;
//    }

    public Vector2D addX(float x) {
        this.x += x;
        return this;
    }
    public Vector2D addY(float y) {
        this.y += y;
        return this;
    }
    public Vector2D addThis(float x, float y){
        this.x += x;
        this.y += y;
        return this; // giup viet mot operator dai x : + - ....
    }
    public Vector2D addThis (Vector2D other) {
        return this.addThis(other.x, other.y);
    }
//    public Vector2D parabol(float x, float y, float a, float b) {
//        this.x = x + 1;
//        this.y = (x - a) * (x - a) - 20 * (x - a) + b;
//        return this;
//    }

    public Vector2D setX(float x) {
        this.x = x;
        return this;
    }
    public Vector2D setY(float y) {
        this.y = y;
        return this;
    }
    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    public  Vector2D set(Vector2D other) {

        return this.set(other.x, other.y);
    }
    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }
    public Vector2D subtractThis(float x, float y){
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector2D subtractThis(Vector2D other) {
        return this.subtractThis(other.x, other.y);
    }


    public Vector2D scaleThis(float rate){
        this.x *= rate;
        this.y *= rate;
        return this;
    }

    public Vector2D scaleThis(float rateX, float rateY) {
        this.x *= rateX;
        this.y *= rateY;
        return this;
    }

    public Vector2D scaleThis(Vector2D rate) {
        this.x *= rate.x;
        this.y *= rate.y;
        return this;
    }

    public Vector2D scaleX(float rate){
        this.x *= rate;
        return this;
    }

    public Vector2D scaleY(float rate){
        this.y *= rate;
        return this;
    }

    public float getLength(){
        return (float) Math.sqrt(x * x + y * y);

    }

    public Vector2D setLength(float length){

        float currentLength = this.getLength();
        if (currentLength != 0) {
            float rate = length/ currentLength;
            this.scaleThis(rate);
        }
        return this;
    }

    public float getAngle() {
        if (this.x == 0) {
            if (this.y == 0) {
                return 361;
            }
            return (float)(Math.PI / 2 - Math.PI * Math.signum(this.y - Math.abs(this.y)));
        }
        return (float)(Math.atan(this.y / this.x) - Math.PI * Math.signum((int)(this.x - Math.abs(this.x))));
    }

    public Vector2D setAngle(float angle){


        this.x = this.getLength() * (float) Math.cos(angle);
        this.y = this.getLength() * (float) Math.sin(angle);
        return this;

    }

    public float dot(Vector2D other) {
        return this.x * other.x + this.y * other.y;
    }

    public float getDistTo(Vector2D other) {
        return other.clone().subtractThis(this).getLength();
    }

    public static float distBetween(Vector2D vector1, Vector2D vector2) {
        return vector2.clone().subtractThis(vector1).getLength();
    }

    @Override
    public String toString() {
        return "tklibs.Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
//
//    public static void main(String[] args) {
//        tklibs.Vector2D v1 = new tklibs.Vector2D(1,1);
//        System.out.println(v1.addThis(2, 2));
//        System.out.println(v1.setAngle((float)Math.PI / 4));
//
//    }


}

// Get set the hien tinh chat dong goi
