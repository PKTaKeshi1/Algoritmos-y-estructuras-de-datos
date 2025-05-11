package Ejercicios.EjercicioPropuesto02;

import Actividades.Act02.Queue;
import Sesion06.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty{
        // Crear una cola de enteros
        Queue<Integer> queueInt = new QueueArray<>(5);
        queueInt.enqueue(10);
        queueInt.enqueue(20);
        queueInt.enqueue(30);
        System.out.println("Cola de enteros: " + queueInt);
        System.out.println("Elemento al frente: " + queueInt.front());
        System.out.println("Elemento eliminado: " + queueInt.dequeue());
        System.out.println("Cola de enteros después de eliminar: " + queueInt);

        // Crear una cola de cadenas
        Queue<String> queueStr = new QueueArray<>(3);
        queueStr.enqueue("Hola");
        queueStr.enqueue("Mundo");
        queueStr.enqueue("Java");
        System.out.println("Cola de cadenas: " + queueStr);
        System.out.println("Elemento al frente: " + queueStr.front());
        System.out.println("Elemento eliminado: " + queueStr.dequeue());
        System.out.println("Cola de cadenas después de eliminar: " + queueStr);

        // Crear una cola de caracteres
        Queue<Character> queueChar = new QueueArray<>(4);
        queueChar.enqueue('A');
        queueChar.enqueue('B');
        queueChar.enqueue('C');
        System.out.println("Cola de caracteres: " + queueChar);
        System.out.println("Elemento al frente: " + queueChar.front());
        System.out.println("Elemento eliminado: " + queueChar.dequeue());
        System.out.println("Cola de caracteres después de eliminar: " + queueChar);
    }
}
