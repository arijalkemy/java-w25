package org.blog.exception;

import org.blog.dto.response.ExceptionResponseDTO;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message) {
        super(message);
    }
}
