package Ejercicios.EjercicioPropuesto03;

import Actividades.Act03.PriorityQueue;
import Ejercicios.EjercicioPropuesto02.QueueArray;
import Sesion06.ExceptionIsEmpty;

public class PriorityQueueLinked<T, N> implements PriorityQueue<T, N> {
    private QueueArray<T>[] queues; // Arreglo de colas, una por cada prioridad
    private int priorities;         // Número de prioridades

    public PriorityQueueLinked(int priorities) {
        if (priorities <= 0) {
            throw new IllegalArgumentException("El número de prioridades debe ser mayor a 0.");
        }
        this.priorities = priorities;
        this.queues = new QueueArray[priorities]; // Crear el arreglo de colas
        for (int i = 0; i < priorities; i++) {
            this.queues[i] = new QueueArray<>(10); // Inicializar cada cola con capacidad fija
        }
    }

    @Override
    public void enqueue(T element, N priority) {
        int priorityIndex = (Integer) priority; // Assuming N is Integer for priority
        if (priorityIndex < 0 || priorityIndex >= priorities) {
            throw new IllegalArgumentException("Prioridad fuera de rango.");
        }
        queues[priorityIndex].enqueue(element); // Insertar el elemento en la cola correspondiente
    }

    @Override
    public T dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < priorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].dequeue(); // Eliminar y devolver el elemento de la cola con mayor prioridad
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    @Override
    public T front() throws ExceptionIsEmpty {
        for (int i = 0; i < priorities; i++) {
            if (!queues[i].isEmpty()) {
                return queues[i].front(); // Devolver el elemento al frente de la cola con mayor prioridad
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < priorities; i++) {
            if (!queues[i].isEmpty()) {
                return false; // Si alguna cola no está vacía, la cola de prioridad no está vacía
            }
        }
        return true;
    }
    @Override
    public T back() throws ExceptionIsEmpty {
        for (int i = priorities - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back(); // Devolver el último elemento de la cola con mayor prioridad
            }
        }
        throw new ExceptionIsEmpty("La cola de prioridad está vacía.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PriorityQueueLinked:\n");
        for (int i = 0; i < priorities; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(queues[i]).append("\n");
        }
        return sb.toString();
    }    
}

