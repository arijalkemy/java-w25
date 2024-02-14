package org.example.ejercicio_exceptions.exception;

public class UniqueIdConstraintException extends RuntimeException{
    public UniqueIdConstraintException(String message){
        super(message);
    }
}
