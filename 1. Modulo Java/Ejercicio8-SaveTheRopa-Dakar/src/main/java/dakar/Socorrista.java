package dakar;

public interface Socorrista<T extends Vehiculo> {
    void socorrer(T v);
}
