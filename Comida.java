public class Comida {
    public int celda = 0;

    public Comida() {
        this.celda = this.hacerComida();
    }

    public int hacerComida() {
        int x = Utils.redondear(Math.random() * (31 - 1) + 1);
        int y = Utils.redondear(Math.random() * (31 - 1) + 1);
        return x + y * Main.world.width;
    }
}
