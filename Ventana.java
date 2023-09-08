import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("Snake.java | trmaa");

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon ico = new ImageIcon("icono.jpg");
        setIconImage(ico.getImage());

        add(Main.cvs);

        setVisible(true);
    }
}