package Sesion05.src.Ejercicios;

public class concatenarListas {

    // Clase Nodo genérica
    static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Método genérico para concatenar dos listas enlazadas
    public static <T> Nodo<T> concatenarListas(Nodo<T> head1, Nodo<T> head2) {
        if (head1 == null) return head2; // Si la primera lista está vacía, devolver la segunda
        if (head2 == null) return head1; // Si la segunda lista está vacía, devolver la primera

        Nodo<T> actual = head1;
        while (actual.siguiente != null) {
            actual = actual.siguiente; // Avanzar al último nodo de la primera lista
        }

        actual.siguiente = head2; // Conectar el último nodo de la primera lista con el head de la segunda
        return head1;
    }

    // Método para mostrar el contenido de una lista enlazada
    public static <T> void mostrarLista(Nodo<T> head) {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Crear la primera lista enlazada de enteros
        Nodo<Integer> head1 = new Nodo<>(1);
        head1.siguiente = new Nodo<>(2);
        head1.siguiente.siguiente = new Nodo<>(3);

        // Crear la segunda lista enlazada de enteros
        Nodo<Integer> head2 = new Nodo<>(4);
        head2.siguiente = new Nodo<>(5);
        head2.siguiente.siguiente = new Nodo<>(6);

        // Mostrar las listas antes de concatenar
        System.out.println("Primera lista de enteros:");
        mostrarLista(head1);
        System.out.println("Segunda lista de enteros:");
        mostrarLista(head2);

        // Concatenar las listas
        Nodo<Integer> listaConcatenada = concatenarListas(head1, head2);

        // Mostrar la lista concatenada
        System.out.println("Lista concatenada:");
        mostrarLista(listaConcatenada);

        // Crear la primera lista enlazada de cadenas
        Nodo<String> headStr1 = new Nodo<>("Hola");
        headStr1.siguiente = new Nodo<>("Mundo");

        // Crear la segunda lista enlazada de cadenas
        Nodo<String> headStr2 = new Nodo<>("Java");
        headStr2.siguiente = new Nodo<>("Generics");

        // Mostrar las listas antes de concatenar
        System.out.println("Primera lista de cadenas:");
        mostrarLista(headStr1);
        System.out.println("Segunda lista de cadenas:");
        mostrarLista(headStr2);

        // Concatenar las listas
        Nodo<String> listaConcatenadaStr = concatenarListas(headStr1, headStr2);

        // Mostrar la lista concatenada
        System.out.println("Lista concatenada de cadenas:");
        mostrarLista(listaConcatenadaStr);
    }
}
