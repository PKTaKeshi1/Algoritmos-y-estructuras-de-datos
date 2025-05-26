package avltree;

public class TestComparativo {
    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        AVLTree<Integer> avl = new AVLTree<>();

        int[] data = {10, 20, 30, 40, 50};

        for (int val : data) {
            bst.insert(val);
            avl.insert(val);
        }

        System.out.println("Altura BST: " + getHeight(bst.root));
        System.out.println("Altura AVL: " + getHeight(avl.root));
    }

    // Altura simple para comparación
    private static int getHeight(Node<?> node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}
