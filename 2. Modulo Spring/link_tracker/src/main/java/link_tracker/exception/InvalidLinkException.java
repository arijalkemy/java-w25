package link_tracker.exception;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException(){

    }

    public InvalidLinkException(String message){ 
        super(message);
    }
}
