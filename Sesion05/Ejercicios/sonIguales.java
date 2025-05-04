package Sesion05.src.Ejercicios;

public class sonIguales {

    // Clase Nodo genérica
    static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Método genérico para comparar dos listas enlazadas
    public static <T> boolean sonIguales(Nodo<T> head1, Nodo<T> head2) {
        Nodo<T> actual1 = head1;
        Nodo<T> actual2 = head2;

        while (actual1 != null && actual2 != null) {
            if (!actual1.dato.equals(actual2.dato)) {
                return false; // Si los datos no coinciden, las listas no son iguales
            }
            actual1 = actual1.siguiente;
            actual2 = actual2.siguiente;
        }

        // Si una lista es más larga que la otra, no son iguales
        return actual1 == null && actual2 == null;
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
        // Crear dos listas enlazadas de enteros
        Nodo<Integer> head1 = new Nodo<>(1);
        head1.siguiente = new Nodo<>(2);
        head1.siguiente.siguiente = new Nodo<>(3);

        Nodo<Integer> head2 = new Nodo<>(1);
        head2.siguiente = new Nodo<>(2);
        head2.siguiente.siguiente = new Nodo<>(3);

        // Mostrar las listas
        System.out.println("Lista 1:");
        mostrarLista(head1);
        System.out.println("Lista 2:");
        mostrarLista(head2);

        // Comparar las listas
        boolean iguales = sonIguales(head1, head2);
        System.out.println("¿Las listas son iguales? " + iguales);

        // Crear dos listas enlazadas de cadenas
        Nodo<String> headStr1 = new Nodo<>("Hola");
        headStr1.siguiente = new Nodo<>("Mundo");

        Nodo<String> headStr2 = new Nodo<>("Hola");
        headStr2.siguiente = new Nodo<>("Java");

        // Mostrar las listas
        System.out.println("Lista de cadenas 1:");
        mostrarLista(headStr1);
        System.out.println("Lista de cadenas 2:");
        mostrarLista(headStr2);

        // Comparar las listas
        boolean igualesStr = sonIguales(headStr1, headStr2);
        System.out.println("¿Las listas son iguales? " + igualesStr);
    }
}
