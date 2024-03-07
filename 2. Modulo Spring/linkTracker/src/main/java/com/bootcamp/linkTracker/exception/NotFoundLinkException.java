package com.bootcamp.linkTracker.exception;

public class NotFoundLinkException extends RuntimeException{
    public NotFoundLinkException(){}
    public NotFoundLinkException(String message){super(message);}
}
