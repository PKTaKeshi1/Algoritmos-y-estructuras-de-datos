import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Menú de Operaciones Genéricas ===");
            System.out.println("Seleccione tipo de datos: 1. Integer  2. Double");
            int tipo = sc.nextInt();
            System.out.print("Ingrese primer número: ");
            double val1 = sc.nextDouble();
            System.out.print("Ingrese segundo número: ");
            double val2 = sc.nextDouble();

            System.out.println("1. Suma\n2. Resta\n3. Producto\n4. División\n5. Potencia\n6. Raíz Cuadrada\n7. Raíz Cúbica\n8. Salir");
            opcion = sc.nextInt();

            if (tipo == 1) {
                OperacionesMatInteger a = new OperacionesMatInteger((int)val1);
                OperacionesMatInteger b = new OperacionesMatInteger((int)val2);
                switch (opcion) {
                    case 1 -> System.out.println("Resultado: " + a.suma(b).getValor());
                    case 2 -> System.out.println("Resultado: " + a.resta(b).getValor());
                    case 3 -> System.out.println("Resultado: " + a.producto(b).getValor());
                    case 4 -> System.out.println("Resultado: " + a.division(b).getValor());
                    case 5 -> {
                        System.out.print("Ingrese exponente: ");
                        double exp = sc.nextDouble();
                        System.out.println("Resultado: " + a.potencia(exp).getValor());
                    }
                    case 6 -> System.out.println("Resultado: " + a.raizCuadrada().getValor());
                    case 7 -> System.out.println("Resultado: " + a.raizCubica().getValor());
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida");
                }
            } else if (tipo == 2) {
                OperacionesMatDouble a = new OperacionesMatDouble(val1);
                OperacionesMatDouble b = new OperacionesMatDouble(val2);
                switch (opcion) {
                    case 1 -> System.out.println("Resultado: " + a.suma(b).getValor());
                    case 2 -> System.out.println("Resultado: " + a.resta(b).getValor());
                    case 3 -> System.out.println("Resultado: " + a.producto(b).getValor());
                    case 4 -> System.out.println("Resultado: " + a.division(b).getValor());
                    case 5 -> {
                        System.out.print("Ingrese exponente: ");
                        double exp = sc.nextDouble();
                        System.out.println("Resultado: " + a.potencia(exp).getValor());
                    }
                    case 6 -> System.out.println("Resultado: " + a.raizCuadrada().getValor());
                    case 7 -> System.out.println("Resultado: " + a.raizCubica().getValor());
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida");
                }
            } else {
                System.out.println("Tipo de dato no válido.");
            }

        } while (opcion != 8);

        sc.close();
    }
}
