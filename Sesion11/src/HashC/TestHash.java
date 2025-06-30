package HashC;

/**
 * Clase de prueba para la tabla hash.
 * Inserta varios registros, muestra la tabla, elimina una clave y busca otra.
 */
public class TestHash {
    public static void main(String[] args) {
        // Se recomienda aumentar el tamaño de la tabla para evitar llenado
        HashC hashTable = new HashC(10);

        // Insertar registros
        System.out.println("Insertando registros en la tabla hash:");
        hashTable.insert(new Register(34, "A"));
        hashTable.insert(new Register(3, "B"));
        hashTable.insert(new Register(7, "C"));
        hashTable.insert(new Register(30, "D"));
        hashTable.insert(new Register(11, "E"));
        hashTable.insert(new Register(8, "F"));
        hashTable.insert(new Register(7, "G")); // clave repetida
        hashTable.insert(new Register(23, "H"));
        hashTable.insert(new Register(41, "I"));
        hashTable.insert(new Register(16, "J"));
        hashTable.insert(new Register(34, "K")); // clave repetida
        
        
        System.out.println("\nTabla hash despues de insertar:");
        hashTable.printTable();
        // Eliminar la clave 30
        hashTable.delete(30);

        System.out.println("\nTabla hash después de eliminar la clave 30:");
        hashTable.printTable();

        // Buscar la clave 23
        Register result = hashTable.search(23);
        System.out.println("\nResultado de buscar la clave 23:");
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("No se encontró la clave 23.");
        }
    }
}