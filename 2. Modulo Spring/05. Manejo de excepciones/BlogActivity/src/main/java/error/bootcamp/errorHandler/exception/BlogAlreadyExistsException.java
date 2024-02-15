package error.bootcamp.errorHandler.exception;


public class BlogAlreadyExistsException extends RuntimeException{

    public BlogAlreadyExistsException(String message){
        super(message);
    }

}
