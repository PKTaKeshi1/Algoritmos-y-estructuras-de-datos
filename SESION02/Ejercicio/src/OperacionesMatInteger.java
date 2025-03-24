public class OperacionesMatInteger implements Operable<OperacionesMatInteger> {
    private Integer valor;

    public OperacionesMatInteger(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    @Override
    public OperacionesMatInteger suma(OperacionesMatInteger op) {
        return new OperacionesMatInteger(this.valor + op.valor);
    }

    @Override
    public OperacionesMatInteger resta(OperacionesMatInteger op) {
        return new OperacionesMatInteger(this.valor - op.valor);
    }

    @Override
    public OperacionesMatInteger producto(OperacionesMatInteger op) {
        return new OperacionesMatInteger(this.valor * op.valor);
    }

    @Override
    public OperacionesMatInteger division(OperacionesMatInteger op) {
        if(op.valor == 0) throw new ArithmeticException("División por cero");
        return new OperacionesMatInteger(this.valor / op.valor);
    }

    @Override
    public OperacionesMatInteger potencia(double exponente) {
        return new OperacionesMatInteger((int)Math.pow(this.valor, exponente));
    }

    @Override
    public OperacionesMatInteger raizCuadrada() {
        return new OperacionesMatInteger((int)Math.sqrt(this.valor));
    }

    @Override
    public OperacionesMatInteger raizCubica() {
        return new OperacionesMatInteger((int)Math.cbrt(this.valor));
    }
}
