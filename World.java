public class World {
    public int width = 33;
    public int height = 33;

    public int[] grid = new int[this.width * this.height];
    public int[][] id = new int[this.width * this.height][2];

    public World() {
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.width; y++) {
                this.grid[x + y * this.width] = 0;
                this.id[x + y * this.width][0] = x;
                this.id[x + y * this.width][1] = y;
            }
        }
    }

    public void print() {
        for (int x = 0; x < this.width; x++) 
            for (int y = 0; y < this.width; y++) 
                this.grid[x + y * this.width] = 0;

        this.grid[Snake.head] = 1;

        for (int i = 0; i < Snake.points; i++)
            this.grid[Snake.body[i]] = 1;

        this.grid[Main.comida.celda] = 2;
    }
}
