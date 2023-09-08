import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    public static boolean KEY_UP = false;
    public static boolean KEY_DOWN = false;
    public static boolean KEY_LEFT = false;
    public static boolean KEY_RIGHT = false;

    public static boolean moving = false;

    @Override
    public void keyPressed(KeyEvent e) {
        MyKeyListener.KEY_UP = e.getKeyCode() == KeyEvent.VK_UP ? true : MyKeyListener.KEY_UP;
        MyKeyListener.KEY_DOWN = e.getKeyCode() == KeyEvent.VK_DOWN ? true : MyKeyListener.KEY_DOWN;
        MyKeyListener.KEY_LEFT = e.getKeyCode() == KeyEvent.VK_LEFT ? true : MyKeyListener.KEY_LEFT;
        MyKeyListener.KEY_RIGHT = e.getKeyCode() == KeyEvent.VK_RIGHT ? true : MyKeyListener.KEY_RIGHT;

        MyKeyListener.moving = KEY_UP || KEY_DOWN || KEY_LEFT || KEY_RIGHT;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        MyKeyListener.KEY_UP = e.getKeyCode() == KeyEvent.VK_UP ? false : MyKeyListener.KEY_UP;
        MyKeyListener.KEY_DOWN = e.getKeyCode() == KeyEvent.VK_DOWN ? false : MyKeyListener.KEY_DOWN;
        MyKeyListener.KEY_LEFT = e.getKeyCode() == KeyEvent.VK_LEFT ? false : MyKeyListener.KEY_LEFT;
        MyKeyListener.KEY_RIGHT = e.getKeyCode() == KeyEvent.VK_RIGHT ? false : MyKeyListener.KEY_RIGHT;

        MyKeyListener.moving = KEY_UP || KEY_DOWN || KEY_LEFT || KEY_RIGHT;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
