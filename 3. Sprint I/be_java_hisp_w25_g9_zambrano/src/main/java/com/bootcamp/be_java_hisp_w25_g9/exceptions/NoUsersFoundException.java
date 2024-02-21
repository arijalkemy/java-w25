package com.bootcamp.be_java_hisp_w25_g9.exceptions;

public class NoUsersFoundException extends RuntimeException{

    public NoUsersFoundException(String message) {
        super(message);
    }

}
