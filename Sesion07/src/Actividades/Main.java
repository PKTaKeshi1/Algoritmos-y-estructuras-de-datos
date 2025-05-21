package Actividades;
import Actividades.bstreelinklistinterfgeneric.LinkedBST;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> tree = new LinkedBST<>();
        try {
            tree.insert(8);
            tree.insert(3);
            tree.insert(1);
            tree.insert(20);
            tree.insert(10);
            tree.insert(5);
            tree.insert(4);

            System.out.println("InOrder:");
            tree.inOrder();

            System.out.println("PreOrder:");
            tree.preOrder();

            System.out.println("PostOrder:");
            tree.postOrder();

            System.out.println("Árbol:");
            System.out.println(tree);

            System.out.println("Mínimo del árbol: " + tree.getMin());
            System.out.println("Máximo del árbol: " + tree.getMax());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

