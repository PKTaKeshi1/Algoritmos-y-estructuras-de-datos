package Actividades.Act02;
import Sesion06.ExceptionIsEmpty;
public class Main {
    public static void main(String[]Args){
        QueueLink<Integer> queue = new QueueLink<>();
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            System.out.println(queue); 
            
            System.out.println("Elemento frente: " + queue.front()); 
            
            System.out.println("Elemento eliminado: " + queue.dequeue()); 
            System.out.println(queue); 
            
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
            System.out.println(queue); 
            
        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        } 
    }

}
