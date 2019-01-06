package game.explosion;

import game.FrameCounter;
import game.GameObject;
import game.Setting;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;
import tklibs.Vector2D;

import java.util.Random;

public class Particle extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public FrameCounter lifeTime;

    public Particle() {
        this(new Vector2D(Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT), 1, true);
    }

    public Particle(Vector2D startingPosition) {
        this(startingPosition, 1, true);
    }

    public Particle(Vector2D startingPosition, float maxVelocity, boolean isActive) {
        Random random = new Random();
        this.velocity.set(1, 1);
        this.velocity.setLength(random.nextFloat() * maxVelocity).setAngle((float)(random.nextFloat() * Math.PI * 2));
        this.position.set(startingPosition);
        this.active = isActive;
        this.lifeTime = new FrameCounter(random.nextInt(51) + 20);
        this.createRenderer();
        this.createBoxCollider();
        GameObject.midLayer.add(this);
    }

    private void createBoxCollider() {
        this.boxCollider = new BoxCollider(this, "circle");
    }

    private void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/particle/0.png"));
    }

    public static void generateParticle(int how_many, Vector2D startingPosition) {
        for (int i = 0; i < how_many; i++) {
            Particle particle = GameObject.recycleGameObject(Particle.class);
            particle.position.set(startingPosition);
            Random random = new Random();
            particle.velocity.set(1, 1);
            particle.velocity.setLength(random.nextFloat()).setAngle((float)(random.nextFloat() * Math.PI * 2));
            particle.lifeTime.reset();
        }
    }

    @Override
    public void run() {
        super.run();
        if (this.lifeTime.count()) {
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        this.createBoxCollider();
        return this.boxCollider;
    }
}
