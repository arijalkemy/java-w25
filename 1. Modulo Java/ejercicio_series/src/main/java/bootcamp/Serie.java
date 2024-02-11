package bootcamp;

public abstract class Serie<T extends Number> {
    private T valorInicial;
    private Integer cantIncrementos = 0;

    public Serie() {
        valorInicial = (T)Integer.valueOf(0);
    }

    public Serie(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract T siguienteValor();
    public void reiniciar(){
        cantIncrementos = 0;
    }

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getCantIncrementos() {
        return cantIncrementos;
    }

    public void setCantIncrementos(int cantIncrementos) {
        this.cantIncrementos = cantIncrementos;
    }

}
