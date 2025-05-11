package Ejercicios.EjercicioPropuesto03;

import Actividades.Act03.PriorityQueue;
import Sesion06.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        // Crear una cola de prioridad para cadenas
        PriorityQueue<String, Integer> priorityQueueStr = new PriorityQueueLinked<>(3);

        // Insertar elementos con diferentes prioridades
        priorityQueueStr.enqueue("Tarea de prioridad 0", 0);
        priorityQueueStr.enqueue("Tarea de prioridad 1", 1);
        priorityQueueStr.enqueue("Tarea de prioridad 2", 2);
        priorityQueueStr.enqueue("Otra tarea de prioridad 1", 1);

        // Mostrar la cola de prioridad
        System.out.println("Cola de prioridad (cadenas):");
        System.out.println(priorityQueueStr);

        // Eliminar elementos según prioridad
        System.out.println("Elemento eliminado: " + priorityQueueStr.dequeue());
        System.out.println("Elemento eliminado: " + priorityQueueStr.dequeue());

        // Mostrar la cola de prioridad después de eliminar
        System.out.println("Cola de prioridad después de eliminar:");
        System.out.println(priorityQueueStr);

    }
}

