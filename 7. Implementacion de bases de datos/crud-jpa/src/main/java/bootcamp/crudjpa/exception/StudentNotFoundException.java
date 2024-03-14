package bootcamp.crudjpa.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(long id) {
        super(String.format("Student with id %d not found", id));
    }

}
