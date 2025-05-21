package Actividades.bstreelinklistinterfgeneric;

import Actividades.bstreeInterface.BinarySearchTree;
import Actividades.Exceptions.*;

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
}