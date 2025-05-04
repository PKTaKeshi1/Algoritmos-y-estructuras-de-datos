package Sesion05.src.Ejercicios;

public class contarNodos {

    // Clase Nodo genérica
    static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Método genérico para contar nodos
    public static <T> int contarNodos(Nodo<T> head) {
        int contador = 0;
        Nodo<T> actual = head;

        while (actual != null) {
            contador++;
            actual = actual.siguiente; // Avanzar al siguiente nodo
        }

        return contador;
    }

    public static void main(String[] args) {
        // Crear una lista enlazada de enteros
        Nodo<Integer> head = new Nodo<>(1);
        head.siguiente = new Nodo<>(2);
        head.siguiente.siguiente = new Nodo<>(3);
        head.siguiente.siguiente.siguiente = new Nodo<>(4);

        // Contar nodos en la lista
        int totalNodos = contarNodos(head);
        System.out.println("Total de nodos: " + totalNodos);

        // Crear una lista enlazada de cadenas
        Nodo<String> headStr = new Nodo<>("Hola");
        headStr.siguiente = new Nodo<>("Mundo");
        headStr.siguiente.siguiente = new Nodo<>("Java");

        // Contar nodos en la lista
        int totalNodosStr = contarNodos(headStr);
        System.out.println("Total de nodos: " + totalNodosStr);
    }
}
