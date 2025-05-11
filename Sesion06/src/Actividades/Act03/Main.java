package Actividades.Act03;
import Sesion06.ExceptionIsEmpty;

public class Main {
    public static void main(String[]Args){
        PriorityQueueLinkSort<Integer, Integer> queue = new PriorityQueueLinkSort<>();
        try {
            queue.enqueue(1, 1);
            queue.enqueue(2, 2);
            queue.enqueue(3, 3);
            System.out.println(queue); 
            
            System.out.println("Elemento frente: " + queue.front()); 
            
            System.out.println("Elemento eliminado: " + queue.dequeue()); 
            System.out.println(queue); 
            
            queue.enqueue(4, 4);
            queue.enqueue(5, 5);
            queue.enqueue(6, 1);
            System.out.println(queue); 
            
        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
    }

}
