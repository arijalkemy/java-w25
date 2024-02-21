package com.sfritz.blog.exceptions;

public class AlreadyPresentException extends RuntimeException{

    public AlreadyPresentException(String message){
        super(message);
    }
}
