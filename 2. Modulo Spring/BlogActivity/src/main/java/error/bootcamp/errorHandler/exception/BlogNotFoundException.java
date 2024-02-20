package error.bootcamp.errorHandler.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException(String message){
        super(message);
    }
}
