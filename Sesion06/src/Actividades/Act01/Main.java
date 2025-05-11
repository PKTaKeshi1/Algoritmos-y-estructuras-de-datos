package Actividades.Act01;
import Sesion06.ExceptionIsEmpty;

public class Main {
    public static void main(String[] args) {
        StackArray<Integer> stack = new StackArray<>(5);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            System.out.println(stack); 
            
            System.out.println("Elemento superior: " + stack.peek()); 
            
            System.out.println("Elemento eliminado: " + stack.pop()); 
            System.out.println(stack); 
            
            stack.push(4);
            stack.push(5);
            stack.push(6);
            System.out.println(stack); 
            
        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }
}
