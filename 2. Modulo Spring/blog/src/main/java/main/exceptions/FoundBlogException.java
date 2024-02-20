package main.exceptions;

public class FoundBlogException extends RuntimeException{

    public FoundBlogException(){

    }

    public FoundBlogException(String message) {
        super(message);
    }
}
