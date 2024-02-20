public class CircuitoChico extends Circuito {
    public CircuitoChico(Integer id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }

    @Override
    public Integer montoAAbonarPor(Participante p) {
        if (p.getEdad() < 18) {
            return 1300;
        } else {
            return 1500;
        }
    }
}
