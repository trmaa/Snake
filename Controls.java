public class Controls {
    public int dir;

    public void update() {
        if (MyKeyListener.KEY_RIGHT && this.dir != 2)
            this.dir = 0;
        if (MyKeyListener.KEY_LEFT && this.dir != 0)
            this.dir = 2;
        if (MyKeyListener.KEY_UP && this.dir != 3)
            this.dir = 1;
        if (MyKeyListener.KEY_DOWN && this.dir != 1)
            this.dir = 3;
    }
}
