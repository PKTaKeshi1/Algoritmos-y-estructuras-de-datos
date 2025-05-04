package Sesion05.src.Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class invertirLista {

    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInvertida.add(lista.get(i));
        }
        return listaInvertida;
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

        List<Integer> numerosInvertidos = invertirLista(numeros);
        System.out.println("Original: " + numeros);
        System.out.println("Invertida: " + numerosInvertidos);

        System.out.println("===================================");

        // Ingresar palabras
        System.out.println("Ingrese palabras separadas por espacio:");
        String inputPalabras = scanner.nextLine();
        String[] palabrasArray = inputPalabras.split(" ");
        List<String> palabras = new ArrayList<>();
        for (String palabra : palabrasArray) {
            palabras.add(palabra);
        }

        List<String> palabrasInvertidas = invertirLista(palabras);
        System.out.println("Original: " + palabras);
        System.out.println("Invertida: " + palabrasInvertidas);

        scanner.close();
    }
}