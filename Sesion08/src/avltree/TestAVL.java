package avltree;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();

        int[] elementos = {30, 15, 20, 50, 40, 60, 70, 10, 25, 45, 55, 65, 75};
        for (int e : elementos) {
            System.out.println("Insertando: " + e);
            tree.insert(e);
            tree.preorder(); // para visualizar rotaciones
        }

        System.out.println("\nRecorrido final inorden:");
        tree.inorder();
    }
}
