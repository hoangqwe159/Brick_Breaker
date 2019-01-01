package Game.Player;

import Game.*;
import Game.Physics.BoxCollider;
import Game.Physics.Physics;
import Game.Renderer.AnimationRenderer;
import Game.Renderer.SingleimageRenderer;
import Game.Scene.GameOverScene;
import Game.Scene.Scene;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {

    BoxCollider boxCollider;


    public Player() {
        // Game.Player.Player.playerName; // co the goi y het ben canvas
        super();

        this.createRenderer();
        this.position.set(400, 570);
        this.anchor.set(0f,0f);
        this.boxCollider = new BoxCollider(this, 140, 30);
        GameObject.midLayer.add(this);
    }

    private void createRenderer() {
        BufferedImage image = SpriteUtils.loadImage("assets/images/paddle/0.png");
        this.renderer = new SingleimageRenderer(image);

    }

    @Override
    public void run() {
        super.run();
        this.move();

        this.limitPlayerPosition();
    }
    //TODO continue editting



    private void move() {

        this.velocity.set(0, 0);

        if (GameWindow.isLeftPress) {
            this.velocity.addThis(Setting.PLAYER_VECLOCITY_LEFT);
        }
        if (GameWindow.isRightPress) {
            this.velocity.addThis(Setting.PLAYER_VECLOCITY_RIGHT);
        }
        this.velocity.setLength(Setting.PLAYER_VECLOCITY_DOWN.y);
    }

    private void limitPlayerPosition() {
            if (this.position.x < 0) {
                this.position.set(0, this.position.y);
            }
            if (this.position.x > 800 - 150) {
                this.position.set(800 - 150, this.position.y);
            }



    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

    @Override
    public void destroy() {
        super.destroy();
        Scene.signNewScene(new GameOverScene());
    }

}

//Gioi han di chuyen cho player
//Vector 2D: diem(x, y) vector (x, y)

// Polymorphisim
// override and overload

// Dong giooi ke thua da hinh
// BTVN
// Ban nhieu vien (nhieu huong)
// Ban nhieu loai doan
// Nang cap duong dan

// Setting