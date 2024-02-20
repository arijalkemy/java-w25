public class CircuitoMedio extends Circuito {
    @Override
    public Integer montoAAbonarPor(Participante p) {
        if (p.getEdad() < 18) {
            return 2000;
        } else {
            return 2300;
        }
    }

    public CircuitoMedio(Integer id, String nombre, String descripcion) {
        super(id, nombre, descripcion);
    }
}
