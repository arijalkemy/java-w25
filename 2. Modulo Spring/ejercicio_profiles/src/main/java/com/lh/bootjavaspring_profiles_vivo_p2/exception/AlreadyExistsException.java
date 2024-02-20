package com.lh.bootjavaspring_profiles_vivo_p2.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
