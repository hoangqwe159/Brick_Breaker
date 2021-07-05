package game.particle;

import game.FrameCounter;
import game.GameObject;
import game.Setting;
import game.physics.BoxCollider;
import game.physics.Physics;
import game.renderer.SingleimageRenderer;
import tklibs.SpriteUtils;
import tklibs.Vector2D;

import java.util.Random;

public class ParticleExplosion extends GameObject implements Physics {
    public BoxCollider boxCollider;
    public FrameCounter lifeTime;
    public float maxVelocity;

    public ParticleExplosion() {
        this(new Vector2D(Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT), 1, true);
    }

    public ParticleExplosion(Vector2D startingPosition) {
        this(startingPosition, 1, true);
    }

    public ParticleExplosion(Vector2D startingPosition, float maxVelocity, boolean isActive) {
        Random random = new Random();
        this.velocity.set(1, 1);
        this.velocity.setLength(random.nextFloat() * maxVelocity).setAngle((float)(random.nextFloat() * Math.PI * 2));
        this.position.set(startingPosition);
        this.active = isActive;
        this.lifeTime = new FrameCounter(random.nextInt(41) + 15);
        this.maxVelocity = maxVelocity;
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

    public static void generateParticle(int how_many, Vector2D startingPosition, boolean isActive) {
        for (int i = 0; i < how_many; i++) {
            ParticleExplosion particleExplosion = GameObject.recycleGameObject(ParticleExplosion.class);
            if (isActive) {
                particleExplosion.position.set(startingPosition);
                Random random = new Random();
                particleExplosion.velocity.set(1, 1);
                particleExplosion.velocity.setLength(random.nextFloat() * particleExplosion.maxVelocity).setAngle((float) (random.nextFloat() * Math.PI * 2));
                float velocity = particleExplosion.velocity.getLength();
                if (velocity > 0.97 * particleExplosion.maxVelocity) {
                    particleExplosion.velocity.setLength(2 * velocity);
                }
            }
            else {
                particleExplosion.position.set(-1, -1);
                particleExplosion.velocity.set(0, 0);
            }
            particleExplosion.lifeTime.reset();
        }
    }

    public static void generateParticle(int how_many, Vector2D startingPosition) {
        ParticleExplosion.generateParticle(how_many, startingPosition, true);
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
