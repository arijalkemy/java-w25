package com.example.youtuber.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){

    }
    public NotFoundException(String message){
        super(message);
    }
}
