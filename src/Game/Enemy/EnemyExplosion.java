package Game.Enemy;

import Game.GameObject;
import Game.Renderer.AnimationRenderer;
import tklibs.SpriteUtils;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion() {
        this.renderer = new AnimationRenderer(SpriteUtils.loadImages("assets/images/explosion/explosion_type_I"), true);
        GameObject.midLayer.add(this);
    }
}
