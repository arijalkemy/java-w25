package com.bootcamp.linkTracker.exception;

public class InvalidateLinkException extends RuntimeException{
    public InvalidateLinkException(){}
    public InvalidateLinkException(String message){super(message);}
}