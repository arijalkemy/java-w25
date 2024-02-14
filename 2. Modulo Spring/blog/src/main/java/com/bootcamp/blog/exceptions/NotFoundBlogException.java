package com.bootcamp.blog.exceptions;

public class NotFoundBlogException extends RuntimeException{

    public NotFoundBlogException() {

    }

    public NotFoundBlogException(String message){
        super(message);
    }
}
