package avltree;

public class BSTree<E extends Comparable<E>> {
    protected Node<E> root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E data) {
        root = insert(root, data);
    }

    protected Node<E> insert(Node<E> node, E data) {
        if (node == null) return new Node<>(data);
        if (data.compareTo(node.data) < 0)
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insert(node.right, data);
        return node;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node<E> node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node + " ");
            inorder(node.right);
        }
    }
}
