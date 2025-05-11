package Ejercicios.EjercicioPropuesto01;
import Actividades.Act01.Stack;
import Actividades.Act03.Node;
import Sesion06.ExceptionIsEmpty;
    
public class StackLink<T> implements Stack<T> {
    private Node<T> top; // Nodo superior de la pila
    private int size;    // Tamaño de la pila

    public StackLink() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top; // El nuevo nodo apunta al nodo superior actual
        top = newNode;      // El nuevo nodo se convierte en el nodo superior
        size++;
    }

    @Override
    public T pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía.");
        }
        T data = top.data;  // Obtener el dato del nodo superior
        top = top.next;     // El nodo superior ahora es el siguiente nodo
        size--;
        return data;
    }

    @Override
    public T peek() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía.");
        }
        return top.data; // Devolver el dato del nodo superior sin eliminarlo
    }

    @Override
    public boolean isEmpty() {
        return top == null; // La pila está vacía si el nodo superior es nulo
    }

    public int size() {
        return size; // Devolver el tamaño de la pila
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> actual = top;
        while (actual != null) {
            sb.append(actual.data).append(" -> ");
            actual = actual.next;
        }
         sb.append("null");
        return sb.toString();
    }
}