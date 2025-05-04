package Sesion05.src.Actividades;

import java.util.ArrayList;
import java.util.List;

public class GestorDeTareas<T extends Comparable<T>> {
    private Node<T> head;
    private List<T> tareasCompletadas;

    public GestorDeTareas() {
        this.head = null;
        this.tareasCompletadas = new ArrayList<>();
    }

    public void agregarTarea(T tarea) {
        Node<T> nuevo = new Node<>(tarea);
        if (head == null) {
            head = nuevo;
        } else {
            Node<T> actual = head;
            while (actual.next != null) actual = actual.next;
            actual.next = nuevo;
        }
    }

    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;

        if (head.data.equals(tarea)) {
            head = head.next;
            return true;
        }

        Node<T> actual = head;
        while (actual.next != null && !actual.next.data.equals(tarea)) {
            actual = actual.next;
        }

        if (actual.next != null) {
            actual.next = actual.next.next;
            return true;
        }

        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> actual = head;
        while (actual != null) {
            if (actual.data.equals(tarea)) return true;
            actual = actual.next;
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> actual = head;
        while (actual != null) {
            System.out.println(actual.data);
            actual = actual.next;
        }
    }

    public int contarTareas() {
        int contador = 0;
        Node<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.next;
        }
        return contador;
    }

    public T obtenerTareaMasPrioritaria() {
        if (head == null) return null;

        Node<T> actual = head;
        T mayor = head.data;

        while (actual != null) {
            if (actual.data.compareTo(mayor) < 0) {
                mayor = actual.data;
            }
            actual = actual.next;
        }
        return mayor;
    }

    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = head;
        while (actual != null) {
            Node<T> siguiente = actual.next;
            actual.next = anterior;
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    public void completarTarea(T tarea) {
        if (eliminarTarea(tarea)) {
            tareasCompletadas.add(tarea);
        }
    }

    public void mostrarCompletadas() {
        System.out.println("Tareas completadas:");
        for (T t : tareasCompletadas) {
            System.out.println(t);
        }
    }
}
