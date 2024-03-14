package bootcamp.crudjpajewerly.exception;

public class JewerlyNotFoundException extends RuntimeException {

    public JewerlyNotFoundException(long id) {
        super(String.format("Jewerly with id %d not found", id));
    }

}
