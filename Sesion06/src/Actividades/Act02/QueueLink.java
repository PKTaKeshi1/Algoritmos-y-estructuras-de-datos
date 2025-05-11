package Actividades.Act02;
import Sesion06.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x){
        Node<E> aux = new Node<>(x, null);
        if (isEmpty()) {
            first = aux;
            last = aux;
        } else {
            last.setNext(aux);
            last = aux;
        }
    }
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        } else {
            E x = first.getElement();
            first = first.getNext();
            if (first == null) {
                last = null;
            }
            return x;
        }
    }
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        } else {
            return first.getElement();
        }
    }
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacia");
        } else {
            return last.getElement();
        }
    }
    public boolean isEmpty() {
        return first == null;
    }
public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            sb.append(current.getElement()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim(); // Remove trailing space
    }

}
