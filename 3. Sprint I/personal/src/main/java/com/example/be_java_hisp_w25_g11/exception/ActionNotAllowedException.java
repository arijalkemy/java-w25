package com.example.be_java_hisp_w25_g11.exception;

public class ActionNotAllowedException extends RuntimeException{
    public ActionNotAllowedException(String message) {
        super(message);
    }
}
