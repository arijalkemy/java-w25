package bootcamp.springejerciciospracticosp2vivo.exception;

public class PlateWithNoValidIngredientsException extends Exception {

    public PlateWithNoValidIngredientsException(String name) {
        super(String.format("The plate '" + name + "' has no valid ingredients."));
    }

}
