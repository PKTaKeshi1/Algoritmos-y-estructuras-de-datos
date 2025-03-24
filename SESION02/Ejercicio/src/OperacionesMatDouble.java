public class OperacionesMatDouble implements Operable<OperacionesMatDouble> {
    private Double valor;

    public OperacionesMatDouble(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public OperacionesMatDouble suma(OperacionesMatDouble op) {
        return new OperacionesMatDouble(this.valor + op.valor);
    }

    @Override
    public OperacionesMatDouble resta(OperacionesMatDouble op) {
        return new OperacionesMatDouble(this.valor - op.valor);
    }

    @Override
    public OperacionesMatDouble producto(OperacionesMatDouble op) {
        return new OperacionesMatDouble(this.valor * op.valor);
    }

    @Override
    public OperacionesMatDouble division(OperacionesMatDouble op) {
        if(op.valor == 0.0) throw new ArithmeticException("División por cero");
        return new OperacionesMatDouble(this.valor / op.valor);
    }

    @Override
    public OperacionesMatDouble potencia(double exponente) {
        return new OperacionesMatDouble(Math.pow(this.valor, exponente));
    }

    @Override
    public OperacionesMatDouble raizCuadrada() {
        return new OperacionesMatDouble(Math.sqrt(this.valor));
    }

    @Override
    public OperacionesMatDouble raizCubica() {
        return new OperacionesMatDouble(Math.cbrt(this.valor));
    }
}
