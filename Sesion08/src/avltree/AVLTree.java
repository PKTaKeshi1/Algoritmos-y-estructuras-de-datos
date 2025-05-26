package avltree;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    @Override
    public void insert(E data) {
        root = insert((NodeAVL<E>) root, data);
    }

    private NodeAVL<E> insert(NodeAVL<E> node, E data) {
        if (node == null)
            return new NodeAVL<>(data);

        if (data.compareTo(node.data) < 0) {
            node.left = insert((NodeAVL<E>) node.left, data);
            node.bf--;
        } else if (data.compareTo(node.data) > 0) {
            node.right = insert((NodeAVL<E>) node.right, data);
            node.bf++;
        }

        // balanceo si es necesario
        if (node.bf == -2)
            return balanceToRight(node);
        else if (node.bf == 2)
            return balanceToLeft(node);

        return node;
    }

    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> child = (NodeAVL<E>) node.right;
        if (child.bf >= 0) {
            return rotateSL(node);
        } else {
            node.right = rotateSR(child);
            return rotateSL(node);
        }
    }

    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> child = (NodeAVL<E>) node.left;
        if (child.bf <= 0) {
            return rotateSR(node);
        } else {
            node.left = rotateSL(child);
            return rotateSR(node);
        }
    }

    private NodeAVL<E> rotateSL(NodeAVL<E> a) {
        NodeAVL<E> b = (NodeAVL<E>) a.right;
        a.right = b.left;
        b.left = a;
        a.bf = b.bf = 0;
        return b;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> b) {
        NodeAVL<E> a = (NodeAVL<E>) b.left;
        b.left = a.right;
        a.right = b;
        a.bf = b.bf = 0;
        return a;
    }

    public void preorder() {
        preorder((NodeAVL<E>) root);
        System.out.println();
    }

    private void preorder(NodeAVL<E> node) {
        if (node != null) {
            System.out.print(node + " ");
            preorder((NodeAVL<E>) node.left);
            preorder((NodeAVL<E>) node.right);
        }
    }
    public void delete(E data) {
    root = delete((NodeAVL<E>) root, data);
}

private NodeAVL<E> delete(NodeAVL<E> node, E data) {
    if (node == null) return null;

    int cmp = data.compareTo(node.data);
    if (cmp < 0) {
        node.left = delete((NodeAVL<E>) node.left, data);
        node.bf++; // subió por izquierda → árbol derecho crece
    } else if (cmp > 0) {
        node.right = delete((NodeAVL<E>) node.right, data);
        node.bf--;
    } else {
        // Nodo con 0 o 1 hijo
        if (node.left == null) return (NodeAVL<E>) node.right;
        else if (node.right == null) return (NodeAVL<E>) node.left;

        // Caso 3: dos hijos → reemplazar por mínimo de subárbol derecho
        NodeAVL<E> min = findMin((NodeAVL<E>) node.right);
        node.data = min.data;
        node.right = delete((NodeAVL<E>) node.right, min.data);
        node.bf--;
    }

    // Rebalanceo
    if (node.bf == 2) return balanceToLeft(node);
    if (node.bf == -2) return balanceToRight(node);

    return node;
}

private NodeAVL<E> findMin(NodeAVL<E> node) {
    while (node.left != null)
        node = (NodeAVL<E>) node.left;
    return node;
}


public void printBFS() {
    if (root == null) return;

    Queue<NodeAVL<E>> queue = new LinkedList<>();
    queue.add((NodeAVL<E>) root);

    while (!queue.isEmpty()) {
        NodeAVL<E> node = queue.poll();
        System.out.print(node + " ");

        if (node.left != null) queue.add((NodeAVL<E>) node.left);
        if (node.right != null) queue.add((NodeAVL<E>) node.right);
    }
    System.out.println();
}

}
