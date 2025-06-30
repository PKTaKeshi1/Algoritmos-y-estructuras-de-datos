package Ejercicios;

import HashC.HashC;
import HashC.Register;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("===== Ejercicio 2: Resolver colisiones con sondeo lineal =====");

        // Crear tabla hash con tamaño 6
        HashC tabla = new HashC(6);

        // Insertar los valores: 12, 18, 24, 30
        int[] valores = {12, 18, 24, 30};
        for (int val : valores) {
            tabla.insert(new Register(val, "V" + val));
        }

        // Mostrar la tabla hash
        System.out.println("\nTabla hash resultante:");
        tabla.printTable();
    }
}
