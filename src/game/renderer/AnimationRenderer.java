package game.renderer;

import game.FrameCounter;
import game.GameObject;
import tklibs.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer<render> extends Renderer {
    int currentImageIndex;
    boolean isOnce;
    FrameCounter nextImageCounter;

//    public AnimationRenderer(ArrayList<BufferedImage > images) {
//        this.images = images;
//        this.currentImageIndex = 0;
//        this.nextImageCounter = new FrameCounter(10);
//    }
//
//    public AnimationRenderer(ArrayList<BufferedImage> images, boolean isOnce) {
//        this(images); //tuong duong ham tao ben tren
//        this.isOnce = isOnce;
//    }
    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this(images, false, 10);
    } //Ham tao ko day du tham so

    public AnimationRenderer(ArrayList<BufferedImage> images
            , boolean isOnce) {
        this(images, isOnce, 10);
    }//Ham tao ko day du tham so

    public AnimationRenderer(ArrayList<BufferedImage> images
            , boolean isOnce
            , int nextImageCount) {
        this.originalImages = images;
        this.images = images;
        this.sizes = new ArrayList<>();
        for (int i = 0; i < this.images.size(); i++) {
            this.sizes.add(new Vector2D(this.images.get(i).getWidth(), this.images.get(i).getHeight()));
        }
        this.isOnce = isOnce;
        this.nextImageCounter = new FrameCounter(nextImageCount);
    }
    // TODO continue editting

    @Override
    public void render (Graphics g, GameObject master) {
        BufferedImage currentImage = this.images.get(this.currentImageIndex);
        g.drawImage(currentImage
//                , (int) (master.position.x - currentImage.getWidth() * master.anchor.x)
//                , (int) (master.position.y - currentImage.getHeight() * master.anchor.y)
                , (int) (master.position.x - currentImage.getWidth() * master.anchor.x)
                , (int) (master.position.y - currentImage.getHeight() * master.anchor.y)
                , null);



        if (this.nextImageCounter.count()) {
            this.currentImageIndex++; // Chuyen Anh
            //TODO
            if (this.isOnce && this.currentImageIndex >= this.images.size()) {
                master.destroy();

            }
            if (this.currentImageIndex >= this.images.size())
                this.currentImageIndex = 0;
            this.nextImageCounter.reset();
        }

    }

    @Override
    public Vector2D getCurrentImageSize() {
        return this.sizes.get(this.currentImageIndex);
    }

    @Override
    public void reset() {
        this.currentImageIndex = 0;
    }
}
// clas gom thuoc tinh, phuong thuc
// abstract class gom them ca abstract phuong thuc
// interface = 1 class chua toan abstract, dinh nghia tinh chat, dac diem cua nhom doi tuong
//abstract Ko can biet no chay the nao, chi can dung
// class C1, c2.C3 chi co the ke thua 1 trong 2 C1 or C2
// class C1, interface I1 I2 ... => class C3 co the ke thua cac thuoc tinh C1, I1, I2,...
//VD Interface di xuyen tuong Interface bat tu, teleport => co the cam het vao paddle
//OOP Encapsulaton (Dong goi):tu moi thang su tu giu cac thuoc tinh, puhong thuc cua no(dong goi de dinh nghia)
                            //:setter(dua vao VD dua vao < 0), getter(tra ra VD lam tron so) (Dong goi de xu ly)
// , Extend (ke thua): this vs super, override ham
// , Abstraction: abstract class, interface, abstract method ** abstract level
// , Polymorphism ( da hinh) - da hinh voi class
            //               - da hinh voi method Override Overload
//Generic: vu co 1 ham burn(), muon no dot cai gi cx dc va truyen dc rat nhieu n object vao trong ham don nay
//tra ra n kieu
// goi chung ten kieu dau vao, dau ra la E
// Dung generic voi - class: vd List: Arraylist<E >, AbstractList<>, ...
//                              Map: Treemap<K, V, ...> Goi nhieu class voi nhau
//                  - method: <E extends GameObject> E recycle()