package org.example.recapitulandospringp2vivo.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(){

    }

    public NotFoundException (String message){
        super(message);
    }
}
