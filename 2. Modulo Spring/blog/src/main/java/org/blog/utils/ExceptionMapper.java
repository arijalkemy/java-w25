package org.blog.utils;

import org.blog.dto.response.ExceptionResponseDTO;

public final class ExceptionMapper {
    public static ExceptionResponseDTO newExceptionResponseDTO(String message){
        return new ExceptionResponseDTO(message);
    }
}
