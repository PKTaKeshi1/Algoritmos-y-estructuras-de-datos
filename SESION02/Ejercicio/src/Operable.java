public interface Operable<E> {
    E suma(E op);
    E resta(E op);
    E producto(E op);
    E division(E op);
    E potencia(double exponente);
    E raizCuadrada();
    E raizCubica();
}
