public class World {
    public int width = 33;
    public int height = 33;

    public int[] grid = new int[this.width * this.height];

    public World() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.width; y++) {
                grid[x + y * this.width] = 0;
            }
        }
    }

    public void print() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.width; y++) {
                grid[x + y * this.width] = 0;
            }
        }

        grid[Sneak.head] = 1;

        for (int i = 0; i < Sneak.points; i++) {
            grid[Sneak.body[i]] = 1;
        }

        for (int x = 0; x < this.width; x++) {
            grid[x] = 3;
            grid[x + (this.height - 1) * (this.height - 1)] = 3;
        }
        for (int y = 0; y < this.width; y++) {
            grid[y * this.width] = 3;
            grid[(y + 1) * this.width - 1] = 3;
        }

        grid[Main.comida.celda] = 2;
    }
}
