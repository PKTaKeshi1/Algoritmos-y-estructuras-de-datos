package EjerciciosPropuestos.bstreelinklistinterfgeneric;

import EjerciciosPropuestos.bstreeInterface.BinarySearchTree;
import EjerciciosPropuestos.Exceptions.*;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    private static class Node<E> {
        E data;
        Node<E> left, right;

        Node(E data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> node, E data) throws ItemDuplicated {
        if (node == null) return new Node<>(data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0) node.left = insertRec(node.left, data);
        else if (cmp > 0) node.right = insertRec(node.right, data);
        else throw new ItemDuplicated("Elemento duplicado: " + data);
        return node;
    }

    @Override
    public boolean search(E data) throws ItemNotFound {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<E> node, E data) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Elemento no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0) return searchRec(node.left, data);
        else if (cmp > 0) return searchRec(node.right, data);
        return true;
    }

    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNotFound {
        if (root == null) throw new ExceptionIsEmpty("El árbol está vacío.");
        root = deleteRec(root, data);
    }

    private Node<E> deleteRec(Node<E> node, E data) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Elemento no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0) node.left = deleteRec(node.left, data);
        else if (cmp > 0) node.right = deleteRec(node.right, data);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<E> temp = findMinNode(node.right);
            node.data = temp.data;
            node.right = deleteRec(node.right, temp.data);
        }
        return node;
    }

    // Mínimo y máximo
    private Node<E> findMinNode(Node<E> node) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Subárbol vacío. No se puede encontrar el mínimo.");
        Node<E> current = node;
        while (current.left != null) {
            current = current.left;
        }
        if (!search(current.data)) throw new ItemNotFound("El mínimo no se encuentra en el árbol.");
        return current;
    }

    private Node<E> findMaxNode(Node<E> node) throws ItemNotFound {
        if (node == null) throw new ItemNotFound("Subárbol vacío. No se puede encontrar el máximo.");
        Node<E> current = node;
        while (current.right != null) {
            current = current.right;
        }
        if (!search(current.data)) throw new ItemNotFound("El máximo no se encuentra en el árbol.");
        return current;
    }

    public E getMin() throws ItemNotFound {
        return findMinNode(root).data;
    }

    public E getMax() throws ItemNotFound {
        return findMaxNode(root).data;
    }

    // Recorridos
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<E> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node<E> node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.data + " ");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb, 0);
        return sb.toString();
    }

    private void toStringRec(Node<E> node, StringBuilder sb, int depth) {
        if (node != null) {
            toStringRec(node.right, sb, depth + 1);
            sb.append(" ".repeat(depth * 4)).append(node.data).append("\n");
            toStringRec(node.left, sb, depth + 1);
        }
    }

    // Ejercicio 1a: eliminar todos los nodos
    public void destroyNodes() throws ExceptionIsEmpty {
        if (root == null) throw new ExceptionIsEmpty("El árbol ya está vacío.");
        root = null;
    }

    // Ejercicio 1b: contar todos los nodos (incluso hojas)
    public int countAllNodes() {
        return countAllNodesRec(root);
    }

    private int countAllNodesRec(Node<E> node) {
        if (node == null) return 0;
        return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
    }

    // Ejercicio 1c: contar solo hojas
    public int countLeafNodes() {
        return countLeafNodesRec(root);
    }

    private int countLeafNodesRec(Node<E> node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeafNodesRec(node.left) + countLeafNodesRec(node.right);
    }

    // Ejercicio 1d: altura desde nodo x (no recursivo)
    public int height(E data) {
        Node<E> node = root;
        while (node != null) {
            int cmp = data.compareTo(node.data);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else break;
        }
        if (node == null) return -1;
        return heightIterative(node);
    }

    private int heightIterative(Node<E> node) {
        if (node == null) return -1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(node);
        int height = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node<E> current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            height++;
        }
        return height;
    }

    // Ejercicio 1e: amplitud por nivel
    public int amplitude(int levelTarget) {
        if (root == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            if (level == levelTarget) return levelSize;
            while (levelSize-- > 0) {
                Node<E> current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            level++;
        }
        return 0;
    }

    // Ejercicio 2a: área = hojas × altura total
    public int areaBST() {
        int hojas = countLeafNodes();
        int altura = heightIterative(root);
        return hojas * altura;
    }

    // Ejercicio 2b: dibujar árbol
    public void drawBST() {
        System.out.println(toString());
    }

    // Ejercicio 2c: comparar áreas
    public boolean sameArea(LinkedBST<E> other) {
        return this.areaBST() == other.areaBST();
    }

    // Ejercicio 3: imprimir con sangría y paréntesis
    public String parenthesize() {
        StringBuilder sb = new StringBuilder();
        parenthesizeRec(root, sb, 0);
        return sb.toString();
    }

    private void parenthesizeRec(Node<E> node, StringBuilder sb, int level) {
        if (node == null) return;
        sb.append(" ".repeat(level * 4)).append("(").append(node.data).append("\n");
        parenthesizeRec(node.left, sb, level + 1);
        parenthesizeRec(node.right, sb, level + 1);
        sb.append(" ".repeat(level * 4)).append(")\n");
    }
}