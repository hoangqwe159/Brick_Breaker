package Game.Ball;

import Game.Enemy.Enemy;
import Game.GameObject;
import Game.Physics.BoxCollider;
import Game.Player.Player;
import Game.Renderer.SingleimageRenderer;
import Game.Scene.GameOverScene;
import Game.Scene.Scene;
import tklibs.SpriteUtils;


public class BallType1 extends Ball {

    public BallType1() {
        this.position.set(400, 400);
        this.velocity.set(3 , -5);
        this.anchor.set(0,0);
        GameObject.midLayer.add(this);
    }
    @Override
    public void createBoxCollider() {
        this.boxCollider =new BoxCollider(this, 30, 30);
    }

    @Override
    public void createRenderer() {
        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/ball/0.png"));
    }

    @Override
    public void run() {
        super.run();
        Player player = GameObject.findIntercepts(Player.class, this.boxCollider);
        if (player != null){

            // when ball hits left or right of brick
            if(this.position.x + 29 <= player.position.x || this.position.x + 1 >= player.position.x + 150)
            {
                this.velocity.scaleX(-1);
            }
            // when ball hits top or bottom of brick
            else
            {
                this.position.set(this.position.x, 540);
                this.velocity.scaleY(-1);
            }
        }

        Enemy enemy = GameObject.findIntercepts(Enemy.class, this.boxCollider);
        if (enemy != null) {
            enemy.destroy();
            // when ball hits left or right of brick
            if(this.position.x + 29 <= enemy.position.x || this.position.x + 1 >= enemy.position.x + 80)
            {
                this.velocity.scaleX(-1);
            }
            // when ball hits top or bottom of brick
            else
            {
                this.velocity.scaleY(-1);
            }

        }
        this.limitBallType1Position();

    }


    private void limitBallType1Position() {
        if (this.position.x < 0) {
            this.position.set(0, this.position.y);
            this.velocity.scaleX(-1);
        }
        if (this.position.x > 800 -30) {
            this.position.set(800 -30, this.position.y);
            this.velocity.scaleX(-1);
        }

        if (this.position.y < 0) {
            this.position.set(this.position.x, 0);
            this.velocity.scaleY(-1);
        }

        if (this.position.y > 600) {
            this.destroy();
            Scene.signNewScene(new GameOverScene());
        }
    }
}
