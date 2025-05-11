package Ejercicios.EjercicioPropuesto01;
import Sesion06.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        StackLink<Integer> stackint = new StackLink<>();

        // Operaciones con la pila
        stackint.push(10);
        stackint.push(20);
        stackint.push(30);
        stackint.push(40);
        stackint.push(50);

        System.out.println("Contenido de la pila: " + stackint);
        System.out.println("Elemento superior: " + stackint.peek());
        System.out.println("Tamaño de la pila: " + stackint.size());

        System.out.println("Elemento eliminado: " + stackint.pop());
        System.out.println("Contenido de la pila: " + stackint);
        System.out.println("Elemento superior después de pop: " + stackint.peek());
        System.out.println("Tamaño de la pila después de pop: " + stackint.size());

        System.out.println("¿La pila está vacía? " + stackint.isEmpty());

        System.out.println("-------------------------");
        StackLink<String> stackstr = new StackLink<>();

        // Operaciones con la pila
        stackstr.push("Hola");
        stackstr.push("Mundo");
        stackstr.push("Desde");
        stackstr.push("Java");
        stackstr.push("Pilas");

        System.out.println("Contenido de la pila: " + stackstr);
        System.out.println("Elemento superior: " + stackstr.peek());
        System.out.println("Tamaño de la pila: " + stackstr.size());

        System.out.println("Elemento eliminado: " + stackstr.pop());
        System.out.println("Contenido de la pila: " + stackstr);
        System.out.println("Elemento superior después de pop: " + stackstr.peek());
        System.out.println("Tamaño de la pila después de pop: " + stackstr.size());

        System.out.println("¿La pila está vacía? " + stackstr.isEmpty());

        System.out.println("-------------------------");
        StackLink<Character> stackchar = new StackLink<>();

        // Operaciones con la pila
        stackchar.push('A');
        stackchar.push('B');
        stackchar.push('C');
        stackchar.push('D');
        stackchar.push('E');

        System.out.println("Contenido de la pila: " + stackchar);
        System.out.println("Elemento superior: " + stackchar.peek());
        System.out.println("Tamaño de la pila: " + stackchar.size());

        System.out.println("Elemento eliminado: " + stackchar.pop());
        System.out.println("Contenido de la pila: " + stackchar);
        System.out.println("Elemento superior después de pop: " + stackchar.peek());
        System.out.println("Tamaño de la pila después de pop: " + stackchar.size());

        System.out.println("¿La pila está vacía? " + stackchar.isEmpty());
    }
}


