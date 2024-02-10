public class Serie3 extends Serie<Double> {
    private Double valorActual = 0.0;

    @Override
    public Double siguienteValor() {
        valorActual+=3;
        return valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0.0;
    }

    @Override
    public void establecerInicio(Double valor) {
        valorActual = valor;
    }
}
