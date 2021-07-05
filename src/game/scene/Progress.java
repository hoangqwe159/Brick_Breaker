//package game.scene;
//
//import game.GameObject;
//import game.Setting;
//import game.renderer.AnimationRenderer;
//import tklibs.SpriteUtils;
//import tklibs.Vector2D;
//
//public class Progress extends GameObject{
//
//    public Progress() {
//        this.createRenderer();
//        this.position.set(new Vector2D(Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT).subtractThis(this.renderer.getCurrentImageSize().clone().scaleThis(0.5f)));
//        GameObject.topLayer.add(this);
//    }
//
//    public void createRenderer() {
//        this.renderer = new AnimationRenderer(SpriteUtils.loadImages());
//    }
//}
