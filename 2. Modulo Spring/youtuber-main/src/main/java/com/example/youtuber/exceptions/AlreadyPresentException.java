package com.example.youtuber.exceptions;

public class AlreadyPresentException extends RuntimeException{
    public AlreadyPresentException(){

    }
    public AlreadyPresentException(String message){
        super(message);
    }
}
