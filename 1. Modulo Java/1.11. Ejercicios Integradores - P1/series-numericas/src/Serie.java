public abstract class Serie<N extends Number> {
    public abstract N siguienteValor();

    public abstract void reiniciarSerie();

    public abstract void establecerInicio(N valor);
}
