package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isNewBallPress;
    public static boolean isAnyKeyPress;


    //boolean : co bam nut hay ko. Static: truy cap qua Gamewindow
    public GameCanvas canvas;

    public GameWindow() {
//        this.setSize(Setting.SCREEN_HEIGHT, Setting.SCREEN_HEIGHT);
        this.setTitle("game brick Breaker");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.canvas = new GameCanvas();
        this.canvas.setPreferredSize(new Dimension(Setting.SCREEN_WIDTH, Setting.SCREEN_HEIGHT));

        this.add(canvas);
        this.pack();
        this.setupEventListener();

        this.setVisible(true);

    }

    private void setupEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                isAnyKeyPress = true;
                if (e.getKeyCode() == KeyEvent.VK_W){
                    GameWindow.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    GameWindow.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    GameWindow.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    GameWindow.isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    GameWindow.isFirePress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_N) {
                    GameWindow.isNewBallPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                isAnyKeyPress = false;
                if (e.getKeyCode() == KeyEvent.VK_W){
                    GameWindow.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    GameWindow.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    GameWindow.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    GameWindow.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    GameWindow.isFirePress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_N) {
                    GameWindow.isNewBallPress = false;
                }
            }
        });
    }
}
