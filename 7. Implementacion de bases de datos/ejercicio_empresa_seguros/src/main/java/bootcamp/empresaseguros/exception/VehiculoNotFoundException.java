package bootcamp.empresaseguros.exception;

public class VehiculoNotFoundException extends RuntimeException {

    public VehiculoNotFoundException(Long id) {
        super(String.format("Vehículo con id %d no encontrado", id));
    }

}
