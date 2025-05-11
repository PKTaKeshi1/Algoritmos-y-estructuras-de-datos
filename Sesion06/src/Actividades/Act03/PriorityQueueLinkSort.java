package Actividades.Act03;
import Sesion06.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N> implements PriorityQueue<E, N> {

    class EntryNode{
        E data;
        N priority;
        EntryNode (E data, N priority){
            this.data = data;
            this.priority = priority;
        }
        }
    private Node<EntryNode> first;
    private Node<EntryNode> last;

    public PriorityQueueLinkSort(){
        first = null;
        last = null;
    }

    public void enqueue(E data, N priority) {
        EntryNode newEntry = new EntryNode(data, priority);
        Node<EntryNode> newNode = new Node<>(newEntry);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            Node<EntryNode> current = first;
            Node<EntryNode> previous = null;
            while (current != null && ((Comparable<N>) current.getData().priority).compareTo(priority) < 0) {
                previous = current;
                current = current.getNext();
            }
            if (previous == null) {
                newNode.setNext(first);
                first = newNode;
            } else {
                previous.setNext(newNode);
                newNode.setNext(current);
            }
            if (current == null) {
                last = newNode;
            }
        }
    }
    public E dequeue() throws ExceptionIsEmpty {
        if (first == null) {
            return null;
        }
        E data = first.getData().data;
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        return data;
    }
    public E back() throws ExceptionIsEmpty {
        if (first == null) {
            return null;
        }
        return first.getData().data;
    }
    public E front() throws ExceptionIsEmpty {
        if (first == null) {
            return null;
        }
        return last.getData().data;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> current = first;
        while (current != null) {
            sb.append(current.getData().data).append(" (").append(current.getData().priority).append(") ");
            current = current.getNext();
        }
        return sb.toString();
    }
}