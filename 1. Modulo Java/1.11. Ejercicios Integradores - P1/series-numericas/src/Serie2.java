public class Serie2 extends Serie<Integer> {
    private Integer valorActual = 0;

    @Override
    public Integer siguienteValor() {
        valorActual+=2;
        return valorActual;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0;
    }

    @Override
    public void establecerInicio(Integer valor) {
        valorActual = valor;
    }
}
