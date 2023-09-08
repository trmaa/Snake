import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Canvas extends JPanel {
    public MyKeyListener kl = new MyKeyListener();

    public Canvas() {
        this.addKeyListener(this.kl);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.cls(g, new Color(0xff0000));
        for (int x = 0; x < Main.world.width; x++) {
            for (int y = 0; y < Main.world.height; y++) {
                this.print(
                        g, x * (Main.ventana.getWidth() / Main.world.width),
                        y * (Main.ventana.getHeight() / Main.world.height),
                        (Main.ventana.getWidth() / Main.world.width), (Main.ventana.getHeight() / Main.world.height),
                        new Color(
                                Main.world.grid[x + y * Main.world.width] == 3 ? 0xbb55bb
                                        : (Main.world.grid[x + y * Main.world.width] == 1 ? 0x00ff00
                                                : (Main.world.grid[x + y * Main.world.width] == 2 ? 0xff0000
                                                        : 0x000000))));
            }
        }
    }

    public void cls(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(0, 0, Main.ventana.getWidth(), Main.ventana.getHeight());
    }

    public void print(Graphics g, float x, float y, float w, float h, Color c) {
        g.setColor(c);
        g.fillRect(Math.round(x), Math.round(y), Math.round(w), Math.round(h));
    }
}