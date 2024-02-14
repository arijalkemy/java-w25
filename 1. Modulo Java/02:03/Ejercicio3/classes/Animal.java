package classes;

public abstract class Animal {
    protected String tipo;

    public abstract void emitirSonido();

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
