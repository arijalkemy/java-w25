public class CircuitoAvanzado extends Circuito {
    public CircuitoAvanzado(Integer id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }

    @Override
    public Integer montoAAbonarPor(Participante p) {
        if (p.getEdad() < 18) {
            throw new RuntimeException("No se admite la inscripción de menores de edad en esta categoría");
        } else {
            return 2800;
        }
    }
}
