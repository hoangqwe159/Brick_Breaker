package Game.Renderer;

import Game.GameObject;

import java.awt.*;

public class TextRenderer extends Renderer {
    public String text;
    public Color color;
    public Font font;
    public TextRenderer(String text) {
        this(text, Color.YELLOW, new Font("Verdana", Font.BOLD, 24));
    }
    public TextRenderer(String text, Color color, Font font) {
        this.text = text;
        this.color = color;
        this.font = font;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        g.setColor(this.color);
        g.setFont(this.font);
        g.drawString(this.text, (int) master.position.x, (int) master.position.y);
    }
}
