package bootcamp.crudjpa.exception;

public class StudentAlreadyExistsException extends RuntimeException {

    public StudentAlreadyExistsException(long id) {
        super(String.format("Student with id %d already exists", id));
    }

}
