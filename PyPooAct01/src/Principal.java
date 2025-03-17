//Principal.java
import java.util.Scanner;

public class Principal {
    public static void mostrarRectangulo(String nombre, Rectangulo r) {
        System.out.println("Rectangulo " + nombre + " = " + r.toString());
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double x1 = Math.max(Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()), Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double y1 = Math.max(Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()), Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
        double x2 = Math.min(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()), Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
        double y2 = Math.min(Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()), Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));

        Coordenada c1 = new Coordenada(x1, y1);
        Coordenada c2 = new Coordenada(x2, y2);
        return new Rectangulo(c1, c2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese una esquina del 1er rectángulo: ");
        double x1 = sc.nextDouble(), y1 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 1er rectángulo: ");
        double x2 = sc.nextDouble(), y2 = sc.nextDouble();

        System.out.print("Ingrese una esquina del 2do rectángulo: ");
        double x3 = sc.nextDouble(), y3 = sc.nextDouble();
        System.out.print("Ingrese la esquina opuesta del 2do rectángulo: ");
        double x4 = sc.nextDouble(), y4 = sc.nextDouble();

        Rectangulo A = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        Rectangulo B = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        mostrarRectangulo("A", A);
        mostrarRectangulo("B", B);

        if (Verificador.seSobreponen(A, B)) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo sobre = rectanguloSobre(A, B);
            System.out.printf("Area de sobreposicion = %.2f\n", sobre.calcularArea());
        } else if (Verificador.estanJuntos(A, B)) {
            System.out.println("Rectangulos A y B se juntan.");
        } else {
            System.out.println("Rectangulos A y B son disjuntos.");
        }

        sc.close();
    }
}
