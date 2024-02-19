package org.bootcamp.blog.exception;

public class DuplicateBlogException extends RuntimeException{
    public DuplicateBlogException(String message) {
        super(message);
    }
}
