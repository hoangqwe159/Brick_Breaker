//package game.scene;
//
//import game.FrameCounter;
//import game.GameObject;
//import game.renderer.SingleimageRenderer;
//import tklibs.SpriteUtils;
//
//public class BackgroundProgress implements Runnable {
//    FrameCounter idleCounter;
//    Scene currentScene;
//    Progress progress;
//    boolean ready;
//
//    public BackgroundProgress(Scene currentScene) {
//        this.createRenderer();
//        this.anchor.set(0, 0);
//        this.ready = false;
//        GameObject.topLayer.add(this);
//        this.currentScene = currentScene;
//        this.progress = new Progress();
//    }
//
//    public void createRenderer() {
//        this.renderer = new SingleimageRenderer(SpriteUtils.loadImage("assets/images/background/background.png"));
//    }
//
//    public void run() {
//        if (this.currentScene.ready && !this.ready) {
//            this.idleCounter = new FrameCounter(60);
//            this.ready = true;
//        }
//        if (this.ready && this.idleCounter.count()) {
//            this.destroy();
//            this.ready = false;
//        }
//    }
//}
