package HashC;

/**
 * Clase que representa un registro con una clave y un nombre.
 */
public class Register {
    private int key;
    private String name;

    /**
     * Constructor del registro.
     * Clave del registro.
     * Nombre asociado al registro.
     */
    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Obtiene la clave del registro.
     * Clave.
     */
    public int getKey() {
        return key;
    }

    /**
     * Obtiene el nombre del registro.
     * Nombre.
     */
    public String getName() {
        return name;
    }

    /**
     * Representación en texto del registro.
     */
    public String toString() {
        return "(" + key + ", " + name + ")";
    }
}
