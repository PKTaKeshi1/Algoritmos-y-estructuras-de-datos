//ContainerRect.java
public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;  // capacidad máxima
    private static int numRec = 0;  // rectángulos almacenados

    // Constructor
    public ContainerRect(int capacidad) {
        this.n = capacidad;
        rectangulos = new Rectangulo[capacidad];
        distancias = new double[capacidad];
        areas = new double[capacidad];
    }

    // Método para agregar un rectángulo si hay espacio
    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            // Calcular distancia entre sus esquinas
            double d = r.getEsquina1().distancia(r.getEsquina2());
            double a = r.calcularArea();

            distancias[numRec] = d;
            areas[numRec] = a;

            numRec++;
        } else {
            System.out.println("¡Contenedor lleno! No se puede agregar más rectángulos.");
        }
    }

    // Mostrar todos los rectángulos almacenados con sus datos
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectangulo\tCoordenadas\t\t\tDistancia\tÁrea\n");
        for (int i = 0; i < numRec; i++) {
            sb.append((i + 1)).append("\t\t")
              .append(rectangulos[i].toString()).append("\t")
              .append(String.format("%.3f", distancias[i])).append("\t\t")
              .append(String.format("%.2f", areas[i])).append("\n");
        }
        return sb.toString();
    }
}
