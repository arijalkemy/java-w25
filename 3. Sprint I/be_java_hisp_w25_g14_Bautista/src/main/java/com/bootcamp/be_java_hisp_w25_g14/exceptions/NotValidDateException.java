package com.bootcamp.be_java_hisp_w25_g14.exceptions;

public class NotValidDateException extends RuntimeException{

    public NotValidDateException(String message) {
        super(message);
    }
}
