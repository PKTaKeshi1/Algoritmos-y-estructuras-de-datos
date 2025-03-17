// Coordenada.Java
public class Coordenada {
    private double x;
    private double y;

    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada c) {
        this.x = c.x;
        this.y = c.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double distancia(Coordenada c) {
        double dx = this.x - c.x;
        double dy = this.y - c.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distancia(Coordenada c1, Coordenada c2) {
        return c1.distancia(c2);
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}
