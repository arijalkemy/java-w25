package org.socialmeli.dto.response;

import lombok.Data;

@Data
public class NotValidExceptionDto {

    private String field;
    private String message;

    public NotValidExceptionDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

}
