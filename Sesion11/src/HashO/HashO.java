package HashO;

import java.util.LinkedList;

public class HashO {
    private LinkedList<Register>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int index = hash(reg.getKey());
        // Verificamos si ya existe la clave para evitar duplicados
        for (Register r : table[index]) {
            if (r.getKey() == reg.getKey()) {
                System.out.println("Clave duplicada: " + reg.getKey());
                return;
            }
        }
        table[index].add(reg);
    }

    public Register search(int key) {
        int index = hash(key);
        for (Register r : table[index]) {
            if (r.getKey() == key) {
                return r;
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        table[index].removeIf(r -> r.getKey() == key);
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            if (table[i].isEmpty()) {
                System.out.println("Vacío");
            } else {
                for (Register r : table[i]) {
                    System.out.print(r + " -> ");
                }
                System.out.println("null");
            }
        }
    }
}
