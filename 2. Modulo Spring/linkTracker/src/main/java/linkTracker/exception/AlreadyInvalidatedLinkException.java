package linkTracker.exception;

public class AlreadyInvalidatedLinkException extends RuntimeException{
    public AlreadyInvalidatedLinkException(){

    }

    public AlreadyInvalidatedLinkException(String message){
        super(message);
    }
}
