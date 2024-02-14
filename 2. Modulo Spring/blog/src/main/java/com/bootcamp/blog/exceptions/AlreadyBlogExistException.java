package com.bootcamp.blog.exceptions;

public class AlreadyBlogExistException extends  RuntimeException{
    public AlreadyBlogExistException(){
    };
    public AlreadyBlogExistException(String message){
        super(message);
    }
}
