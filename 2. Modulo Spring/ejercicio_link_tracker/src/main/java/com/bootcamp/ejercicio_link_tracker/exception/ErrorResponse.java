package com.bootcamp.ejercicio_link_tracker.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private int code;
    private String message;
}