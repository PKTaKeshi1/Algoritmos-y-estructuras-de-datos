package Sesion05.src.Ejercicios;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class buscarElemento {

    public static <T> boolean buscarElemento(List<T> lista, T valor) {
        for (T elemento : lista) {
            if (elemento.equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingresar números
        System.out.println("Ingrese números separados por espacio:");
        String inputNumeros = scanner.nextLine();
        String[] numerosArray = inputNumeros.split(" ");
        List<Integer> numeros = new ArrayList<>();
        for (String num : numerosArray) {
            numeros.add(Integer.parseInt(num));
        }
        System.out.println("Ingrese el número a buscar:");
        int valor = scanner.nextInt();
        boolean encontrado = buscarElemento(numeros, valor);
        System.out.println("Número " + (encontrado ? "encontrado" : "no encontrado") + ": " + valor);
        scanner.nextLine(); // Limpiar el buffer 
        System.out.println("===================================");

        // Ingresar palabras
        System.out.println("Ingrese palabras separadas por espacio:");
        String inputPalabras = scanner.nextLine();
        String[] palabrasArray = inputPalabras.split(" ");
        List<String> palabras = new ArrayList<>();
        for (String palabra : palabrasArray) {
            palabras.add(palabra);
        }
        System.out.println("Ingrese la palabra a buscar:");
        String valorPalabra = scanner.nextLine();
        boolean encontradoPalabra = buscarElemento(palabras, valorPalabra);
        System.out.println("Palabra " + (encontradoPalabra ? "encontrada" : "no encontrada") + ": " + valorPalabra);

        scanner.close();
        
    }
}