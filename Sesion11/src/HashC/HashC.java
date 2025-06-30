package HashC;

/**
 * Implementación de una tabla hash con sondeo lineal.
 */
public class HashC {

    /**
     * Clase interna que representa un elemento de la tabla hash.
     */
    private static class Element {
        Register register;
        boolean isAvailable;

        /**
         * Constructor del elemento, inicialmente disponible.
         */
        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    /**
     * Constructor que permite definir el tamaño de la tabla hash.
     *  size Tamaño de la tabla.
     */
    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    /**
     * Constructor por defecto (tamaño 10).
     */
    public HashC() {
        this(10); 
    }

    /**
     * Función hash simple.
     *  key Clave a hashear.
     *  Índice en la tabla.
     */
    private int hash(int key) {
        return key % size;
    }

    /**
     * Inserta un registro en la tabla hash usando sondeo lineal.
     *  reg Registro a insertar.
     */
    public void insert(Register reg) {
        int index = hash(reg.getKey());
        int startIndex = index;
        while (!table[index].isAvailable) {
            index = (index + 1) % size;
            if (index == startIndex) {
                System.out.println("La tabla hash está llena. No se puede insertar: " + reg);
                return;
            }
        }
        table[index].register = reg;
        table[index].isAvailable = false;
    }

    /**
     * Busca un registro por su clave.
     *  key Clave a buscar.
     *  El registro encontrado o null si no existe.
     */
    public Register search(int key) {
        int index = hash(key);
        int startIndex = index;
        while (!table[index].isAvailable) {
            if (table[index].register != null && table[index].register.getKey() == key) {
                return table[index].register;
            }
            index = (index + 1) % size;
            if (index == startIndex) {
                break; 
            }
        }
        return null;
    }

    /**
     * Elimina un registro por su clave.
     *  key Clave a eliminar.
     */
    public void delete(int key) {
        int index = hash(key);
        while (!table[index].isAvailable) {
            if (table[index].register.getKey() == key) {
                table[index].isAvailable = true; 
                table[index].register = null; 
                return;
            }
            index = (index + 1) % size; 
        }
    }

    /**
     * Imprime el contenido de la tabla hash.
     */
    public void printTable() {
        for (int i = 0; i < size; i++) {
            if (!table[i].isAvailable) {
                System.out.println("Index " + i + ": " + table[i].register);
            } else {
                System.out.println("Index " + i + ": Available");
            }
        }
    }
}
