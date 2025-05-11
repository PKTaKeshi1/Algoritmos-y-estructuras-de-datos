package Ejercicios.EjercicioPropuesto04;

import Ejercicios.EjercicioPropuesto01.StackLink;
import Sesion06.ExceptionIsEmpty;

public class Application {

    public static boolean symbolBalancing(String S) throws ExceptionIsEmpty {
        StackLink<Character> stack = new StackLink<>();

        for (char c : S.toCharArray()) {
            // Si es un corchete de apertura, lo apilamos
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // Si es un corchete de cierre, verificamos el tope de la pila
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // No hay un corchete de apertura correspondiente
                }
                char top = stack.pop();
                // Verificamos si el corchete de cierre corresponde al de apertura
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // Si la pila está vacía al final, la secuencia está correctamente anidada
        return stack.isEmpty();
    }

    public static void main(String[] args) throws ExceptionIsEmpty {
        // Ejemplos de prueba
        System.out.println(symbolBalancing("()()[()]")); // true
        System.out.println(symbolBalancing("[(()]"));    // false
        System.out.println(symbolBalancing("{[()]}"));   // true
        System.out.println(symbolBalancing(""));         // true
        System.out.println(symbolBalancing("[(])"));     // false
    }
}