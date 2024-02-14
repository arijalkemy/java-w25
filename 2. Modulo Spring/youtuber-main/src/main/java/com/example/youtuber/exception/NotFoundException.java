package com.example.youtuber.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){}

    public NotFoundException (String message){
        super(message);
    }
}
