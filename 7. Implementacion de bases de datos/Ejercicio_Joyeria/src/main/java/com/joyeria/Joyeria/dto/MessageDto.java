package com.joyeria.Joyeria.dto;

import org.springframework.http.HttpStatus;

public class MessageDto {
    private String msg;
    private HttpStatus status;

    public MessageDto(String msg, HttpStatus status) {
        this.status = status;
        this.msg = msg;
    }
}
