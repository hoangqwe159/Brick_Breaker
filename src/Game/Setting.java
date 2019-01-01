package Game;

import tklibs.Vector2D;

import java.awt.*;

public class Setting {
    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 600;
    public static int PLAYER_START_POSITION_X = 400;
    public static int PLAYER_START_POSITION_Y = 570;
    public static Vector2D PLAYER_VECLOCITY_UP = new Vector2D(0, -5);
    public static Vector2D PLAYER_VECLOCITY_DOWN = new Vector2D(0, 5);
    public static Vector2D PLAYER_VECLOCITY_LEFT = new Vector2D(-5, 0);
    public static Vector2D PLAYER_VECLOCITY_RIGHT = new Vector2D(5, 0);
    public static Font FONT_XS = new Font("Verdana", Font.BOLD, 12);
    public static Font FONT_SM = new Font("Verdana", Font.BOLD, 14);
    public static Font FONT_MD = new Font("Verdana", Font.BOLD, 16);
    public static Font FONT_LG = new Font("Verdana", Font.BOLD, 24);



}
