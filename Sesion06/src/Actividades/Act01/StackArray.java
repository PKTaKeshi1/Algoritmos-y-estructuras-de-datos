package Actividades.Act01;
import Sesion06.ExceptionIsEmpty;

public class StackArray<E> implements Stack<E> {
    private E[] stack;
    private int top;
    private int n;

    public StackArray(int n) {
        this.n = n;
        stack = (E[]) new Object[n];
        top = -1;
    }

    @Override
    public void push(E x) {
        if (top == n - 1) {
            throw new StackOverflowError("Pila llena");
        }
        stack[++top] = x;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacia");
        }
        return stack[top--];
    }

    @Override
    public E peek() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacia");
        }
        return stack[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: [");
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
