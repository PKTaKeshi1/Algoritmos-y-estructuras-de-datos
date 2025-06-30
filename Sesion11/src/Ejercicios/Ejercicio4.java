package Ejercicios;

import HashC.HashC;
import HashC.Register;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("===== Ejercicio 4: Eliminación lógica y búsqueda en HashC =====");

        HashC tabla = new HashC(7);

        tabla.insert(new Register(5, "Cinco"));
        tabla.insert(new Register(12, "Doce"));
        tabla.insert(new Register(19, "Diecinueve"));

        System.out.println("\nTabla antes de eliminar 12:");
        tabla.printTable();

        tabla.delete(12);

        System.out.println("\nTabla después de eliminar 12:");
        tabla.printTable();

        System.out.println("\nBuscando 19:");
        Register r = tabla.search(19);
        System.out.println(r != null ? "Encontrado: " + r : "No encontrado");
    }
}
