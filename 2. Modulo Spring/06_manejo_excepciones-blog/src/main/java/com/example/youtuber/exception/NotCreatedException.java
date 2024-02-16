package com.example.youtuber.exception;

public class NotCreatedException extends RuntimeException{
    public NotCreatedException(){}

    public NotCreatedException(String message){
        super(message);
    }
}
