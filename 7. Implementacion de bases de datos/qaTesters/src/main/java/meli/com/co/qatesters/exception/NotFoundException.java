package meli.com.co.qatesters.exception;

import org.hibernate.annotations.NotFound;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
