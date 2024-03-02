package org.example.manejo_de_excepciones_p1_vivo.exception;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String message){ super(message); }
}
