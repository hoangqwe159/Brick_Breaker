package game.brick;

import game.GameObject;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

public class BrickDestroy extends GameObject {
    public BrickDestroy() {
        this.renderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/particle/explosion_type_I"), true);
        GameObject.midLayer.add(this);
    }
}
