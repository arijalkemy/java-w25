package org.example.recapitulandospringp2vivo.exceptions;

public class PermissionDenied extends Exception {
    public PermissionDenied(){

    }

    public PermissionDenied (String message){
        super(message);
    }
}
