public class Comida {
    public int celda = 0;

    public Comida() {
        this.celda = this.hacerComida();
    }

    public int hacerComida() {
        int x = Utils.redondear(Math.random() * Main.world.width);
        int y = Utils.redondear(Math.random() * Main.world.height);
        return x + y * Main.world.width;
    }
}
