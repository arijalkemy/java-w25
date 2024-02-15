package com.lh.bootjavaspring_profiles_vivo_p2.exception;

public class UnauthorizedLinkException extends RuntimeException{
    public UnauthorizedLinkException(String message) {
        super(message);
    }
}
