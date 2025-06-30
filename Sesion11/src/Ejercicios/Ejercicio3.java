package Ejercicios;

import HashO.HashO;
import HashO.Register;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("===== Ejercicio 3: Usando HashO (hash abierto con encadenamiento) =====");

        HashO tabla = new HashO(5);

        tabla.insert(new Register(10, "Juan"));
        tabla.insert(new Register(15, "Ana"));
        tabla.insert(new Register(20, "Luis"));
        tabla.insert(new Register(25, "Rosa"));

        System.out.println("\nTabla después de insertar:");
        tabla.printTable();

        System.out.println("\nBuscando clave 20:");
        Register r = tabla.search(20);
        System.out.println(r != null ? "Encontrado: " + r : "No se encontró");

        System.out.println("\nBuscando clave 30:");
        Register r2 = tabla.search(30);
        System.out.println(r2 != null ? "Encontrado: " + r2 : "No se encontró");
    }
}
