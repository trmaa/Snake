public class Main {
    public static int iter = 0;
    public static Canvas cvs = new Canvas();
    public static Ventana ventana = new Ventana();

    public static World world = new World();
    public static Comida comida = new Comida();

    public static void main(String[] args) {
        while (true) {
            Main.loop();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loop() {
        Main.iter++;
        Main.cvs.repaint();

        Sneak.update();
        world.print();
    }
}