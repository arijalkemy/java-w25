package bootcamp.qatesters.exception;

public class TestCaseNotFoundException extends RuntimeException {

    public TestCaseNotFoundException(long id) {
        super(String.format("Test case with id %d not found", id));
    }

}
