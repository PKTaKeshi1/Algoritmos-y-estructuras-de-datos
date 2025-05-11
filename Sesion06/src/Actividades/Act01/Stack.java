package Actividades.Act01;
import Sesion06.ExceptionIsEmpty;

public interface Stack<E> {
    void push(E x); 
    E pop() throws ExceptionIsEmpty; 
    E peek() throws ExceptionIsEmpty; 
    boolean isEmpty(); 

}
