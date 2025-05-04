package Sesion05.src.Actividades;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- MENÚ DEL GESTOR DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Mostrar todas las tareas");
            System.out.println("4. Verificar si una tarea existe");
            System.out.println("5. Obtener tarea más prioritaria");
            System.out.println("6. Invertir lista de tareas");
            System.out.println("7. Completar tarea");
            System.out.println("8. Mostrar tareas completadas");
            System.out.println("9. Contar tareas pendientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre de la tarea: ");
                    String nombre = sc.nextLine();
                    System.out.print("Prioridad (1 = más alta): ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    gestor.agregarTarea(new Tarea(nombre, prioridad));
                    System.out.println("Tarea agregada.");
                }
                case 2 -> {
                    System.out.print("Nombre de la tarea a eliminar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Prioridad de la tarea: ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    boolean eliminado = gestor.eliminarTarea(new Tarea(nombre, prioridad));
                    System.out.println(eliminado ? "Tarea eliminada." : "Tarea no encontrada.");
                }
                case 3 -> {
                    System.out.println("Tareas actuales:");
                    gestor.imprimirTareas();
                }
                case 4 -> {
                    System.out.print("Nombre de la tarea: ");
                    String nombre = sc.nextLine();
                    System.out.print("Prioridad: ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    boolean existe = gestor.contieneTarea(new Tarea(nombre, prioridad));
                    System.out.println(existe ? "La tarea existe." : "La tarea no está en la lista.");
                }
                case 5 -> {
                    Tarea prioritaria = gestor.obtenerTareaMasPrioritaria();
                    if (prioritaria != null) {
                        System.out.println("Tarea más prioritaria: " + prioritaria);
                    } else {
                        System.out.println("No hay tareas.");
                    }
                }
                case 6 -> {
                    gestor.invertirTareas();
                    System.out.println("Lista invertida.");
                }
                case 7 -> {
                    System.out.print("Nombre de la tarea a completar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Prioridad: ");
                    int prioridad = sc.nextInt();
                    sc.nextLine();
                    gestor.completarTarea(new Tarea(nombre, prioridad));
                    System.out.println("Tarea completada y transferida.");
                }
                case 8 -> gestor.mostrarCompletadas();
                case 9 -> System.out.println("Tareas pendientes: " + gestor.contarTareas());
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
