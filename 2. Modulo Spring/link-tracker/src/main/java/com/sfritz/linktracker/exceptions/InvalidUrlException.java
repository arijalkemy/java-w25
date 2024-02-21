package com.sfritz.linktracker.exceptions;

public class InvalidUrlException extends RuntimeException{

    public InvalidUrlException(String message){
        super(message);
    }
}
