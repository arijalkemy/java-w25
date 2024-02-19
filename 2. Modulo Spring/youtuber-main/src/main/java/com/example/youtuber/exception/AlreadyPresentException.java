package com.example.youtuber.exception;

public class AlreadyPresentException extends RuntimeException{
    public AlreadyPresentException(String message){
        super(message);
    }
}
