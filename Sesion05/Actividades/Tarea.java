package Sesion05.src.Actividades;

public class Tarea implements Comparable<Tarea> {
    String nombre;
    int prioridad; // 1 es la más alta

    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return "Tarea: " + nombre + " (Prioridad: " + prioridad + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tarea)) return false;
        Tarea otra = (Tarea) obj;
        return this.nombre.equals(otra.nombre) && this.prioridad == otra.prioridad;
    }
}

