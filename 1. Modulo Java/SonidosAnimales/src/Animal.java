public abstract class Animal {

    String nombre;
    String tipo;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void emitirSonido();
}
