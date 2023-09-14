import javax.swing.*;
import java.awt.*;

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

        this.cls(g, new Color(0x449911));
        for (int x = 0; x < Main.world.width; x++) {
            for (int y = 0; y < Main.world.height; y++) {
                this.print(
                        g, x * (Main.ventana.getWidth() / (Main.world.width)),
                        y * (Main.ventana.getHeight() / (Main.world.height)),
                        (Main.ventana.getWidth() / Main.world.width),
                        (Main.ventana.getHeight() / Main.world.height),
                        new Color(
                                (Main.world.grid[x + y * Main.world.width] == 1 ? 0x006600
                                        : (Main.world.grid[x + y * Main.world.width] == 2 ? 0x005500
                                                : 0x449911))));
            }
        }
        this.printext(g, "Score: " + (Snake.points - 3), 10, 42, "consolas", 32, new Color(0x005500));
    }

    private void cls(Graphics g, Color c) {
        g.setColor(c);
        g.fillRect(0, 0, Main.ventana.getWidth(), Main.ventana.getHeight());
    }

    private void print(Graphics g, float x, float y, float w, float h, Color c) {
        g.setColor(c);
        g.fillRect(Math.round(x), Math.round(y), Math.round(w), Math.round(h));
    }

    private void printext(Graphics g, String msg, int x, int y, String fnt, int d, Color c) {
        g.setColor(c);
        g.setFont(new Font(fnt, Font.BOLD, d));
        g.drawString(msg, x, y);
    }
}