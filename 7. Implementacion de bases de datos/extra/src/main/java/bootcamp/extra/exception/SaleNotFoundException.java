package bootcamp.extra.exception;

public class SaleNotFoundException extends RuntimeException {

    public SaleNotFoundException(Long id) {
        super(String.format("Sale with id %d not found", id));
    }

}
