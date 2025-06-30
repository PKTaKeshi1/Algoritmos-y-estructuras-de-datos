package Ejercicios;

import HashC.HashC;
import HashC.Register;

public class Ejercicio1 {
    public static void main(String[] args) {
        System.out.println("===== Ejercicio 1: Insertar sin colisiones =====");

        // Crear tabla hash con tamaño 7
        HashC tabla = new HashC(7);

        // Insertar los valores: 3, 10, 17, 24
        int[] valores = {3, 10, 17, 24};
        for (int val : valores) {
            tabla.insert(new Register(val, "V" + val));
        }

        // Mostrar la tabla hash
        System.out.println("\nTabla hash resultante:");
        tabla.printTable();
    }
}
