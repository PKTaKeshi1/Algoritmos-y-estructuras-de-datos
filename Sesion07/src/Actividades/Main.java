package Actividades;

import Actividades.bstreelinklistinterfgeneric.LinkedBST;
import Actividades.Exceptions.*;

public class Main {
    public static void main(String[] args) {
        LinkedBST<Integer> tree = new LinkedBST<>();

        try {
            // Inserción de nodos
            tree.insert(8);
            tree.insert(3);
            tree.insert(1);    // hoja
            tree.insert(20);
            tree.insert(10);   // tiene un hijo
            tree.insert(5);
            tree.insert(4);    // hoja
            tree.insert(9);    // para que 10 tenga 1 hijo (10 -> 9)
            tree.insert(6);    // para que 5 tenga 2 hijos (5 -> 4, 6)

            //  Recorridos
            System.out.println("Recorrido InOrder:");
            tree.inOrder();

            System.out.println("Recorrido PreOrder:");
            tree.preOrder();

            System.out.println("Recorrido PostOrder:");
            tree.postOrder();

            // Representación del árbol
            System.out.println("Árbol BST:");
            System.out.println(tree);

            //  Mínimo y máximo
            System.out.println("Mínimo del árbol: " + tree.getMin());
            System.out.println("Máximo del árbol: " + tree.getMax());

            //  Búsqueda
            System.out.println("¿Existe el 10?: " + tree.search(10));
            try {
                tree.search(100);
            } catch (ItemNotFound e) {
                System.out.println("Elemento 100 no encontrado (manejo correcto).");
            }

            // Eliminación de nodos
            System.out.println("Eliminando nodo hoja (4)...");
            tree.delete(4);
            System.out.println(tree);

            System.out.println("Eliminando nodo con un hijo (10)...");
            tree.delete(10);
            System.out.println(tree);

            System.out.println("Eliminando nodo con dos hijos (5)...");
            tree.delete(5);
            System.out.println(tree);

        } catch (ItemDuplicated e) {
            System.err.println("Duplicado: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.err.println("No encontrado: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Árbol vacío: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }
}

