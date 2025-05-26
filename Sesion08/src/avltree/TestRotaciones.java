package avltree;

public class TestRotaciones {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        int[] inserciones = {30, 20, 10, 40, 50, 25, 5};
        for (int val : inserciones) {
            System.out.println("Insertando: " + val);
            tree.insert(val);
            tree.preorder();
        }

        int[] eliminaciones = {50, 40};
        for (int val : eliminaciones) {
            System.out.println("Eliminando: " + val);
            tree.delete(val);
            tree.preorder();
        }
    }
}
