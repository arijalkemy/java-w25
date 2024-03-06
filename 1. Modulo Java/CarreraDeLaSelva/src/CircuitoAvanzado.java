public class CircuitoAvanzado extends Circuito{
    public CircuitoAvanzado(int id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }

    @Override
    public double calcularMonto(int edad) {
        if (edad > this.getEdadMenores()) return this.getMontoMayores();
        else throw new RuntimeException("No se pueden inscribir menores");
    }
}
