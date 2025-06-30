package HashO;

public class TestHashO {
    public static void main(String[] args) {
        HashO hashTable = new HashO(5); // Tamaño pequeño para provocar colisiones

        System.out.println("Insertando registros:");
        hashTable.insert(new Register(10, "Juan"));
        hashTable.insert(new Register(15, "Ana"));
        hashTable.insert(new Register(20, "Luis"));
        hashTable.insert(new Register(25, "Rosa"));
        hashTable.insert(new Register(30, "Pedro"));
        hashTable.insert(new Register(5, "Carlos")); // Colisión con 10

        System.out.println("\nTabla hash con encadenamiento:");
        hashTable.printTable();

        System.out.println("\nBuscando la clave 20:");
        Register r = hashTable.search(20);
        if (r != null) {
            System.out.println("Encontrado: " + r);
        } else {
            System.out.println("No se encontró la clave.");
        }

        System.out.println("\nEliminando la clave 15:");
        hashTable.delete(15);
        hashTable.printTable();
    }
}
