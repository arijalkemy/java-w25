package bootcamp.springejerciciospracticosp2vivo.exception;

public class IngredientNotFoundException extends Exception {

    public IngredientNotFoundException(String name) {
        super(String.format("The ingredient '" + name + "' was not found."));
    }

}
