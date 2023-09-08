public class Sneak {
    public static int head = Main.world.width / 2 + (Main.world.height / 2) * Main.world.height;
    public static int[] body = new int[30];

    public static int points = 2;
    public static int step = 1;

    public static Controls controls = new Controls();

    public static void update() {
        controls.update();
        Sneak.move();
        Sneak.moveb();

        Sneak.feed();
        Sneak.die();
    }

    public static void move() {
        Sneak.body[0] = Sneak.head;

        switch (controls.dir) {
            case 0:
                Sneak.head++;
                break;
            case 2:
                Sneak.head--;
                break;
            case 1:
                Sneak.head -= Main.world.width;
                break;
            case 3:
                Sneak.head += Main.world.width;
                break;
        }
    }

    public static void moveb() {
        for (int i = Sneak.step; i >= 1; i--)
            Sneak.body[i] = Sneak.body[i - 1];
        Sneak.step += Sneak.step < Sneak.points - 1 ? 1 : 0;
    }

    public static void die() {
        if (Main.world.id[Sneak.head][0] != Main.world.id[Sneak.body[0]][0]
                && Main.world.id[Sneak.head][1] != Main.world.id[Sneak.body[0]][1])
            Sneak.head = 10000000;
        for (int i = 0; i < Sneak.points; i++) {
            if (Sneak.head == Sneak.body[i])
                Sneak.head = 10000000;
        }
    }

    public static void feed() {
        if (Sneak.colide(2)) {
            Main.comida.celda = Main.comida.hacerComida();
            Sneak.points++;
        }
    }

    private static boolean colide(int n) {
        boolean r = false;

        for (int x = 0; x < Main.world.width; x++) {
            for (int y = 0; y < Main.world.height; y++) {
                if (Main.world.grid[x + y * Main.world.width] == n) {
                    if ((x + y * Main.world.width) == Sneak.head) {
                        r = true;
                        return r;
                    } else {
                        r = false;
                        return r;
                    }
                }
            }
        }
        return r;
    }
}
