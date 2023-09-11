public class Snake {
    public static int head = Main.world.width / 2 + (Main.world.height / 2) * Main.world.height;
    public static int[] body = new int[100];

    public static int points = 3;
    public static int step = 1;

    public static Controls controls = new Controls();

    public static void update() {
        Snake.controls.update();
        Snake.move();
        Snake.moveb();

        Snake.feed();
        Snake.die();
    }

    public static void move() {
        Snake.body[0] = Snake.head;

        switch (controls.dir) {
            case 0:
                Snake.head++;
                break;
            case 2:
                Snake.head--;
                break;
            case 1:
                Snake.head -= Main.world.width;
                break;
            case 3:
                Snake.head += Main.world.width;
                break;
        }
    }

    public static void moveb() {
        for (int i = Snake.step; i >= 1; i--)
            Snake.body[i] = Snake.body[i - 1];
        Snake.step += Snake.step < Snake.points - 1 ? 1 : 0;
    }

    public static void die() {
        if (Main.world.id[Snake.head][0] != Main.world.id[Snake.body[0]][0]
                && Main.world.id[Snake.head][1] != Main.world.id[Snake.body[0]][1])
            Snake.head = 10000000;
        for (int i = 0; i < Snake.points; i++) {
            if (Snake.head == Snake.body[i])
                Snake.head = 10000000;
        }
    }

    public static void feed() {
        if (Snake.colide(2)) {
            Main.comida.celda = Main.comida.hacerComida();
            Snake.points++;
        }
    }

    private static boolean colide(int n) {
        boolean r = false;

        for (int x = 0; x < Main.world.width; x++) {
            for (int y = 0; y < Main.world.height; y++) {
                if (Main.world.grid[x + y * Main.world.width] == n) {
                    if ((x + y * Main.world.width) == Snake.head) {
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
