package Ejercicios.EjercicioPropuesto02;

import Actividades.Act02.Queue;
import Sesion06.ExceptionIsEmpty;

public class QueueArray<T> implements Queue<T> {
    private T[] array;      // Arreglo que almacena los elementos de la cola
    private int first;      // Índice del primer elemento
    private int last;       // Índice del último elemento
    private int size;       // Cantidad de elementos en la cola
    private int capacity;   // Capacidad máxima de la cola

    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.first = 0;
        this.last = -1;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == capacity) {
            throw new IllegalStateException("La cola está llena.");
        }
        last = (last + 1) % capacity; // Incrementar last de forma circular
        array[last] = element;       // Insertar el elemento en la posición last
        size++;
    }

    @Override
    public T dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        }
        T element = array[first];    // Obtener el elemento en la posición first
        array[first] = null;         // Eliminar el elemento de la cola
        first = (first + 1) % capacity; // Incrementar first de forma circular
        size--;
        return element;
    }

    @Override
    public T front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        }
        return array[first]; // Devolver el elemento en la posición first
    }

    public boolean isEmpty() {
        return size == 0; // La cola está vacía si el tamaño es 0
    }

    public int size() {
        return size; // Devolver el tamaño actual de la cola
    }

    @Override
    public T back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía.");
        }
        return array[last]; // Devolver el elemento en la posición last
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        for (int i = 0; i < size; i++) {
            sb.append(array[(first + i) % capacity]).append(" ");
        }
        return sb.toString().trim();
    }

}
