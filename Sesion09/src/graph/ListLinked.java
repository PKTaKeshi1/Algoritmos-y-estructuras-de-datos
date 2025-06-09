package graph;

public class ListLinked<T> {
    public static class Node<T> {
        public T data;
        public Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public ListLinked() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next == null) return false;
        current.next = current.next.next;
        return true;
    }

    public boolean contains(Vertex<T> vDes) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(vDes)) return true;
            current = current.next;
        }
        return false;
    }

    public void clear() {
        head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getNext(Node<T> node) {
        if (node == null) return null;
        return node.next;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null && !current.data.toString().contains("\n")) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
