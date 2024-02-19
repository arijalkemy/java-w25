package com.bootcampW22.EjercicioGlobal.exception;

public class AlreadyCreated extends RuntimeException{
    public AlreadyCreated(String message) {
        super(message);
    }
}
