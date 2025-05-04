package Sesion05.src.Ejercicios;

public class insertarAlFinal {

    // Clase Nodo genérica
    static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Método genérico para insertar al final
    public static <T> Nodo<T> insertarAlFinal(Nodo<T> head, T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (head == null) {
            // Si la lista está vacía, el nuevo nodo será el head
            return nuevoNodo;
        }

        Nodo<T> actual = head;
        while (actual.siguiente != null) {
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }

        // Insertar el nuevo nodo al final
        actual.siguiente = nuevoNodo;
        return head;
    }

    // Método para imprimir la lista enlazada
    public static <T> void imprimirLista(Nodo<T> head) {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Crear una lista enlazada de enteros
        Nodo<Integer> head = new Nodo<>(1);
        head = insertarAlFinal(head, 2);
        head = insertarAlFinal(head, 3);
        head = insertarAlFinal(head, 4);

        // Mostrar la lista de enteros
        System.out.println("Lista de enteros:");
        imprimirLista(head);

        // Crear una lista enlazada de cadenas
        Nodo<String> headStr = new Nodo<>("Hola");
        headStr = insertarAlFinal(headStr, "Mundo");
        headStr = insertarAlFinal(headStr, "Java");

        // Mostrar la lista de cadenas
        System.out.println("Lista de cadenas:");
        imprimirLista(headStr);
    }
}
